import java.util.ArrayList;
import java.util.Date;

public abstract class Cliente {
	//Abstrata 
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	
	//construtor
	public Cliente(String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco; 
		this.email = email;
	}
	
	//geters e setters

	//getters 
	public String getNome() {
		return nome;
	}

	public String getTelefone(){
		return telefone;
	}

	public String getEndereco(){
		return endereco;
	}

	public String getEmail(){
		return email;
	}

	public String getIdentificador(){
		return "";
	}

	

	
	//setters 

	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	public void setTelefone(String novoTelefone){
		this.telefone = novoTelefone;
	}
	public void setEndereco(String novoEndereco) {
		this.endereco = novoEndereco;
	}	
	public void setEmail(String novoEmail){
		this.email = novoEmail;
	}

    public String toString(){
        return  "Nome : " + this.nome + "\n" +
				"Telefone : " +this.telefone + "\n"+ 
				"Endereco: " + this.endereco + "\n"+
				"Email " + this.email + "\n";
    }

}
	
