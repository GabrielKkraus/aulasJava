import java.util.Random;

public class CampoMinado {

    public static void main(String[] args) {
        char[][] matriz = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = '.';
            }
        }

        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int j = r.nextInt(9);
            int k = r.nextInt(9);

            if (matriz[j][k] == '*') {
                i--;
            }
            matriz[j][k] = '*';
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}