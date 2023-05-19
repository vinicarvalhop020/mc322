import java.util.ArrayList;
/*o valor double valorSeguro é preenchido pela função calcula seguro da seguradora, enviado para o set */

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
		this.valorSeguro = 0;
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
	public double getValorSeguro(){
		return valorSeguro;
	}


	//setters 

	public void setNome(String nome){
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	public void setValorSeguro(double valor){
		this.valorSeguro = valor;
	}
	public void adciona_veiculo(Veiculo veiculo){
		this.veiculos.add(veiculo);
	}
	public ArrayList<Veiculo> listar_Veiculos(){
		return this.veiculos;
	}
	public Veiculo obter_veiculo(String placa){
		for (int i = 0; i < veiculos.size(); i++){
			if (veiculos.get(i).getPlaca().equals(placa)){
				return veiculos.get(i);
			}	
		}
		return null;
	}

	public void excluir_veiculo(Veiculo veiculo){
		veiculos.remove(veiculo);
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
				"Endereco: " + this.endereco + "\n"+
				"Valor Seguro: R$:" + this.valorSeguro + "\n";
    }

}
	
