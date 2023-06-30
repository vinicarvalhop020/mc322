import java.util.ArrayList;

public class AuxilarSeguradora {
	//Classe estatica contendo funcoes uteis para utilizacao da seguradora



    public static boolean buscar_cliente(String identificador, ArrayList<Cliente> clientes){
        //busca cliente, recebendo uma lista de clientes e um identificador
		boolean flag = false;
		for(int i = 0; i < clientes.size(); i++){
			if (clientes.get(i).getIdentificador().equals(identificador)){
				flag = true;
			}
		}
		return flag;
	}

	public static boolean buscar_condutor(String identificador, ArrayList<Condutor> condutores){
        //busca condutor, recebendo uma lista de clientes e um identificador
		boolean flag = false;
		for(int i = 0; i < condutores.size(); i++){
			if (condutores.get(i).getCPF().equals(identificador)){
				flag = true;
			}
		}
		return flag;
	}

	public static boolean buscarSeguro(int ID, ArrayList<Seguro> seguros){

		boolean flag = false;
		for(int i = 0; i < seguros.size(); i++){
			if (seguros.get(i).getId() == ID){
				flag = true;
			}
		}
		return flag;
	}

	public static int calculaqtdSinistrosCliente(Seguradora seguradora, Cliente cliente){
		//Atraves da seguradora obtem-se a lista de sinistros do cliente e o tamanho dessa informa a quantidade de sinistros do cliente 
		int quantidadeSinistrosCliente = seguradora.getSinistrosPorCliente(cliente).size();
		return quantidadeSinistrosCliente;
	}

	public static int calculaqtdSinistrosCondutor(Seguro seguro){
		//atraves do seguro obtem-se a lista de condutores desse seguro
		//em cada condutor dessa lista de condutores existe uma lista de sinistros
		//basta acumular em uma variavel o tamanho dessas listas de sinistros,de cada condutor
		ArrayList<Condutor> condutores = seguro.getLCondutores();
		int quantidadeSinistrosCondutor = 0;
		for(Condutor condutor : condutores){
			quantidadeSinistrosCondutor += condutor.getSinistros().size();
		}

		return quantidadeSinistrosCondutor;
	}

	public static int calculaqtdFuncionarios(Seguro seguro){
		int quantidadeFunc = seguro.getLCondutores().size();
		return quantidadeFunc;
	}


	public static Seguradora obterSeguradora(ArrayList<Seguradora> seguradoras, String cnpj){
		//busca um objeto seguradora pelo cnpj
		for(int i = 0; i < seguradoras.size(); i++){
			if (seguradoras.get(i).getCnpj().equals(cnpj)){
				return seguradoras.get(i);
			}
		}
		return null;
	}

	public static Cliente obterCliente(Seguradora seguradora, String identificador){
		for(Cliente ClienteAUX : seguradora.listarclientes()){
			if(ClienteAUX.getIdentificador().equals(identificador)){
				return ClienteAUX;
			}
		}
		return null;
	}

	public static Seguro obterSeguro(Seguradora seguradora, int id){
		for(Seguro seguro : seguradora.listarseguros()){
			if(seguro.getId() == id){
				return seguro;
			}
		}
		return null;
	}

	public static Sinistro obterSinistro(Seguradora seguradora, int id){
		for (Seguro seguro: seguradora.listarseguros()){
			for(Sinistro sinistro : seguro.getLSinistros()){
				if(sinistro.getID() == id){
					return sinistro;
				}
			}
		}
		return null;
	}
}


