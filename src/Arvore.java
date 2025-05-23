import java.util.Stack;

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

    public void buscarPosordem (No raiz){
        if (raiz != null){
            buscarPosordem(raiz.esquerda);
            buscarPosordem(raiz.direita);
            System.out.print(raiz.valor + " ");
        }
    }

    public void preordemIterativa(No raiz) {
        if (raiz == null) return;
        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);
        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.print(atual.valor + " ");

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
    }

    public void emordemIterativa(No raiz) {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }
            atual = pilha.pop();
            System.out.print(atual.valor + " ");
            atual = atual.direita;
        }
    }

}