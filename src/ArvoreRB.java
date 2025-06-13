public class ArvoreRB {
    public NoRB raiz;

    private NoRB inserirOutros(NoRB atual, NoRB novo) {
        if (atual == null) return novo;
        if (novo.valor < atual.valor) {
            atual.esquerda = inserirOutros(atual.esquerda, novo);
            atual.esquerda.pai = atual;
        } else {
            atual.direita = inserirOutros(atual.direita, novo);
            atual.direita.pai = atual;
        }
        return atual;
    }
    //PAREI AQUI
    public void inserir(int valor){
        NoRB novoNo = new NoRB(valor);
        raiz = inserirOutros(raiz, novoNo);
    }

    public void colorir(NoRB no){

    }

    public NoRB rotacaoDireita(NoRB y) {
        NoRB x = y.esquerda;
        NoRB T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        return x;
    }

    public NoRB rotacaoEsquerda(NoRB x) {
        NoRB y = x.direita;
        NoRB T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        return y;
    }


}
