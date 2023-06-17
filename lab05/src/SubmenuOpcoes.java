//Utilizacao do exemplo dado pela PED Rebeca Padovani

//modificacao colocando um submenu cliente para o usario decidir entre PF ou PJ

/*
 * Define as constantes dos submenus
 */
public enum SubmenuOpcoes {
	CADASTRAR_CLIENTE("Cadastrar cliente",new SubmenuCliente[]{
		SubmenuCliente.CLIENTE_PF,
		SubmenuCliente.CLIENTE_PJ,
		SubmenuCliente.VOLTAR
	}),
	CADASTRAR_VEICULO("Cadastrar veiculo",new SubmenuCliente[]{
		SubmenuCliente.VEICULO_CLIENTE_PF,
		SubmenuCliente.VEICULO_CLIENTE_PJ,
		SubmenuCliente.VOLTAR
	}),
	CADASTRAR_CONDUTOR("Cadastrar frota",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	CADASTRAR_FROTA("Cadastrar frota",new SubmenuCliente[]{SubmenuCliente.VOLTAR}){
	},
	CADASTRAR_SEGURADORA("Cadastrar seguradora",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_CLIENTES("Listar cliente",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_CONDUTORES_CL("Listar condutores por cliente",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_SEGUROS_SEG("Listar seguros seguradora",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_SEGUROS_CLI("Listar seguros cliente",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_SINISTROS_SEG("Listar sinistros",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_SINISTROS_CL("Listar sinistros",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_VEICULOS_PF("Listar veiculo PF",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_FROTA_PJ("Listar frota PJ",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_CLIENTE("Excluir cliente",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_CONDUTOR("Excluir condutor",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_FROTA("Excluir frota",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_VEICULO_FROTA("Excluir veiculo de uma frota",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_VEICULO_PF("Excluir veiculo de um cliente PF",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_SINISTRO("Excluir sininstro",new SubmenuCliente[]{SubmenuCliente.VOLTAR}
	),
	EXCLUIR_SEGURO("Excluir seguro",new SubmenuCliente[]{SubmenuCliente.VOLTAR}
	),
	GERAR_SINISTRO("Gerar sinistro",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	GERAR_SEGURO("Gerar seguro",new SubmenuCliente[]{
		SubmenuCliente.SEGURO_PF,
		SubmenuCliente.SEGURO_PJ,
		SubmenuCliente.VOLTAR
	}),
	AUTORIZAR_CONDUTOR("Autorizar Condutor",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	DESAUTORIZAR_CONDUTOR("Desautorizar Condutor",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	VOLTAR("Voltar",new SubmenuCliente[]{});

	
	//atributo
	private final String descricao;
	private final SubmenuCliente[] subcliente;
	
	//Construtor
	SubmenuOpcoes(String descricao,SubmenuCliente[] subcliente){
		this.descricao = descricao;
		this.subcliente = subcliente;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}

	public SubmenuCliente[] getSubmenuCliente() {
		return subcliente;
	}
}