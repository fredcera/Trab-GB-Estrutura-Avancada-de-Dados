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

public class Ferramentas {

    private String caminhoDoArquivo, cvsPessoa;

    public static Double transformarStringEmDouble(String cpf) {
        return Double.parseDouble(cpf);
    }

    public void setCaminhoDoArquivo(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

    public String getCaminhoDoArquivo() {
        return caminhoDoArquivo;
    }

    public void salvarArquivo(Pessoa pessoa) throws IOException {
        File arquivo = new File(this.caminhoDoArquivo);

        serializarPessoa(pessoa);

        try (BufferedWriter dados = new BufferedWriter(new FileWriter(arquivo))) {
            dados.write(cvsPessoa);
//            dados.append(cvsPessoa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarNovaPessoaNaArvore(String chave) {

        MenuUI.arvoreAVLCPF.inserir(chave);
        //  MenuUI.arvoreAVLNOME.inserir(novaPessoa);
        //  MenuUI.arvoreAVLDATA.inserir(novaPessoa);

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
                novaPessoa = new Pessoa(pessoa[2], pessoa[0], Long.parseLong(pessoa[1]), transformarEmLocalDate(data), pessoa[4]);

                /** Valida se o CPF ja existe na árvore, caso não existir, insere na lista e insere índice na AVL */
                if(MenuUI.arvoreAVLCPF.buscarPeloCPF(novaPessoa.getCpf())) {
                    MenuUI.pessoas.add(novaPessoa);
                    MenuUI.arvoreAVLCPF.inserir(pessoa[0]);
                    MenuUI.arvoreAVLNOME.inserir(pessoa[2]);
                    MenuUI.arvoreAVLDATA.inserir(pessoa[3]);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public static LocalDate transformarEmLocalDate(String[] data) {
        Integer dia = Integer.parseInt(data[0]);
        Integer mes = Integer.parseInt(data[1]);
        Integer ano = Integer.parseInt(data[2]);

        return LocalDate.of(ano, mes, dia);
    }

    public void serializarPessoa(Pessoa pessoa) {
        //TODO Alterar esse metodo para concatenar com mais infos
        cvsPessoa = "";
        cvsPessoa = String.format("%s;%s;%s;%s;%s",
                pessoa.getCpf(),
                pessoa.getRg(),
                pessoa.getNome(),
                pessoa.getData().toString(),
                pessoa.getCidade());
    }

}
