package br.unisinos.estruturas.trabalho.gb.main;

import br.unisinos.estruturas.trabalho.gb.avl.ArvoreAVL;
import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.enumerador.Tipo;

import java.time.LocalDate;
import java.util.Scanner;

public class Teste_da_Arvore_AVL {
    public static void main(String[] args) {

        ArvoreAVL arvoreAVLCPF = new ArvoreAVL(Tipo.DATA);
        Pessoa pessoa1 = new Pessoa("Fredeira", 11111111111D, 1212121212, LocalDate.of(1995,5,24), "Montenegro");
        Pessoa pessoa2 = new Pessoa("Brunão", 22222222222D, 131313131, LocalDate.of(1999,6,10), "São Leopoldo");
        Pessoa pessoa3 = new Pessoa("Andriele Professora", 33333333333D, 1414141414, LocalDate.of(1997,7,9), "Inferno");
        Pessoa pessoa4 = new Pessoa("Arthur Nílson", 44444444444D, 151515151, LocalDate.of(2000,2,12), "São Leopoldo");
        Pessoa pessoa5 = new Pessoa("Arthur Nílson", 44444444444D, 151515151, LocalDate.of(2000,2,12), "São Leopoldo");
        Pessoa pessoa6 = new Pessoa("Arthur Nílson", 44444444444D, 151515151, LocalDate.of(2000,2,12), "São Leopoldo");
        Pessoa pessoa7 = new Pessoa("Arthur Nílson", 44444444444D, 151515151, LocalDate.of(2000,2,12), "São Leopoldo");

        arvoreAVLCPF.inserir(pessoa4);
        arvoreAVLCPF.inserir(pessoa1);
        arvoreAVLCPF.inserir(pessoa2);
        arvoreAVLCPF.inserir(pessoa3);
        arvoreAVLCPF.inserir(pessoa5);
        arvoreAVLCPF.inserir(pessoa6);
        arvoreAVLCPF.inserir(pessoa7);

//        arvoreAVLCPF.imprimeAVL(arvoreAVLCPF.raiz);


//        Scanner le = new Scanner(System.in);
//
//        char opcao;
//        int valor;
//        System.out.print("\n Programa Arvore binaria de INTEIROS");
//        do {
//            System.out.print("\n***********************************");
//            System.out.print("\nEntre com a opcao:");
//            System.out.print("\n ----i: Inserção");
//            System.out.print("\n ----r: Remoção");
//            System.out.print("\n ----b: Buscar");
//            System.out.print("\n ----o: Exibir em Ordem");
//            System.out.print("\n ----p: Exibir em Pós-Ordem");
//            System.out.print("\n ----z: Exibir em Pré-Ordem");
//            System.out.print("\n ----s: Sair do programa");
//            System.out.print("\n***********************************");
//            System.out.print("\n-> ");
//            String opcaoString = le.next();
//            opcao = opcaoString.charAt(0);
//            switch (opcao) {
//            case 'i': {
//                System.out.print("\n Informe o valor da inserção(int) -> ");
//                valor = le.nextInt();
//                arvoreAVL.inserir(valor);
//                arvoreAVL.imprimeAVL(arvoreAVL.raiz);
//                break;
//            }
//            case 'r': {
//                System.out.print("\n Informe o valor de remoção (int) -> ");
//                valor = le.nextInt();
//                arvoreAVL.remover(valor);
//                arvoreAVL.imprimeAVL(arvoreAVL.raiz);
//                break;
//            }
//            case 'b': {
//                System.out.print("\n Informe o valor de busca (int) -> ");
//                valor = le.nextInt();
//                arvoreAVL.buscar(valor);
//                arvoreAVL.imprimeAVL(arvoreAVL.raiz);
//                break;
//            }
//            case 'o': {
//                arvoreAVL.imprimirEmOrdem();
//                break;
//            }
//            case 'p': {
//                arvoreAVL.imprimirPosOrdem();
//                break;
//            }
//            case 'z': {
//                arvoreAVL.imprimirPreOrdem();
//                break;
//            }
//            case 's': {
//                System.out.println("saíndo do programa");
//                break;
//            }
//            default:
//                System.out.println("Opção inexistente");
//            }
//        } while (opcao != 's');

    }

}