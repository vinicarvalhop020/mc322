//constantes para atualiza frota

public enum EnumAtualizaFrota{

    ADCIONA_VEICULO("Adciona veiculo"),
	REMOVE_VEICULO("Remove veiculo"),
	REMOVE_FROTA("Remove frota");

    private final String descricao;
	
	//Construtor
	EnumAtualizaFrota(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}
}
