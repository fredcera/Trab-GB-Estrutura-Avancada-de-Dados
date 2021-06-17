package br.unisinos.estruturas.trabalho.gb.utilitarios;

import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.ui.MenuUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ferramentas {

    private String caminhoDoArquivo, cvsPessoa;

    public static Double transformarStringEmDouble(String cpf) {
        return Double.parseDouble(cpf);
    }

    public void setCaminhoDoArquivo(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

    /**
     * Método que recebe uma String que contém um caminho (path) para um arquivo .txt, onde o mesmo será carregado recuperando os dados
     * referente a pessoas(CPF, RG, Nome, Data de Nascimento, Cidade).
     * @param caminhoArquivo - Caminho de origem do arquivo .txt no computador.
     */
    public static void carregaDoArquivo(String caminhoArquivo) { // Pessoas.txt
        File file = new File(caminhoArquivo);
        try {
            FileReader arquivoLer = new FileReader(file);
            BufferedReader ler = new BufferedReader(arquivoLer);

            Pessoa novaPessoa;
            String linhas = "";

            /* Esse laço irá se repitir até não haver mais dados no arquivo .txt*/
            while ((linhas = ler.readLine()) != null) {
                //Aqui cada linha do arquivo é transportado para um array e cada index do array é uma string obtida pela "quebra" da linha com base no ";" (cvs).
                String[] pessoa = linhas.split(";");
                novaPessoa = new Pessoa(pessoa[2], pessoa[0], Long.parseLong(pessoa[1]), transformarEmLocalDate(pessoa[3]), pessoa[4]);

                inserirPessoa(novaPessoa);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Valida se o CPF ja existe na árvore, caso não existir, insere na lista e insere índice na AVL.
     * @param novaPessoa - Objeto do tipo pessoa passado como parametro para validação.
     */
    public static void inserirPessoa(Pessoa novaPessoa) {

        if(MenuUI.arvoreAVLCPF.buscarPeloCPF(novaPessoa.getCpf())) {

            MenuUI.pessoas.add(novaPessoa);
            MenuUI.arvoreAVLCPF.inserir(novaPessoa.getCpf());
            MenuUI.arvoreAVLNOME.inserir(novaPessoa.getNome());
            MenuUI.arvoreAVLDATA.inserir(novaPessoa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

    /**
     * Método que recebe uma data no formato de String e converte para um valor do tipo LocalDate.
     * @param data - String representando uma Data, no qual será convertido em LocalDate.
     * @return Reorna um valor do tipo LocalDate
     */
    public static LocalDate transformarEmLocalDate(String data) {

        return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
