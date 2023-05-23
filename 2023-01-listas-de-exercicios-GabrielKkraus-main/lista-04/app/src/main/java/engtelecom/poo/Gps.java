package engtelecom.poo;

public class Gps {

    private int coordenada_X;
    private int coordenada_Y;
    private int coordenada_Z;
    private char gpsFrente;

    public Gps(int coordenada_X, int coordenada_Y, int coordenada_Z) {
        this.coordenada_X = coordenada_X;
        this.coordenada_Y = coordenada_Y;
        this.coordenada_Z = coordenada_Z;
        gpsFrente = 'X';
    }

    public void coordenadaRotaciona() {

        if (gpsFrente == 'X') {
            this.gpsFrente = 'Y';
        }

        else if (gpsFrente == 'Y') {
            this.gpsFrente = 'X';
        }

    }

    public void incrementaGps(int incremento) {
        if (gpsFrente == 'X') {
            this.coordenada_X += incremento;
        } else if (gpsFrente == 'Y') {
            this.coordenada_Y += incremento;
        }

    }

    public void setCoordenada_Z(int coordenada_Z) {
        this.coordenada_Z += coordenada_Z;
    }

    public void retornaPontoZero() {
        this.coordenada_X -= coordenada_X;
        this.coordenada_Y -= this.coordenada_Y;
        this.coordenada_Z -= this.coordenada_Z;

    }

    public String coordenadaAtual() {

        return "[ X = " + this.coordenada_X + ", Y = " + this.coordenada_Y + ", Z = " + this.coordenada_Z
                + " ]";
    }

}
