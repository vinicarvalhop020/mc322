import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

// classe herdeira de Cliente 
public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private String educacao;
    private Date dataNascimento;
    private ArrayList<Veiculo> veiculos;

    //construtor 
    public ClientePF (String nome,String telefone,String endereco,String email, String cpf,String genero,String educacao,Date dataNascimento){
        super(nome,telefone,endereco,email);
        this.cpf = cpf; 
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.veiculos = new ArrayList<>();
    }

    //getters e setters

    //getters
    public String getGenero(){
        return genero;
    }
    public String getEducacao(){
        return educacao;
    }

    public Date getData_nascimento(){
        return dataNascimento;
    }
    @Override
    public String getIdentificador(){
        return cpf;
    }

    public ArrayList<Veiculo> getVeiculos(){
        return veiculos;
    }

    //setters (não precisa de sett para cpf por ser uma variavel final e o construtor ja alocou valor na memoria)

    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setEnducacao(String educacao){
        this.educacao = educacao;
    }
    public void setData_nascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo){
        boolean flag = false;
        if(!AuxiliarCliente.busca_veiculo(veiculo.getPlaca(), veiculos)){
            flag = true;
            veiculos.add(veiculo);
        }
        return flag;
    }

    public boolean removerVeiculo(Veiculo veiculo){
        boolean flag = false;
        if(AuxiliarCliente.busca_veiculo(veiculo.getPlaca(), veiculos)){
            flag = true;
            veiculos.remove(veiculo);
        }
        return flag;
    }


    public String toString(){
        DateFormat ft_data = new SimpleDateFormat("dd-MM-yyyy");
        String data_nascimento = ft_data.format(this.dataNascimento.getTime());

        return 
                super.toString()+
                "CPF: " + this.cpf + "\n" +
                "Genero: "+ this.genero+"\n"+
                "Educacao: "+ this.educacao+"\n"+
                "Data de nascimento: " + data_nascimento + "\n"+
                AuxiliarCliente.listarVeiculosStr(veiculos)
                + "\n";

                

    }

}