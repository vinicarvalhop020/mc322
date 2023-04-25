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

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        Date datalicenca = fmt.parse(data1);             

        Date datanascimento = fmt.parse(data2);
        


        //vamos adcionar um cliente pf
        seguradora.cadastrarCliente("Joao","Rua marcechal",datalicenca,"Ensino Superior Completo", "Masculino", "B", "45532618801", datanascimento);
        System.out.println(seguradora.listarclientes());
        seguradora.removerCliente("Joao");
        System.out.println(seguradora.listarclientes());

        //funçao de adcionar e remover funcionam



    }
}