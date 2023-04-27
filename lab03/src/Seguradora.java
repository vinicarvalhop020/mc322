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
	public boolean buscar_cliente(String CPX){
		//busca pelo cpf
		boolean flag = false;
		for(int i = 0; i < this.Clientes.size(); i++){
			if (this.Clientes.get(i).getIdentificador().equals(CPX)){
				flag = true;
			}
		}
		return flag;
	}

    public boolean cadastrarCliente(String nome,String endereco, Date dataLicenca, String educacao, String genero,String classeEconomica, String CPX, Date dataX){
        boolean flag = true;
		/*o fator determinante de pf e pj é a quantidade de digitos em CP */
        /*true se o cliente nao está na lista e o cpf/cnpj é valido */
        /* false seria se o cliente ja estivesse na lista ou se o cpf/cnpj é invalido*/
		String CPX_aux;
		CPX_aux = CPX.replaceAll("\\D","");
		if (CPX_aux.length() == 11){
			//cliente PF
			ClientePF novo_clientePF = new ClientePF(nome,endereco,dataLicenca,educacao,genero,classeEconomica,CPX,dataX);

			if (novo_clientePF.validarCPF() && !buscar_cliente(CPX)){
				//se o cpf for falso nao a validação de cliente
				Clientes.add(novo_clientePF);
			}
			else 
				flag = false;
		}
		else{
			ClientePJ novo_ClientePJ = new ClientePJ(nome, endereco, dataLicenca, educacao, genero, classeEconomica, CPX, dataX);
			if(novo_ClientePJ.validarcnpj() && !buscar_cliente(nome)){
				Clientes.add(novo_ClientePJ);
			}
		else 
			flag = false;
		}
        return flag;
    }

    public boolean removerCliente(String CPX){
        boolean flag = true;
        /*false se o cliente  não esta na lista*/
		if (buscar_cliente(CPX)){
			for(int i = 0; i<this.Clientes.size(); i++){
				if(Clientes.get(i).getIdentificador().equals(CPX)){
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
		return Sinistros;
	}
	public ArrayList<Cliente> listarclientes(){
		return Clientes;
	}

	public Cliente busca_cliente(String CPX){
	
		for (int i = 0; i<this.Clientes.size();i++){
			if (this.Clientes.get(i).getIdentificador().equals(CPX)){
				return Clientes.get(i);
			}
		}
		return 
			null;
	}


	
    public String toString(){
        return "O nome da seguradora : " + this.nome + "\n"+
				"telefone: " + this.telefone + "\n"+
				"email: " + this.email + "\n"+
				"e endereco: "+ this.endereco +"\n";
    }
}