//Utilização do exemplo dado pel PED Rebeca Padovani


/* enum para menu externo
Cada constante é vista como uma descrição e uma lista de outras constantes (que são as constantes do submenu)
new SubmenuOpcoes[]{} cria uma lista de constantes do submenu.
*/
public enum MenuOpcoes {
	CADASTROS("Cadastros", new SubmenuOpcoes[] {
			SubmenuOpcoes.CADASTRAR_CLIENTE,
			SubmenuOpcoes.CADASTRAR_VEICULO,
			SubmenuOpcoes.CADASTRAR_SEGURADORA,
			SubmenuOpcoes.CADASTRAR_FROTA,
			SubmenuOpcoes.CADASTRAR_CONDUTOR,
			SubmenuOpcoes.VOLTAR
	}),
	LISTAR("Listar", new SubmenuOpcoes[] {
			SubmenuOpcoes.LISTAR_CLIENTES,
			SubmenuOpcoes.LISTAR_SEGUROS_SEG,
			SubmenuOpcoes.LISTAR_SEGUROS_CLI,
			SubmenuOpcoes.LISTAR_SINISTROS_SEG,
			SubmenuOpcoes.LISTAR_SINISTROS_CL,
			SubmenuOpcoes.LISTAR_VEICULOS_PF,
			SubmenuOpcoes.LISTAR_FROTA_PJ,
			SubmenuOpcoes.VOLTAR
	}),
	EXCLUIR("Excluir", new SubmenuOpcoes[] {
			SubmenuOpcoes.EXCLUIR_CLIENTE,
			SubmenuOpcoes.EXCLUIR_CONDUTOR,
			SubmenuOpcoes.EXCLUIR_SINISTRO,
			SubmenuOpcoes.EXCLUIR_VEICULO_FROTA,
			SubmenuOpcoes.EXCLUIR_VEICULO_PF,
			SubmenuOpcoes.EXCLUIR_FROTA,
			SubmenuOpcoes.EXCLUIR_SEGURO,
			SubmenuOpcoes.VOLTAR}),
	GERAR("Gerar",new SubmenuOpcoes[] {
			SubmenuOpcoes.GERAR_SINISTRO,
			SubmenuOpcoes.GERAR_SEGURO,
			SubmenuOpcoes.VOLTAR}),
	AUTORIZAR_DESAUTORIZAR("Autorizar ou Desautorizar", new SubmenuOpcoes[] {
			SubmenuOpcoes.AUTORIZAR_CONDUTOR,
			SubmenuOpcoes.DESAUTORIZAR_CONDUTOR,
			SubmenuOpcoes.VOLTAR}),
	CALCULAR_RECEITA("Calcular Receita", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	SAIR("Sair", new SubmenuOpcoes[] {});
	
	//atributos
	private final String descricao;
	private final SubmenuOpcoes[] submenu;
	
	//Construtor
	MenuOpcoes(String descricao, SubmenuOpcoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}
	
	//getters
	public String getDescricao() {
		return descricao;
	}
	
	public SubmenuOpcoes[] getSubmenu() {
		return submenu;
	}
}