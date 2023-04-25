import java.util.Date;
import java.util.ArrayList;


public class Cliente {
	//SUPER CLASSE 
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private ArrayList<Veiculo> veiculos; 
	
	
	//construtor
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.veiculos = new ArrayList<>(); /*instancia o objeto lista*/
	}

	public Cliente(){}
	
	//geters e setters

	//getters 
	public String getNome() {
		return nome;
	}
	public String getEndereco(){
		return endereco;
	}
	public Date getData_licenca() {
		return dataLicenca;
	}
	public String getEducacao() {
		return educacao;
	}
	public String getGenero(){
		return genero;
	}
	public String getClasse_economica(){
		return classeEconomica;
	}

	//setters 

	public void setNome(String nome){
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	public void setEnducacao(String educacao){
		this.educacao = educacao;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setClasse_economica(String classeEconomica){
		this.classeEconomica = classeEconomica;
	}
	
	public void adciona_veiculo(String placa, String marca, String modelo, int anoFabricacao){
		//a intenção é abstrair do cliente a criação do objeto
		Veiculo carro_aux = new Veiculo(placa, marca, modelo, anoFabricacao);
		this.veiculos.add(carro_aux);
	}
	public void remove_veiculo(String placa){
		//remover o veiculo pela placa, abstrai do cliente essa funcao
		//acessar o objeto pelo indice
		//comparar strings em java é assim?
		for (int i=0; i <this.veiculos.size(); i++){
			if (this.veiculos.get(i).getPlaca() == "placa"){
				this.veiculos.remove(i);
				break;//esse break sai do laço e da func
			}
		}
	}

    public String toString(){
        return "NOME: " + this.nome + "\n" +
				"Endereco: " + this.endereco + "\n"+
				"Educacao: " + this.educacao + "\n"+
				"Genero: "  + this.genero + "\n"+
				"classe: "  + this.classeEconomica;
    }
}