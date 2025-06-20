import java.util.LinkedList;
import java.util.Queue;
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

    public void buscarEmnivel (No raiz){
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()){
            No atual = fila.poll();
            System.out.print(atual.valor + " ");
            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
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

    public void posordemIterativa(No raiz) {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;
        No ultimoVisitado = null;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }
            No topo = pilha.peek();
            if (topo.direita == null || topo.direita == ultimoVisitado) {
                System.out.print(topo.valor + " ");
                ultimoVisitado = pilha.pop();
                atual = null;
            } else {
                atual = topo.direita;
            }
        }
    }

    public int contarnosIterativoFila(No raiz){
        if (raiz == null) {
            return 0;
        }
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;
        while (!fila.isEmpty()) {
            No atual = fila.poll();
            contador++;

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
        return contador;
    }

    public int contarnosIterativoPilha(No raiz){
        if (raiz == null) {
            return 0;
        }
        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);
        int contador = 0;
        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            contador++;

            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
        }
        return contador;
    }

    public int contarNosFolha() {
        if (raiz == null) {
            return 0;
        }
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;

        while (!fila.isEmpty()) {
            No atual = fila.poll();


            if (atual.esquerda == null && atual.direita == null) {
                contador++;
            }

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
        return contador;
    }
}