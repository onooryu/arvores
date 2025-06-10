public class MainAvl {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        int[] valores = {10, 20, 30, 40, 50, 25};
        for (int v : valores) {
            System.out.println("Inserir: " + v);
            arvore.raiz = arvore.inserir(arvore.raiz, v);
        }

        arvore.emOrdem(arvore.raiz);
        System.out.println();
        arvore.raiz = arvore.remover(arvore.raiz, 30);
        arvore.emOrdem(arvore.raiz);
    }
}