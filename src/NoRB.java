public class NoRB {
    enum Cores {
        RED, BLACK;
    }

    int valor;
    Cores cor;
    NoRB esquerda, direita, pai;

    public NoRB(int valor) {
        this.valor = valor;
        this.cor = Cores.RED;
        this.esquerda = this.direita = this.pai = null;
    }
}

