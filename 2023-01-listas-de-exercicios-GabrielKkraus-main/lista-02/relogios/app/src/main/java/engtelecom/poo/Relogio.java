package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;

public class Relogio {

    private String nome = "UTC";
    private int fusoHorario;
    private int x;
    private int y;

    public Relogio(int x, int y) {

        if (x >= 0 && x <= 700) {
            this.x = x;
        } else {
            this.x = 400;

            if (y >= 0 && y <= 700) {
                this.y = y;
            } else {
                this.y = 400;
            }

            this.fusoHorario = -3;
            this.nome = "Brasilia";
        }
    }

    public Relogio(String nome, int fusoHorario, int x, int y) {

        this.nome = nome;
        if (x >= 0 && x <= 700) {
            this.x = x;
        } else {
            this.x = 400;
        }

        if (y >= 0 && y <= 700) {
            this.y = y;
        } else {
            this.y = 400;
        }

        if (fusoHorario >= -12 && fusoHorario <= 12) {
            this.fusoHorario = fusoHorario;
        } else {
            this.fusoHorario = 0;
        }

    }

    public String horaMinutoSegundo(int hora, int minuto, int segundo) {
        String sHora, sMinuto, sSegundo;
        hora = aplicaFuso(hora);

        if (!verificaUTC(hora, minuto, segundo)) {
            nome = "UTC";
            hora = 0;
            sHora = Integer.toString(hora);
            if (hora < 10) {
                sHora = '0' + Integer.toString(hora);
            }
            return nome + ", " + sHora + ':' + "00" + ':' + "00";
        }
        sHora = Integer.toString(hora);
        sMinuto = Integer.toString(minuto);
        sSegundo = Integer.toString(segundo);
        if (hora < 10) {
            sHora = '0' + Integer.toString(hora);
        }
        if (minuto < 10) {
            sMinuto = '0' + Integer.toString(minuto);
        }
        if (segundo < 10) {
            sSegundo = '0' + Integer.toString(segundo);
        }

        return this.nome + ", " + sHora + ':' + sMinuto + ':' + sSegundo;

    }

    private boolean verificaUTC(int hora, int minuto, int segundo) {
        return hora < 24 && hora >= 0 && minuto <= 59 && minuto >= 0 && segundo <= 59 && segundo >= 0;
    }

    private int aplicaFuso(int horas) {
        int valorHora = horas + this.fusoHorario;

        if (this.fusoHorario > 0) {
            if (horas == 23) {
                horas = this.fusoHorario - 1;
            } else if (valorHora > 23) {
                horas = valorHora - 24;
            }
        }
        if (this.fusoHorario < 0) {
            if (horas == 0) {
                horas = 24 + this.fusoHorario;
            } else if (valorHora < 0) {
                int x = Math.abs(valorHora);
                horas = 24 - x;
            }
        }
        if (valorHora >= 0 && valorHora <= 23) {
            horas = valorHora;
        }
        return horas;
    }

    public void desenha(Draw desenhaRelogio, int horas, int minutos, int segundos) {
        if (!verificaUTC(horas, minutos, segundos)) {
            horas = 0;
            horas = aplicaFuso(horas);
            minutos = 0;
            segundos = 0;
            this.nome = "UTC";
        }
        horas = aplicaFuso(horas);
        double vetX = 0.5 + this.x;
        double vetY = 0.5 + this.y;
        desenhaRelogio.setPenColor(Draw.WHITE);
        desenhaRelogio.filledCircle(vetX, vetY, 100.5);
        desenhaRelogio.setPenColor(Draw.BLACK);
        double r2 = 50.08;
        double r3 = 50.05;
        double r4 = 100;
        double r5 = 90;

        desenhaRelogio.setPenRadius(0.01);
        for (int i = 0; i < 12; i++) {
            double valor = Math.toRadians(30 * i);
            // https://brasilescola.uol.com.br/matematica/simetria-no-circulo-trigonometrico.htm
            desenhaRelogio.line(vetX + r5 * Math.sin(valor), vetY + r5 * Math.cos(valor), vetX + r4 * Math.sin(valor),
                    vetY + r4 * Math.cos(valor));
        }
        double h = Math.toRadians(30 * horas);
        double m = Math.toRadians(6 * minutos);
        double s = Math.toRadians(6 * segundos);
        // 360 graus / 12 horas = 30 graus
        desenhaRelogio.line(vetX, vetY, vetX + r3 * Math.sin(h), vetY + r3 * Math.cos(h));
        // 360 graus / 60 minutos = 6 graus
        desenhaRelogio.setPenColor(Draw.BLUE);
        desenhaRelogio.line(vetX, vetY, vetX + r3 * 2 * Math.sin(m), vetY + r3 * 2 * Math.cos(m));
        desenhaRelogio.setPenColor(Draw.RED);
        desenhaRelogio.setPenRadius(0.005);
        desenhaRelogio.line(vetX, vetY, vetX + r2 * 2 * Math.sin(s), vetY + r2 * 2 * Math.cos(s));
        desenhaRelogio.text(vetX + 10, vetY + 10, this.nome);

    }
}
