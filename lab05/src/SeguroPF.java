import java.text.ParseException;
import java.util.Date;


public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private Cliente clientePF;

    public SeguroPF(Date DataInicio, Date DataFim , Seguradora seguradora, Veiculo veiculo, Cliente clientePF){
        super(DataInicio,DataFim,seguradora);
        this.veiculo = veiculo;
        this.clientePF = clientePF;
        super.setValorMensal(calcularValor());
        
    }

    public Veiculo getVeiculo(){
        return this.veiculo;
    }

    public Cliente getCliente(){
        return this.clientePF;
    }

    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public void setCliente(Cliente cliente){
        this.clientePF = cliente;
    }
    
    public boolean desautorizarCondutor(String identificador){
        //se o condutor buscado recebe null, quer dizer que esse nao esta na lista, entao retornamos false
        boolean flag = false;   
        Condutor condutorBuscado = AuxiliarCliente.ObterCondutor(identificador, this.getLCondutores());
        if(condutorBuscado != null){
            condutorBuscado.setAutorizado(false);
            flag = true;
        }
        return flag;
    }

    public boolean autorizarCondutor(String identificador){
        //simetrica a funcao desautorizar
        boolean flag = false;
        Condutor condutorBuscado = AuxiliarCliente.ObterCondutor(identificador, this.getLCondutores());
        if(condutorBuscado != null){
            condutorBuscado.setAutorizado(true);
            flag = true;
        }
        return flag;
    }
    
    public boolean gerarSinistro(String cpfCondutor) throws ParseException{
        boolean flag = false;
        //sinistro se relaciona com o condutor, seguro 
        //add a lista de sinistros 
        Sinistro sinistroAD;
        Condutor condutor = AuxiliarCliente.ObterCondutor(cpfCondutor, this.getLCondutores());
        sinistroAD = CriaObjetos.criaSinistro(condutor,this);//this envia esse sinistro relacao de composicao 1-0

        if (!AuxiliarCliente.buscaSinistro(sinistroAD, getLSinistros())){
            flag = true;
            this.getLSinistros().add(sinistroAD);
            condutor.adcionarSinistro(sinistroAD);
        }
        return flag;
    }

    public boolean excluirCondutor(String cpf){
        boolean flag = false;
        for(Condutor condutor : this.getLCondutores()){
            if(condutor.getCPF().equals(cpf)){
                this.getLCondutores().remove(condutor);
                flag = true;
            }
        }
        return flag;
    }

    public boolean adcionarCondutor(Condutor condutorAD){
        boolean flag = false;
    
        if(!AuxilarSeguradora.buscar_condutor(condutorAD.getCPF(),this.getLCondutores())){
            this.getLCondutores().add(condutorAD);
            flag = true;
        }
        return flag;
    }
    
    @Override
    public double calcularValor(){
        double valor;
        int quantidadeVeiculos = ((ClientePF)clientePF).getVeiculos().size();//DOWNCASTING
        int quantidadeSinistrosCliente = AuxilarSeguradora.calculaqtdSinistrosCliente(super.getSeguradora(), this.clientePF);
        int quantidadeSinistrosCondutor = AuxilarSeguradora.calculaqtdSinistrosCondutor(this);

        long  idade = AuxiliarCliente.calculaIdade(((ClientePF)clientePF).getData_nascimento());

        if(18 <= idade && idade < 30){
            valor = (CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_18_30.fator * (1 + 1/(quantidadeVeiculos+2)) *
            (2 + quantidadeSinistrosCliente/10)*(5 + quantidadeSinistrosCondutor/10));
        }
        else if(30 <= idade && idade < 60){
            valor = (CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_30_60.fator * (1 + 1/(quantidadeVeiculos+2)) *
            (2 + quantidadeSinistrosCliente/10)*(5 + quantidadeSinistrosCondutor/10));
        }
        else{
            valor = (CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_60_90.fator * (1 + 1/(quantidadeVeiculos+2)) *
            (2 + quantidadeSinistrosCliente/10)*(5 + quantidadeSinistrosCondutor/10));
        }
        super.setValorMensal(valor);
        return valor;
    }
	

    public String toString(){
        return 
        super.toString()+
        "Veiculo: " + this.veiculo.toString() + "\n" +
        "ClientePF :" + this.clientePF.toString();
    }
}
