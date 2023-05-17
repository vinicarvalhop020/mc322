public class Validacao{
    
    public static boolean validarCPF(String cpf) {
        int verificador = 0;
        String cpf_verificador;//variavel necessaria para operacao no cpf que é static
        cpf_verificador = cpf.replaceAll("\\D","");
        
        if (cpf_verificador.length() == 11) {
            verificador++;
                
            int peso = 10;
            int acumula = 0;	
            
            //verificacao do primeiro dgt
            for(int i = 0; i < 9; i++) {
                //ok
                int digito = cpf_verificador.charAt(i) - 48;
                acumula += digito*peso;
                peso--;
            }
            
            int dgt_verificador = ((acumula * 10)%11);
            if (dgt_verificador == 10){
                dgt_verificador = 0;
            }
            

            if ((dgt_verificador == ((cpf_verificador.charAt(cpf_verificador.length()-2)) - 48))){
                verificador++;
                peso = 11;
                acumula = 0;
                
            }

            for(int i = 0; i < 9; i++) {
                int digito = cpf_verificador.charAt(i) - 48;
                acumula += digito*(peso);
                peso--;
            
            }
            
            acumula += dgt_verificador*peso;
            dgt_verificador = ((acumula* 10)%11);
            if (dgt_verificador == (cpf_verificador.charAt(cpf_verificador.length()-1) - 48)){
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

    public static boolean validarcnpj(String cnpj){
        //algogitmo para validar cnpj
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
            for(int i = 0; i < 13; i++) {
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

    public static boolean validar_nome(String nome){
        //simples usando esse regex 
        //se tiver numero o nome é invalido
        return nome.matches("^[a-zA-Z]*$");
    }






}