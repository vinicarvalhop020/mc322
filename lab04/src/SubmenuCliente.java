/*
 * Define as constantes dos submenus
 */
public enum SubmenuCliente {
	CLIENTE_PF("Cadastrar cliente PF"),
	CLIENTE_PJ("Cadastrar cliente PJ"),
	VOLTAR("Voltar");
	
	//atributo
	private final String descricao;
	
	//Construtor
	SubmenuCliente(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}

}