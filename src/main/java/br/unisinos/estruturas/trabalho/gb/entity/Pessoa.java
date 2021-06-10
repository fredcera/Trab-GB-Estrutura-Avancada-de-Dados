package br.unisinos.estruturas.trabalho.gb.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        return String.format(
            "―――――――――――――――――――――――――\n"
         + " > Nome:  %s\n"
         + " > CPF:     %s\n"
         + " > RG:      %s\n"
         + " > Data de Nascimento: %s\n"
         + " > Cidade: %s\n"
         + "―――――――――――――――――――――――――\n",
            nome, cpf, rg, data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), cidade);
    }
}
