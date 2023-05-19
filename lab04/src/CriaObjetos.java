import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class CriaObjetos {
//tem a função de criar objetos 

    public static ClientePF cria_ClientePF() throws ParseException{
        SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");


        Scanner leitor = new Scanner(System.in);


        System.out.println("Informe qual será o nome do cliente: ");
        String nome = leitor.nextLine();

        System.out.println("Informe qual o endereco do cliente :");
        String endereco = leitor.nextLine();

        System.out.println("Informe qual a data de licenca do cliente :");
        String data_auxPF = leitor.nextLine();
        Calendar dataLicenca = Calendar.getInstance();
        dataLicenca.setTime(formata_data.parse(data_auxPF));

        System.out.println("Informe qual a nivel educacional do cliente :");
        String educacao = leitor.nextLine();

        System.out.println("Informe qual o genero do cliente :");
        String genero = leitor.nextLine();

        System.out.println("Informe qual a classe economica do cliente :");
        String classeEconomica = leitor.nextLine();

        System.out.println("Informe qual o CPF do cliente");
        String CPF = leitor.nextLine();

        System.out.println("Informe qual a data de nascimento do cliente ");
        String dataNascimento_auxPF = leitor.nextLine();
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(formata_data.parse(dataNascimento_auxPF));


        if (Validacao.validarCPF(CPF) && Validacao.validar_nome(nome)){

            System.out.println("Cliente PF cadastrado com sucesso!");
            ClientePF ClientePF = new ClientePF(nome, endereco, CPF, genero, dataLicenca, educacao, dataNascimento, classeEconomica);
            System.out.println("ClientePF criado com sucesso! ");
            return ClientePF;

        }
        else{
            if (!Validacao.validarCPF(CPF)){
                System.out.println("CPF INVALIDO :");
            }
            if (!Validacao.validar_nome(nome)){
                System.out.println("NOME INVALIDO :");
            }
                return null;
            }
        }
    

        public static ClientePJ cria_ClientePJ() throws ParseException{

            SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");
            Scanner leitor = new Scanner(System.in);

            System.out.println("Informe qual será o nome da Empresa: ");
            String nome = leitor.nextLine();

            System.out.println("Informe qual o CNPJ da empresa");
            String cnpj = leitor.nextLine();
            System.out.println("Informe qual o endereco da empresa :");
            String endereco = leitor.nextLine();

            System.out.println("Informe quando a empresa foi fundada :");
            String dataFundacao_aux = leitor.nextLine();
            Calendar dataFundacao = Calendar.getInstance();
            dataFundacao.setTime(formata_data.parse(dataFundacao_aux));

            System.out.println("Informe a quantidade de funcionarios na empresa");
            int qtdeFuncionarios = leitor.nextInt();
            leitor.nextLine();

            if(Validacao.validarcnpj(cnpj) && Validacao.validar_nome(nome)){
                System.out.println("ClientePJ cadastrado com sucesso! ");
                ClientePJ clientePJ = new ClientePJ(cnpj, nome, endereco, dataFundacao, qtdeFuncionarios);
                System.out.println("ClientePJ criado com sucesso! ");
                return clientePJ;

            }
            else{
                if (!Validacao.validarcnpj(cnpj)){
                    System.out.println("CNPJ INVALIDO");
                }
                if  (!Validacao.validar_nome(nome)){
                    System.out.println("NOME INVALIDO");
                }
                return null;
            }

        }
        
        public static Veiculo criarVeiculo(){
            Scanner leitor = new Scanner(System.in);

            System.out.println("Informe qual a placa do veiculo: ");
            String placa = leitor.nextLine();

            System.out.println("Informe a marca do veiculo: ");
            String marca = leitor.nextLine();

            System.out.println("Informe o modelo do veiculo: ");
            String modelo = leitor.nextLine();

            System.out.println("Informe o ano de fabricacao do veiculo: ");
            int ano = leitor.nextInt();
            leitor.nextLine();
            System.out.println("Veiculo criado com sucesso! ");
            System.out.println("****************************************************");
            return new Veiculo(placa, marca, modelo, ano);

        }

        public static Sinistro criaSinistro(Veiculo veiculo, Seguradora seguradora, Cliente cliente) throws ParseException{
            //Só faz sentido a existencia de um sinistro se existe um veiculo uma seguradora e um cliente desse sinistro
            
            SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");
            Scanner leitor = new Scanner(System.in);


            System.out.println("Informe a data de ocorrencia do sinistro :");
            String dataOcorrencia_aux = leitor.nextLine();
            Calendar dataOcorrencia = Calendar.getInstance();
            dataOcorrencia.setTime(formata_data.parse(dataOcorrencia_aux));

            System.out.println("Informe o endereco: ");
            String endereco = leitor.nextLine();
            System.out.println("Sinistro criado com sucesso! ");
            System.out.println("****************************************************");

            return new Sinistro(dataOcorrencia, endereco, seguradora, veiculo, cliente);

        }

        public static Seguradora criaSeguradora(){

            Scanner leitor = new Scanner(System.in);

            System.out.println("Digite um nome para a seguradora: ");
            String nome = leitor.nextLine(); 

            System.out.println("Digite um telefone para a seguradora: ");
            String telefone = leitor.nextLine(); 

            System.out.println("Digite um email para a seguradora: ");
            String email = leitor.nextLine();

            System.out.println("Digite um endereco para a seguradora: ");
            String endereco = leitor.nextLine(); 
            System.out.println("Seguradora criada com sucesso! ");
            System.out.println("****************************************************");


            return new Seguradora(nome, telefone, email, endereco);
        }
    }

//implementar os cadastros dentro da main