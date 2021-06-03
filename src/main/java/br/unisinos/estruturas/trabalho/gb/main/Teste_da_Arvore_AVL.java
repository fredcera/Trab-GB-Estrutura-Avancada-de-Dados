package br.unisinos.estruturas.trabalho.gb.main;

import br.unisinos.estruturas.trabalho.gb.avl.ArvoreAVL;
import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.enumerador.Tipo;
import br.unisinos.estruturas.trabalho.gb.utilitarios.Ferramentas;

import java.io.*;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Teste_da_Arvore_AVL {

    //Declaração dos atributos globais publicos para acesso externo a classe
    public static ArvoreAVL arvoreAVLCPF = new ArvoreAVL(Tipo.CPF);
    public static ArvoreAVL arvoreAVLNOME = new ArvoreAVL(Tipo.NOME);
    public static ArvoreAVL arvoreAVLDATA = new ArvoreAVL(Tipo.DATA);

    public static void main(String[] args) {
//        Pessoa pessoa1 = new Pessoa("Fredeira", "11111111111", 1212121212, LocalDate.of(1995, 5, 24), "Montenegro");
//        Pessoa pessoa2 = new Pessoa("Brunão", "22222222222", 131313131, LocalDate.of(1999, 6, 10), "São Leopoldo");
//        Pessoa pessoa3 = new Pessoa("Andriele Professora", "33333333333", 1414141414, LocalDate.of(1997, 7, 9), "Inferno");
//        Pessoa pessoa4 = new Pessoa("Arthur Nílson", "44444444444", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
//        Pessoa pessoa5 = new Pessoa("Breno Campos", "55555555555", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
//        Pessoa pessoa6 = new Pessoa("Marcelle Nunes", "66666666666", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
//        Pessoa pessoa7 = new Pessoa("Diegão Santos ", "77777777777", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
//        Pessoa pessoa8 = new Pessoa("Bryan Coult ", "88888888", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
//
//        arvoreAVLCPF.inserir(pessoa4);
//        arvoreAVLCPF.inserir(pessoa1);
//        arvoreAVLCPF.inserir(pessoa2);
//        arvoreAVLCPF.inserir(pessoa3);
//        arvoreAVLCPF.inserir(pessoa5);
//        arvoreAVLCPF.inserir(pessoa6);
//        arvoreAVLCPF.inserir(pessoa7);
//        arvoreAVLCPF.inserir(pessoa8);
//
//        arvoreAVLNOME.inserir(pessoa2);
//        arvoreAVLNOME.inserir(pessoa3);
//        arvoreAVLNOME.inserir(pessoa1);
//        arvoreAVLNOME.inserir(pessoa7);
//        arvoreAVLNOME.inserir(pessoa5);
//        arvoreAVLNOME.inserir(pessoa4);
//        arvoreAVLNOME.inserir(pessoa6);
//        arvoreAVLNOME.inserir(pessoa8);
//
//        arvoreAVLDATA.inserir(pessoa2);
//        arvoreAVLDATA.inserir(pessoa3);
//        arvoreAVLDATA.inserir(pessoa1);
//        arvoreAVLDATA.inserir(pessoa7);
//        arvoreAVLDATA.inserir(pessoa5);
//        arvoreAVLDATA.inserir(pessoa4);
//        arvoreAVLDATA.inserir(pessoa6);
//        arvoreAVLDATA.inserir(pessoa8);

//        carregaDoArquivo("Pessoas.txt");

        Ferramentas.carregaDoArquivo("Pessoas.txt");

        arvoreAVLCPF.imprimeAVL(arvoreAVLCPF.raiz);
        System.out.println();
        arvoreAVLNOME.imprimeAVL(arvoreAVLNOME.raiz);
        System.out.println();
        arvoreAVLDATA.imprimeAVLData(arvoreAVLDATA.raiz);

        Scanner le = new Scanner(System.in);

        char opcao;
        String valor;
        do {
            System.out.print("\n***********************************");
            System.out.print("\nEntre com a opcao:");
            System.out.print("\n ----b: Consultar uma única pessoa pelo seu CPF e exibir seus dados na tela;");
            System.out.printf("\n ----e: Consultar todas as pessoas cujo nome comece com uma string informada pelo usuário e exibir \n"
                + "%7s na tela todos os dados dessas pessoas na forma de lista" ,"");
            System.out.printf("\n ----d: Consultar todas as pessoas cuja data de nascimento esteja em um intervalo estabelecido pelo \n"
                + "%7s usuário e exibir na tela todos os dados dessas pessoas na forma de lista." ,"");
            System.out.print("\n ----s: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\n-> ");
            String opcaoString = le.next();
            opcao = opcaoString.charAt(0);
            switch (opcao) {
                case 'b': {
                    System.out.print("\n Informe o valor de busca -> ");
                    valor = le.next();
                    arvoreAVLCPF.buscarPeloCPF(valor);
                    break;
                }
                case 'e': {
                    System.out.print("\n Informe o nome de filtro -> ");
                    valor = le.next();
                    arvoreAVLNOME.consultarTodasPessoasPorNome(arvoreAVLNOME.raiz, valor);
                    break;
                }
                case 'd': {
                    System.out.print("\n Informe o dia inicial  -> ");
                    var diaInicial =le.nextInt();
                    System.out.print("\n Informe o mes inicial  -> ");
                    var mesInicial = le.nextInt();
                    System.out.print("\n Informe o ano inicial  -> ");
                    var anoInicial = le.nextInt();

                    System.out.print("\n Informe o dia final  -> ");
                    var diaFinal =le.nextInt();
                    System.out.print("\n Informe o mes final  -> ");
                    var mesFinal = le.nextInt();
                    System.out.print("\n Informe o ano final  -> ");
                    var anoFinal = le.nextInt();

                    LocalDate dataInicial = LocalDate.of(anoInicial, mesInicial, diaInicial);
                    LocalDate dataFinal = LocalDate.of(anoFinal, mesFinal, diaFinal);

                    arvoreAVLDATA.consultarTodasPessoasPorData(arvoreAVLDATA.raiz, dataInicial, dataFinal);
                    break;
                }
                case 's': {
                    System.out.println("saíndo do programa");
                    break;
                }
                default:
                    System.out.println("Opção inexistente");
            }
        } while (opcao != 's');

    }

//    public static void carregaDoArquivo (String caminhoArquivo){ // Pessoas.txt
//        File file = new File(caminhoArquivo);
//
//        try {
//            FileReader arquivoLer = new FileReader(file);
//            BufferedReader ler = new BufferedReader(arquivoLer);
//
//            Pessoa novaPessoa;
//            String linhas = "";
//
//            while ((linhas = ler.readLine()) != null){
//                String[] pessoa = linhas.split(";");
////                String[] data = pessoa[3].split("/");
//                novaPessoa = new Pessoa(pessoa[2],pessoa[0],Integer.parseInt(pessoa[1]),LocalDate.parse(pessoa[3]),pessoa[4]);
//                arvoreAVLCPF.inserir(novaPessoa);
//                arvoreAVLNOME.inserir(novaPessoa);
//                arvoreAVLDATA.inserir(novaPessoa);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}