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
		Scanner scan = new Scanner(System.in);

		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op,seguradoras);
				break;
			case GERAR_SINISTRO:
			
				System.out.println("******************************************************");
				System.out.println("Informe o nome da Seguradora: ");
				String nome = scan.nextLine();
				System.out.println("Informe o nome CPF ou CNPJ do cliente: ");
				String identificador = scan.nextLine();
				System.out.println("Informe a placa do veiculo: ");
				String placa = scan.nextLine();

				for(int i = 0; i < seguradoras.size(); i++){
				//procura a seguradora de nome informado na lista de seguradoras
					if (seguradoras.get(i).getNome().equals(nome)){
						seguradoras.get(i).gerarSinistro(CriaObjetos.criaSinistro(seguradoras.get(i).obter_Cliente(identificador).obter_veiculo(placa), seguradoras.get(i), seguradoras.get(i).obter_Cliente(identificador)));
						//veja que "seguradoras.get(i)" retorna uma seguradora e a funcao "gerarSinistro pede como parametro (veiculo, seguradora , cliente)"
					}
				}
				System.out.println("******************************************************");

				break;

			case TRANSFERIR_SEGURO:

				System.out.println("******************************************************");
				System.out.println("Informe o nome da Seguradora que os clientes fazem parte : ");
				nome = scan.nextLine();
				Seguradora seguradora_aux = obter_Seguradora(seguradoras, nome);

				System.out.println("Informe qual o CPF ou CNPJ do Cliente remetente do seguro: ");
				identificador = scan.nextLine();
				Cliente clienteRemetente = seguradora_aux.obter_Cliente(identificador);

				System.out.println("Informe qual o CPF ou CNPJ do Cliente destinatario do seguro: ");
				String identificador_0 = scan.nextLine();
				Cliente clienteDestinatario = seguradora_aux.obter_Cliente(identificador_0);

				seguradora_aux.transferir_seguro(clienteRemetente,clienteDestinatario);

				//atualizacao dos valores de seguro
				seguradora_aux.calcularPrecoSeguroCliente(clienteRemetente);//atualiza o valor do seguro do remetente
				System.out.println("O novo valor do seguro para o cliente remetente é de " + clienteRemetente.getValorSeguro());

				seguradora_aux.calcularPrecoSeguroCliente(clienteDestinatario);//atualiza o valor do seguro do remetente
				System.out.println("O novo valor do seguro para o cliente destinatario é de " + clienteDestinatario.getValorSeguro());

				System.out.println("******************************************************");

				break;

			case CALCULAR_RECEITA:

				System.out.println("******************************************************");
				System.out.println("Informe o nome da Seguradora que: ");
				nome = scan.nextLine();
				obter_Seguradora(seguradoras, nome).calcularReceita();
				System.out.println("******************************************************");

				break;
			//case SAIR:
		}
	}

	public static void executarOpcaoSubMenuCliente(SubmenuCliente opSubmenuCliente, ArrayList<Seguradora> seguradoras) throws ParseException{
		//usando o exemplo foi possivel separa o cadastro PF ou PJ do cliente
		Scanner scan = new Scanner(System.in);

		switch(opSubmenuCliente){

			case CLIENTE_PF:
			String nome;
			System.out.println("******************************************************");
			System.out.println("Informe o nome da Seguradora que deseja cadastrar o cliente: ");

			nome = scan.nextLine();
			ClientePF clientePF = CriaObjetos.cria_ClientePF();

			if(clientePF != null){
				obter_Seguradora(seguradoras, nome).cadastrarCliente(clientePF);
				obter_Seguradora(seguradoras, nome).calcularPrecoSeguroCliente(clientePF);
				System.out.println("O valor do seguro atual é :" + clientePF.getValorSeguro()+ "");
			}
			else{
				System.out.println("Cliente não Cadastrado");
			}
			break;

			case CLIENTE_PJ:

			System.out.println("Informe o nome da Seguradora que deseja cadastrar o cliente: ");
			nome = scan.nextLine();
			ClientePJ clientePJ = CriaObjetos.cria_ClientePJ();
			
			if(clientePJ != null){
				obter_Seguradora(seguradoras, nome).cadastrarCliente(clientePJ);
				obter_Seguradora(seguradoras, nome).calcularPrecoSeguroCliente(clientePJ);
				System.out.println("O valor do seguro atual é :" +clientePJ.getValorSeguro()+ "");
			}
			else{
				System.out.println("Cliente não cadastrado");
			}
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

			//preciso do cliente saber de qual cliente da seguradora é o veiculo
			System.out.println("******************************************************");
			System.out.println("Informe o nome da Seguradora: ");
			nome = scan.nextLine();
			System.out.println("Informe o CPF ou CNPJ do cliente que deseja adcionar o veiculo: ");
			identificador = scan.nextLine();

			Cliente cliente_seg_aux = obter_Seguradora(seguradoras, nome).obter_Cliente(identificador); //busca o primeiro qual a seguradora na lista de seguradoras e depois qual o cliente;
			cliente_seg_aux.adciona_veiculo(CriaObjetos.criarVeiculo());
			System.out.println("Veiculo Cadastrado com sucesso!!: ");

			obter_Seguradora(seguradoras, nome).calcularPrecoSeguroCliente(cliente_seg_aux);//atualiza o valor do seguro apos um carro adconado
			System.out.println("O novo valor do para " + obter_Seguradora(seguradoras, nome).obter_Cliente(identificador).getNome() + " é de " + obter_Seguradora(seguradoras, nome).obter_Cliente(identificador).getValorSeguro());
			System.out.println("******************************************************");

			break;
			
		case CADASTRAR_SEGURADORA:

			System.out.println("******************************************************");
			cadastrar_seguradora(CriaObjetos.criaSeguradora(), seguradoras);
			System.out.println("Seguradora Cadastrada com Sucesso!!: ");
			System.out.println("******************************************************");

			break;

		case LISTAR_CLIENTES:
			System.out.println("******************************************************");
			System.out.println("Informe o nome da Seguradora: ");
			nome = scan.nextLine();
			System.out.println(obter_Seguradora(seguradoras, nome).listarclientes());//busca a seguradora pelo nome e lista todos os seus clientes
			System.out.println("******************************************************");
			break;

		case LISTAR_SINISTROS_SEG:
			System.out.println("******************************************************");
			System.out.println("Informe o nome da Seguradora: ");
			nome = scan.nextLine();
			System.out.println("Os sinistros dessa seguradora são: ");
			System.out.println(obter_Seguradora(seguradoras, nome).listarSinistros());
			System.out.println("******************************************************");
			System.out.println("******************************************************");

			break;

		case LISTAR_SINISTROS_CL:
			System.out.println("******************************************************");
			System.out.println("Informe o CPF ou CNPJ do cliente que deseja buscar sinistros: ");
			identificador = scan.nextLine();

			
			for (int i = 0; i < seguradoras.size();i++){
				if (seguradoras.get(i).buscar_cliente(identificador)){
					System.out.println("Os sinistros da seguradora "+ seguradoras.get(i).toString() +" para o cliente " + seguradoras.get(i).obter_Cliente(identificador).toString()+ " correspondem: ");
					//se existe um cliente com esse nome na seguradora eu uso a funcao "listar_clienteSinistro para obter todos os sinistros desse cliente"
					seguradoras.get(i).listar_clienteSinistro(seguradoras.get(i).obter_Cliente(identificador));
				}
			}
			System.out.println("******************************************************");
			break;	

		case LISTAR_VEICULOS_SEG:
			System.out.println("******************************************************");
			System.out.println("Informe o nome da Seguradora: ");
			nome = scan.nextLine();
			
			for(int i = 0; i < seguradoras.size() ; i++){

				if(seguradoras.get(i).getNome().equals(nome)){
					System.out.println("Os veiculos da seguradora "+ seguradoras.get(i).toString()+ " correspondem: ");
					System.out.println(seguradoras.get(i).listarclientes());
				}
			}
			System.out.println("******************************************************");
			break;


		case LISTAR_VEICULOS_CL:
			System.out.println("******************************************************");	
			System.out.println("Informe o CPF ou CNPJ do cliente que deseja buscar veiculos: ");
			identificador = scan.nextLine();

			for (int i = 0; i < seguradoras.size();i++){
				if (seguradoras.get(i).buscar_cliente(identificador)){
					System.out.println("Os veiculos da seguradora "+ seguradoras.get(i).toString() +" para o cliente " + seguradoras.get(i).obter_Cliente(identificador).toString()+ " correspondem: ");
					//se existe um cliente com esse identificador na seguradora eu uso a funcao "listar_clienteSinistro para obter todos os sinistros desse cliente"
					System.out.println (seguradoras.get(i).obter_Cliente(identificador).listar_Veiculos());
				}
			}
			System.out.println("******************************************************");
			break;	

		case EXCLUIR_CLIENTE:

			System.out.println("******************************************************");
			System.out.println("Informe o CPF ou CNPJ do cliente que deseja excluir : ");
			identificador = scan.nextLine();
			System.out.println("Informe de qual seguradora desejas que cliente seja excluido");
			nome = scan.nextLine();
			System.out.println("******************************************************");

			for (int i = 0; i < seguradoras.size();i++){
				if (seguradoras.get(i).getNome().equals(nome)){
					//busca a seguradora escolida pelo usario pelo nome e depois exclui o cliente dessa seguradora
					System.out.println("O cliente :" + seguradoras.get(i).obter_Cliente(identificador).toString()+ "foi excluido" );
					//se existe um cliente com esse nome na seguradora eu uso a funcao "listar_clienteSinistro para obter todos os sinistros desse cliente"
					seguradoras.get(i).removerCliente(identificador);

				}
			}
			System.out.println("******************************************************");
			break;	

		case EXCLUIR_VEICULO:
			//excluir um veiculo altera o preco do seguro do cliente
			//pode haver veiculos excluidos com sinistro entao precisei excluir o sinistro ligado a esse veiculo

			System.out.println("******************************************************");
			System.out.println("Informe o CPF ou CNPJ do cliente que deseja excluir veiculo: ");
			identificador = scan.nextLine();
			System.out.println("Informe a placa do veiculo a ser excluido: ");
			String placa = scan.nextLine();

			for (int i = 0; i < seguradoras.size();i++){
				if (seguradoras.get(i).buscar_cliente(identificador)){
					//se existe um cliente com esse identificador na seguradora eu uso a funcao
					 
					Cliente cliente_aux = seguradoras.get(i).obter_Cliente(identificador);//cliente que teve veiculo excluido
					Veiculo veiculo_aux = seguradoras.get(i).obter_Cliente(identificador).obter_veiculo(placa);//veiculo excluido
					//veja que o parametro excluir_veiculo é um objeto veiculos e "seguradoras.get(i).obter_Cliente(identificador).obter_veiculo(placa)" retorna um veiculo

					seguradoras.get(i).obter_Cliente(identificador).excluir_veiculo(veiculo_aux);//exclusao do veiculo
					System.out.println("O veiculo do cliente " + cliente_aux.toString()+ " contido na seguradora " + seguradoras.get(i).toString() + "foi excluido");


					//se o veiculo excluido possuir um sinistro esse sinistro precisa ser removido
					if (seguradoras.get(i).buscar_sinistro(veiculo_aux)){
						//busca o sinistro pelo veiculo
						seguradoras.get(i).excluir_sinistro(seguradoras.get(i).obter_Sinistro(veiculo_aux));//exclui o sinistro da seguradora caso tenha um veiculo com esse sinistro
					}

					seguradoras.get(i).calcularPrecoSeguroCliente(cliente_aux);//atualiza o valor do seguro do cliente
					System.out.println("O novo valor do seguro para o cliente é de " + cliente_aux.getValorSeguro());
					System.out.println("******************************************************");

				}
			}
			break;	


		case EXCLUIR_SINISTRO:

			System.out.println("******************************************************");
			//ao excluir um sinistro o preco do seguro do cliente muda!!
			System.out.println("Informe a placa veiculo com Sinistro a ser excluido ");
			placa = scan.nextLine();
			System.out.println("Informe o CPF ou CNPJ do cliente:  ");
			identificador = scan.nextLine();

			for (int i = 0; i < seguradoras.size();i++){
				//se existe um sinistro com essa id em alguma das seguradoras ele é excluido"
				Veiculo veiculo_aux = seguradoras.get(i).obter_Cliente(identificador).obter_veiculo(placa);//veiculo com sinistro excluido


				if (seguradoras.get(i).buscar_sinistro(veiculo_aux)){
					Cliente cliente_aux = seguradoras.get(i).obter_Sinistro(veiculo_aux).getCliente();//salva o cliente que vai ter o sinistro excluido

					System.out.println("O sinistro " + seguradoras.get(i).obter_Sinistro(veiculo_aux).toString()+ "foi excluido");

					seguradoras.get(i).excluir_sinistro(seguradoras.get(i).obter_Sinistro(veiculo_aux));//exclui o veiculo

					seguradoras.get(i).calcularPrecoSeguroCliente(cliente_aux);//atualiza o valor do seguro do cliente
	
					System.out.println("O novo valor do seguro para o cliente é de " + cliente_aux.getValorSeguro());

				}
			}
			System.out.println("******************************************************");

			break;

		//case VOLTAR:
		//	break;
		}
	}

	public static void cadastrar_seguradora(Seguradora seguradora, ArrayList<Seguradora> seguradoras){
		seguradoras.add(seguradora);
	}

	public static void listar_seguradoras(ArrayList<Seguradora> seguradoras){
		for(Seguradora  s : seguradoras){
			System.out.println(s);
		}
	}

	public static Seguradora obter_Seguradora(ArrayList<Seguradora> seguradoras, String nome_seguradora){
		//busca um objeto seguradora pelo nome
		for(int i = 0; i < seguradoras.size(); i++){
			if (seguradoras.get(i).getNome().equals(nome_seguradora)){
				return seguradoras.get(i);
			}
		}
		return null;
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

		//instancia.instancia_pedida_main(seguradoras);//realiza os processos pedidos no lab antes de abrir o menu =)

		MenuOpcoes op;
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op, seguradoras);
		}while(op != MenuOpcoes.SAIR);
		System.out.println("Saiu do sistema");
	}

}

