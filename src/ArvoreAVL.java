public class ArvoreAVL {
    No raiz;

    int altura (NoAvl No){
        if (No == null){
            return 0;
        } return No.altura;
    }

    int getBalanceamento (NoAvl No){
        if (No == null){
            return 0;
        } return altura(No.esquerda) - altura(No.direita);
    }

    void atualizarAltura (NoAvl No){
        No.altura = 1 + Math.max(altura(No.esquerda), altura(No.direita));
    }


}
