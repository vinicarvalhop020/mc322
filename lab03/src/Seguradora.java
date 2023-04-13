import java.util.ArrayList;

public class Seguradora {
	//variaveis privadas
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
    private static ArrayList<Sinistro> Sinistros = new ArrayList<>(); //array de todos os Sinistros de uma seguradora
    private static ArrayList<Cliente> Clientes = new ArrayList<>(); //array de todos os clientes de uma seguradora


	// construtor
	public Seguradora(String nome,String telefone,String email,String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
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
    public boolean cadastrarCliente(Cliente Cliente){
        boolean flag = true;
        /*true se o cliente nao está na lista e o cpf/cnpj é valido */
        /* false seria se o cliente ja estivesse na lista ou se o cpf/cnpj é invalido*/
        return flag;
    }

    public boolean removerCliente(String nome){
        boolean flag = true;
        /*false se o cliente  não esta na lista*/
        /*true se removido */
        return flag;
    }

    public boolean gerarSinistro( ){
		boolean flag = true;
		/* false se o cliente ja esta na seguradora, se o id ja está na lista de sinistros*/
		return flag;
        
    }
	public boolean visualizarSinistro(){
		boolean flag = true;
		/*falso se o sinistro nao esta na lista de sinistro */
		/*true se ele esta e seria legao printar usando a to string */
		return flag;
	}

	public ArrayList<Sinistro> listarSinistros(){
		//retorna a array de sinistros
		return Sinistros;
	}

    public String toString(){
        return "O nome da seguradora eh: " + this.nome + ", com telefone: " + this.telefone + ", com email: " + this.email + " e endereco: "+ this.endereco;
    }
}