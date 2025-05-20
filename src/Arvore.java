public class Arvore {
    No raiz;

    public int contarNos (No raiz){
        if(raiz == null) return 0;
        return 1 + contarNos(raiz.esquerda) + contarNos(raiz.direita);
    }

    public void buscarPreordem (No raiz){
        if (raiz != null){
            System.out.print(raiz.valor + " ");
            buscarPreordem(raiz.esquerda);
            buscarPreordem(raiz.direita);
        }
    }

    public void buscarEmordem (No raiz){
        if (raiz != null){
            buscarEmordem(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            buscarEmordem(raiz.direita);
        }
    }
}