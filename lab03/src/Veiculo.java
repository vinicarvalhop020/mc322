public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao; 

//construtor
	public Veiculo(String placa,String marca,String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}
	//getters e setters

	//getters

	public String getPlaca() {
		return placa;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getAno_fabricacao(){
		return anoFabricacao;
	}

	// setters 

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setAno_fabricacao(int anoFabricacao){
		this.anoFabricacao = anoFabricacao;
	}

    public String toString(){
		return "Placa: " + this.placa + "\n" +
				"Marca: " + this.marca + "\n"+
				"Modelo: " + this.modelo + "\n"+
				"Ano de fabricacao: "  + this.anoFabricacao + "\n";
    }
}