package Model;

import java.util.ArrayList;

public class listVuelos {
    private ArrayList<vuelo> coleccion;
    
    public listVuelos(ArrayList<vuelo> coleccion) {
        this.coleccion = coleccion;
    }

    public listVuelos() {
        this.coleccion = new ArrayList<>();
    }

    public ArrayList<vuelo> getColeccion() {
        return coleccion;
    }

    public void setColeccion(ArrayList<vuelo> coleccion) {
        this.coleccion = coleccion;
    }
    
    public vuelo buscarVuelo(int numeroAux){
        for(vuelo aux : coleccion){
            if(aux.getNumero()== numeroAux){
                return aux;
            }
        }
        return null;
    }
    
    public vuelo getElemento(int pos){return coleccion.get(pos);}
    
    public void eliminarVuelo(int numeroAux){
        for(vuelo aux : coleccion){
            if(aux.getNumero() == numeroAux){
                coleccion.remove(aux);
            }
        }
    }
    
    public void agregarVuelo(vuelo Aux){
        coleccion.add(Aux);
    }
    
    public void actualizarVuelo(vuelo aux){
        int num = aux.getNumero();
        buscarVuelo(num).setDestino(aux.getDestino());
        buscarVuelo(num).setOrigen(aux.getOrigen());
        buscarVuelo(num).setHoraLlegada(aux.getHoraLlegada());
        buscarVuelo(num).setHoraSalida(aux.getHoraSalida());
    }
    
    public boolean existeVuelo(vuelo aux){
        int num = aux.getNumero();
        return buscarVuelo(num) != null;
    }
    
    public int Size() {return coleccion.size();}
    
        public Object[] creaFilallena(vuelo Aux) {
            Object[] filAux = new Object[10];
            filAux[0] = Aux.getNumero();
            filAux[1] = Aux.getOrigen().getNombre();
            filAux[2] = Aux.getHoraSalida();
            filAux[3] = Aux.getDestino().getNombre();
            filAux[4] = Aux.getHoraLlegada();
            filAux[5] = Aux.duracion();
            return filAux;
        }

          public Object[] retornaFila(int i) {
            Object[] filAux = new Object[8];
            if (i < coleccion.size()) {
                vuelo Aux = coleccion.get(i);
                filAux[0] = Aux.getNumero();
                filAux[1] = Aux.getOrigen().getNombre();// System.out.println("------------------\n"+Aux.getOrigen().getNombre()+"------------------\n");
                filAux[2] = Aux.getHoraSalida();
                filAux[3] = Aux.getDestino().getNombre();
                filAux[4] = Aux.getHoraLlegada();
                filAux[5] = Aux.duracion();
                return filAux;
            }
            return null;
        }

    @Override
    public String toString() {
        String s = "Vuelos\n";
        for(vuelo aux : coleccion){
            s = s+ aux.toString();
        }
        return s;
    }
          
        
          
}
