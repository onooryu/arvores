public class MainAvl {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        int[] valores = {7, 4, 10, 2, 6, 8, 12, 1, 3, 5, 9};
        for (int v : valores) {
            System.out.println("Inserir: " + v);
            arvore.raiz = arvore.inserir(arvore.raiz, v);
        }

        arvore.preOrdem(arvore.raiz);

        arvore.raiz = arvore.remover(arvore.raiz, 6);

        arvore.preOrdem(arvore.raiz);
    }
}