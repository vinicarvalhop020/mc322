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
	CADASTRAR_VEICULO("Cadastrar veiculo",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	CADASTRAR_SEGURADORA("Cadastrar seguradora",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_CLIENTES("Listar cliente",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_SINISTROS_SEG("Listar sinistros",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_SINISTROS_CL("Listar sinistros",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_VEICULOS_CL("Listar veiculo",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	LISTAR_VEICULOS_SEG("Listar veiculo",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_CLIENTE("Excluir cliente",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_VEICULO("Excluir veiculo",new SubmenuCliente[]{SubmenuCliente.VOLTAR
	}),
	EXCLUIR_SINISTRO("Excluir sininstro",new SubmenuCliente[]{SubmenuCliente.VOLTAR
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