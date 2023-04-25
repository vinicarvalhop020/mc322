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

    public boolean validarcnpj(){
        int verificador = 0;
        String cnpj_verificador;//variavel necessaria para operacao no cpf que é static
        cnpj_verificador = cnpj.replaceAll("\\D","");
        
        if (cnpj_verificador.length() == 14) {
            verificador++;
                
            int[] peso1 = {5,4,3,2,9,8,7,6,5,4,3,2};
            int[] peso2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};
            int acumula = 0;	
            
            //verificacao do primeiro dgt
            for(int i = 0; i < 12; i++) {
                //ok
                int digito = cnpj_verificador.charAt(i) - 48;
                acumula += digito*peso1[i];
            }
            
            int dgt_verificador = ((acumula)%11);
            if (dgt_verificador == 0 || dgt_verificador == 1){
                dgt_verificador = 0;
            }
            else 
                dgt_verificador = 11 - dgt_verificador;

            if ((dgt_verificador == ((cnpj_verificador.charAt(cnpj_verificador.length()-2)) - 48))){
                verificador++;
                acumula = 0;
            }

            //verificaçao do segundo dgt
            for(int i = 0; i < 12; i++) {
                int digito = cnpj_verificador.charAt(i) - 48;
                acumula += digito*peso2[i];            
            }

            dgt_verificador = ((acumula)%11);

            if (dgt_verificador == 0 || dgt_verificador == 1){
                dgt_verificador = 0;
            }
            else 
                dgt_verificador = 11 - dgt_verificador;

            if ((dgt_verificador == ((cnpj_verificador.charAt(cnpj_verificador.length()-1)) - 48))){
                verificador++;
                acumula = 0;
            }

        }

        
        if (verificador == 3){
            return true;
        }
        
        else {
            return false;
            }
    }

    public String toString(/*tem como utilizar o toString da classe mãe? ou vai sobrecarregar o metodo? */){
        return "CNPJ: " + this.cnpj + "\n" +
                "Data de Fundacao: " + this.dataFundacao + "\n"; 
    }

}