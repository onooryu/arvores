class ArvoreAVL {
    public NoAvl raiz;

    public NoAvl inserir(NoAvl no, int valor) {
        if (no == null)
            return new NoAvl(valor);

        if (valor < no.valor)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = inserir(no.direita, valor);
        else
            return no;
        atualizarAltura(no);
        return balancear(no);
    }

    public NoAvl remover(NoAvl no, int valor) {
        if (no == null) return null;

        if (valor < no.valor)
            no.esquerda = remover(no.esquerda, valor);
        else if (valor > no.valor)
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

    public NoAvl minimoValor(NoAvl no) {
        while (no.esquerda != null)
            no = no.esquerda;
        return no;
    }

    public void emOrdem(NoAvl no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public NoAvl rotacaoDireita(NoAvl y) {
        NoAvl x = y.esquerda;
        NoAvl T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    public NoAvl rotacaoEsquerda(NoAvl x) {
        NoAvl y = x.direita;
        NoAvl T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    public NoAvl balancear(NoAvl no) {
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

    public void atualizarAltura(NoAvl no) {
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    public int altura(NoAvl no) {
        if (no == null)
            return 0;
        return no.altura;
    }

    public int fatorBalanceamento(NoAvl no) {
        if (no == null)
            return 0;
        return altura(no.esquerda) - altura(no.direita);
    }
}