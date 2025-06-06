public class MainAvl {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        String[] valores = {"G", "D", "J", "B", "F", "H", "K", "A", "C", "E", "I"};
        for (String v : valores) {
            System.out.println("Inserir: " + v);
            arvore.inserir(v);
        }

        arvore.preOrdem();
        arvore.remover("F");
        System.out.println();
        arvore.preOrdem();
    }
}
