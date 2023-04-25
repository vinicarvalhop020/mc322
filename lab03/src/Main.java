import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


public class Main {
	public static void main(String[] args) throws ParseException {
        //primeiro criamos a seguradora
        Seguradora seguradora = new Seguradora("ProtectVec","965456783","vecveiculos@gmail.com","rua nobregal nora 12");

        String data1 = "23/04/2005";
        String data2 = "05/12/1998";
        String data3 = "03/01/1997";
        String data4 = "25/10/2008";
        String data5 = "22/05/2008";

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        Date datalicenca = fmt.parse(data1);             
        Date datanascimento = fmt.parse(data2);
        Date datalicenca2 = fmt.parse(data3);
        Date datafundaca = fmt.parse(data4);
        Date datasinistro = fmt.parse(data5);


        //vamos adcionar um cliente pf
        seguradora.cadastrarCliente("Joao","Rua marcechal",datalicenca,"Ensino Superior Completo", "Masculino", "B", "45532618801", datanascimento);
        seguradora.cadastrarCliente("Carlos","Rua Dom bosco",datalicenca2,"Ensino Superior Completo", "Masculino", "A", "14.237.943/0001-47", datafundaca);
        System.out.println(seguradora.listarclientes());
        seguradora.removerCliente("Carlos");
        System.out.println(seguradora.listarclientes());

    
        //funçao de adcionar e remover funcionam

        //como chegar no cliente dito que a lista é privada??
            //PRECISO ACESSAR O OBJETO CLIENTE NA LISTA CLIENTES PARA ADCIONAR CARROS VALIDAR CPFS ETC
            //preciso acessar o objeto cliente na lista para mostrar o validar cpf ou cnpj
            //preciso do objeto cliente na lista de clientes da seguradora para cadastrar um veiculo
        
        //usar o system in

    }
}