package A08_executor.part2_ex_06;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int[] vet = {8, 9, 3, 5, 1};
        Set<Callable<int[]>> sort = new HashSet<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        sort.add(() -> insertionSort(vet));
        sort.add(() -> bubbleSort(vet));
        sort.add(() -> countingSort(vet));

        try {
            int[] ints = executor.invokeAny(sort);
            print(ints);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static int[] insertionSort(int[] values) {
        int[] vetor = values.clone();
        int j;
        int key;
        int i;

        for (j = 1; j < vetor.length; j++) {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
        return vetor;
    }

    public static int[] bubbleSort(int[] values) {
        int[] vet = values.clone();

        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    int aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
        return vet;
    }

    private static void print(int[] values) {
        for (int i = 0; i < values.length; ++i) {
            System.out.print(values[i] + ", ");
        }
        System.out.println();
    }

    private static int getIndiceDoMaiorElemento(int[] vetor, int inicio, int fim) {
        int indice = -1;
        int maximo = Integer.MIN_VALUE;
        for (int i = inicio; i < fim; ++i) {
            if (vetor[i] > maximo) {
                maximo = vetor[i];
                indice = i;
            }
        }
        return indice;
    }

    private static int getIndiceDoMenorElemento(int[] vetor, int inicio, int fim) {
        int indice = -1;
        int minimo = Integer.MAX_VALUE;
        for (int i = inicio; i < fim; ++i) {
            if (vetor[i] < minimo) {
                minimo = vetor[i];
                indice = i;
            }
        }
        return indice;
    }

    public static int[] countingSort(int[] values) {
        int[] vetor = values.clone();
        int menor = vetor[getIndiceDoMenorElemento(vetor, 0, vetor.length)];
        int maior = vetor[getIndiceDoMaiorElemento(vetor, 0, vetor.length)];

        //Cria um vetor com o número de posições igual ao número máximo de elementos diferentes do vetor a ser ordenado
        int[] aux = new int[maior - menor + 1];

        for (int x = 0; x < vetor.length; x++) { // aux[i] fika com o número de elementos iguais a i
            aux[vetor[x] - 1]++;
        }

        for (int x = 1; x < aux.length; x++) { // aux[i] fika com o número de elementos menores ou iguais a i
            aux[x] += aux[x - 1];
        }

        int[] resposta = new int[vetor.length]; // Crio um vetor para guardar os elementos ordenados

        for (int x = 0; x < vetor.length; x++) {
            resposta[aux[vetor[x] - 1] - 1] = vetor[x];
            aux[vetor[x] - 1] -= 1;

        }


        return resposta;
    }

}
