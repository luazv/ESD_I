import estruturas.Lista;

public class VetorApp {

    public static void main(String[] args) {
        Lista lista = new Lista();
        
        int[] valores = {2, 7, 9, 12, 16, 21, 27, 33, 42, 54};

        for (int valor : valores) {
            lista.adicionarAoFinal(valor);
        }

        System.out.println("Lista inicial:");
        lista.mostrarNos();

        System.out.println("-----");

        lista.remover(21);
        System.out.println("Lista após remover o valor 21:");
        lista.mostrarNos();
    }
}