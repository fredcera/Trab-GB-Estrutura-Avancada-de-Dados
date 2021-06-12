package br.unisinos.estruturas.trabalho.gb.utilitarios;

import java.time.format.DateTimeFormatter;

import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.enumerador.Tipo;
import br.unisinos.estruturas.trabalho.gb.ui.MenuUI;

public class GetDadosPessoa {

    public static String getPessoa(String valorAPesquisar, Tipo buscarPor) {
        String pessoas = "";

        for (Pessoa pessoa : MenuUI.pessoas) {
            if (buscarPor == Tipo.DATA) {
                if (valorAPesquisar.equals(pessoa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
                    pessoas += pessoa.toString() + "\n";
                }
            } else if (buscarPor == Tipo.CPF) {
                if (valorAPesquisar.equals(pessoa.getCpf())) {
                    pessoas += pessoa.toString() + "\n";
                }
            } else if (buscarPor == Tipo.NOME) {
                if (valorAPesquisar.equals(pessoa.getNome())) {
                    pessoas += pessoa.toString() + "\n";
                }
            }
        }
        System.out.println(pessoas);
        return pessoas;
    }
}
