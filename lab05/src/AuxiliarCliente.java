import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//Classe estatica contendo funcoes uteis para utilizacao de todo o codigo, mas com foco em clientes


public class AuxiliarCliente {

    public static Veiculo obter_veiculo(String placa, ArrayList<Veiculo> veiculos){
        //recebe uma placa e uma lista de veiculos e devolve um objeto veiculo
		for (int i = 0; i < veiculos.size(); i++){
			if (veiculos.get(i).getPlaca().equals(placa)){
				return veiculos.get(i);
			}	
		}
		return null;
	}

    public static boolean busca_veiculo(String placa, ArrayList<Veiculo> veiculos){

        boolean flag = false;
        for (int i = 0; i < veiculos.size(); i++){
            if(veiculos.get(i).getPlaca().equals(placa)){
                flag = true;
            }
        }
        return flag;
    }

    public static void excluir_veiculo(Veiculo veiculo, ArrayList<Veiculo> veiculos){
		veiculos.remove(veiculo);
	}

    public static boolean buscaFrota(Frota frota, ArrayList<Frota> frotas){
        boolean flag = false;
        for(int i = 0; i < frotas.size(); i++){
            if(frotas.get(i).getCode().equals(frota.getCode())){
                flag = true;
            }
        }
        return flag;
    }

    public static String listarVeiculosStr(ArrayList<Veiculo> veiculos){
        //retorna uma string o qual é a soma dos tostring de cada veiculo da lista 
        String aux = "Lista de Veiculos: ";

        for(int i = 0; i < veiculos.size(); i++){
            aux += veiculos.get(i).toString()+"\n";
        }

        return aux;
    }

    public static String listarFrotaStr(ArrayList<Frota> frotas){
        
        String aux = "Lista de Frotas: "+"\n";

        for(int i = 0; i < frotas.size(); i++){
            aux += frotas.get(i).toString()+"\n";
        }

        return aux;
    }

    public static String listarCondutoresStr(ArrayList<Condutor> condutores){
        String aux = "Lista de condutores: "+"\n";

        for(Condutor condutorls : condutores){
            aux += condutorls.toString()+"\n";
        }
        return aux;
    }

    public static String listarSinistrosStr(ArrayList<Sinistro> sinistros){
        String aux = "Lista de sinistros: "+"\n";

        for(Sinistro sinistrols : sinistros){
            aux += sinistrols.toString()+"\n";
        }
        return aux;
    }

    public static String listarClientesStr(ArrayList<Cliente> clientes){
        String aux = "Lista de Clientes "+"\n";

        for(Cliente clientesls : clientes){
            aux += clientesls.toString()+"\n";
        }
        return aux;
    }

    public static String listarSegurosStr(ArrayList<Seguro> seguros){
        String aux = "Lista de seguros "+"\n";

        for(Seguro segurosls : seguros){
            aux += segurosls.toString()+"\n";
        }
        return aux;
    }


    public static Frota ObterFrota(String codeDaFrota, ArrayList<Frota> listaFrota){
        //recebe o codigo da frota e retorna a frota caso exista
        for(int i = 0; i < listaFrota.size(); i++){
            if (listaFrota.get(i).getCode().equals(codeDaFrota)){
                return listaFrota.get(i);
            }
        }
        return null;
    }

    public static Condutor ObterCondutor(String identificador, ArrayList<Condutor> condutores){
        for(Condutor condutorls : condutores){
            if (condutorls.getCPF().equals(identificador)){
                return condutorls;
            }
        }
        return null;
    }

    public static Frota ObterFrota(String codigo, ClientePJ cliente){
        for(Frota frotals : cliente.getListaFrota()){
            if (frotals.getCode().equals(codigo)){
                return frotals;
            }
        }
        return null;
    }

    public static boolean buscaSinistro(Sinistro sinistro, ArrayList<Sinistro> sinistros){
        //busca sinistro na lista de sinistro
        boolean flag = false;
        for(Sinistro sinistro_ls : sinistros){
            if (sinistro_ls.equals(sinistro)){
                flag = true;
            }
        }
        return flag;
    }

    public static long calculaIdade(Date data){
        //calcula a idade da pessoa realizando a diferenca entre milissegundos entre datas e depois por milissegundos em um ano
        Calendar dataNascimento = Calendar.getInstance(); // converter tipo date para calendar
        dataNascimento.setTime(data);

        Calendar data_hoje = Calendar.getInstance();
        
        long millisecond_em_ano = 31536000000L;
    
        long idade = (data_hoje.getTimeInMillis() - dataNascimento.getTimeInMillis())/millisecond_em_ano;
       

        return idade;
    }


}
