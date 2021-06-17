package br.unisinos.estruturas.trabalho.gb.avl;

public class Folha {

    private Folha esquerda = null; // chave menor
    private Folha direita = null; // cheve maior
    private Folha pai = null;
    private String chave; //index
    private int balanceamento;

    public Folha(String chave) {
        this.chave = chave;
        setBalanceamento(0);
    }


    public Folha getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Folha esquerda) {
        this.esquerda = esquerda;
    }

    public Folha getDireita() {
        return direita;
    }

    public void setDireita(Folha direita) {
        this.direita = direita;
    }

    public Folha getPai() {
        return pai;
    }

    public void setPai(Folha pai) {
        this.pai = pai;
    }

    public String getChave() {
        return chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    @Override
    public String toString() {
        return "Chave encontrada: " + chave;
    }
}