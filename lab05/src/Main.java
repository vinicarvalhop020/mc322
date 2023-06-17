//Utilização do exemplo dado pel PED Rebeca Padovani

import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
	//exibir menu externo
	private static void exibirMenuExterno() {
		MenuOpcoes menuOpcoes[] = MenuOpcoes.values();
		System.out.println("Menu principal");
		for(MenuOpcoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
	private static void exibirSubmenu(MenuOpcoes op) {
		SubmenuOpcoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}

	private static void exibirSubmenuCliente(SubmenuOpcoes op){//simetrico ao exemplo dado trocando por submenu de clientes PF ou PJ
		SubmenuCliente[] submenuClientes = op.getSubmenuCliente();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenuClientes.length;i++){
			System.out.println(i +" - " + submenuClientes[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOpcoes lerOpcaoMenuExterno() {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		MenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOpcoes.values().length - 1);
		opUsuarioConst = MenuOpcoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//ler opção dos submenus
	private static SubmenuOpcoes lerOpcaoSubmenu(MenuOpcoes op) {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		SubmenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}

	//ler opção do submenucliente
	private static SubmenuCliente lerOpcaoSubmenuCliente(SubmenuOpcoes op){
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		SubmenuCliente opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenuCliente().length - 1);
		opUsuarioConst = op.getSubmenuCliente()[opUsuario];
		return opUsuarioConst;
	}
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOpcoes op,ArrayList<Seguradora> seguradoras) throws ParseException {

		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
			case GERAR:
				executarSubmenu(op,seguradoras);
			break;
			case AUTORIZAR_DESAUTORIZAR:
				executarSubmenu(op, seguradoras);
			case CALCULAR_RECEITA:
				operacoesMain.calcularReceita(seguradoras);
				break;
			//case SAIR:
		}
	}

	public static void executarOpcaoSubMenuCliente(SubmenuCliente opSubmenuCliente, ArrayList<Seguradora> seguradoras) throws ParseException{
		//usando o exemplo foi possivel separa o cadastro PF ou PJ do cliente
		Scanner scan = new Scanner(System.in);

		switch(opSubmenuCliente){

			case CLIENTE_PF:
				operacoesMain.cadastrarClientePF(seguradoras);
			break;
			case CLIENTE_PJ:
				operacoesMain.cadastrarClientePJ(seguradoras);
			break;
			case VEICULO_CLIENTE_PF:
				operacoesMain.cadastrarVeiculoPF(seguradoras);
			break;
			case VEICULO_CLIENTE_PJ:
				operacoesMain.cadastrarVeiculoPJ(seguradoras);
			break;
			case SEGURO_PF:
				operacoesMain.gerarSeguroPF(seguradoras);
			break;
			case SEGURO_PJ:
				operacoesMain.gerarSeguroPJ(seguradoras);
			break;			
			

			//case VOLTAR:
					//	break;
		}
	}

	
	public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu, ArrayList<Seguradora> seguradoras) throws ParseException {
		Scanner scan = new Scanner(System.in);
		String nome;
		String identificador;
		
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
			executarSubmenuCliente(opSubmenu, seguradoras);//
			break;
		case CADASTRAR_VEICULO:
			executarSubmenuCliente(opSubmenu, seguradoras);//
			break;
		case CADASTRAR_FROTA:
			operacoesMain.cadastrarFrota(seguradoras);
			break;
		case CADASTRAR_SEGURADORA:
			operacoesMain.cadastrarSeguradora(seguradoras);
			break;
		case CADASTRAR_CONDUTOR:
			operacoesMain.cadastrarCondutor(seguradoras);
			break;
		case LISTAR_CLIENTES:
			operacoesMain.listarClientePorSeg(seguradoras);
			break;
		case LISTAR_SEGUROS_SEG:
			operacoesMain.listarSegurosSeg(seguradoras);
			break;
		case LISTAR_CONDUTORES_CL:
			operacoesMain.listarCondutoresCl(seguradoras);
			break;
		case LISTAR_SEGUROS_CLI:
			operacoesMain.listarSegurosCli(seguradoras);
			break;
		case LISTAR_SINISTROS_SEG:
			operacoesMain.listarSinistrosPorSeg(seguradoras);
			break;
		case LISTAR_SINISTROS_CL:
			operacoesMain.listarSinistrosPorCli(seguradoras);
			break;	
		case LISTAR_VEICULOS_PF:
			operacoesMain.listarVeiculosPF(seguradoras);
			break;
		case LISTAR_FROTA_PJ:
			operacoesMain.listarFrotaPJ(seguradoras);
			break;	
		case EXCLUIR_CLIENTE:
			operacoesMain.excluirCliente(seguradoras);
			break;
		case EXCLUIR_CONDUTOR:
			operacoesMain.excluirCondutor(seguradoras);
			break;
		case EXCLUIR_FROTA:
			operacoesMain.excluirFrota(seguradoras);
		case EXCLUIR_VEICULO_FROTA:
			operacoesMain.excluirVeiculoFr(seguradoras);
			break;	
		case EXCLUIR_VEICULO_PF:
			operacoesMain.excluirVeiculoPf(seguradoras);
			break;	
		case EXCLUIR_SEGURO:
			operacoesMain.excluirSeguro(seguradoras);
		case EXCLUIR_SINISTRO:
			operacoesMain.excluirSinistro(seguradoras);
			break;
		case GERAR_SEGURO:
			executarSubmenuCliente(opSubmenu, seguradoras);//
			break;
		case GERAR_SINISTRO:
			operacoesMain.gerarSinistro(seguradoras);
			break;
		case AUTORIZAR_CONDUTOR:
			operacoesMain.autorizarCondutor(seguradoras);
			break;
		case DESAUTORIZAR_CONDUTOR:
			operacoesMain.desautorizarCondutor(seguradoras);
			break;
		}
	}	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOpcoes op, ArrayList<Seguradora> seguradoras) throws ParseException {
		SubmenuOpcoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu,seguradoras);
		}while(opSubmenu != SubmenuOpcoes.VOLTAR);
	}

	private static void executarSubmenuCliente(SubmenuOpcoes op, ArrayList<Seguradora> seguradoras) throws ParseException {
		SubmenuCliente opSubmenuCliente;
		do{
			exibirSubmenuCliente(op);
			opSubmenuCliente = lerOpcaoSubmenuCliente(op);
			executarOpcaoSubMenuCliente(opSubmenuCliente, seguradoras);
		}while(opSubmenuCliente != SubmenuCliente.VOLTAR);
	}
	
	//executa o menu externo: exibição do menu, leitura da opção e execução da opção
	public static void main(String[] args) throws ParseException {
		ArrayList<Seguradora> seguradoras = new ArrayList<>();


		Intanciacoes.instanciacoes(seguradoras);//instanciacoes necessarias antes de chamar o menu de operacoes
		
		MenuOpcoes op;
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op, seguradoras);
		}while(op != MenuOpcoes.SAIR);
		System.out.println("Saiu do sistema");
	}

}

