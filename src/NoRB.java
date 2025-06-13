public class NoRB {
    enum Cores{ RED, BLACK }
    int valor;
    Cores cor;
    NoRB direita, esquerda, pai;

    public NoRB(int valor) {
        this.valor = valor;
        this.cor = Cores.RED;
        this.direita = this.esquerda = this.pai = null;
    }
}
