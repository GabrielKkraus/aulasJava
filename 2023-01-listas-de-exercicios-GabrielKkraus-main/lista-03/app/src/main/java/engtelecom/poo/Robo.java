package engtelecom.poo;

public class Robo {

    private String nome;
    private int coordenadaX;
    private int coordenadaY;
    private String frenteRobo; // Norte, Sul, Leste, Oeste
    private int bateria;
    private static int MAX = 30; // valor maximo da bateria
    private static int MIN = 0; // valor minimo da bateria

    /**
     * Modele uma classe para representar um robô de exploração. O Robô tem: um nome
     * (uma cadeia
     * de caracteres); sua coordenada atual em um plano cartesiano (números inteiros
     * positivos para
     * coordenadas X e Y); para onde está apontando sua frente (Norte, Sul, Leste ou
     * Oeste); um medidor
     * de bateria, que indica quantas unidades (no eixo X ou no eixo Y) poderá se
     * deslocar
     * 
     * @param nome        nome do robo
     * @param coordenadaX coordenada x no plano cartesiano
     * @param coordenadaY coordenada y no plano cartesiano
     * @param frenteRobo  para onde o robo esta apontando sendo: N = Norte, S = Sul,
     *                    L = Leste, O = Oeste
     * @param bateria     guantidade de bateria do robo
     */

    public Robo(String nome, int coordenadaX, int coordenadaY, String frenteRobo, int bateria) {

        if (bateria > MAX || bateria < MIN) {

            this.bateria = 10;

        } else {
            this.bateria = bateria;
        }

        if (frenteRobo == "N" || frenteRobo == "S" || frenteRobo == "L" || frenteRobo == "O") {
            this.frenteRobo = frenteRobo;

        } else {

            this.frenteRobo = "N";
        }

        if ((coordenadaX < 0) || (coordenadaY < 0)) {

            coordenadaX = 0;
            coordenadaY = 0;
        } else {
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        }

        this.nome = nome;

    }

    /**
     * Retornar sua coordenada atual na forma de uma cadeia de caracteres combinando
     * os valores
     * de X e Y, dentro de parênteses e separados por vírgula. Exemplo: “(0,0)”;
     * 
     * @return retorna coordenadas (x,y)
     */

    public String coordenadaAtual() {

        String coordenadaCombinadas = "(" + coordenadaX + "," + this.coordenadaY + ")";

        return coordenadaCombinadas;
    }

    /**
     * Retornar para onde está apontando sua frente. Deverá retornar um dos
     * seguintes caracteres:
     * N, S, L ou O;
     * 
     * @return retorna a frente do robo
     */

    public String roboApontando() {

        return frenteRobo;

    }

    /**
     * Faz o robo executar um movimento de rotação em seu próprio eixo.
     * Aceitando os parametros D e E.
     * D = Direita.
     * E = Esquerda.
     * 
     * @param direcao String que representa a direção desejada, sendo aceito E e D.
     * @return String contendo a nova orientação do robo
     */
    public String girarRobo(String direcao) {

        this.bateria--;
        switch (direcao) {
            case "D":
                switch (this.frenteRobo) {
                    case "N":
                        this.frenteRobo = "L";
                        break;
                    case "S":
                        this.frenteRobo = "O";
                        break;
                    case "L":
                        this.frenteRobo = "S";
                        break;
                    case "O":
                        this.frenteRobo = "N";
                        break;
                }
                break;
            case "E":
                switch (this.frenteRobo) {
                    case "N":
                        this.frenteRobo = "O";
                        break;
                    case "S":
                        this.frenteRobo = "L";
                        break;
                    case "L":
                        this.frenteRobo = "N";
                        break;
                    case "O":
                        this.frenteRobo = "S";
                        break;
                }
                break;
        }

        return this.frenteRobo;
    }

    /**
     * Deslocar z unidades para onde está apontando sua frente. Por exemplo, se o
     * robô foi instanciado
     * nas coordenadas x = 0, y = 10, frente = N, então quando este método for
     * invocado, sendo z = 20,
     * a nova coordenada do robô será: x = 0, y = 30, frente = N. Antes de iniciar o
     * deslocamento o
     * robô precisa verificar se tem bateria suficiente para isso. Se tiver, então
     * realiza o movimento e o
     * método retorna true, se não tiver, então o robô fica onde está e o método
     * retorna false;
     * 
     * @return True caso o movimento do robo esteja dentro do limite permitido,
     *         False caso não seja possivel movimentar o robo
     */
    public boolean moverRobo(int deslocar) {

        if (this.bateria <= MIN) {
            return false;
        }

        switch (this.frenteRobo) {
            case "N":
                if (deslocar <= this.bateria) {
                    this.coordenadaY += deslocar;
                    this.bateria -= deslocar;

                } else {
                    return false;
                }
                break;

            case "S":
                if (deslocar <= this.bateria) {
                    this.coordenadaY += deslocar;
                    this.bateria -= deslocar;

                } else {
                    return false;
                }
                break;

            case "L":
                if (deslocar <= this.bateria) {
                    this.coordenadaX += deslocar;
                    this.bateria -= deslocar;

                } else {
                    return false;
                }
                break;

            case "O":
                if (deslocar <= this.bateria) {
                    this.coordenadaX += deslocar;
                    this.bateria -= deslocar;

                } else {
                    return false;
                }
                break;
        }

        return true;
    }

    /**
     * Retornar o total de movimentos que o robô ainda será capaz de realizar antes
     * que sua bateria
     * acabe.
     * 
     * @return retorna carga atual da bateria
     */

    public int valorBateria() {

        return this.bateria;
    }

}
