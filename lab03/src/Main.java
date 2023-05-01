import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


public class Main {
	public static void main(String[] args) throws ParseException {
        SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");
        Scanner leitor = new Scanner(System.in);

      //CRIAÇÃO DA SEGURADORA
        System.out.println("--------------Olá vamos criar uma seguradora-----------"+"\n");
        System.out.println("Informe qual será o nome da seguradora: ");
        String nome = leitor.nextLine();
        System.out.println("Informe qual será o telefone dessa seguradora: ");
        String telefone = leitor.nextLine();
        System.out.println("Informe qual será o email dessa seguradora: ");
        String email = leitor.nextLine();
        System.out.println("Informe qual será o endereco dessa seguradora:");
        String endereco = leitor.nextLine();
        Seguradora seguradora = new Seguradora(nome,telefone,email,endereco);
        System.out.println("----------!!!Seguradora criada com sucesso!!!!-----------"+"\n");
        System.out.println(seguradora.toString());


        //CADASTRAMENTO E  REMOÇÃO DO CLIENTE PF E PJ  

        //CADASTRAMENTO DO CLIENTE PF
            System.out.println("--------------Agora vamos cadastrar um cliente PF nessa seguradora--------------");
            System.out.println("-------------É necessário informar um CPF valido para cadastrar o cliente------------"+"\n");
            System.out.println("Informe qual será o nome do cliente: ");
            String nome_clientePF = leitor.nextLine();
            System.out.println("Informe qual o endereco do cliente :");
            String endereco_clientePF = leitor.nextLine();
            System.out.println("Informe qual a data de licenca do cliente :");
            String data_auxPF = leitor.nextLine();
            Date dataLicenca_ClientePF = formata_data.parse(data_auxPF);
            System.out.println("Informe qual a nivel educacional do cliente :");
            String educacao_ClientePF = leitor.nextLine();
            System.out.println("Informe qual o genero do cliente :");
            String genero_ClientePF = leitor.nextLine();
            System.out.println("Informe qual a classe economica do cliente :");
            String classeEconomica_ClientePF = leitor.nextLine();
            System.out.println("Informe qual o CPF do cliente");
            String CPF_clientePF = leitor.nextLine();
            System.out.println("Informe qual a data de nascimento do cliente ");
            String dataNascimento_auxPF = leitor.nextLine();
            Date dataNascimento_ClientePF = formata_data.parse(dataNascimento_auxPF);
            seguradora.cadastrarCliente(nome_clientePF,endereco_clientePF,dataLicenca_ClientePF,educacao_ClientePF,genero_ClientePF,classeEconomica_ClientePF,CPF_clientePF,dataNascimento_ClientePF);
            System.out.println("-----------------Cliente Cadastrado com sucesso--------------- "+"\n");
            System.out.println(seguradora.obter_cliente(CPF_clientePF));

        //CADASTRAMENTO DO CLIENTE PJ
            System.out.println("Agora vamos cadastrar um cliente PJ nessa seguradora"+"\n");
            System.out.println("É necessário informar um CNPJ valido para cadastrar a Empresa"+"\n");
            System.out.println("Informe qual será o nome do Empresa: ");
            String nome_clientePJ = leitor.nextLine();
            System.out.println("Informe qual o endereco do Empresa :");
            String endereco_clientePJ = leitor.nextLine();
            System.out.println("Informe qual a data de licenca do Empresa :");
            String data_auxPJ = leitor.nextLine();
            Date dataLicenca_ClientePJ = formata_data.parse(data_auxPJ);
            System.out.println("Informe qual a nivel educacional do Empresa :");
            String educacao_ClientePJ = leitor.nextLine();
            System.out.println("Informe qual o genero do cliente :");
            String genero_ClientePJ = leitor.nextLine();
            System.out.println("Informe qual a classe economica do Empresa :");
            String classeEconomica_ClientePJ = leitor.nextLine();
            System.out.println("Informe qual o CNPJ do cliente");
            String CNPJ_clientePJ = leitor.nextLine();
            System.out.println("Informe qual a data de fundacao da Empresa ");
            String dataFundacao_auxpPJ = leitor.nextLine();
            Date dataFundacao_ClientePJ = formata_data.parse(dataFundacao_auxpPJ);
            seguradora.cadastrarCliente(nome_clientePJ,endereco_clientePJ,dataLicenca_ClientePJ,educacao_ClientePJ,genero_ClientePJ,classeEconomica_ClientePJ,CNPJ_clientePJ,dataFundacao_ClientePJ);
            System.out.println("----------------Cliente Cadastrado com sucesso --------------"+"\n");
            System.out.println(seguradora.obter_cliente(CNPJ_clientePJ));
          
        //REMOCAO DOS CLIENTES DA LISTA
            System.out.println("------------Vamos remover clientes da lista------------------"+"\n");
            System.out.println("----------------Veja que antes da remoção a lista esta completa ainda----------");
            System.out.println(seguradora.listarclientes());

            System.out.println("-------------Vamos primeiro remover um cliente PF, mas veja que a ordem é independente: ----------------"+"\n");
            System.out.println("Informe o cliente a ser removido: "+"\n");
            String CPX = leitor.nextLine();
            seguradora.removerCliente(CPX);
            System.out.println(seguradora.listarclientes());
            System.out.println("----------------Veja que ocorreu a remoção do cliente -------------------"+"\n");
            System.out.println("Vamos remover o cliente PJ agora "+"\n");
            CPX = leitor.nextLine();
            seguradora.removerCliente(CPX);
            System.out.println(seguradora.listarclientes());
            System.out.println("----------------Veja que ocorreu a remoção do cliente -------------------"+"\n");
     

    
        //VALIDAR CPF E CNPJ

            //VALIDAR CPF
            System.out.println("Vamos verificar o que ocorre quando tentamos utilizar um CPF falso "+"\n"+
                                "Informe um CPF falso"+"\n");
            String CPF_falso = leitor.nextLine();


            String data_teste = "22/04/1990";
            Date dataTeste = formata_data.parse(data_teste);

            ClientePF ClientePF_teste = new ClientePF("teste", "teste", dataTeste, "teste", "teste","teste",CPF_falso, dataTeste);
            if (!ClientePF_teste.validarCPF()){
                //se o cpf for falso ocorre o rpint abaixo
                System.out.println("CPF INVALIDO !!!");
            }
            
            //VALIDAR CNPJ
            System.out.println("Vamos verificar o que ocorre quando tentamos utilizar um CNPJ falso "+"\n"+
                                "Informe um CNPJ falso"+"\n");
            String CNPJ_falso = leitor.nextLine();

            ClientePJ ClientePJ_teste = new ClientePJ("teste", "teste", dataTeste, "teste", "teste","teste",CNPJ_falso, dataTeste);
            if (!ClientePJ_teste.validarcnpj()){
                //se o cnpj for falso ocorre o priint abaixo
                System.out.println("CNPJ INVALIDO !!!");
            }
        
        



    
        //CADASTRAMENTO SEM  REMOÇÃO DO CLIENTE PF E PJ  

          //CADASTRAMENTO DO CLIENTE PF
          System.out.println("--------------Agora vamos cadastrar um cliente PF nessa seguradora--------------");
          System.out.println("-------------É necessário informar um CPF valido para cadastrar o cliente------------"+"\n");
          System.out.println("Informe qual será o nome do cliente: ");
          nome_clientePF = leitor.nextLine();
          System.out.println("Informe qual o endereco do cliente :");
          endereco_clientePF = leitor.nextLine();
          System.out.println("Informe qual a data de licenca do cliente :");
          data_auxPF = leitor.nextLine();
          dataLicenca_ClientePF = formata_data.parse(data_auxPF);
          System.out.println("Informe qual a nivel educacional do cliente :");
          educacao_ClientePF = leitor.nextLine();
          System.out.println("Informe qual o genero do cliente :");
          genero_ClientePF = leitor.nextLine();
          System.out.println("Informe qual a classe economica do cliente :");
          classeEconomica_ClientePF = leitor.nextLine();
          System.out.println("Informe qual o CPF do cliente");
          CPF_clientePF = leitor.nextLine();
          System.out.println("Informe qual a data de nascimento do cliente ");
          dataNascimento_auxPF = leitor.nextLine();
          dataNascimento_ClientePF = formata_data.parse(dataNascimento_auxPF);
          seguradora.cadastrarCliente(nome_clientePF,endereco_clientePF,dataLicenca_ClientePF,educacao_ClientePF,genero_ClientePF,classeEconomica_ClientePF,CPF_clientePF,dataNascimento_ClientePF);
          System.out.println("-----------------Cliente Cadastrado com sucesso--------------- "+"\n");
          System.out.println(seguradora.obter_cliente(CPF_clientePF));
  
          //CADASTRAMENTO DO CLIENTE PJ
          System.out.println("Agora vamos cadastrar um cliente PJ nessa seguradora"+"\n");
          System.out.println("É necessário informar um CNPJ valido para cadastrar a Empresa"+"\n");
          System.out.println("Informe qual será o nome do Empresa: ");
          nome_clientePJ = leitor.nextLine();
          System.out.println("Informe qual o endereco do Empresa :");
          endereco_clientePJ = leitor.nextLine();
          System.out.println("Informe qual a data de licenca do Empresa :");
          data_auxPJ = leitor.nextLine();
          dataLicenca_ClientePJ = formata_data.parse(data_auxPJ);
          System.out.println("Informe qual a nivel educacional do Empresa :");
          educacao_ClientePJ = leitor.nextLine();
          System.out.println("Informe qual o genero do cliente :");
          genero_ClientePJ = leitor.nextLine();
          System.out.println("Informe qual a classe economica do Empresa :");
          classeEconomica_ClientePJ = leitor.nextLine();
          System.out.println("Informe qual o CNPJ do cliente");
          CNPJ_clientePJ = leitor.nextLine();
          System.out.println("Informe qual a data de fundacao da Empresa ");
          dataFundacao_auxpPJ = leitor.nextLine();
          dataFundacao_ClientePJ = formata_data.parse(dataFundacao_auxpPJ);
          seguradora.cadastrarCliente(nome_clientePJ,endereco_clientePJ,dataLicenca_ClientePJ,educacao_ClientePJ,genero_ClientePJ,classeEconomica_ClientePJ,CNPJ_clientePJ,dataFundacao_ClientePJ);
          System.out.println("----------------Cliente Cadastrado com sucesso --------------"+"\n");
          System.out.println(seguradora.obter_cliente(CNPJ_clientePJ));
        

        //VAMOS AGORA INSTANCIAR VEICULOS NOS CLIENTES DA LISTA

        System.out.println("----------------Vamos adcionar um carro ao cliente PF primeiro------------------------"+"\n");
        System.out.println("Informe a Placa do Veiculo");
        String placa_PF = leitor.nextLine();
        System.out.println("Informe a Marca do Veiculo");
        String marca_PF = leitor.nextLine();
        System.out.println("Informe o Modelo do Veiculo");
        String modelo_PF = leitor.nextLine();
        System.out.println("Informe o Ano de fabricacao do Veiculo");
        int anoFabricacao_PF = leitor.nextInt();
        leitor.nextLine();//necessario para corrigir um "bug" que o enter é lido após usar nextInt ou qualquer tipo
        seguradora.obter_cliente(CPF_clientePF).adciona_veiculo(placa_PF, marca_PF, modelo_PF,anoFabricacao_PF);
        System.out.println("-----------Carro cadastrado com sucesso------------");
        System.out.println(seguradora.obter_cliente(CPF_clientePF).listar_veiculos());
    
        System.out.println("----------------Vamos adcionar um carro ao cliente PJ ------------------------"+"\n");
        System.out.println("Informe a Placa do Veiculo");
        String placa_PJ = leitor.nextLine();
        System.out.println("Informe a Marca do Veiculo");
        String marca_PJ = leitor.nextLine();
        System.out.println("Informe o Modelo do Veiculo");
        String modelo_PJ = leitor.nextLine();
        System.out.println("Informe o Ano de fabricacao do Veiculo");
        int anoFabricacao_PJ = leitor.nextInt();
        leitor.nextLine();//necessario para corrigir um "bug" que o enter é lido após usar nextInt ou qualquer tipo
        seguradora.obter_cliente(CNPJ_clientePJ).adciona_veiculo(placa_PJ, marca_PJ, modelo_PJ,anoFabricacao_PJ);
        System.out.println("-----------Carro cadastrado com sucesso------------");
        System.out.println(seguradora.obter_cliente(CNPJ_clientePJ).listar_veiculos());
        

        //VAMOS AGORA INSTANCIAR SINISTROS
        System.out.println("---------------vamos instanciar um sinistro--------------"+"\n");
        System.out.println("Informe a data que ocorreu o acidente: ");
        String dataSinistro_aux = leitor.nextLine();
        Date data_Sinistro = formata_data.parse(dataSinistro_aux);
        System.out.println("Informe o endereco do Sinistro: ");
        String endereco_Sinistro = leitor.nextLine();
        System.out.println("Informe a placa do veiculo : ");
        String placa_sinistro = leitor.nextLine();
        System.out.println("Informe o cpf ou cnpj do cliente : ");
        String CPX_aux = leitor.nextLine();
        Veiculo veiculo_aux = (seguradora.obter_cliente(CPX_aux)).obter_veiculo(placa_sinistro);


        seguradora.gerarSinistro(data_Sinistro,endereco_Sinistro,seguradora,veiculo_aux,seguradora.obter_cliente(CPX_aux));
        System.out.println("---------------Sinistro adcionado com sucesso--------------"+"\n");
        System.out.println(seguradora.listarSinistros());

        //POR FIM VAMOS BUSCAR UM SINISTRO PELO ID

        System.out.println("---------------Vamos buscar um sinistro pelo ID --------------"+"\n");
            //FUNCIONOU EM UM TESTE DE INSTANCIAMENTO MANUAL
            if(seguradora.buscar_sinistro(seguradora.obter_Sinistro(placa_sinistro).getID())){
                // veja que -->seguradora.obter_Sinistro(placa_sinistro).getID()<-- retorna um ID para a funçao buscar_sinistro
                System.out.println("Sinistro encontrado!!!");
                System.out.println(seguradora.obter_Sinistro(placa_sinistro).toString());
            }
    }
}