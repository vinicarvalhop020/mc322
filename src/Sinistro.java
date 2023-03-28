import java.util.Random;

public class Sinistro {
	private int id ;
	private String data;
	private String endereco;

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
	public void setID() {
		Random numero = new Random();
		this.id = numero.nextInt(99999);
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