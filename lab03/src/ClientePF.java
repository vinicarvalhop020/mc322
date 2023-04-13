import java.util.Date;

// classe herdeira de Cliente 
public class ClientePF extends Cliente{
    private final String cpf;
    private Date dataNascimento;




    //construtor 
    public ClientPF (String cpf, Date dataNascimento){
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

    public boolean validarCPF() {
        int verificador = 0;
        String cpf_verificador;
        cpf_verificador = cpf.replaceAll("\\D","");
        
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
            return true;
        }
        
        else {
            return false;
            }
    }
    public String toString(/*tem como utilizar o toString da classe mãe? ou vai sobrecarregar o metodo? */){
        return "CPF: " + this.cpf + "\n"
                "Data de nascimento" + this.dataNascimento + "\n"; 
    }
}