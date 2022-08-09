package Objetos;

public class Tarjeta {

    private String infoReto;
    private int puntos;

    public Tarjeta(String infoReto, int puntos) {
        this.infoReto = infoReto;
        this.puntos = puntos;
    }

    public String getInfoReto() {
        return infoReto;
    }

    public void setInfoReto(String infoReto) {
        this.infoReto = infoReto;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
