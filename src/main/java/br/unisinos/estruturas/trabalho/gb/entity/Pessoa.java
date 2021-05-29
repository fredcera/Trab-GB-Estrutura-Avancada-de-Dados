package br.unisinos.estruturas.trabalho.gb.entity;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private Double cpf;
    private Integer rg;
    private LocalDate data;
    private String cidade;

    public Pessoa(String nome, Double cpf, Integer rg, LocalDate data, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.data = data;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public Double getCpf() {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return cpf.equals(pessoa.cpf);
    }
}
