public class Seguradora {
	//variaveis privadas
	private String nome;
	private String telefone;
	private String email;
	private String endereco;

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
    public String toString(){
        return "O nome da seguradora eh: " + this.nome + ", com telefone: " + this.telefone + ", com email: " + this.email + " e endereco: "+ this.endereco;
    }
}