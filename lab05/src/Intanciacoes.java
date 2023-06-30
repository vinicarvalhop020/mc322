import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



public class Intanciacoes{
    //instanciacoes, que ocorrem antes do menu iniciar

    public static void instanciacoes(ArrayList<Seguradora> seguradoras)throws ParseException{

        System.out.println("---------------COMECO DAS INSTANCIACOES------------------"+"\n");

        System.out.println("Criacao seguradora: " + "\n");
        SimpleDateFormat formata_data = new SimpleDateFormat("dd/MM/yyyy");
        
        /*CRIACAO DE MULTIPLOS OBJETOS */
        //CRIACAO SEGURADORAS
        Seguradora seguradora1 = new Seguradora("55.789.315/0001-51","JoseSeguros","1987735250","JoseSegurosComercial@gmail.com","Rua Manoel silveiro,253");
        //System.out.println(seguradora1.toString());
        Seguradora seguradora2 = new Seguradora("31.329.291/0001-90","CarlosEscudo","1982215250","CarlosEscudo@gmail.com","Rua Cambui,267");
        //System.out.println(seguradora2.toString());
        //adcao das seguradoras na array de seguradoras que será usada pelo sistema
        seguradoras.add(seguradora1);
        seguradoras.add(seguradora2);
        System.out.println(seguradora1.toString()+"\n");
        System.out.println(seguradora2.toString()+"\n");

        
        System.out.println("Agora vamos criar alguns clientes e colocalos nessas seguradoras"+"\n");

        ClientePF clientePF1 = new ClientePF("Vinicius Carvalho", "1998552506", "Rua Monteiro Lobato,2022", "viniciusCarvalho22@gmail.com", "513.574.960-87", "Masculino", "Superior Completo", formata_data.parse("22/10/2001"));
        ClientePF clientePF2 = new ClientePF("Janaina melo", "19281881321", "Rua do tomatinho,513", "JanainaM@gmail.com", "262.750.150-04", "Feminino", "Superior Completo", formata_data.parse("27/05/2002"));
        ClientePJ clientePJ1 = new ClientePJ("JaurTransportadora", "17273123129", "Rua paulo filipe,9588", "JaurComercial@gmail.com", "97.306.047/0001-10",formata_data.parse("12/08/2018") );
        ClientePJ clientePJ2 = new ClientePJ("CalcifireCargas", "118278371298", "Rua Arlinda Silva,9992", "Calcifire@gmail.com", "13.854.067/0001-35",formata_data.parse("17/03/2012") );

        System.out.println(clientePF1.toString()+"\n");
        System.out.println(clientePJ1.toString()+"\n");

        System.out.println("vamos adcionalos as seguradoras,usando o metodo da seguradora"+"\n");

        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.cadastrarCliente(clientePJ2);
        seguradora2.cadastrarCliente(clientePF2);
        seguradora2.cadastrarCliente(clientePJ1);


        System.out.println("vamos agora criar alguns veiculos "+"\n");
        
        Veiculo veiculo1 = new Veiculo("CBS19283","BMW","R1000", 2015);
        Veiculo veiculo2 = new Veiculo("CBT32S1","FORD","Fusion", 2010);
        Veiculo veiculo3 = new Veiculo("CBT372312","mercedes","Classe E", 2017);
        Veiculo veiculo4 = new Veiculo("CBT7D56","ferrari","enzo", 2022);
        Veiculo veiculo5 = new Veiculo("CBT5312", "volkswagen", "nivus", 2013);
        Veiculo veiculo6 = new Veiculo("HGE3362", "Volkswagen ", "Gol", 2013);
        Veiculo veiculo7 = new Veiculo("KCZ6336", "Fiat", "Punto", 2019);
        Veiculo veiculo8 = new Veiculo("JXZ9874", "Ford", "Mustang", 2020);
        Veiculo veiculo9 = new Veiculo("LQP4521", "Toyota", "Camry", 2018);
        Veiculo veiculo10 = new Veiculo("GHB2398", "Honda", "Civic", 2017);
        Veiculo veiculo11 = new Veiculo("TKN5412", "Mercedes-Benz", "E-Class", 2021);

        System.out.println(veiculo1.toString()+"\n");
        System.out.println(veiculo2.toString()+"\n");

        System.out.println("vamos usar alguns para criar frotas"+"\n");
        
        Frota frota1 = new Frota("CBSHSD1");
        frota1.addVeiculo(veiculo7);
        frota1.addVeiculo(veiculo8);
        frota1.addVeiculo(veiculo9);
        Frota frota2 = new Frota("UTK121");
        frota2.addVeiculo(veiculo10);
        frota2.addVeiculo(veiculo11);
        System.out.println(frota1.toString()+"\n");
        System.out.println(frota2.toString()+"\n");


        System.out.println("vamos adciona-los aos clientes"+"\n");


        clientePF1.cadastrarVeiculo(veiculo1);
        clientePF1.cadastrarVeiculo(veiculo2);
        clientePF1.cadastrarVeiculo(veiculo3);
        clientePF1.cadastrarVeiculo(veiculo4);
        clientePF2.cadastrarVeiculo(veiculo5);
        clientePF2.cadastrarVeiculo(veiculo6);
        clientePJ1.cadastrarFrota(frota1);
        clientePJ2.cadastrarFrota(frota2);

        clientePJ1.cadastrarFrota(frota1);
        clientePJ2.cadastrarFrota(frota2);

        System.out.println("vamos agora adcionar seguro"+"\n");
       
        SeguroPF seguroPF1n1= new SeguroPF(formata_data.parse("17/03/2012") , formata_data.parse("11/03/2022") , seguradora1, veiculo1, clientePF1);
        SeguroPF seguroPF1n2= new SeguroPF(formata_data.parse("11/01/2010") , formata_data.parse("16/06/2017") , seguradora1, veiculo2, clientePF1);
        SeguroPF seguroPF1n3= new SeguroPF(formata_data.parse("21/01/2011") , formata_data.parse("17/03/2020") , seguradora1, veiculo3, clientePF1);
        SeguroPF seguroPF1n4= new SeguroPF(formata_data.parse("15/03/2019") , formata_data.parse("17/10/2029") , seguradora1, veiculo4, clientePF1);
        SeguroPF seguroPF2n1= new SeguroPF(formata_data.parse("12/06/2019") , formata_data.parse("23/12/2029") , seguradora2, veiculo5, clientePF2);
        SeguroPF seguroPF2n2= new SeguroPF(formata_data.parse("28/08/2019") , formata_data.parse("18/04/2030") , seguradora2, veiculo6, clientePF2);
        SeguroPJ seguroPJ1 = new SeguroPJ(formata_data.parse("28/08/2011"),formata_data.parse("28/08/2021") , seguradora1, frota1, clientePJ1);
        SeguroPJ seguroPJ2 = new SeguroPJ(formata_data.parse("28/08/2012"),formata_data.parse("28/08/2021") , seguradora2, frota2, clientePJ2);

        System.out.println(seguroPF1n1.toString()+"\n");
        System.out.println(seguroPJ2.toString()+"\n");

        System.out.println("vamos agoroa criar alguns condutores e depois adcionalos nos seguros"+"\n");

     
        Condutor condutor1 = new Condutor("912.104.800-26", "Carlos Filho", "192818381", "Rua das Flores, 123", "CarlosF@gmail.com",formata_data.parse("28/08/1985") , false);
        Condutor condutor2 = new Condutor("313.980.380-08", "Pedro Silva", "192818381", "Avenida Brasil, 456", "Pedro@gmail.com",formata_data.parse("15/12/1992") , false);
        Condutor condutor3 = new Condutor("192.732.070-49", "Maria Santos", "192818381", "Rua dos Coqueiros, 789", "Maria12@gmail.com",formata_data.parse("03/06/1978") , false);
        Condutor condutor4 = new Condutor("884.544.840-19", "Lucas Souza", "192818381", "Avenida São Paulo, 321", "LucasOs@gmail.com",formata_data.parse("19/04/2001") , false);
        Condutor condutor5 = new Condutor("620.002.310-71", "Beatriz Oliveira", "192818381", "Rua das Palmeiras, 987", "Beatriz@gmail.com",formata_data.parse("07/11/1990") , false);
        Condutor condutor6 = new Condutor("320.784.270-47", "Gabriel Rodrigues", "192818381", "Avenida Rio de Janeiro, 654", "Gabriel@gmail.com",formata_data.parse("10/02/1987") , false);
        Condutor condutor7 = new Condutor("078.119.130-03", "Laura Costa", "192818381", "Rua dos Ipês, 890", "lauracoem@gmail.com",formata_data.parse("05/09/1995") , false);
        Condutor condutor8 = new Condutor("984.876.130-63", "Enzo Almeida", "192818381", "Avenida Amazonas, 234", "EnzoMeida@gmail.com",formata_data.parse("22/07/2003") , false);
        Condutor condutor9 = new Condutor("894.557.470-06", "Sofia Pereira", "192818381", "Rua das Mangueiras, 567", "SofiaPira@gmail.com",formata_data.parse("30/01/1973") , false);
        Condutor condutor10 = new Condutor("003.992.620-67", "Matheus Carvalho", "192818381", "Rua mineira", "MathesCarvalho@gmail.com",formata_data.parse("14/10/1998") , false);
        Condutor condutor11 = new Condutor("479.557.270-45", "Isabella Ferreira", "192818381", "Avenida da Liberdade, 901", "IsaFA@gmail.com",formata_data.parse("28/08/2001") , false);


        System.out.println(condutor1.toString()+"\n");
        System.out.println(condutor2.toString()+"\n");

        seguroPF1n1.adcionarCondutor(condutor1);
        seguroPF1n1.adcionarCondutor(condutor2);
        seguroPF1n1.adcionarCondutor(condutor3);
        seguroPF2n2.adcionarCondutor(condutor4);
        seguroPF1n2.adcionarCondutor(condutor5);
        seguroPF2n1.adcionarCondutor(condutor6);
        seguroPF1n3.adcionarCondutor(condutor7);
        seguroPF1n4.adcionarCondutor(condutor8);
        seguroPJ1.adcionarCondutor(condutor9);
        seguroPJ1.adcionarCondutor(condutor10);
        seguroPJ2.adcionarCondutor(condutor11);


        
        System.out.println("vamos agora adcionar sinistros em algumas frotas e veiculos"+"\n");


        Sinistro sinistro1 = new Sinistro(formata_data.parse("28/08/2019"),"Rua das Mangueiras, 567" , condutor11, seguroPJ2);
        Sinistro sinistro2 = new Sinistro(formata_data.parse("28/08/2018"), "Rua dos Ipês, 890", condutor1,seguroPF1n1);
        Sinistro sinistro3 = new Sinistro(formata_data.parse("28/09/2017"), "Avenida da Liberdade, 901", condutor1,seguroPF1n1);
        Sinistro sinistro4 = new Sinistro(formata_data.parse("28/09/2021"), "Avenida Amazonas, 234", condutor3, seguroPF1n1);
        Sinistro sinistro5 = new Sinistro(formata_data.parse("28/09/2021"), "Avenida Rio de Janeiro, 654", condutor6, seguroPF2n1);
        
        System.out.println(sinistro1.toString()+"\n");
        System.out.println(sinistro3.toString()+"\n");

     

        System.out.println("vamos adcionar os sinistros aos condutores"+"\n");

        condutor11.adcionarSinistro(sinistro1);
        condutor1.adcionarSinistro(sinistro2);
        condutor1.adcionarSinistro(sinistro3);
        condutor3.adcionarSinistro(sinistro4);
        condutor6.adcionarSinistro(sinistro5);


        System.out.println("vamos adcionar os sinistros ao seguro, veja que a funcao de seguro portanto vamos coloca-lo na lista manualmente"+"\n");

    

        ((Seguro)seguroPJ2).getLSinistros().add(sinistro1);
        ((Seguro)seguroPF1n1).getLSinistros().add(sinistro2);
        ((Seguro)seguroPF1n1).getLSinistros().add(sinistro3);
        ((Seguro)seguroPF1n1).getLSinistros().add(sinistro4);
        ((Seguro)seguroPF2n1).getLSinistros().add(sinistro5);


        
        System.out.println("vamos agora adcionar os seguros na seguradora 1 e 2"+"\n");

      
        seguradora1.gerarSeguro(seguroPF1n1);
        seguradora1.gerarSeguro(seguroPF1n2);
        seguradora1.gerarSeguro(seguroPF1n3);
        seguradora1.gerarSeguro(seguroPF1n4);
        seguradora2.gerarSeguro(seguroPF2n1);
        seguradora2.gerarSeguro(seguroPF2n2);
        seguradora2.gerarSeguro(seguroPF1n1);
        seguradora2.gerarSeguro(seguroPJ1);
        seguradora1.gerarSeguro(seguroPJ2);
        

        System.out.println("vamos agora imprimir alguns objetos criados usando os metodos toString()"+"\n");


        System.out.println(clientePF1.toString()+"\n");
        System.out.println(clientePF2.toString()+"\n");
        System.out.println(clientePJ1.toString()+"\n");
        System.out.println(clientePJ2.toString()+"\n");
        System.out.println(veiculo1.toString()+"\n");
        System.out.println(veiculo2.toString()+"\n");
        System.out.println(frota1.toString()+"\n");
        System.out.println(seguroPF1n1.toString()+"\n");

        System.out.println("vamos agora mostrar algumas funçoes da seguradora exemplos"+"\n");

        System.out.println(seguradora1.getSegurosPorCliente(clientePF1)+"\n");
        System.out.println(seguradora1.getSinistrosPorCliente(clientePF1)+"\n");
        System.out.println(seguradora1.calcularReceita()+"\n");

        System.out.println(seguradora1.toString()+"\n");


        seguradora1.cancelarSeguro(seguroPF1n2);

        //seguradora1.removerCliente(clientePF1.getIdentificador());

        System.out.println(seguradora1.getSegurosPorCliente(clientePF1));

        System.out.println("---------------ACABOU AS INSTANCIACOES------------------"+"\n");

    }
}