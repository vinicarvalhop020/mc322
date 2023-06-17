import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;


//classe herdeira de Cliente
public class ClientePJ extends Cliente{
    private final String cnpj;
    private Date dataFundacao;
    private ArrayList<Frota> listaFrota;//uma empresa pode ter multiplas frotas de veiculos

     //construtor 
     public ClientePJ (String nome,String telefone,String endereco,String email, String cnpj,Date dataFundacao){
        super(nome,telefone,endereco,email);
        this.cnpj = cnpj; //cnpj só pode ser alterado uma vez por ser uma variavel final
        this.dataFundacao = dataFundacao;
        this.listaFrota = new ArrayList<>();
    }

    //getters e setters

    //getters

    public Date getData_fundacao(){
        return dataFundacao;
    }

    public ArrayList<Frota> getListaFrota(){
        return listaFrota;
    }
    @Override
    public String getIdentificador(){
        return cnpj;
    }
    //setters (não precisa de sett para cpf por ser uma variavel final e o construtor ja alocou valor na memoria)

    public void setData_fundacao(Date novaDataFundacao){
        this.dataFundacao = novaDataFundacao;
    }

    public boolean cadastrarFrota(Frota frota){
        boolean flag = false;
        
        if(frota.getFrota().size() < 1 || !AuxiliarCliente.buscaFrota(frota, listaFrota)){
            //o que falha o if é caso a frota seja menor que 1 ou que ja exista uma frota de mesmo codigo na listadefrotas
            listaFrota.add(frota);
            flag = true;
        }
        return flag;
    }

    public boolean adcionaVeiculo(Veiculo veiculo, String codeFrota){

        boolean flag = false;
        Frota frota = AuxiliarCliente.ObterFrota(codeFrota, this.getListaFrota());
        if (frota != null){
            flag = true;
            frota.addVeiculo(veiculo);
        }
        else
            flag = false;

        return flag;
    }

    public boolean removeVeiculo(String placa, String codeFrota){

        boolean flag = false;
        Frota frota = AuxiliarCliente.ObterFrota(codeFrota, this.getListaFrota());
        Veiculo veiculo_rm = AuxiliarCliente.obter_veiculo(placa, frota.getFrota());
        if (frota != null){
            flag = true;
            frota.removeVeiculo(veiculo_rm);
        }
        return flag;
    }

    public boolean removefrota(String codeFrota){

        boolean flag = false;
        for(Frota frotals : this.getListaFrota()){
            if (frotals.getCode().equals(codeFrota)){
                flag = true;
                this.getListaFrota().remove(frotals);
            }
        }
        return flag;
    }



    
    public void atualizarFrota(EnumAtualizaFrota opEnumAtualizaFrota){ //troquei o tipo da fucao de boolean para void, acho que ficou mais elegante com os enuns
        Scanner scan = new Scanner(System.in);
        switch(opEnumAtualizaFrota){

			case ADCIONA_VEICULO:
                Veiculo veiculo_add = CriaObjetos.criarVeiculo();
                System.out.println("\n");
                System.out.println("Informe o codigo da frota que deseja adcioanar o veiculo:\n");
                String code = scan.nextLine();
                adcionaVeiculo(veiculo_add, code);
			break;

			case REMOVE_VEICULO:
                System.out.println("\n");
                System.out.println("Informe o codigo da frota que deseja remover o veiculo:\n");
                code = scan.nextLine();
                System.out.println("Informe a placa do veiculo que deseja excluir");
                String placa = scan.nextLine();
                removeVeiculo(placa,code);
			break;

            case REMOVE_FROTA:
                System.out.println("\n");
                System.out.println("Informe o codigo da frota que deseja remover:\n");
                code = scan.nextLine();
                removefrota(code);
			break;
        }
    }

    public ArrayList<Veiculo> getVeiculosPorFrota(String codeDaFrota){
        //no laboratorio essa funcao esta como boolean mas e uma get.Confuso?

        ArrayList<Veiculo> ListaVeiculoFrota = new ArrayList<>();
        Frota frota_aux;
        frota_aux = AuxiliarCliente.ObterFrota(codeDaFrota, listaFrota);

        if (frota_aux ==  null){
            return null;
        }
        else {
            for (int i = 0; i < frota_aux.getFrota().size(); i++){
                ListaVeiculoFrota.add(frota_aux.getFrota().get(i));
            }
            return ListaVeiculoFrota;
        }
    }

    public String toString(){
        DateFormat ft_data = new SimpleDateFormat("dd-MM-yyyy");
        String data_fundacao = ft_data.format(this.dataFundacao.getTime());

        return 
                super.toString()+
                "CNPJ: " + this.cnpj + "\n" +
                "Data de Fundacao: " + data_fundacao + "\n"+
                AuxiliarCliente.listarFrotaStr(listaFrota)
                + "\n";
    }
    
}