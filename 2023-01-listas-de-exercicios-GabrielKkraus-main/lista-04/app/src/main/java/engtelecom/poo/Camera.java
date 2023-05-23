package engtelecom.poo;

import java.beans.IntrospectionException;

public class Camera {

    private int quantidade;
    private boolean gravando;
    private boolean infravermelho;

    public void setGravando(boolean gravando) {
        this.gravando = gravando;
    }

    public void setInfravermelho(boolean infravermelho) {
        this.infravermelho = infravermelho;
    }

    public Camera(int quantidade, boolean gravando, boolean infravermelho) {

        if (quantidade > 2) {
            this.quantidade = 2;
        } else if (quantidade < 1) {
            this.quantidade = 1;
        } else {
            this.quantidade = quantidade;
        }

        this.gravando = gravando;
        if (gravando) {
            System.out.println(quantidade + " camera ON");
        } else {
            System.out.println(quantidade + "camera OFF");
        }

        this.infravermelho = infravermelho;
        if (infravermelho) {
            System.out.println("Imfravermelho ON");
        } else {
            System.out.println("Imfravermelho OFF");
        }
    }

    public Camera(boolean gravando, boolean infravermelho) {

        this.quantidade = 1;
        this.gravando = gravando;
        if (gravando) {
            System.out.println("Camera ON");
        } else {
            System.out.println("Camera OFF");
        }
        this.infravermelho = infravermelho;
        if (infravermelho) {
            System.out.println("Imfravermelho ON");
        } else {
            System.out.println("Imfravermelho OFF");
        }

    }

}
