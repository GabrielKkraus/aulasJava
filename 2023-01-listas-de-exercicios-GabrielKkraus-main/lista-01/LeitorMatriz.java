import java.util.Scanner;

public class LeitorMatriz {
    public static void main(String[] args) {
        // lê arquivo
        Scanner entrada = new Scanner(System.in);
        int i = 0;
        char[][] matriz = new char[9][9];
        while (entrada.hasNext()) {
            String linha = entrada.nextLine();
            // trasforma linha em vetor
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = linha.charAt(j);
            }
            i++;
        }
        // percorre todas linhas e colunas
        for (int lin = 0; lin < 9; lin++) {
            for (int col = 0; col < 9; col++) {
                if (matriz[lin][col] == '*') {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            // ignora o valor de x e y em 0
                            if (x == 0 && y == 0) {
                                continue;
                            }
                            // analisa se o valor a ser adicionado está fora da matriz
                            if (x + lin >= 9 || y + col >= 9 || y + col < 0 || x + lin < 0) {
                                continue;
                            }
                            // adiciona 1 em volta das bombas
                            else if (matriz[x + lin][y + col] == '.') {
                                matriz[x + lin][y + col] = '1';
                            }
                            // se já foi adicionado algum numero o valor é incrementado
                            else if (matriz[x + lin][y + col] != '*') {
                                matriz[x + lin][y + col]++;
                            }
                        }
                    }
                }
            }
        }
        // imprime matriz
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(matriz[x][y]);
            }
            System.out.println("");
        }
    }
}