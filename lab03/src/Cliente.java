import java.util.Date;
import java.util.ArrayList;


public class Cliente {
	//SUPER CLASSE 
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private ArrayList<Veiculo> veiculos; 
	
	
	//construtor
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica) {
		this.nome = nome;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.veiculos = new ArrayList<>();
	}
	
	//geters e setters
	public String getNome() {
		return nome;
	}
	public String getEndereco(){
		return endereco;
	}
	public Date getData_licenca() {
		return dataLicenca;
	}
	public String getEducacao() {
		return educacao;
	}
	
	
	public String setGenero(String genero) {
		this.genero = genero;
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