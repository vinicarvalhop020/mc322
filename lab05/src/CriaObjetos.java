import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


//Classe que é uma fabrica de criar objetos

public class CriaObjetos {

    public static ClientePF cria_ClientePF() throws ParseException{
        SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");

        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe qual será o nome do cliente: ");
        String nome = leitor.nextLine();

        System.out.println("Informe qual o telefone do cliente: ");
        String telefone = leitor.nextLine();
        
        System.out.println("Informe qual o endereco do cliente :");
        String endereco = leitor.nextLine();

        System.out.println("Informe qual o email do cliente :");
        String email = leitor.nextLine();

        System.out.println("Informe qual o cpf do cliente :");
        String cpf = leitor.nextLine();
        
        System.out.println("Informe qual o genero do cliente :");
        String genero = leitor.nextLine();

        System.out.println("Informe qual a nivel educacional do cliente :");
        String educacao = leitor.nextLine();

        System.out.println("Informe qual a data de licenca do cliente :");
        String data_auxPF = leitor.nextLine();
        Date dataNascimento;
        dataNascimento = formata_data.parse(data_auxPF);

        if (Validacao.validarCPF(cpf) && Validacao.validar_nome(nome)){

            System.out.println("Cliente PF cadastrado com sucesso!");
            ClientePF ClientePF = new ClientePF(nome, telefone , endereco , email , cpf, genero, educacao, dataNascimento);
            System.out.println("ClientePF criado com sucesso! ");
            return ClientePF;

        }
        else{
            if (!Validacao.validarCPF(cpf)){
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

        System.out.println("Informe qual o telefone da empresa");
        String telefone = leitor.nextLine();

        System.out.println("Informe qual o endereco da empresa :");
        String endereco = leitor.nextLine();
        
        System.out.println("Informe qual o email da empresa :");
        String email = leitor.nextLine();

        System.out.println("Informe qual o CNPJ da empresa");
        String cnpj = leitor.nextLine();

        System.out.println("Informe quando a empresa foi fundada :");
        String dataFundacao_aux = leitor.nextLine();
        Date dataFundacao = formata_data.parse(dataFundacao_aux);
        
        if(Validacao.validarcnpj(cnpj) && Validacao.validar_nome(nome)){
            System.out.println("ClientePJ cadastrado com sucesso! ");
            ClientePJ clientePJ = new ClientePJ(nome, telefone, endereco, email, cnpj,dataFundacao);
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

    public static Condutor criaCondutor()throws ParseException{

        SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");

        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe qual o cpf do condutor: ");
        String cpf = leitor.nextLine();

        System.out.println("Informe qual o nome do condutor: ");
        String nome = leitor.nextLine();
        
        System.out.println("Informe qual o telefone do condutor :");
        String telefone = leitor.nextLine();

        System.out.println("Informe qual o endereco do condutor :");
        String endereco = leitor.nextLine();

        System.out.println("Informe qual o email do condutor :");
        String email = leitor.nextLine();

        System.out.println("Informe qual a data de nascimento do condutor :");
        String data_auxPF = leitor.nextLine();
        Date dataNascimento;
        dataNascimento = formata_data.parse(data_auxPF);

        return new Condutor(cpf, nome, telefone, endereco, email, dataNascimento, false);


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
        return new Veiculo(placa, marca, modelo, ano);

    }

    public static Frota criarFrota(){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe qual o codigo da sua frota: ");
        String codigo = leitor.nextLine();
        
        Frota novaFrota = new Frota(codigo);
        
        return novaFrota;
    }

    public static Sinistro criaSinistro(Condutor condutor, Seguro seguro) throws ParseException{
        //Só faz sentido a existencia de um sinistro se existe um veiculo uma seguradora e um cliente desse sinistro
        
        SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");
        Scanner leitor = new Scanner(System.in);


        System.out.println("Informe a data de ocorrencia do sinistro :");
        String dataOcorrencia_aux = leitor.nextLine();
        Date data = formata_data.parse(dataOcorrencia_aux);

        System.out.println("Informe o endereco: ");
        String endereco = leitor.nextLine();

        System.out.println("Sinistro criado com sucesso! ");

        return new Sinistro(data,endereco,condutor,seguro);

    }

    public static Seguro criaSeguroPF(Seguradora seguradora, Veiculo veiculo, Cliente cliente) throws ParseException{
        
        SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");
        Scanner leitor = new Scanner(System.in);


        System.out.println("Informe a data de inicio do seguro :");
        String datainicioAux = leitor.nextLine();
        Date DataInicio = formata_data.parse(datainicioAux);

        String datafimAux = leitor.nextLine();
        Date DataFim = formata_data.parse(datafimAux);

        System.out.println("Seguro criado com sucesso! ");

        return new SeguroPF(DataInicio, DataFim, seguradora, veiculo, cliente);
    }

    public static Seguro criaSeguroPJ(Seguradora seguradora,Frota frota,Cliente clientePJ) throws ParseException{

        SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");
        Scanner leitor = new Scanner(System.in);


        System.out.println("Informe a data de inicio do seguro :");
        String datainicioAux = leitor.nextLine();
        Date DataInicio = formata_data.parse(datainicioAux);

        String datafimAux = leitor.nextLine();
        Date DataFim = formata_data.parse(datafimAux);

        System.out.println("Seguro criado com sucesso! ");

        return new SeguroPJ(DataInicio, DataFim, null, null, null);

    }

    public static Seguradora criaSeguradora(){

            Scanner leitor = new Scanner(System.in);

            System.out.println("Digite o CNPJ da seguradora: ");
            String cnpj = leitor.nextLine(); 

            if(Validacao.validarcnpj(cnpj)){

                System.out.println("Digite um nome para a seguradora: ");
                String nome = leitor.nextLine(); 

                System.out.println("Digite um telefone para a seguradora: ");
                String telefone = leitor.nextLine(); 

                System.out.println("Digite um email para a seguradora: ");
                String email = leitor.nextLine();

                System.out.println("Digite um endereco para a seguradora: ");
                String endereco = leitor.nextLine(); 
                System.out.println("Seguradora criada com sucesso! ");

                return new Seguradora(cnpj, nome, telefone, email, endereco);

            }

            else{
                System.out.println("cnpj invalido!");
                return null;
            }
        }
    }

//implementar os cadastros dentro da main