package Estruturas;

import java.util.Arrays;

public class VetorApp {
    public static void main(String[] args) {
        int[] vetor = {2, 7, 9, 12, 16, 21, 27, 33, 42, 54};

        System.out.println("Vetor original: " + Arrays.toString(vetor));

        int valorBusca = 16; 
        int indice = buscaBinaria(vetor, valorBusca);
        System.out.println("Índice do valor " + valorBusca + ": " + indice);


        int valorInserir = 5; 
        vetor = inserirNoInicio(vetor, valorInserir);
        System.out.println("Vetor após inserção no início: " + Arrays.toString(vetor));


        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        for (int valor : vetor) {
            lista.inserirNoFinal(valor);
        }

        System.out.print("Lista original: ");
        lista.exibirLista();


        lista.inserirAposValor(16, 99);
        System.out.print("Lista após inserir 99 após 16: ");
        lista.exibirLista();

        System.out.println("Número de nós na lista: " + lista.getNumeroDeNos());


        Iterador iterador = new Iterador(lista);
        iterador.inserirAposAtual(100);
        System.out.print("Lista após inserir 100 após o atual: ");
        lista.exibirLista();

        iterador.removerAposAtual();
        System.out.print("Lista após remover após o atual: ");
        lista.exibirLista();

        iterador.inserirAntesAtual(50);
        System.out.print("Lista após inserir 50 antes do atual: ");
        lista.exibirLista();

        iterador.removerAntesAtual();
        System.out.print("Lista após remover antes do atual: ");
        lista.exibirLista();
    }


    public static int buscaBinaria(int[] vetor, int valor) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == valor) {
                return meio;
            } else if (vetor[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; 
    }


    public static int[] inserirNoInicio(int[] vetor, int valor) {
        int[] novoVetor = new int[vetor.length + 1];
        novoVetor[0] = valor;

        for (int i = 0; i < vetor.length; i++) {
            novoVetor[i + 1] = vetor[i];
        }

        return novoVetor;
    }
}
