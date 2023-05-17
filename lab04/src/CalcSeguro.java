import java.util.Calendar; 


public enum CalcSeguro{

    
    VALOR_BASE(100.0),
    FATOR_18_30(1.2),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    final double fator;

    CalcSeguro(double fator){
        this.fator = fator;
    }

    public int idade(Calendar dataNascimento){

        Calendar data_hoje = Calendar.getInstance();
        int idade = data_hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
        return idade;
    }

    //recebe a idade do cliente e usa o switch pra mudar qual fator usar
}