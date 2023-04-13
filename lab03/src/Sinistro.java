import java.util.Random;

public class Sinistro {
	private final int id ; // uma vez setada pelo construtor nao muda
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo; //de cada veiculo, o cliente pode ter muitos sinistros mas um para cada sinistro
	private Cliente cliente;

	//construtor
	public Sinistro(String data,String endereco,Seguradora seguradora,Veiculo veiculo,Cliente cliente) {

		Random numero = new Random();
		this.id = numero.nextInt(99999);
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora; /*chamo o construtor da classe seguradora passando os parametros,ou ja passaria o objeto */
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	//getters e setters
	//GETTERS

	public int getID() {
		return id;
	}
	public String getData() {
		return data;
	}
	public String getEndereco(){
		return endereco;
	}
	/*nesses 3 retornaria o objeto? */
	public Seguradora getSeguradora(){
		return seguradora;
	}
	public Veiculo getVeiculo(){
		return veiculo;
	}
	public Cliente cliente(){
		return cliente;
	}

	//SETTERS
	
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