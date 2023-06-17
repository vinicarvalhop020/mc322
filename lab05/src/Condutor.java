import java.util.ArrayList;
import java.util.Date;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNasc;
    private boolean autorizado;//ao criterio, se for true o condutor está autorizado, false nao
    private ArrayList<Sinistro> sinistros;

    public Condutor(String cpf, String nome ,String telefone, String endereco, String email, Date dataNasc, boolean autorizado){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.autorizado = autorizado;
        sinistros = new ArrayList<>();
    }

    //getters 
    public String getCPF(){
        return cpf;
    }
    public String getNome(){
        return nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public String endereco(){
        return endereco;
    }
    public String email(){
        return email;
    }
    public ArrayList<Sinistro> getSinistros(){
        return sinistros;
    }

    public boolean getAutorizacao(){
        return autorizado;
    }
    public Date getDataNasc(){
        return dataNasc;
    }
    //setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDataNasc(Date dataNasc){
        this.dataNasc = dataNasc;
    }
    public void setAutorizado(boolean flag){
        this.autorizado = flag;
    }

    public boolean adcionarSinistro(Sinistro sinistro){
        boolean flag = false;

        if(!AuxiliarCliente.buscaSinistro(sinistro, sinistros)){
            System.out.println("Sinistro adcionado com Sucesso!");
            sinistros.add(sinistro);
            flag = true;
        }
        return flag;
    }
}
