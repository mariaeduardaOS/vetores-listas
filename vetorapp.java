import java.util.Arrays;

class Vetor {
    private int[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (tamanho < elementos.length) {
            elementos[tamanho++] = elemento;
        } else {
            System.out.println("Vetor cheio");
        }
    }

    public int buscaBinaria(int valor) {
        int inicio = 0, fim = tamanho - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (elementos[meio] == valor) return meio;
            if (elementos[meio] < valor) inicio = meio + 1;
            else fim = meio - 1;
        }
        return -1;
    }

    public void inserirNoInicio(int valor) {
        if (tamanho == elementos.length) {
            System.out.println("Vetor cheio");
            return;
        }
        for (int i = tamanho; i > 0; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[0] = valor;
        tamanho++;
    }

    public void exibir() {
        System.out.println(Arrays.toString(Arrays.copyOf(elementos, tamanho)));
    }
}

class No {
    int valor;
    No anterior, proximo;

    public No(int valor) {
        this.valor = valor;
        this.anterior = this.proximo = null;
    }
}

class ListaDuplamenteEncadeada {
    private No inicio, fim;
    private int tamanho;

    public void inserirNoFinal(int valor) {
        No novo = new No(valor);
        if (fim == null) inicio = fim = novo;
        else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        tamanho++;
    }

    public int getNumeroNos() {
        return tamanho;
    }

    public void inserirAposValor(int valorReferencia, int novoValor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor == valorReferencia) {
                No novo = new No(novoValor);
                novo.proximo = atual.proximo;
                novo.anterior = atual;
                if (atual.proximo != null) atual.proximo.anterior = novo;
                else fim = novo;
                atual.proximo = novo;
                tamanho++;
                return;
            }
            atual = atual.proximo;
        }
    }

    public void exibir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class VetorApp {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(20);
        int[] valores = {2, 7, 9, 12, 16, 21, 27, 33, 42, 54};
        for (int v : valores) vetor.adicionar(v);
        
        System.out.print("Vetor antes: ");
        vetor.exibir();
        vetor.inserirNoInicio(99);
        System.out.print("Vetor após inserção no início: ");
        vetor.exibir();

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        for (int v : valores) lista.inserirNoFinal(v);
        
        System.out.print("Lista antes: ");
        lista.exibir();
        lista.inserirAposValor(21, 100);
        System.out.print("Lista após inserção: ");
        lista.exibir();
        
        System.out.println("Número de nós: " + lista.getNumeroNos());
    }
}
