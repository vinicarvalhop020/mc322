import java.text.ParseException;
import java.util.ArrayList;

public class instancia{

    public static void instancia_pedida_main( ArrayList<Seguradora> seguradoras ) throws ParseException{

        System.out.println("Instanciacoes requisitadas no lab antes da abertura do menu");
        System.out.println("Instanciacoes realizadas de forma manual usando o system.in, quem ira corrigir deve informar o que é pedido pelas funcoes =)");
        System.out.println("**************************************************************************************************************");
        System.out.println("Instanciacao do primeiro veiculo: ");
        Veiculo veiculo1 = CriaObjetos.criarVeiculo();
        System.out.println("Instanciacao do segundo veiculo: ");
        Veiculo veiculo2 = CriaObjetos.criarVeiculo();
        System.out.println("Instanciacao do clientePF: ");
        ClientePF clientePF = CriaObjetos.cria_ClientePF();
        System.out.println("Instanciacao do clientePJ: ");
        ClientePJ clientePJ = CriaObjetos.cria_ClientePJ();
        System.out.println("Instanciacao de uma Seguradora: ");
        Seguradora seguradora = CriaObjetos.criaSeguradora();
        System.out.println("Adcao de um veiculo ao clientePF: ");
        clientePF.adciona_veiculo(veiculo1);
        System.out.println("Adcao de um veiculo ao clientePJ: ");
        clientePJ.adciona_veiculo(veiculo2);

        System.out.println("Cadastro de um cliente clientePF na seguradora: ");
        seguradora.cadastrarCliente(clientePF);
        System.out.println("Cadastro de um cliente clientePJ na seguradora: ");
        seguradora.cadastrarCliente(clientePJ);

        System.out.println("Gerando o primeiro Sinistro, nesse caso o sinistro é do unico carro do cliente PF: ");
        Sinistro sinistro1 = CriaObjetos.criaSinistro(veiculo1, seguradora, clientePF);
        seguradora.gerarSinistro(sinistro1);
        System.out.println("Gerando o segundo Sinistro, nesse caso o sinistro é do unico carro do cliente PJ: ");
        Sinistro sinistro2 = CriaObjetos.criaSinistro(veiculo2, seguradora, clientePJ);
        seguradora.gerarSinistro(sinistro2);

        System.out.println("chamando o metodo da seguradora listarCliente(): ");
        System.out.println(seguradora.listarclientes());
        System.out.println("chamando o metodo da seguradora visualizarSinistro, nesse caso o Sinistro do veiculo1 do clientePF: ");
        System.out.println(seguradora.visualizarSinistro(veiculo1));
        System.out.println("chamando o metodo da seguradora listarSinistro(): ");
        System.out.println(seguradora.listarSinistros());
        System.out.println("chamando o metodo da seguradora calcularReceita(): ");

        System.out.println(seguradora.calcularReceita());

        System.out.println("Atualiza o preco do seguro do ClientePF ");
        seguradora.cadastrarCliente(clientePF);
        seguradora.calcularPrecoSeguroCliente(clientePF);
        System.out.println("Atualiza o preco do seguro do ClientePF é " + clientePF.getValorSeguro());


        System.out.println("Atualiza o preco do seguro do ClientePJ ");
        seguradora.cadastrarCliente(clientePJ);
        seguradora.calcularPrecoSeguroCliente(clientePF);
        System.out.println("Atualiza o preco do seguro do ClientePF é " + clientePF.getValorSeguro());

        System.out.println("chamando o metodo da seguradora calcularReceita() e mostra na tela: ");
        System.out.println(seguradora.calcularReceita());
    }
}
