package estruturas;

public class Lista {

    public No inicio;
    public No cauda;
    public int tamanho;

    public Lista() {
        this.inicio = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void adicionarAoInicio(int valor) {
        No no = new No(valor);
        if (this.inicio == null) {
            this.inicio = no;
            this.cauda = no;
        } else {
            this.inicio.anterior = no;
            no.proximo = this.inicio;
            this.inicio = no;
        }
        tamanho++;
    }

    public void adicionarAoFinal(int valor) {
        No no = new No(valor);
        if (this.inicio == null) {
            this.inicio = no;
            this.cauda = no;
        } else {
            this.cauda.proximo = no;
            no.anterior = this.cauda;
            this.cauda = no;
        }
        tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void inserirAposValor(int valor, int novoValor) {
        No noAux = this.inicio;
        while (noAux != null && noAux.valor != valor) {
            noAux = noAux.proximo;
        }
        if (noAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }
        No novoNo = new No(novoValor);
        novoNo.proximo = noAux.proximo;
        novoNo.anterior = noAux;
        if (noAux.proximo != null) {
            noAux.proximo.anterior = novoNo;
        } else {
            this.cauda = novoNo;
        }
        noAux.proximo = novoNo;
        tamanho++;
    }

    public void mostrarNos() {
        Iterador iterador = this.getIterador();
        while (iterador.getAtual() != null) {
            iterador.display();
            iterador.proximo();
        }
    }

    public Iterador getIterador() {
        return new Iterador(this, this.inicio);
    }
}