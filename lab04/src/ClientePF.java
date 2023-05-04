import java.util.Date;

// classe herdeira de Cliente 
public class ClientePF extends Cliente{
    private final String cpf;
    private Date dataNascimento;

    //construtor 
    public ClientePF (String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cpf, Date dataNascimento){
        super(nome,endereco,dataLicenca,educacao,genero,classeEconomica);
        this.cpf = cpf; //cpf só pode ser alterado uma vez por ser uma variavel final
        this.dataNascimento = dataNascimento;
    }

    //getters e setters

    //getters
    public String getCPF(){
        return cpf;
    }
    public Date getData_nascimento(){
        return dataNascimento;
    }
    //setters (não precisa de sett para cpf por ser uma variavel final e o construtor ja alocou valor na memoria)

    public void setData_nascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }


    @Override
    public String getIdentificador() {
		return cpf;
	}

    public String toString(/*tem como utilizar o toString da classe mãe? ou vai sobrecarregar o metodo? */){
        return 
                super.toString()+"\n"+
                "CPF: " + this.cpf + "\n" +
                "Data de nascimento:" + this.dataNascimento + "\n"; 
    }

}