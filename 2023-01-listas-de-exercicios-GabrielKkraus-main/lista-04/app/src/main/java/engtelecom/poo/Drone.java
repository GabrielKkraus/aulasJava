package engtelecom.poo;

import java.util.ArrayList;

import javax.crypto.spec.ChaCha20ParameterSpec;

import org.checkerframework.checker.units.qual.C;

public class Drone {

    private String nome;
    private Rotores rot;
    private Bateria bat;
    private Camera cam;
    private Gps gps;

    /**
     * O drone apenas pode rotacionar em 90 graus e as configurações de rotação dos
     * motores já vem pré
     * configuradas, a pode se ter até duas cameras mas o controle de ligar é unico
     * 
     * @param nome                nome do drone
     * @param cargaBateria        bateria de 0 à 100. valores a baixos de 10 o drone
     *                            retorna
     * @param QuantidadeDeCameras quantidade de cameras, pode ser até duas
     * @param gravando            liga e desliga gravação
     * @param infravermelho       liga e desliga infravermelho
     */
    public Drone(String nome, int cargaBateria, int QuantidadeDeCameras, boolean gravando, boolean infravermelho) {
        this.nome = nome;
        this.rot = new Rotores(0, 0, 0, 0);
        this.cam = new Camera(QuantidadeDeCameras, gravando, infravermelho);
        this.gps = new Gps(0, 0, 0);
        this.bat = new Bateria(cargaBateria);
        if (this.bat.getAutonomia() <= 10) {
            System.out.println("Bateria fraca");
        }
    }

    public Drone(String nome, int cargaBateria, boolean gravando, boolean infravermelho) {
        this.nome = nome;
        this.rot = new Rotores(0, 0, 0, 0);
        this.cam = new Camera(gravando, infravermelho);
        this.gps = new Gps(0, 0, 0);
        this.bat = new Bateria(cargaBateria);
        if (this.bat.getAutonomia() <= 10) {
            System.out.println("Bateria fraca");
        }
    }

    public void alterarEstadoCamera(boolean estado) {
        this.cam.setGravando(estado);
    }

    public void droneEstabilizado() {

        this.rot.setRotorUm(25);
        this.rot.setRotorDois(25);
        this.rot.setRotorTres(25);
        this.rot.setRotorQuatro(25);
        System.out.println("Drone parado(no ar)");
    }

    public void droneEsquerda() {
        this.rot.setRotorUm(25);
        this.rot.setRotorDois(50);
        this.rot.setRotorTres(25);
        this.rot.setRotorQuatro(50);
        bateriaBaixa();
        this.bat.gastoDeBateria();
        this.gps.coordenadaRotaciona();
        System.out.println("Indo para esquerda");

    }

    public void droneDireita() {
        this.rot.setRotorUm(50);
        this.rot.setRotorDois(25);
        this.rot.setRotorTres(50);
        this.rot.setRotorQuatro(25);
        bateriaBaixa();
        this.bat.gastoDeBateria();
        this.gps.coordenadaRotaciona();
        System.out.println("Indo para direita");
    }

    public void droneFrente(int incrementa) {
        this.rot.setRotorUm(100);
        this.rot.setRotorDois(100);
        this.rot.setRotorTres(50);
        this.rot.setRotorQuatro(50);
        bateriaBaixa();
        this.bat.gastoDeBateria();
        this.gps.incrementaGps(incrementa);
        System.out.println("Indo para frente " + incrementa);
    }

    public void droneAtras(int decrementa) {
        this.rot.setRotorUm(50);
        this.rot.setRotorDois(50);
        this.rot.setRotorTres(100);
        this.rot.setRotorQuatro(100);
        bateriaBaixa();
        this.bat.gastoDeBateria();
        this.gps.incrementaGps(-1 * decrementa);
        System.out.println("Indo para trás " + decrementa);
    }

    public void droneSobe(int incrementa) {
        this.rot.setRotorUm(100);
        this.rot.setRotorDois(100);
        this.rot.setRotorTres(100);
        this.rot.setRotorQuatro(100);
        bateriaBaixa();
        this.bat.gastoDeBateria();
        this.gps.setCoordenada_Z(incrementa);
        System.out.println("Subindo " + incrementa);
    }

    public void droneDesce(int decrementa) {
        this.rot.setRotorUm(10);
        this.rot.setRotorDois(10);
        this.rot.setRotorTres(10);
        this.rot.setRotorQuatro(10);
        bateriaBaixa();
        this.bat.gastoDeBateria();
        this.gps.setCoordenada_Z(-1 * decrementa);
        System.out.println("Descendo " + decrementa);
    }

    public void droneDecola() {
        droneSobe(10);
        droneEstabilizado();
        System.out.println("Decolagem concluida");
    }

    public void coordenadaDoDroneAtual() {
        bateriaBaixa();
        System.out.println(this.gps.coordenadaAtual());
    }

    public int cargaBateriaAtual() {
        System.out.println("Bateria = " + this.bat.getAutonomia());
        return this.bat.getAutonomia();
    }

    public void droneRetorna() {
        gps.retornaPontoZero();
        System.out.println("Retornando");
    }

    public void bateriaBaixa() {
        if (bat.bateriaBaixa()) {
            gps.retornaPontoZero();
            System.out.println("Bateria baixa retornando para casa, comandos de movimento serão ignorados");
        }
    }
}
