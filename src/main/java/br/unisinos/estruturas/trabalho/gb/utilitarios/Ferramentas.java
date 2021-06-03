package br.unisinos.estruturas.trabalho.gb.utilitarios;

import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.main.Teste_da_Arvore_AVL;

import java.io.*;
import java.time.LocalDate;

public class Ferramentas {

    public static Double transformarStringEmDouble(String cpf) {
        return Double.parseDouble(cpf);
    }

    public static void carregaDoArquivo(String caminhoArquivo) { // Pessoas.txt
        File file = new File(caminhoArquivo);
        Teste_da_Arvore_AVL main = new Teste_da_Arvore_AVL();
        try {
            FileReader arquivoLer = new FileReader(file);
            BufferedReader ler = new BufferedReader(arquivoLer);

            Pessoa novaPessoa;
            String linhas = "";

            while ((linhas = ler.readLine()) != null) {
                String[] pessoa = linhas.split(";");
                String[] data = pessoa[3].split("/");
                novaPessoa = new Pessoa(pessoa[2], pessoa[0], Integer.parseInt(pessoa[1]), transformarEmLocalDate(data), pessoa[4]);
                main.arvoreAVLCPF.inserir(novaPessoa);
                main.arvoreAVLNOME.inserir(novaPessoa);
                main.arvoreAVLDATA.inserir(novaPessoa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static LocalDate transformarEmLocalDate(String[] data){
        Integer dia = Integer.parseInt(data[2]);
        Integer mes = Integer.parseInt(data[1]);
        Integer ano = Integer.parseInt(data[0]);

        return LocalDate.of(ano, mes, dia);
    }


}
