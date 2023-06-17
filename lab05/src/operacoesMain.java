//funçao estatica, melhor organizacao do codigo
//executo as operacoes "CASE" da main;

import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;

public class operacoesMain {

    public static void cadastrarClientePF(ArrayList<Seguradora> seguradoras) throws ParseException{

        Scanner scan = new Scanner(System.in);
        String cnpj;
        cnpj = perguntaSeguradora();
        Seguradora Seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpj);

        if(cnpj != null){
                ClientePF clientePF = CriaObjetos.cria_ClientePF();
                if(clientePF != null){
                    Seguradora_aux.cadastrarCliente(clientePF);
                    //System.out.println("O valor do seguro atual é :" + clientePF.getValorSeguro()+ "");
                }
                else{
                    System.out.println("Cliente não Cadastrado");
                }
                if(Seguradora_aux == null){
                    System.out.println("Cliente não Cadastrado, seguradora inexistente");
                    }
                else{
                    System.out.println("Cliente não Cadastrado, o cnpj da seguradora é INVALIDO");
                }
            }
        else
            return;
        }

    

    public static void cadastrarClientePJ(ArrayList<Seguradora> seguradoras) throws ParseException{

        Scanner scan = new Scanner(System.in);
        String cnpj;
        cnpj = perguntaSeguradora();

        if(cnpj != null){
            ClientePJ clientePJ = CriaObjetos.cria_ClientePJ();
            Seguradora Seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpj);
            if(clientePJ != null){
                Seguradora_aux.cadastrarCliente(clientePJ);
                //System.out.println("O valor do seguro atual é :" + clientePJ.getValorSeguro()+ "");
            }
            else{
                System.out.println("Cliente não Cadastrado");
            }
            if(Seguradora_aux == null){
                System.out.println("Cliente não Cadastrado, seguradora inexistente");
                }
            else{
                System.out.println("Cliente não Cadastrado, o cnpj da seguradora é INVALIDO");
                }
            }
        else 
            return;
        }
    

    public static void cadastrarCondutor(ArrayList<Seguradora> seguradoras)throws ParseException{

        String cnpjSeg = perguntaSeguradora();
        if(cnpjSeg != null){
            int id = perguntaSeguro();
            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeg);
            Seguro seguro = AuxilarSeguradora.obterSeguro(seguradora, id);
            Condutor novoCondutor = CriaObjetos.criaCondutor();
            seguro.adcionarCondutor(novoCondutor);
        }
        else
            return;
    }
    
    public static void cadastrarVeiculoPF(ArrayList<Seguradora> seguradoras){

        Scanner scan = new Scanner(System.in);
        String cnpjSeguradora;
        String cpfCliente;

        System.out.println("\n");
        cnpjSeguradora = perguntaSeguradora();
        cpfCliente = perguntaCliente();

            if (cnpjSeguradora != null && cpfCliente != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Cliente Cliente = AuxilarSeguradora.obterCliente(seguradora_aux, cpfCliente);

            Veiculo novoVeiculo = CriaObjetos.criarVeiculo();

            if(Cliente != null && seguradora_aux != null){
                ((ClientePF)Cliente).cadastrarVeiculo(novoVeiculo);
            }
            else{
                System.out.println("Seguradora ou cliente invalido:\n");
            }
            seguradora_aux.atualizaValorSeguros();
        }
            else 
                return;
    }

    public static void cadastrarVeiculoPJ(ArrayList<Seguradora> seguradoras){
        //cadastra um veiculo em uma frota
        Scanner scan = new Scanner(System.in);
        
        String cnpjSeguradora;
        String cnpjCliente;

        cnpjSeguradora = perguntaSeguradora();
        cnpjCliente = perguntaCliente();

        if(cnpjCliente != null && cnpjSeguradora != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Cliente Cliente = AuxilarSeguradora.obterCliente(seguradora_aux, cnpjCliente);

            if(Cliente != null && seguradora_aux != null){
                ((ClientePJ)Cliente).atualizarFrota(EnumAtualizaFrota.ADCIONA_VEICULO);
            }
            else{
                System.out.println("Seguradora ou cliente invalido:\n");
            }
            seguradora_aux.atualizaValorSeguros();
        }
        else 
            return;
    }

    public static void cadastrarFrota(ArrayList<Seguradora> seguradoras){

        Scanner scan = new Scanner(System.in);
        
        String cnpjSeguradora = perguntaSeguradora();
        String cnpjCliente = perguntaCliente();

        if(cnpjCliente != null && cnpjSeguradora != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Cliente Cliente = AuxilarSeguradora.obterCliente(seguradora_aux, cnpjCliente);

            if(Cliente != null && seguradora_aux != null){
                ((ClientePJ)Cliente).cadastrarFrota(CriaObjetos.criarFrota());
                System.out.println("Frota cadastrada com Sucesso!\n");
            }
            else{
                System.out.println("Seguradora ou cliente invalido!\n");
            }
            seguradora_aux.atualizaValorSeguros();
        }
        else 
            return;
    }   
  
    public static void cadastrarSeguradora(ArrayList<Seguradora> seguradoras){

        Seguradora seguradora_aux = CriaObjetos.criaSeguradora();

        if (seguradora_aux != null){//retorno null significa que o cnpj era invalido
            seguradoras.add(seguradora_aux);
            System.out.println("Seguradora cadastrada com sucesso!");
        }
        else
            System.out.println("Seguradora não cadastrada!");
    }

    public static void listarClientePorSeg(ArrayList<Seguradora> seguradoras){

        Scanner scan = new Scanner(System.in);
        String cnpjSeguradora;
        ArrayList<Cliente> ClientesDaSeg = new ArrayList<Cliente>();

        cnpjSeguradora = perguntaSeguradora();

        
        if(cnpjSeguradora != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            if(seguradora_aux != null){
                ClientesDaSeg = seguradora_aux.listarclientes();
                System.out.println(AuxiliarCliente.listarClientesStr(ClientesDaSeg));
            }
            else{
                System.out.println("Seguradora invalida");
            }
        
        }
        else 
            return;

    }

    public static void listarSinistrosPorSeg(ArrayList<Seguradora> seguradoras){

        Scanner scan = new Scanner(System.in);
        String cnpjSeguradora;
        ArrayList<Seguro> SegurosDaSeg = new ArrayList<Seguro>();
        ArrayList<Sinistro> SinistroDoSeg = new ArrayList<Sinistro>();
        
        cnpjSeguradora = perguntaSeguradora();

        if(cnpjSeguradora != null){

            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            if(seguradora_aux != null){
                SegurosDaSeg = seguradora_aux.listarseguros();

                System.out.println("Seguros da seguradora " + seguradora_aux.getNome());
                for(Seguro segurols : SegurosDaSeg){
                    SinistroDoSeg = segurols.getLSinistros();//salva em uma array a lista de sinistros de um determinado seguro da seguradora escolhida
                    System.out.println(AuxiliarCliente.listarSinistrosStr(SinistroDoSeg));
                }
            }
            else{
                System.out.println("Seguradora invalida");
            }   
       }
       else 
        return;
    }

    public static void listarSinistrosPorCli(ArrayList<Seguradora> seguradoras){
        
        Scanner scan = new Scanner(System.in);

        ArrayList<Sinistro> Sinistros = new ArrayList<Sinistro>();

        String cnpjSeguradora;
        String identificadorCliente;

        cnpjSeguradora = perguntaSeguradora();
        identificadorCliente = perguntaCliente();

       
        if(cnpjSeguradora != null && identificadorCliente != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Cliente cliente  = AuxilarSeguradora.obterCliente(seguradora_aux, identificadorCliente);

            Sinistros = seguradora_aux.getSinistrosPorCliente(cliente);

            System.out.println(AuxiliarCliente.listarSinistrosStr(Sinistros));
        }
        else    
            return;
        
    }

    public static void listarCondutoresCl(ArrayList<Seguradora> seguradoras){
        
        Scanner scan = new Scanner(System.in);

        ArrayList<Seguro> seguros = new ArrayList<Seguro>();

        String cnpjSeguradora;
        String identificadorCliente;

        cnpjSeguradora = perguntaSeguradora();
        identificadorCliente = perguntaCliente();

       
        if(cnpjSeguradora != null && identificadorCliente != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Cliente cliente = AuxilarSeguradora.obterCliente(seguradora_aux, identificadorCliente);
            seguros = seguradora_aux.getSegurosPorCliente(cliente);
            for (Seguro seguro: seguros){
                System.out.println(AuxiliarCliente.listarCondutoresStr(seguro.getLCondutores()));
                }
        }
        else    
            return;
        
    }


    public static void listarSegurosSeg(ArrayList<Seguradora> seguradoras){

        Scanner scan = new Scanner(System.in);

        ArrayList<Seguro> seguros = new ArrayList<Seguro>();

        String cnpjSeguradora;

        cnpjSeguradora = perguntaSeguradora();

        if(cnpjSeguradora != null){

            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);

            seguros = seguradora_aux.listarseguros();

            System.out.println(AuxiliarCliente.listarSegurosStr(seguros));
        }
        else
            return;
    }

    public static void listarSegurosCli(ArrayList<Seguradora> seguradoras){
    Scanner scan = new Scanner(System.in);

    ArrayList<Seguro> seguros = new ArrayList<Seguro>();

    String cnpjSeguradora;
    String identificadorCliente;

    identificadorCliente = perguntaCliente();
    cnpjSeguradora = perguntaSeguradora();

    if(cnpjSeguradora != null && identificadorCliente != null){

        Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
        Cliente Cliente_aux = AuxilarSeguradora.obterCliente(seguradora_aux, identificadorCliente);

        seguros = seguradora_aux.getSegurosPorCliente(Cliente_aux);

        System.out.println(AuxiliarCliente.listarSegurosStr(seguros));
    }

    else
        return;
    }

    public static void listarVeiculosPF(ArrayList<Seguradora> seguradoras){
        Scanner scan = new Scanner(System.in);

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    
        String cnpjSeguradora;
        String identificadorCliente;
    
        cnpjSeguradora = perguntaSeguradora();
        identificadorCliente = perguntaCliente();
    
        if(cnpjSeguradora != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Cliente Cliente_aux = AuxilarSeguradora.obterCliente(seguradora_aux, identificadorCliente);

            veiculos = ((ClientePF)Cliente_aux).getVeiculos();

            System.out.println(AuxiliarCliente.listarVeiculosStr(veiculos));
        }
        else 
            return;
    }

    public static void listarFrotaPJ(ArrayList<Seguradora> seguradoras){
        Scanner scan = new Scanner(System.in);

        ArrayList<Frota> frotas = new ArrayList<Frota>();
    
        String cnpjSeguradora;
        String identificadorCliente;
    
        cnpjSeguradora = perguntaSeguradora();   
        identificadorCliente = perguntaCliente();

        if(cnpjSeguradora != null && identificadorCliente != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Cliente Cliente_aux = AuxilarSeguradora.obterCliente(seguradora_aux, identificadorCliente);
            
            frotas = ((ClientePJ)Cliente_aux).getListaFrota();

            System.out.println(AuxiliarCliente.listarFrotaStr(frotas));
            seguradora_aux.atualizaValorSeguros();
        }
        else
            return;
    }
   
    public static void excluirCliente(ArrayList<Seguradora> seguradoras){
        String cnpjSeg = perguntaSeguradora();
        if(cnpjSeg != null){
            Seguradora seguradora_aux = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeg);
            String identificador_cliente = perguntaCliente();
            seguradora_aux.removerCliente(identificador_cliente);
            seguradora_aux.atualizaValorSeguros();
        }
        else 
            return;
    }

    public static void excluirCondutor(ArrayList<Seguradora> seguradoras){

        String cnpjSeg = perguntaSeguradora();
        String identificador = perguntaCliente();
        String cpfCondutor = perguntaCondutor();

        if(cnpjSeg != null && identificador != null && cpfCondutor != null){
        Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeg);
        Cliente cliente = AuxilarSeguradora.obterCliente(seguradora, identificador);
        ArrayList<Seguro> segurosCL = new ArrayList<Seguro>();
        segurosCL = seguradora.getSegurosPorCliente(cliente);
        
        for(Seguro seguro : segurosCL){
            seguro.excluirCondutor(cpfCondutor);
        }
        seguradora.atualizaValorSeguros();
        }
        else    
            return;



    }

    public static void excluirFrota(ArrayList<Seguradora> seguradoras){

        String cnpjSeg = perguntaSeguradora();
        String identificador = perguntaCliente();
        if(cnpjSeg != null && identificador != null){
        Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeg);
        Cliente cliente = AuxilarSeguradora.obterCliente(seguradora, identificador);

        ((ClientePJ)cliente).atualizarFrota(EnumAtualizaFrota.REMOVE_FROTA);
        seguradora.atualizaValorSeguros();
        }
        else
            return;


    }
    
    public static void excluirVeiculoFr(ArrayList<Seguradora> seguradoras){

        String cnpjSeg = perguntaSeguradora();
        String identificador = perguntaCliente();

        
        Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeg);
        Cliente cliente = AuxilarSeguradora.obterCliente(seguradora, identificador);
        if(cnpjSeg != null && identificador != null){
        ((ClientePJ)cliente).atualizarFrota(EnumAtualizaFrota.REMOVE_VEICULO);
        seguradora.atualizaValorSeguros();
        }
        else
            return;

    }
    
    public static void excluirVeiculoPf(ArrayList<Seguradora> seguradoras){

        String cnpjSeg = perguntaSeguradora();
        String identificador = perguntaCliente();

        if(cnpjSeg != null && identificador != null){
            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeg);
            Cliente cliente = AuxilarSeguradora.obterCliente(seguradora, identificador);
            String placa = perguntaVeiculo();
            Veiculo veiculo = AuxiliarCliente.obter_veiculo(placa, ((ClientePF)cliente).getVeiculos());
            ((ClientePF)cliente).removerVeiculo(veiculo);
            seguradora.atualizaValorSeguros();
        }
        else 
            return;

    }
    
    public static void excluirSeguro(ArrayList<Seguradora> seguradoras){

        String cnpjSeg = perguntaSeguradora();
        if(cnpjSeg != null){
            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeg);
            int id = perguntaSeguro();
            Seguro seguro = AuxilarSeguradora.obterSeguro(seguradora,id);
            seguradora.cancelarSeguro(seguro);
            seguradora.calcularReceita();
        }
        else
            return;

    }

    public static void excluirSinistro(ArrayList<Seguradora> seguradoras){
        //REVER
        String cnpjSeg = perguntaSeguradora();
        int idSinistro = perguntaSinistro();
        if (cnpjSeg != null){
            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeg);
            Sinistro sinistro = AuxilarSeguradora.obterSinistro(seguradora,idSinistro);
            seguradora.removerSinistro(sinistro);
            seguradora.atualizaValorSeguros();
        }
        else return;
    }

    public static void gerarSeguroPF(ArrayList<Seguradora> seguradoras)throws ParseException{

        //Só faz sentido gerar um seguro se existe um veiculo
        String cnpjSeguradora = perguntaSeguradora();
        String cpfCliente = perguntaCliente();
        String placaVeiculoSegurado = perguntaVeiculo();

        if(cnpjSeguradora != null && cpfCliente != null){
            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Cliente clientePF = AuxilarSeguradora.obterCliente(seguradora, cpfCliente);
            Veiculo veiculo = AuxiliarCliente.obter_veiculo(placaVeiculoSegurado, ((ClientePF)clientePF).getVeiculos());
            

            Seguro novoSeguroPF = CriaObjetos.criaSeguroPF(seguradora, veiculo, clientePF);

            seguradora.gerarSeguro(novoSeguroPF);
        }
        else   
            return;

    }

    public static void gerarSeguroPJ(ArrayList<Seguradora> seguradoras)throws ParseException{

        //Só faz sentido gerar um seguro se existe uma frota
        String cnpjSeguradora = perguntaSeguradora();
        String cnpjCliente = perguntaCliente();
        String codeFrota = perguntaFrota();

        if(cnpjSeguradora != null && cnpjCliente != null){
        Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
        Cliente clientePJ = AuxilarSeguradora.obterCliente(seguradora, cnpjCliente);
        Frota frota = AuxiliarCliente.ObterFrota(codeFrota, ((ClientePJ)clientePJ).getListaFrota());
    
        Seguro novoSeguroPJ = CriaObjetos.criaSeguroPJ(seguradora,frota,clientePJ);
        seguradora.gerarSeguro(novoSeguroPJ);
        }
        else    
            return;
    }
        
    public static void gerarSinistro(ArrayList<Seguradora> seguradoras)throws ParseException{
        //qual a seguradora?qual o cliente?qual o seguro? a funcao de gerar um sinistro é do seguro
        //para gerar um sinistro eu preciso do condutor tbm, note que na classe condutor tem o metodo de adcionar sinistro

        String cnpjSeguradora = perguntaSeguradora();
        int seguroid = perguntaSeguro();
        String cpfCondutor = perguntaCondutor();

        if(cnpjSeguradora != null && cpfCondutor != null){
            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Seguro seguro = AuxilarSeguradora.obterSeguro(seguradora, seguroid);
        
            seguro.gerarSinistro(cpfCondutor);
            seguro.calcularValor(); //atualiza o valor do seguro
        }
        else 
            return;

    }

    public static void autorizarCondutor(ArrayList<Seguradora> seguradoras){

        String cnpjSeguradora = perguntaSeguradora();
        if (cnpjSeguradora != null){
            int seguroid = perguntaSeguro();
            String cpfCondutor = perguntaCondutor();

            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Seguro seguro = AuxilarSeguradora.obterSeguro(seguradora, seguroid);
        
            seguro.autorizarCondutor(cpfCondutor);
        }
        else 
            return;
    }

    public static void desautorizarCondutor(ArrayList<Seguradora> seguradoras){

        String cnpjSeguradora = perguntaSeguradora();
        if (cnpjSeguradora != null){
            int seguroid = perguntaSeguro();
            String cpfCondutor = perguntaCondutor();

            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            Seguro seguro = AuxilarSeguradora.obterSeguro(seguradora, seguroid);
        
            seguro.desautorizarCondutor(cpfCondutor);
        }
        else 
            return;
    }

    public static void calcularReceita(ArrayList<Seguradora> seguradoras){

        String cnpjSeguradora = perguntaSeguradora();
        if (cnpjSeguradora != null){
            Seguradora seguradora = AuxilarSeguradora.obterSeguradora(seguradoras, cnpjSeguradora);
            atualizaValoresMensais(seguradora);//para garantir que os valores mensais dos seguros estao corretos:)
            Double receita = seguradora.calcularReceita();
            System.out.println(" A receita da seguradora "+seguradora.getNome()+" eh de  "+receita);
        }
        else 
            return;
    }

    public static void atualizaValoresMensais(Seguradora seguradora){

        for(Seguro seguro : seguradora.listarseguros()){
            seguro.calcularValor();
        }

    }

    public static String perguntaSeguradora(){
        //devolve o cnpj seguradora se ele for valido
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o cnpj da Seguradora:\n");
        String cnpjSeguradora = scan.nextLine();
    
        if (!Validacao.validarcnpj(cnpjSeguradora)){
            System.out.println("O cnpj da seguradora é invalido:\n");
            return null;
        }
        else
            return cnpjSeguradora;
    }

    public static String perguntaCliente(){

    Scanner scan = new Scanner(System.in);
    System.out.println("Informe o identificador do cliente:\n");
    String identificador = scan.nextLine();

    if (!Validacao.validar_identificador(identificador)){
        System.out.println("O identificador do cliente é invalido:\n");
        return null;
    }
    else
        return identificador;
    }

    public static String perguntaCondutor(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o cpf do condutor:\n");
        String identificador = scan.nextLine();
    
        if (!Validacao.validarCPF(identificador)){
            System.out.println("O CPF do condutor é invalido:\n");
            return null;
        }
        else
            return identificador;
        }

    public static String perguntaVeiculo(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe a placa do veiculo:\n");
        String placa = scan.nextLine();
        
        return placa;
    }

    public static int perguntaSeguro(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o ID do seguro:\n");
        int id = scan.nextInt();
        scan.nextLine();

        return id;
    }

    public static int perguntaSinistro(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o ID do sinistro:\n");
        int id = scan.nextInt();
        scan.nextLine();

        return id;
    }

    public static String perguntaFrota(){

    Scanner scan = new Scanner(System.in);
    System.out.println("Informe o codigo da frota:\n");
    String code = scan.nextLine();

    return code;
    }

}

    



