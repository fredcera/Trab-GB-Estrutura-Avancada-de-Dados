package br.unisinos.estruturas.trabalho.gb.avl;

import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;

public class Folha {

    private Folha esquerda = null; // chave menor
    private Folha direita = null; // cheve maior
    private Folha pai = null;
    private String chave; //index
    private Pessoa pessoa;

    private int balanceamento;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Folha(Pessoa pessoa, String chave) {
        this.chave = chave;
        setBalanceamento(0);
        this.pessoa = new Pessoa(pessoa.getNome(), pessoa.getCpf(), pessoa.getRg(), pessoa.getData(), pessoa.getCidade());
    }

    @Override
    public String toString() {
        return "Node{" + " Chave=" + chave + '}';
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

    public void setChave(String chave) {
        this.chave = chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }
}