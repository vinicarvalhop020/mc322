import java.util.ArrayList;

public class Seguradora {
	//variaveis privadas
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
    private ArrayList<Cliente> Clientes;
	private ArrayList<Seguro> Seguros;

	// construtor
	public Seguradora(String cnpj, String nome,String telefone,String email,String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.Clientes = new ArrayList<>();
		this.Seguros = new ArrayList<>();

	}
	// getters e setters
	public String getCnpj(){
		return cnpj;
	}
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

	public ArrayList<Cliente> listarclientes(){
		return Clientes;
	}

	public ArrayList<Seguro> listarseguros(){
		return Seguros;
	}

	public boolean gerarSeguro(Seguro seguro){
		boolean flag = false;

		if(!AuxilarSeguradora.buscarSeguro(seguro.getId(), this.Seguros)){
			this.Seguros.add(seguro);
			flag = true;
		}
		return flag;
	}
	

	public boolean cancelarSeguro(Seguro seguro){//relacionamento com seguro
		boolean flag = false;

		for(Seguro seguroRM: this.Seguros){
			if (seguroRM.equals(seguro)){
				this.Seguros.remove(seguro);
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	public boolean removerSinistro(Sinistro sinistro){
	//busca o sinistro por meio dos seguros, achando remove
		boolean flag = false;

		for (Seguro seguro: this.Seguros){
			for(Sinistro sinistroRM : seguro.getLSinistros()){
				if(sinistroRM.equals(sinistro)){
					seguro.getLSinistros().remove(sinistro);
					flag = true;
					return flag;
				}
			}
		}
		return flag;
	}

	public boolean cadastrarCliente(Cliente cliente){//relacionamento com cliente
        boolean flag = false;
		
		if (!AuxilarSeguradora.buscar_cliente(cliente.getIdentificador(),Clientes)){
			//veja que buscar_cliente retorna false se nao ha esse cliente na lista mas precisamos que ela seja verdadeira caso nao tenha esse o motivo do !
			Clientes.add(cliente);
			flag = true;
			return flag; 
    	}
		return flag;
	}

	public boolean removerCliente(String identificador){
		//remove o cliente da lista da seguradora pelo identificador (CPF ou CNPJ)
        boolean flag = false;
        /*false se o cliente  não esta na lista*/
		for(int i = 0; i<this.Clientes.size(); i++){
			if(Clientes.get(i).getIdentificador().equals(identificador)){
				Clientes.remove(i);
				flag = true;
				return flag;

			}
		}
        return flag;
    }


	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		ArrayList<Seguro> SegurosDoCliente = new ArrayList<Seguro>();

		for(Seguro seguro : Seguros){
			if(seguro.getCliente().equals(cliente)){
				SegurosDoCliente.add(seguro);
			}	
		}
		return SegurosDoCliente;
	}



	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
		//por meio do seguro se obtem o sinistro
		ArrayList<Sinistro> Sinistros = new ArrayList<Sinistro>();
		ArrayList<Seguro> seguro_cl = new ArrayList<Seguro>();

		seguro_cl = getSegurosPorCliente(cliente);

		for(Seguro seguro : seguro_cl){
			Sinistros.addAll(seguro.getLSinistros());
		}

		return Sinistros;
	}

	public double calcularReceita(){
		double receita = 0.0;
		atualizaValorSeguros();//garantia que a receita esta sempre atualizada
		for (Seguro seguro: Seguros){
			receita += seguro.getValorMensal();//soma os valores mensais de cada seguro
		}
		return receita;
	}

	public void atualizaValorSeguros(){
		for (Seguro seguro: Seguros){
			seguro.getValorMensal();//atualiza os valores mensais dos seguros
		}
	}
	
    public String toString(){
        return "O nome da seguradora : " + this.nome + "\n"+
				"telefone : " + this.telefone + "\n"+
				"email: " + this.email + "\n"+
				"e endereco: "+ this.endereco +"\n";
    }
}