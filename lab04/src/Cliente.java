import java.util.ArrayList;

public class Cliente {
	//SUPER CLASSE 
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> veiculos; 
	private double valorSeguro;
	
	
	//construtor
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.veiculos = new ArrayList<>(); /*instancia o objeto lista*/
	}
	
	//geters e setters

	//getters 
	public String getNome() {
		return nome;
	}
	public String getEndereco(){
		return endereco;
	}

	public String getIdentificador(){
		return "";
	}
	//setters 

	public void setNome(String nome){
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	

	//necessario para o polimorfismo
	public double calculaScore(){
		return 0.0;
	}

	public int qtdCarros(){
		return veiculos.size();
	}

    public String toString(){
        return "Nome : " + this.nome + "\n" +
				"Endereco: " + this.endereco + "\n";
    }

}
	
