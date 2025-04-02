package estruturas;

public class Iterador {
    
    Lista lista;
    No atual;

    public Iterador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public Boolean haProximo() {
        return this.atual.proximo != null;
    }

    public Boolean haAnterior() {
        return this.atual.anterior != null;
    }

    public void proximo() {
        if (haProximo()) {
            this.atual = atual.proximo;
        } else {
            System.out.println("Não há próximo nó.");
        }
    }

    public int getDadoAnterior() {
        if (haAnterior()) {
            return this.atual.anterior.valor;
        }
        throw new IllegalStateException("Não há nó anterior.");
    }

    public int getDadoProximo() {
        if (haProximo()) {
            return this.atual.proximo.valor;
        }
        throw new IllegalStateException("Não há próximo nó.");
    }

    public int getDado() {
        return this.atual.valor;
    }

    public No getAtual() {
        return this.atual;
    }

    public void resetar() {
        this.atual = this.lista.inicio;
    }

    public void display() {
        if (this.haAnterior()) {
            System.out.print("Anterior -> " + this.getDadoAnterior() + " | ");
        }

        System.out.print("No " + this.getDado());
        
        if (this.haProximo()) {
            System.out.println(" | Proximo -> " + this.getDadoProximo());
        }
        System.out.println("");
        this.proximo();
    }

    // 04 - Inserir após o atual
    public void inserirAposAtual(int novoValor) {
        No novoNo = new No(novoValor);
        novoNo.proximo = this.atual.proximo;
        novoNo.anterior = this.atual;

        if (this.atual.proximo != null) {
            this.atual.proximo.anterior = novoNo;
        }
        this.atual.proximo = novoNo;

        if (this.atual == this.lista.cauda) {
            this.lista.cauda = novoNo; // Atualiza a cauda se necessário
        }
        this.lista.tamanho++;
    }

    // 04 - Remover após o atual
    public void removerAposAtual() {
        if (this.atual.proximo == null) {
            System.out.println("Não é possível remover após o nó atual!");
            return;
        }
        No noParaRemover = this.atual.proximo;
        this.atual.proximo = noParaRemover.proximo;

        if (noParaRemover.proximo != null) {
            noParaRemover.proximo.anterior = this.atual;
        } else {
            this.lista.cauda = this.atual; // Atualiza a cauda se necessário
        }
        this.lista.tamanho--;
    }

    // 04 - Inserir antes do atual
    public void inserirAntesAtual(int novoValor) {
        No novoNo = new No(novoValor);
        novoNo.proximo = this.atual;
        novoNo.anterior = this.atual.anterior;

        if (this.atual.anterior != null) {
            this.atual.anterior.proximo = novoNo;
        } else {
            this.lista.inicio = novoNo; // Atualiza a cabeça se necessário
        }
        this.atual.anterior = novoNo;
        this.lista.tamanho++;
    }

    // 04 - Remover antes do atual
    public void removerAntesAtual() {
        if (this.atual.anterior == null) {
            System.out.println("Não é possível remover antes do nó atual!");
            return;
        }
        No noParaRemover = this.atual.anterior;
        this.atual.anterior = noParaRemover.anterior;

        if (noParaRemover.anterior != null) {
            noParaRemover.anterior.proximo = this.atual;
        } else {
            this.lista.inicio = this.atual; // Atualiza a cabeça se necessário
        }
        this.lista.tamanho--;
    }
}