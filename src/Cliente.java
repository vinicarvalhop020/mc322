public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	//construtor
	public Cliente(String nome, String dataNascimento,String cpf,int idade,String endereco) {
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.cpf = cpf;
	}
	
	//geters e setters
	public String getNome() {
		return nome;
	}
	public String getcpf() {
		return cpf;
	}
	public String getData_nascimento() {
		return dataNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public String getEndereco(){
		return endereco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setcpf(String cpf) {
		this.cpf = cpf;
	}
	public void setData_nascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean validarCPF() {
		int verificador = 0;
		
		cpf = cpf.replaceAll("\\D","");
		
		if (cpf.length() == 11) {
			verificador++;
				
			int peso = 10;
			int acumula = 0;	
			
			//verificacao do primeiro dgt
			for(int i = 0; i < 9; i++) {
				//ok
				int digito = cpf.charAt(i) - 48;
				acumula += digito*peso;
				peso--;
			}
			
			int dgt_verificador = ((acumula * 10)%11);
			if (dgt_verificador == 10){
				dgt_verificador = 0;
			}
			

			if ((dgt_verificador == ((cpf.charAt(cpf.length()-2)) - 48))){
				verificador++;
				peso = 11;
				acumula = 0;
				
			}

			for(int i = 0; i < 9; i++) {
				int digito = cpf.charAt(i) - 48;
				acumula += digito*(peso);
				peso--;
			
			}
			
			acumula += dgt_verificador*peso;
			dgt_verificador = ((acumula* 10)%11);
			if (dgt_verificador == (cpf.charAt(cpf.length()-1) - 48)){
				verificador ++;
			}
		}
		
		if (verificador == 3){
			System.out.println("O CPF É VERDADEIRO!!");
			return true;
		}
		
		else {
			System.out.println("O CPF É FALSO!!!");
			return false;
			}
	}

    public String toString(){
        return "o nome do cliente eh " + this.nome + ", o cliente tem " + this.idade + " anos, a data de nascimento do cliente é: " + this.dataNascimento + " com CPF: " + this.cpf + " e reside no endereco: " + this.endereco; 
    }
	
}