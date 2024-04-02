import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        ArrayList<Integer> lista3 = new ArrayList<Integer>();

        // * PREENCHER */
        preencherLista(lista1);
        preencherLista(lista2);

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);

        // * ORDENAR */
        ordenarListas(lista1);
        ordenarListas(lista2);

        System.out.println("Lista 1 Ordenada: " + lista1);
        System.out.println("Lista 2 Ordenada: " + lista2);

        // * UNIR */
        unirListasOrdenadas(lista1, lista2, lista3);

        System.out.println("Listas : " + lista3);

        // * REMOVER */
        removerElementosRepetidos(lista3);

        System.out.println("Lista 3 (Sem elementos repetidos): " + lista3);

        // * INVERTER */
        inverterLista(lista3);

        System.out.println("Lista 3 Invertida: " + lista3);
    }

    private static void preencherLista(ArrayList<Integer> list) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randNumber = rand.nextInt(30) + 1;
            list.add(randNumber);
        }
    }

    private static void ordenarListas(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    private static void unirListasOrdenadas(ArrayList<Integer> lista1, ArrayList<Integer> lista2,
            ArrayList<Integer> lista3) {
        ordenarListas(lista1);
        ordenarListas(lista2);

        int i = 0, j = 0;
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                lista3.add(lista1.get(i));
                i++;
            } else {
                lista3.add(lista2.get(j));
                j++;
            }
        }

        while (i < lista1.size()) {
            lista3.add(lista1.get(i));
            i++;
        }

        while (j < lista2.size()) {
            lista3.add(lista2.get(j));
            j++;
        }
    }

    private static void removerElementosRepetidos(ArrayList<Integer> list) {
        ArrayList<Integer> listaSemRepeticao = new ArrayList<>();

        for (Integer elemento : list) {
            if (!listaSemRepeticao.contains(elemento)) {
                listaSemRepeticao.add(elemento);
            }
        }

        list.clear();
        list.addAll(listaSemRepeticao);
    }

    private static void inverterLista(ArrayList<Integer> list) {
        int tamanho = list.size();
        for (int i = 0; i < tamanho / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(tamanho - 1 - i));
            list.set(tamanho - 1 - i, temp);
        }
    }

}
