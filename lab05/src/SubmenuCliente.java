/*
 * Define as constantes dos submenus
 */
public enum SubmenuCliente {
	CLIENTE_PF("cadastrar cliente PF"),
	CLIENTE_PJ("cadastrar cliente PJ"),
	VEICULO_CLIENTE_PF("cadastrar veiculo cliente PF"),
	VEICULO_CLIENTE_PJ("cadastrar veiculo cliente PJ"),
	SEGURO_PF("gerar seguro tipo PF"),
	SEGURO_PJ("gerar seguro tipo PJ"),
	LISTAR_CLIENTE_POR_SEG("listar cliente por seguradora"),
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