public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.raiz = new No("A");
        arvore.raiz.esquerda = new No("B");
        arvore.raiz.direita = new No("C");
        arvore.raiz.esquerda.esquerda = new No("D");
        arvore.raiz.esquerda.direita = new No("E");
        arvore.raiz.direita.direita = new No("F");


        System.out.println(arvore.contarNos(arvore.raiz));

        System.out.println("percorrendo em pré-ordem: ");
        arvore.buscarPreordem(arvore.raiz);
        System.out.println();
        System.out.println("percorrendo em ordem: ");
        arvore.buscarEmordem(arvore.raiz);
        System.out.println();
        System.out.println("percorrendo em pré-ordem iterativa: ");
        arvore.preordemIterativa(arvore.raiz);
        System.out.println();
        System.out.println("Percorrendo em ordem iterativa: ");
        arvore.emordemIterativa(arvore.raiz);
    }
}
