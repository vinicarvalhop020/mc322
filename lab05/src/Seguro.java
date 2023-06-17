import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.text.ParseException;

public abstract class Seguro {
    //classe abstrata seguro, nao pode ser instanciada onde só queremos instanciar seus herdeiros
    private final int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;
    
    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora){
        Random numero = new Random();
		this.id = numero.nextInt(99999);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<>();
        this.listaCondutores = new ArrayList<>();
    } 
    
    //gets e setters devem ser abstratos?, acho que nem faz sentido essa ideia//

    //getters 
    public int getId(){
        return this.id;
    }

    public Date getDataInicio(){
        return this.dataInicio;
    }

    public Date getDataFim(){
        return this.dataFim;
    }

    public Seguradora getSeguradora(){
        return this.seguradora;
    }

    public ArrayList<Sinistro> getLSinistros(){
        return this.listaSinistros;
    }

    public ArrayList<Condutor> getLCondutores(){
        return this.listaCondutores;
    }
    public double getValorMensal(){
        return this.valorMensal;
    }
    public Cliente getCliente(){//sobrescrito pelos filhos
        return null;
    }
    //setters  
    public void setDataInicio(Date NovaDataInicio){
        this.dataInicio = NovaDataInicio;
    }
    public void setDataFim(Date NovaDataFim){
        this.dataFim = NovaDataFim;
    }
    public void setSeguradora(Seguradora NovaSeguradora){
        this.seguradora = NovaSeguradora;
    }
    public void setValorMensal(double valorMensal){
        this.valorMensal = valorMensal;
    }
    

    //nao faz sentidos settes para as listas de sinistro e condutores

    public abstract boolean autorizarCondutor(String identificador);
    public abstract boolean desautorizarCondutor(String identificador);
    public abstract boolean gerarSinistro(String identificador) throws ParseException;
    public abstract double calcularValor();
    public abstract boolean excluirCondutor(String CPF);
    public abstract boolean adcionarCondutor(Condutor condutor);
    
    public String toString(){
        return "ID : " + this.id + "\n"+
				"Data de inicio : " + this.dataInicio + "\n"+
                "Data de fim : " + this.dataFim + "\n"+
				"Valor Mensal : "+ this.valorMensal +"\n";
    }
}   

