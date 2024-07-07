package Model;

public class vuelo {
    private int numero;
    private ciudad origen;
    private ciudad destino;
    private int horaSalida;
    private int horaLlegada;

    public vuelo(int numero, ciudad origen, ciudad destino, int horaSalida, int horaLlegada) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public vuelo() {
        this.numero = 0;
        this.origen = new ciudad();
        this.destino = new ciudad();
        this.horaSalida = 0;
        this.horaLlegada = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(ciudad origen) {
        this.origen = origen;
    }

    public ciudad getDestino() {
        return destino;
    }

    public void setDestino(ciudad destino) {
        this.destino = destino;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(int horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    public int duracion() {
        int diferenciaGMT = destino.getGmt() - origen.getGmt();// Calcula la diferencia de GMT y ajusta si es necesario
        int llegadaEstandar = (horaLlegada + diferenciaGMT) % 24;  // Calcula la hora de llegada en el destino
        int duracionVuelo = (llegadaEstandar - horaSalida + 24) % 24; // Calcula la duración del vuelo, teniendo en cuenta casos de cruce de medianoche
        return duracionVuelo;
    }
    
}
