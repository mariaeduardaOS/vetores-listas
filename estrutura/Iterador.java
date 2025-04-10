package Estruturas;

class Iterador {
    private No atual;

    public Iterador(ListaDuplamenteEncadeada lista) {
        this.atual = lista.getInicio();
    }


    public void inserirAposAtual(int valor) {
        if (atual == null) return;

        No novoNo = new No(valor);
        novoNo.proximo = atual.proximo;
        novoNo.anterior = atual;

        if (atual.proximo != null) {
            atual.proximo.anterior = novoNo;
        }
        atual.proximo = novoNo;
    }


    public void removerAposAtual() {
        if (atual == null || atual.proximo == null) return;

        No remover = atual.proximo;
        atual.proximo = remover.proximo;

        if (remover.proximo != null) {
            remover.proximo.anterior = atual;
        }
    }


    public void inserirAntesAtual(int valor) {
        if (atual == null) return;

        No novoNo = new No(valor);
        novoNo.proximo = atual;
        novoNo.anterior = atual.anterior;

        if (atual.anterior != null) {
            atual.anterior.proximo = novoNo;
        }
        atual.anterior = novoNo;
    }


    public void removerAntesAtual() {
        if (atual == null || atual.anterior == null) return;

        No remover = atual.anterior;
        atual.anterior = remover.anterior;

        if (remover.anterior != null) {
            remover.anterior.proximo = atual;
        }
    }
}
