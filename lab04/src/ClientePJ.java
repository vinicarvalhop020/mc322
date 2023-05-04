import java.util.Date;

//classe herdeira de Cliente
public class ClientePJ extends Cliente{
    private final String cnpj;
    private Date dataFundacao;

     //construtor 
     public ClientePJ (String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica,String cnpj, Date dataFundacao){
        super(nome,endereco,dataLicenca,educacao,genero,classeEconomica);
        this.cnpj = cnpj; //cnpj só pode ser alterado uma vez por ser uma variavel final
        this.dataFundacao = dataFundacao;
    }

    //getters e setters

    //getters
    public String getCNPJ(){
        return cnpj;
    }
    public Date getData_fundacao(){
        return dataFundacao;
    }
    //setters (não precisa de sett para cpf por ser uma variavel final e o construtor ja alocou valor na memoria)

    public void setData_fundacao(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String getIdentificador() {
		return cnpj;
	}


    public String toString(/*tem como utilizar o toString da classe mãe? ou vai sobrecarregar o metodo? */){
        return 
                super.toString()+"\n"+
                "CNPJ: " + this.cnpj + "\n" +
                "Data de Fundacao: " + this.dataFundacao + "\n"; 
    }

}