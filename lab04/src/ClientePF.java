import java.util.Calendar;

// classe herdeira de Cliente 
public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private Calendar dataLicenca;
    private String educacao;
    private Calendar dataNascimento;
    private String classeEconomica;


    //construtor 
    public ClientePF (String nome,String endereco,String cpf,String genero,Calendar dataLicenca,String educacao,Calendar dataNascimento,String classeEconomica){
        super(nome,endereco);
        this.cpf = cpf; 
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }

    //getters e setters

    //getters
    public String getCPF(){
        return cpf;
    }
    public String getGenero(){
        return genero;
    }
    public Calendar getData_Licenca(){
        return dataLicenca;
    }
    public String getEducacao(){
        return educacao;
    }
    public Calendar getData_nascimento(){
        return dataNascimento;
    }
    public String getClasse_economica(){
        return classeEconomica;
    }
    @Override
    public String getIdentificador(){
        return cpf;
    }

    //setters (não precisa de sett para cpf por ser uma variavel final e o construtor ja alocou valor na memoria)

    void setGenero(String genero){
        this.genero = genero;
    }
    void setData_licenca(Calendar dataLicenca){
        this.dataLicenca = dataLicenca;
    }
    void setEnducacao(String educacao){
        this.educacao = educacao;
    }
    void setData_nascimento(Calendar dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    void setClasse_economica(String classeEconomica){
        this.classeEconomica = classeEconomica;
    }
    public int calculaIdade(){
        //É CERTO ESE MODO?
    
        Calendar data_hoje = Calendar.getInstance();
        int idade = data_hoje.get(Calendar.YEAR) - this.dataNascimento.get(Calendar.YEAR);
        return idade;
    }


    @Override
    public double calculaScore(){

        double VALOR_BASE = CalcSeguro.VALOR_BASE.fator;
        int idade = calculaIdade();
        double FATOR_IDADE;

        if(18 <= idade && idade < 30){
            FATOR_IDADE = CalcSeguro.FATOR_18_30.fator;
        }
        else if(30 <= idade && idade < 60){
            FATOR_IDADE = CalcSeguro.FATOR_30_60.fator;
        }
        else
            FATOR_IDADE = CalcSeguro.FATOR_60_90.fator;

        int qtdCarros = qtdCarros();

        double score =  VALOR_BASE*FATOR_IDADE*qtdCarros;

        return score;
	}

    public String toString(){

        return 
                super.toString()+"\n"+
                "CPF: " + this.cpf + "\n" +
                "Genero: "+ this.genero+"\n"+
                "Data Licenca: "+ this.dataLicenca+"\n"+
                "Educacao: "+ this.educacao+"\n"+
                "Data de nascimento: " + this.dataNascimento + "\n"+
                "Classe economica: " + this.classeEconomica+"\n";

    }

}