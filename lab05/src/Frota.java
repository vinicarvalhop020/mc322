import java.util.ArrayList;

public class Frota {
    private String code;
    private ArrayList<Veiculo> frota;

    public Frota(String code){
		this.code = code;
        this.frota = new ArrayList<>();
    }

    //getts
    public String getCode(){
        return this.code;
    }

    public ArrayList<Veiculo> getFrota(){
        return this.frota;
    }

    //setts
    public void setCode(String newCode){
        this.code = newCode;
    }
    
    public void setFrota(ArrayList<Veiculo> novaFrota){
        this.frota = novaFrota;
    }

    public boolean buscar_veiculo(Veiculo veiculo){
        boolean flag;
        for(int i = 0; i < frota.size();i++){
            this.frota.get(i).equals(veiculo);
            flag = true;
        }
        flag = false;
        return flag;
    }

    public boolean addVeiculo(Veiculo veiculo){
        boolean flag;
    
        if(!buscar_veiculo(veiculo)){
            flag = true;
            frota.add(veiculo);
        }
        else 
            flag = false;

    return flag;
    }

    public boolean removeVeiculo(Veiculo veiculo){
        boolean flag;

        if(buscar_veiculo(veiculo)){
            flag = true;
            frota.remove(veiculo);
        }
        else 
            flag = false;
    
    return flag;
    }

    public String toString(){
        String aux;

        aux = "Codigo da Frota " + this.code + '\n'+
                AuxiliarCliente.listarVeiculosStr(frota);
        
        return aux;
    }

}
