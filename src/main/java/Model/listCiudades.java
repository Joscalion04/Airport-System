package Model;

import java.util.ArrayList;

public class listCiudades {
    private ArrayList<ciudad> coleccion;

    public listCiudades(ArrayList<ciudad> coleccion) {
        this.coleccion = coleccion;
    }

    public listCiudades() {
        this.coleccion = new ArrayList<>();
    }

    public ArrayList<ciudad> getColeccion() {
        return coleccion;
    }

    public void setColeccion(ArrayList<ciudad> coleccion) {
        this.coleccion = coleccion;
    }
    
    public ciudad buscarCiudad(String idAux){
        for(ciudad aux : coleccion){
            if(aux.getId() == null ? idAux == null : aux.getId().equals(idAux)){
                return aux;
            }
        }
        return null;
    }
    
    public void eliminarCiudad(String idAux){
        for(ciudad aux : coleccion){
            if(aux.getId() == idAux){
                coleccion.remove(aux);
            }
        }
    }
    
    public ciudad buscaCiudadPos(int pos){
        return coleccion.get(pos);
    }
    
    public void agregarCiudad(ciudad Aux){
        coleccion.add(Aux);
    }

    @Override
    public String toString() {
        String s = "CIUDADES\n";
        for(ciudad aux : coleccion){
            s = s+ aux.toString()+"\n";
        }
        return s;
    }
    
    
}
