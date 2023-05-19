import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


//classe herdeira de Cliente
public class ClientePJ extends Cliente{
    private final String cnpj;
    private Calendar dataFundacao;
    private int qtdeFuncionarios;

     //construtor 
     public ClientePJ (String cnpj,String nome, String endereco, Calendar dataFundacao, int qtdeFuncionarios){
        super(nome,endereco);
        this.cnpj = cnpj; //cnpj só pode ser alterado uma vez por ser uma variavel final
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //getters e setters

    //getters
    public String getCNPJ(){
        return cnpj;
    }
    public Calendar getData_fundacao(){
        return dataFundacao;
    }
    public int get_qtdeFuncionarios(){
        return qtdeFuncionarios;
    }
    @Override
    public String getIdentificador(){
        return cnpj;
    }
    //setters (não precisa de sett para cpf por ser uma variavel final e o construtor ja alocou valor na memoria)

    public void setData_fundacao(Calendar dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    public void set_qtdeFuncionarios(int qtdeFuncionarios){
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    @Override
    public double calculaScore(){

        double VALOR_BASE = CalcSeguro.VALOR_BASE.fator;
        double score = VALOR_BASE * (1 + (qtdeFuncionarios)/100) * qtdCarros();

		return score;
	}

    public String toString(){
        DateFormat ft_data = new SimpleDateFormat("dd-MM-yyyy");
        String data_fundacao = ft_data.format(this.dataFundacao.getTime());

        return 
                super.toString()+"\n"+
                "CNPJ: " + this.cnpj + "\n" +
                "Data de Fundacao: " + data_fundacao + "\n"+
                "qtdeFuncionarios: " + this.qtdeFuncionarios +"\n";
    }

}