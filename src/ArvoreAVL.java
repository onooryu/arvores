public class ArvoreAVL {
    private NoAvl raiz;

    public void inserir(String valor) {
        raiz = inserir(raiz, valor);
    }

    private NoAvl inserir(NoAvl no, String valor) {
        if (no == null) return new NoAvl(valor);

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = inserir(no.direita, valor);
        else
            return no;

        atualizarAltura(no);
        return balancear(no);
    }


    public void remover(String valor) {
        raiz = remover(raiz, valor);
    }

    private NoAvl remover(NoAvl no, String valor) {
        if (no == null) return null;

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = remover(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = remover(no.direita, valor);
        else {
            if (no.esquerda == null || no.direita == null) {
                no = (no.esquerda != null) ? no.esquerda : no.direita;
            } else {
                NoAvl sucessor = minimoValor(no.direita);
                no.valor = sucessor.valor;
                no.direita = remover(no.direita, sucessor.valor);
            }
        }

        if (no == null) return null;

        atualizarAltura(no);
        return balancear(no);
    }

    private NoAvl minimoValor(NoAvl no) {
        while (no.esquerda != null)
            no = no.esquerda;
        return no;
    }


    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(NoAvl no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }


    private NoAvl rotacaoDireita(NoAvl y) {
        NoAvl x = y.esquerda;
        NoAvl T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private NoAvl rotacaoEsquerda(NoAvl x) {
        NoAvl y = x.direita;
        NoAvl T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    private NoAvl balancear(NoAvl no) {
        int fb = fatorBalanceamento(no);

        if (fb > 1) {
            if (fatorBalanceamento(no.esquerda) < 0)
                no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (fb < -1) {
            if (fatorBalanceamento(no.direita) > 0)
                no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private void atualizarAltura(NoAvl no) {
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    private int altura(NoAvl no) {
        return (no == null) ? 0 : no.altura;
    }

    private int fatorBalanceamento(NoAvl no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }
}
