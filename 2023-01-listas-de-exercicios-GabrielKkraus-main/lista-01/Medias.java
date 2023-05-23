public class Medias {

    public static void main(String[] args) {

        System.out.println("Forneceu " + args.length + " argumentos");
        System.out.println("Argumentos fornecidos: ");

        float projeto1 = Float.parseFloat(args[0]);
        float projeto2 = Float.parseFloat(args[1]);
        float lista1 = Float.parseFloat(args[2]);
        float lista2 = Float.parseFloat(args[3]);
        float lista3 = Float.parseFloat(args[4]);
        float lista4 = Float.parseFloat(args[5]);
        float lista5 = Float.parseFloat(args[6]);

        float listaCal = (lista1 * lista2 * lista3 * lista4 * lista5);
        double cf = ((((projeto1 * 2 + projeto2 * 4) / 6) * 0.9) + (Math.pow(listaCal, 0.2) * 0.1));
        System.out.println("A nota final é " + cf);

        if (cf >= 6) {
            System.out.println("aluno APROVADO");
        }

        else {
            System.out.println("aluno REPROVADO");
        }
    }
}