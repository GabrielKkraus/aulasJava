package engtelecom.poo;

public class Bateria {

    private int autonomia;

    public Bateria(int autonomia) {
        if (autonomia > 100 || autonomia < 0) {
            this.autonomia = 100;
        }

        else {
            this.autonomia = autonomia;
        }
    }

    public void gastoDeBateria() {
        this.autonomia -= 1;
    }

    public boolean bateriaBaixa() {
        if (this.autonomia <= 10) {
            return true;
        } else
            return false;

    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getAutonomia() {
        return autonomia;
    }

}
