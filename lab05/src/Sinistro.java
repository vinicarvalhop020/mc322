import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Sinistro {
	private final int id ; // uma vez setada pelo construtor nao muda
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	//construtor
	public Sinistro(Date data,String endereco,Condutor condutor,Seguro seguro) {

		Random numero = new Random();
		this.id = numero.nextInt(99999);
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor; /*chamo o construtor da classe seguradora passando os parametros,ou ja passaria o objeto */
		this.seguro = seguro;
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
	public Condutor getCondutor(){
		return condutor;
	}
	public Seguro getSeguro(){
		return seguro;
	}
	
	//SETTERS
	
	public void setData(Date data){
		this.data = data;		
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setCondutor(Condutor condutor){
		this.condutor = condutor;
	}
	public void setSeguro(Seguro seguro){
		this.seguro = seguro;
	}


    public String toString(){
		DateFormat ft_data = new SimpleDateFormat("dd-MM-yyyy");
        String dataa = ft_data.format(this.data);

        return "ID: " + this.id + "\n" +
				"Data: "+	dataa + "\n"+
				"Endereco: "+ this.endereco + "\n"+
				this.endereco.toString() + "\n"+
				this.seguro.toString();
    }
}