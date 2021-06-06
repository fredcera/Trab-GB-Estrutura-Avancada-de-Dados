package br.unisinos.estruturas.trabalho.gb.entity;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private String cpf;
    private Long rg;
    private LocalDate data;
    private String cidade;

    public Pessoa(String nome, String cpf, Long rg, LocalDate data, String cidade) {
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

    public Long getRg() {
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
        String pipe = "|";
        return String.format(
            "―――――――――――――――――――――――――\n"
         + "|Nome: %-25s %7s \n"
         + "|CPF: %s %22s \n"
         + "|RG: %-10s %24s \n"
         + "|Data de Nascimento: %s %8s \n"
         + "|Cidade: %-15s  %14s \n"
         + "―――――――――――――――――――――――――\n",
            nome, pipe, cpf, pipe, rg, pipe, data, pipe, cidade, pipe);
    }
}
