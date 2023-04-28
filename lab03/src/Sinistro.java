import java.util.Random;
import java.util.Date;


public class Sinistro {
	private final int id ; // uma vez setada pelo construtor nao muda
	private Date data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo; //de cada veiculo, o cliente pode ter muitos sinistros mas um para cada sinistro
	private Cliente cliente;

	//construtor
	public Sinistro(Date data,String endereco,Seguradora seguradora,Veiculo veiculo,Cliente cliente) {

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
	public Date getData() {
		return data;
	}
	public String getEndereco(){
		return endereco;
	}
	public Seguradora getSeguradora(){
		return seguradora;
	}
	public Veiculo getVeiculo(){
		return veiculo;
	}
	public Cliente getCliente(){
		return cliente;
	}

	//SETTERS
	
	public void setData(Date data){
		this.data = data;		
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


    public String toString(){
        return "ID: " + this.id + "\n" +
				"Data: "+ this.data + "\n"+
				"Endereco: "+ this.endereco + "\n";
    }
}