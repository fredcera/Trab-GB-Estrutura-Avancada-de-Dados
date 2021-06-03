package br.unisinos.estruturas.trabalho.gb.entity;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private String cpf;
    private Integer rg;

    private LocalDate data;
    private String cidade;

    public Pessoa(String nome, String cpf, Integer rg, LocalDate data, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.data = data;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public LocalDate getData() {
        return data;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return String.format(""
                + "Nome: %s \n"
                + "CPF: %s \n"
                + "RG: %s \n"
                + "Data de Nascimento: %s \n"
                + "Cidade: %s \n",
            nome, cpf, rg, data, cidade);
    }
}
