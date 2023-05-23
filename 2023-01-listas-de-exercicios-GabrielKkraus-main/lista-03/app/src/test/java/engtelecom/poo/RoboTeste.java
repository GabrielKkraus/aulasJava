package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RoboTeste {

    @Test
    public void testeCoordenadaAtual() {

        Robo a = new Robo("Zeta", 5, 8, "N", 25);
        Robo c = new Robo("Zeta", -3, 8, "N", 25);

        assertEquals("(5,8)", a.coordenadaAtual());
        assertEquals("(0,0)", c.coordenadaAtual());

    }

    @Test
    void testeRoboApontando() {
        Robo a = new Robo("Zeta", 5, 8, "N", 25);
        Robo b = new Robo("Zeta", 5, 8, "S", 25);
        Robo c = new Robo("Zeta", 5, 8, "L", 25);
        Robo d = new Robo("Zeta", 5, 8, "O", 25);
        Robo e = new Robo("Zeta", -3, 8, "k", 25);

        assertEquals("N", a.roboApontando());
        assertEquals("S", b.roboApontando());
        assertEquals("L", c.roboApontando());
        assertEquals("O", d.roboApontando());
        assertEquals("N", e.roboApontando());

    }

    @Test
    void testeGirarRobo() {
        Robo a = new Robo("Zeta", 5, 8, "N", 25);
        Robo b = new Robo("Zeta", 5, 8, "S", 25);
        Robo c = new Robo("Zeta", 5, 8, "L", 25);
        Robo d = new Robo("Zeta", 5, 8, "O", 25);
        Robo e = new Robo("Zeta", -3, 8, "k", 25);

        assertEquals("L", a.girarRobo("D"));
        assertEquals("L", b.girarRobo("E"));
        assertEquals("S", c.girarRobo("D"));
        assertEquals("N", d.girarRobo("D"));
        assertEquals("L", e.girarRobo("D"));
    }

    @Test
    void testeMoverRobo() {
        Robo a = new Robo("Zeta", 5, 8, "N", 31);
        Robo b = new Robo("Zeta", 5, 8, "S", 25);
        Robo c = new Robo("Zeta", 5, 8, "L", -2);
        Robo d = new Robo("Zeta", 5, 8, "O", 5);
        Robo e = new Robo("Zeta", -3, 8, "k", -5);

        assertEquals(true, a.moverRobo(5));
        assertEquals(true, b.moverRobo(3));
        assertEquals(true, c.moverRobo(5));
        assertEquals(false, d.moverRobo(6));
        assertEquals(false, e.moverRobo(11));
    }

    @Test
    void testeValorBateria() {
        Robo a = new Robo("Zeta", 5, 8, "N", 31);
        Robo b = new Robo("Zeta", 5, 8, "S", 25);
        Robo c = new Robo("Zeta", 5, 8, "L", -2);
        Robo d = new Robo("Zeta", 5, 8, "O", 5);
        Robo e = new Robo("Zeta", -3, 8, "k", -5);

        assertEquals(10, a.valorBateria());
        assertEquals(25, b.valorBateria());
        assertEquals(10, c.valorBateria());
        assertEquals(5, d.valorBateria());
        assertEquals(10, e.valorBateria());
    }
}