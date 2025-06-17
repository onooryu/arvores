public class MainRB {
    public static void main(String[] args) {
        ArvoreRB tree = new ArvoreRB();

        int[] valores = {10,20,30,15,5,25};
        for (int valor : valores){
            tree.inserir(valor);
        }

        System.out.println("Árvore após inserções (in-order)");
        tree.emOrdem();

        tree.delete(15);
        tree.delete(10);

        System.out.println("Árvore após remoções (in-order)");
        tree.emOrdem();
    }
}
