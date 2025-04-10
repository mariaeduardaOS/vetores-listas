package Estruturas;

class No {
    int valor;
    No anterior;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserirNoFinal(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
        tamanho++;
    }

    public int getNumeroDeNos() {
        return tamanho;
    }

    public boolean inserirAposValor(int valorReferencia, int novoValor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor == valorReferencia) {
                No novoNo = new No(novoValor);
                novoNo.proximo = atual.proximo;
                novoNo.anterior = atual;

                if (atual.proximo != null) {
                    atual.proximo.anterior = novoNo;
                } else {
                    fim = novoNo;
                }

                atual.proximo = novoNo;
                tamanho++;
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void exibirLista() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public No getInicio() {
        return inicio;
    }
}
