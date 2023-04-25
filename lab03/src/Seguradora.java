import java.util.ArrayList;
import java.util.Date;

public class Seguradora {
	//variaveis privadas
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
    private ArrayList<Sinistro> Sinistros;
    private ArrayList<Cliente> Clientes;


	// construtor
	public Seguradora(String nome,String telefone,String email,String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.Sinistros = new ArrayList<>();
		this.Clientes = new ArrayList<>();
	}
	// getters e setters
	public String getNome() {
		return nome;
		//retorna o nome quando pedido
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone; 
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean buscar_cliente(String nome){
		boolean flag = false;
		for(int i = 0; i < this.Clientes.size(); i++){
			if (this.Clientes.get(i).getNome() == nome){
				flag = true;
			}
		}
		return flag;
	}
	public Cliente getCliente(String nome){
		for(int i=0; i <this.Clientes.size();i++){
			if (this.Clientes.get(i).getNome() == nome){
				return this.Clientes.get(i);
			}
		}

	}



    public boolean cadastrarCliente(String nome,String endereco, Date dataLicenca, String educacao, String genero,String classeEconomica, String CP, Date dataX){
        boolean flag = true;
		/*o fator determinante de pf e pj é a quantidade de digitos em CP */
        /*true se o cliente nao está na lista e o cpf/cnpj é valido */
        /* false seria se o cliente ja estivesse na lista ou se o cpf/cnpj é invalido*/
		CP = CP.replaceAll("\\D","");
		if (CP.length() == 11){
			//cliente PF
			ClientePF novo_clientePF = new ClientePF(nome,endereco,dataLicenca,educacao,genero,classeEconomica,CP,dataX);

			if (novo_clientePF.validarCPF() && !buscar_cliente(nome)){
				Clientes.add(novo_clientePF);
			}
			else 
				flag = false;
		}
		else{
			ClientePJ novo_ClientePJ = new ClientePJ(nome, endereco, dataLicenca, educacao, genero, classeEconomica, CP, dataX);
			if(novo_ClientePJ.validarcnpj() && !buscar_cliente(nome)){
				Clientes.add(novo_ClientePJ);
			}
		else 
			flag = false;
		}
        return flag;
    }

    public boolean removerCliente(String nome){
        boolean flag = true;
        /*false se o cliente  não esta na lista*/
		if (buscar_cliente(nome)){
			for(int i = 0; i<this.Clientes.size(); i++){
				if(Clientes.get(i).getNome() == nome){
					Clientes.remove(i);
				}
			}
		}
		else 
			flag = false;
        /*true se removido */
        return flag;
    }

	public boolean buscar_sinistro(int ID){
		boolean flag = false;
		for(int i=0; i<this.Sinistros.size();i++){
			if(this.Sinistros.get(i).getID() == ID){
				flag = true;
			}
		}
		return flag;
	}

    public boolean gerarSinistro(String data,String endereco,Seguradora seguradora,Veiculo veiculo,Cliente cliente){
		boolean flag = false;
		Sinistro novo_Sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
		if ((buscar_sinistro(novo_Sinistro.getID()) != true)){
			//se o id ja na esta na lista
			this.Sinistros.add(novo_Sinistro);
			flag = true;
		}
		return flag;   
    }

	public boolean visualizarSinistro(int ID){
		boolean flag = false;
		if (buscar_sinistro(ID)){
			for (int i = 0; i<Sinistros.size();i++){
				if (Sinistros.get(i).getID() == ID){
					Sinistros.get(i).toString();
				}
			}
			flag = true;
		}
		return flag;
	}

	public ArrayList<Sinistro> listarSinistros(){
		for (int i = 0; i<Sinistros.size();i++){
			System.out.println(Sinistros.get(i).toString());
		}
		return Sinistros;
	}
	public ArrayList<Cliente> listarclientes(){
		return Clientes;
	}
	

	
    public String toString(){
        return "O nome da seguradora : " + this.nome + "\n"+
				"telefone: " + this.telefone + "\n"+
				"email: " + this.email + "\n"+
				"e endereco: "+ this.endereco +"\n";
    }
}