package br.unisinos.estruturas.trabalho.gb.utilitarios;

import java.time.format.DateTimeFormatter;

import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.enumerador.Tipo;
import br.unisinos.estruturas.trabalho.gb.ui.MenuUI;

public class GetDadosPessoa {

    public static String getPessoa(String dados, Tipo pesquisaPor) {
        String dadosPessoas = "";

        if (pesquisaPor == Tipo.NOME) {
            for (Pessoa pessoa : MenuUI.pessoas) {
                if (dados.equals(pessoa.getNome())) {
                    dadosPessoas += pessoa.toString() + "\n";
                }
            }

            System.out.println(dadosPessoas);
            return dadosPessoas;
        } else if (pesquisaPor == Tipo.CPF) {
            for (Pessoa pessoa : MenuUI.pessoas) {
                if (dados.equals(pessoa.getCpf())) {
                    dadosPessoas += pessoa.toString() + "\n";
                }
            }

            System.out.println(dadosPessoas);
            return dadosPessoas;
        } else if (pesquisaPor == Tipo.DATA) {
            for (Pessoa pessoa : MenuUI.pessoas) {
                if (dados.equals(pessoa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
                    dadosPessoas += pessoa.toString() + "\n";
                }
            }

            System.out.println(dadosPessoas);
            return dadosPessoas;
        }

        return "Nenhuma pessoa Encontrada!!";
    }
}
