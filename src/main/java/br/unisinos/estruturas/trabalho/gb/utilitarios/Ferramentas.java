package br.unisinos.estruturas.trabalho.gb.utilitarios;

import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.ui.MenuUI;

import java.io.*;
import java.time.LocalDate;

public class Ferramentas {

    public static Double transformarStringEmDouble(String cpf) {
        return Double.parseDouble(cpf);
    }

    public static void carregaDoArquivo(String caminhoArquivo) { // Pessoas.txt
        File file = new File(caminhoArquivo);
        try {
            FileReader arquivoLer = new FileReader(file);
            BufferedReader ler = new BufferedReader(arquivoLer);

            Pessoa novaPessoa;
            String linhas = "";

            while ((linhas = ler.readLine()) != null) {
                String[] pessoa = linhas.split(";");
                String[] data = pessoa[3].split("/");
                novaPessoa = new Pessoa(pessoa[2], pessoa[0], Long.parseLong(pessoa[1]), transformarEmLocalDate(data),
                        pessoa[4]);
                MenuUI.arvoreAVLCPF.inserir(novaPessoa);
                MenuUI.arvoreAVLNOME.inserir(novaPessoa);
                MenuUI.arvoreAVLDATA.inserir(novaPessoa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static LocalDate transformarEmLocalDate(String[] data) {
        Integer dia = Integer.parseInt(data[2]);
        Integer mes = Integer.parseInt(data[1]);
        Integer ano = Integer.parseInt(data[0]);

        return LocalDate.of(ano, mes, dia);
    }

}
