import java.text.ParseException;
import java.util.Date;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private Cliente clientePJ;

    public SeguroPJ(Date DataInicio, Date DataFim, Seguradora seguradora, Frota frota, Cliente clientePJ){
        super(DataInicio,DataFim,seguradora);
        this.frota = frota;
        this.clientePJ = clientePJ;
        super.setValorMensal(calcularValor());

    }

    public Frota getFrota(){
        return this.frota;
    }

    public Cliente getCliente(){
        return this.clientePJ;
    }

    public void setFrota(Frota frota){
        this.frota = frota;
    }

    public void setCliente(Cliente cliente){
        this.clientePJ = cliente;
    }

    //autorizar e desautorizar é simetrico de PF para PJ
    public boolean autorizarCondutor(String identificador){
        boolean flag = false;
        Condutor condutorAux = AuxiliarCliente.ObterCondutor(identificador, this.getLCondutores());
        if(condutorAux !=  null){
            flag = true;
            condutorAux.setAutorizado(true);
        }
        return flag;
    }

    public boolean desautorizarCondutor(String identificador){
        boolean flag = false;
        Condutor condutorAux = AuxiliarCliente.ObterCondutor(identificador, this.getLCondutores());
        if(condutorAux !=  null){
            flag = true;
            condutorAux.setAutorizado(false);
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
    

    public double calcularValor(){

        double valor;
        int quantidadeFunc =  AuxilarSeguradora.calculaqtdFuncionarios(this);
        int quantidadeVeiculos = this.frota.getFrota().size();
        long AnosPosFundacao = AuxiliarCliente.calculaIdade(((ClientePJ)clientePJ).getData_fundacao());//downcasting
        int quantidadeSinistrosCliente = AuxilarSeguradora.calculaqtdSinistrosCliente(getSeguradora(), clientePJ);
        int quantidadeSinistrosCondutor = AuxilarSeguradora.calculaqtdSinistrosCondutor(this);


        valor = (CalcSeguro.VALOR_BASE.fator *(10 + (quantidadeFunc)/10)*(1+1/(quantidadeVeiculos+2))
        *(1+ 1/(AnosPosFundacao+2)) * (2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutor/10));

        this.setValorMensal(valor);
        return valor;
    }

    public String toString(){
        return 
        super.toString()+
        "Frota: " + this.frota.toString() + "\n" +
        "ClientePJ :" + this.clientePJ.toString();
    }
}
