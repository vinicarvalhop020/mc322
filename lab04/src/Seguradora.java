import java.util.ArrayList;

		/*DUVIDAS */
		/*um cliente pode ter seguros em diferentes seguradoras? */
		/*no cadastro de veiculos, qual classe é responsavel por essa função a seguradora?*/
		/*na parte de transferencia de seguro, é somente trasnferir todos os veiculos de uma 
		seguradora para outra

		como fazer a implementacao de 2.2 e 2.3 ou seja como diferenciar se o sinistro/veiculo é do 
		cliente ou da seguradora??

		 */


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
	public String getTelefone() {
		return telefone;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone; 
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	public boolean buscar_cliente(String CPX){
		//Realiza uma busca na lista de clientes por CPX =(CNPJ ou CPF)
		boolean flag = false;
		for(int i = 0; i < this.Clientes.size(); i++){
			if (this.Clientes.get(i).getIdentificador().equals(CPX)){
				flag = true;
			}
		}
		return flag;
	}

    public boolean cadastrarCliente(Cliente cliente){
        boolean flag = false;
		
		if (!buscar_cliente(cliente.getIdentificador())){
			//veja que buscar_cliente retorna false se nao ha esse cliente na lista mas precisamos que ela seja verdadeira caso nao tenha esse o motivo do !
			Clientes.add(cliente);
			flag = true;
			return flag; 
    	}
		return flag;
	}


    public boolean removerCliente(String CPX){
        boolean flag = false;
        /*false se o cliente  não esta na lista*/
		for(int i = 0; i<this.Clientes.size(); i++){
			if(Clientes.get(i).getIdentificador().equals(CPX)){
				Clientes.remove(i);
				flag = true;
				return flag;

			}
		}
        return flag;
    }

	public ArrayList<Cliente> listarclientes(){
		return Clientes;
	}

	public boolean buscar_sinistro(Veiculo veiculo){
		//busca pelo ID, e retorna falso se nao encontra
		boolean flag = false;
		for(int i=0; i<this.Sinistros.size();i++){
			if(this.Sinistros.get(i).getVeiculo().equals(veiculo)){
				flag = true;
			}
		}
		return flag;
	}

    public boolean gerarSinistro(Sinistro sinistro){
		boolean flag = false;
		if ((!buscar_sinistro(sinistro.getVeiculo()))){
			//queremos que nao tenha um sinistro na lista, logo um false em buscar sinistro, negando com ! 
			this.Sinistros.add(sinistro);
			flag = true;
		}
		return flag;   
    }

	public boolean visualizarSinistro(Veiculo veiculo){
		//visualiza o sinistro pelo veiculo
		boolean flag = false;

		for (int i = 0; i<Sinistros.size();i++){
			if (Sinistros.get(i).getVeiculo().equals(veiculo)){
				Sinistros.get(i).toString();
				flag = true;
			}
		}
		return flag;
	}

	public ArrayList<Sinistro> listarSinistros(){
		//lista todos os sinistros da seguradora
		return Sinistros;
	}
	
	public void listar_clienteSinistro(Cliente cliente){
		//lista todos os sinistros de um cliente
		for (int i = 0; i < Sinistros.size();i++){
			System.out.println(Sinistros.get(i).getCliente().equals(cliente));
		}

	}


	public int qtdeSinistros(Cliente cliente){
		//procura na lista de sinistros todos os sinistros do cliente
		int qtdeSinistros = 0;
		for (int i = 0; i< this.Sinistros.size(); i++){
			if (Sinistros.get(i).getCliente().getIdentificador().equals(cliente.getIdentificador())){
				qtdeSinistros++;
			}

		}
		return qtdeSinistros;

	}

	public void calcularPrecoSeguroCliente(Cliente cliente){
		/*seta para o cliente o valor do seu seguro */
		double precoSeguro = cliente.calculaScore() * (1 + qtdeSinistros(cliente) );
		cliente.setValorSeguro(precoSeguro);
	}

	public double calcularReceita(){
		double receita = 0;

		for(int i = 0; i < Clientes.size(); i++ ){
			receita += Clientes.get(i).getValorSeguro();
		}
		return receita;
		
	}
	
	public Cliente obter_Cliente(String identificador){
		for(int i = 0 ; i < Clientes.size(); i++){
			if (Clientes.get(i).getIdentificador().equals(identificador)){
				return Clientes.get(i);
			}

		}
		return null;
	}

	public Sinistro obter_Sinistro(Veiculo veiculo){
		//busca o sinistro pelo veiculo associado
		for(int i = 0 ; i < Sinistros.size(); i++){
			if (Sinistros.get(i).getVeiculo().equals(veiculo)){
				return Sinistros.get(i);
			}
		}
		return null;
	}

	public void excluir_sinistro(Sinistro sinistro){
		for(int i = 0 ; i < Sinistros.size(); i++){
			if (Sinistros.get(i).equals(sinistro)){
				Sinistros.remove(i);
			}
		}

	}

	public void transferir_seguro(Cliente remetente, Cliente destinatario){
		//transfere todos os carros para o destinatario e apaga os do remetente

		for (Veiculo s : remetente.listar_Veiculos()){//adciona o veiculo 
			if (this.buscar_cliente(email))
			destinatario.adciona_veiculo(s);
		}
		for	(Veiculo z : remetente.listar_Veiculos()){//esclui veiculo
			remetente.excluir_veiculo(z);
		}


	}
	
    public String toString(){
        return "O nome da seguradora : " + this.nome + "\n"+
				"telefone : " + this.telefone + "\n"+
				"email: " + this.email + "\n"+
				"e endereco: "+ this.endereco +"\n";
    }
}