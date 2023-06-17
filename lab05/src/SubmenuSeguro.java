/*
 * Define as constantes dos submenus
 */
public enum SubmenuSeguro {
	SEGURO_PF("Cadastrar seguro PF"),
	SEGURO_PJ("Cadastrar seguro PJ"),
	VOLTAR("Voltar");
	
	//atributo
	private final String descricao;
	
	//Construtor
	SubmenuSeguro(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}

}