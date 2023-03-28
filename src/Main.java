public class Main {
	// testando os clientes
	public static void main(String[] args) {
		
		//TESTES DO CLIENTE//
		
		Cliente n1 = new Cliente("Claudio","29/02/1983" ,"455.326.188-01", 34, "Jardim FLorence 3120");
		//vamos testar se o construtor construiu de maneira correta o cliente n1
		System.out.println("--------------------------------------------------------------------\n");
        System.out.println(n1.toString());
		System.out.println("--------------------------------------------------------------------\n");

		//vamos instanciar outro cliente e mudar os valores e ver o que ocorre:
		Cliente n2 = new Cliente("Fernando","29/02/2000" ,"529.982.247-25", 23, "Jardim Nova Europa 2240");
		System.out.println(n2.toString());
		System.out.println("--------------------------------------------------------------------\n");
		//como visto, para objetos diferentes temos valores diferentes para cada dado da classe
		
		/*vamos testar o que ocorre caso mudemos os dados do cliente n1 para os dados do cliente n2 usando a
		as funcoes de setters*/
		
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("ANTES \n");
        System.out.println(n1.toString());

		n1.setcpf("529.982.247-25");
		n1.setData_nascimento("29/02/2000");
		n1.setNome("Fernando");
		n1.setIdade(23);
		n1.setEndereco("Jardim Nova Europa 2240");
		
		
		System.out.println("--------------------------------------------------------------------\n");
        System.out.println("DEPOIS \n");
        System.out.println(n1.toString());
		System.out.println("--------------------------------------------------------------------\n");
		
		//é visto que o objeto n1 mudou!!
		
		//Vamos agora verificar se o cpf do cliente é verdadeiro, de fato ele eh =)
		
		System.out.println(n1.validarCPF()+"\n");
		
		//Agora vamos colocar um cpf diferente com resto 10 da primeira conta para calcular cpfs
		n1.setcpf("455.326.188-01");
		System.out.println(n1.validarCPF()+"\n");
		//vemos que tambem funciona
		
		//por fim vamos tentar colocar um cpf invalido
		n1.setcpf("111.111.111-02");
		System.out.println(n1.validarCPF()+"\n");
		//retornamos um valor como falso


		//TESTES SINISTRO//
		
		//vamos instanciar um sinistro
		Sinistro s1 = new Sinistro("22/10/2001", "Rua Dom Barreto 3320"+"\n");
		System.out.println(s1.toString());

        //vemos que funciona,vamos tentar agora alterar o valor do sinistro
        s1.setID();
        s1.setEndereco("Rua engenheiro francisco 2223");
        s1.setData("31/10/2003");
        System.out.println(s1.toString()+"\n");

        
        //TESTES SEGURADORA//
        
        //comecemos instanciando a seguradora
        Seguradora seguradora1 = new Seguradora("lucia veiculos", "877725228", "lveiculos@hotmail.com", "Francisco Glicerio");
        System.out.println(seguradora1.toString()+"\n");
        //agora alterando os valores temos:
        seguradora1.setEmail("luciav@hotmail.com");
        seguradora1.setEndereco("Flango verde 2214");
        seguradora1.setNome("paulaautomotivos");
        seguradora1.setTelefone("18992315437");
        System.out.println(seguradora1.toString()+"\n");

        //TESTES VEICULO//
        Veiculo carro = new Veiculo("CBT8325","BMW","2014");
        System.out.println(carro.toString()+"\n");
        //agora alterando os valores temos:
        carro.setMarca("Ford");
        carro.setPlaca("CBT7D52");
        carro.setModelo("2010");
        System.out.println(carro.toString()+"\n");
	}
}
