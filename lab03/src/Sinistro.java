import java.util.Random;

public class Sinistro {
	private final int id ; // uma vez setada pelo construtor nao muda
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo; //de cada veiculo, o cliente pode ter muitos sinistros mas um para cada sinistro
	private Cliente cliente;

	//construtor
	public Sinistro(String data,String endereco) {
		this.data = data;
		this.endereco = endereco;
		Random numero = new Random();
		this.id = numero.nextInt(99999);
		
	}
	//getters e setters
	public int getID() {
		return id;
	}
	public String getdata() {
		return data;
	}
	public String getendereco(){
		return endereco;
	}
	public void setData(String data){
		this.data = data;		
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    public String toString(){
        return "O ID do cliente eh " + this.id + " a data do sinistro eh "+ this.data + " o endereco do sinistro eh "+ this.endereco;
    }
}