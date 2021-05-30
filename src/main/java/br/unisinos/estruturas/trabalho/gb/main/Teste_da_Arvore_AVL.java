package br.unisinos.estruturas.trabalho.gb.main;

import br.unisinos.estruturas.trabalho.gb.avl.ArvoreAVL;
import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.enumerador.Tipo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Teste_da_Arvore_AVL {

    public static void main(String[] args) {

        ArvoreAVL arvoreAVLCPF = new ArvoreAVL(Tipo.CPF);
        ArvoreAVL arvoreAVLNOME = new ArvoreAVL(Tipo.NOME);
        Pessoa pessoa1 = new Pessoa("Fredeira", "11111111111", 1212121212, LocalDate.of(1995, 5, 24), "Montenegro");
        Pessoa pessoa2 = new Pessoa("Brunão", "22222222222", 131313131, LocalDate.of(1999, 6, 10), "São Leopoldo");
        Pessoa pessoa3 = new Pessoa("Andriele Professora", "33333333333", 1414141414, LocalDate.of(1997, 7, 9), "Inferno");
        Pessoa pessoa4 = new Pessoa("Arthur Nílson", "44444444444", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
        Pessoa pessoa5 = new Pessoa("Breno Campos", "55555555555", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
        Pessoa pessoa6 = new Pessoa("Marcelle Nunes", "66666666666", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
        Pessoa pessoa7 = new Pessoa("Diegão Santos ", "77777777777", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");
        Pessoa pessoa8 = new Pessoa("Bryan Coult ", "88888888", 151515151, LocalDate.of(2000, 2, 12), "São Leopoldo");

//        arvoreAVLCPF.inserir(pessoa4);
//        arvoreAVLCPF.inserir(pessoa1);
//        arvoreAVLCPF.inserir(pessoa2);
//        arvoreAVLCPF.inserir(pessoa3);
//        arvoreAVLCPF.inserir(pessoa5);
//        arvoreAVLCPF.inserir(pessoa6);
//        arvoreAVLCPF.inserir(pessoa7);
//        arvoreAVLCPF.inserir(pessoa8);

        arvoreAVLNOME.inserir(pessoa2);
        arvoreAVLNOME.inserir(pessoa3);
        arvoreAVLNOME.inserir(pessoa1);
        arvoreAVLNOME.inserir(pessoa7);
        arvoreAVLNOME.inserir(pessoa5);
        arvoreAVLNOME.inserir(pessoa4);
        arvoreAVLNOME.inserir(pessoa6);
        arvoreAVLNOME.inserir(pessoa8);

        arvoreAVLCPF.imprimeAVL(arvoreAVLCPF.raiz);
        System.out.println();
        arvoreAVLNOME.imprimeAVL(arvoreAVLNOME.raiz);

        Scanner le = new Scanner(System.in);

        char opcao;
        String valor;
        do {
            System.out.print("\n***********************************");
            System.out.print("\nEntre com a opcao:");
            System.out.print("\n ----b: Consultar uma única pessoa pelo seu CPF e exibir seus dados na tela;");
            System.out.printf("\n ----e: Consultar todas as pessoas cujo nome comece com uma string informada pelo usuário e exibir \n"
                + "%7s na tela todos os dados dessas pessoas na forma de lista" ,"");
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
                case 's': {
                    System.out.println("saíndo do programa");
                    break;
                }
                default:
                    System.out.println("Opção inexistente");
            }
        } while (opcao != 's');

    }

}