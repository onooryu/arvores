public class ArvoreRB {
    public NoRB raiz;

    public void inserir(int valor){
        NoRB novoNo = new NoRB(valor);
        novoNo.esquerda = novoNo.direita = novoNo.pai = null;

        NoRB y = null;
        NoRB x = raiz;

        while (x != null){
            y = x;
            if (novoNo.valor < x.valor){
                x = x.esquerda;
            } else {
                x = x.direita;
            }
        }
        novoNo.pai = y;
        if (y == null){
            raiz = novoNo;
        } else if (novoNo.valor < y.valor) {
            y.esquerda = novoNo;
        } else {
            y.direita = novoNo;
        }

        novoNo.esquerda = null;
        novoNo.direita = null;
        novoNo.cor = NoRB.Cores.RED;

        corrigirInsercao(novoNo);
    }

    public void corrigirInsercao(NoRB k) {
        while (k.pai != null && k.pai.cor == NoRB.Cores.RED) {
            if (k.pai == k.pai.pai.esquerda) {
                NoRB u = k.pai.pai.direita;
                if (u != null && u.cor == NoRB.Cores.RED) {
                    k.pai.cor = NoRB.Cores.BLACK;
                    u.cor = NoRB.Cores.BLACK;
                    k.pai.pai.cor = NoRB.Cores.RED;
                    k = k.pai.pai;
                } else {
                    if (k == k.pai.direita) {
                        k = k.pai;
                        rotacaoEsquerda(k);
                    }
                    k.pai.cor = NoRB.Cores.BLACK;
                    k.pai.pai.cor = NoRB.Cores.RED;
                    rotacaoDireita(k.pai.pai);
                }
            } else {
                NoRB u = k.pai.pai.esquerda; // Tio
                if (u != null && u.cor == NoRB.Cores.RED) {
                    k.pai.cor = NoRB.Cores.BLACK;
                    u.cor = NoRB.Cores.BLACK;
                    k.pai.pai.cor = NoRB.Cores.RED;
                    k = k.pai.pai;
                } else {
                    if (k == k.pai.esquerda) {
                        k = k.pai;
                        rotacaoDireita(k);
                    }
                    k.pai.cor = NoRB.Cores.BLACK;
                    k.pai.pai.cor = NoRB.Cores.RED;
                    rotacaoEsquerda(k.pai.pai);
                }
            }
        }
        raiz.cor = NoRB.Cores.BLACK;
    }

    public void transplant(NoRB u, NoRB v){
        if (u.pai == null){
            raiz = v;
        } else if (u == u.pai.esquerda){
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        if (v != null) {
            v.pai = u.pai;
        }
    }


    public NoRB minimum(NoRB novoNo){
        while (novoNo.esquerda != null){
            novoNo = novoNo.esquerda;
        } return novoNo;
    }

    public void emOrdem() {
        inorderHelper(raiz);
        System.out.println();
    }

    public void inorderHelper(NoRB novoNo){
        if (novoNo != null){
            inorderHelper(novoNo.esquerda);
            String colorSuffix = (novoNo.cor == NoRB.Cores.RED) ? "R" : "B";
            System.out.println(novoNo.valor + colorSuffix + " ");
            inorderHelper(novoNo.direita);
        }
    }

    private NoRB buscarArvore(NoRB raiz, int valor) {
        if (raiz == null || raiz.valor == valor)
            return raiz;
        if (valor < raiz.valor)
            return buscarArvore(raiz.esquerda, valor);
        return buscarArvore(raiz.direita, valor);
    }

    public void delete(int valor) {
        NoRB z = buscarArvore (raiz, valor);
        if (z == null) return;

        NoRB y = z;
        NoRB.Cores yOriginalCor = y.cor;
        NoRB x;

        if (z.esquerda == null) {
            x = z.direita;
            transplant(z, z.direita);
        } else if (z.direita == null) {
            x = z.esquerda;
            transplant(z, z.esquerda);
        } else {
            y = minimum(z.direita);
            yOriginalCor = y.cor;
            x = y.direita;

            if (y.pai == z) {
                if (x != null) x.pai = y;
            } else {
                transplant(y, y.direita);
                y.direita = z.direita;
                if (y.direita != null) y.direita.pai = y;
            }

            transplant(z, y);
            y.esquerda = z.esquerda;
            if (y.esquerda != null) y.esquerda.pai = y;
            y.cor = z.cor;
        }

        if (yOriginalCor == NoRB.Cores.BLACK) {
            corrigirRemocao(x);
        }
    }

    private void corrigirRemocao(NoRB x) {
        while (x != raiz && (x == null || x.cor == NoRB.Cores.BLACK)) {
            if (x == x.pai.esquerda) {
                NoRB w = x.pai.direita;
                if (w != null && w.cor == NoRB.Cores.RED) {
                    w.cor = NoRB.Cores.BLACK;
                    x.pai.cor = NoRB.Cores.RED;
                    rotacaoEsquerda(x.pai);
                    w = x.pai.direita;
                }

                if ((w.esquerda == null || w.esquerda.cor == NoRB.Cores.BLACK) &&
                        (w.direita == null || w.direita.cor == NoRB.Cores.BLACK)) {
                    w.cor = NoRB.Cores.RED;
                    x = x.pai;
                } else {
                    if (w.direita == null || w.direita.cor == NoRB.Cores.BLACK) {
                        if (w.esquerda != null) w.esquerda.cor = NoRB.Cores.BLACK;
                        w.cor = NoRB.Cores.RED;
                        rotacaoDireita(w);
                        w = x.pai.direita;
                    }

                    w.cor = x.pai.cor;
                    x.pai.cor = NoRB.Cores.BLACK;
                    if (w.direita != null) w.direita.cor = NoRB.Cores.BLACK;
                    rotacaoEsquerda(x.pai);
                    x = raiz;
                }
            } else {
                NoRB w = x.pai.esquerda;
                if (w != null && w.cor == NoRB.Cores.RED) {
                    w.cor = NoRB.Cores.BLACK;
                    x.pai.cor = NoRB.Cores.RED;
                    rotacaoDireita(x.pai);
                    w = x.pai.esquerda;
                }

                if ((w.direita == null || w.direita.cor == NoRB.Cores.BLACK) &&
                        (w.esquerda == null || w.esquerda.cor == NoRB.Cores.BLACK)) {
                    w.cor = NoRB.Cores.RED;
                    x = x.pai;
                } else {
                    if (w.esquerda == null || w.esquerda.cor == NoRB.Cores.BLACK) {
                        if (w.direita != null) w.direita.cor = NoRB.Cores.BLACK;
                        w.cor = NoRB.Cores.RED;
                        rotacaoEsquerda(w);
                        w = x.pai.esquerda;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = NoRB.Cores.BLACK;
                    if (w.esquerda != null) w.esquerda.cor = NoRB.Cores.BLACK;
                    rotacaoDireita(x.pai);
                    x = raiz;
                }
            }
        }
        x.cor = NoRB.Cores.BLACK;
    }

    public NoRB rotacaoDireita(NoRB y) {
        NoRB x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != null)
            x.direita.pai = y;
        x.pai = y.pai;

        if (y.pai == null)
            raiz = x;
        else if (y == y.pai.direita)
            y.pai.direita = x;
        else
            y.pai.esquerda = x;

        x.direita = y;
        y.pai = x;

        return x;
    }

    public NoRB rotacaoEsquerda(NoRB x) {
        NoRB y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null)
            y.esquerda.pai = x;

        y.pai = x.pai;

        if (x.pai == null)
            raiz = y;
        else if (x == x.pai.esquerda)
            x.pai.esquerda = y;
        else
            x.pai.direita = y;
        y.esquerda = x;
        x.pai = y;

        return y;
    }
}