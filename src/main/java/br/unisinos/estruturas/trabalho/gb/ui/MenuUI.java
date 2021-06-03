package br.unisinos.estruturas.trabalho.gb.ui;

import br.unisinos.estruturas.trabalho.gb.avl.ArvoreAVL;
import br.unisinos.estruturas.trabalho.gb.enumerador.Tipo;
import br.unisinos.estruturas.trabalho.gb.utilitarios.Ferramentas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuUI {
    private Scanner le;
    // Declaração dos atributos globais publicos para acesso externo a classe
    public static ArvoreAVL arvoreAVLCPF = new ArvoreAVL(Tipo.CPF);
    public static ArvoreAVL arvoreAVLNOME = new ArvoreAVL(Tipo.NOME);
    public static ArvoreAVL arvoreAVLDATA = new ArvoreAVL(Tipo.DATA);

    public MenuUI() {
        le = new Scanner(System.in);

        Ferramentas.carregaDoArquivo("Pessoas.txt");
        arvoreAVLCPF.imprimeAVL(arvoreAVLCPF.raiz);
        System.out.println();
        arvoreAVLNOME.imprimeAVL(arvoreAVLNOME.raiz);
        System.out.println();
        arvoreAVLDATA.imprimeAVLData(arvoreAVLDATA.raiz);
    }

    public void menu() {
        char opcao;
        String valor;
        do {
            System.out.print(this.getMenu());
            String opcaoString = le.next();
            opcao = opcaoString.charAt(0);
            switch (opcao) {
                case 'a': {
                    System.out.println("\n----==== Busca por CPF ====----");
                    System.out.print("\n Informe o CPF desejado -> ");
                    valor = le.next();
                    System.out.println();
                    arvoreAVLCPF.buscarPeloCPF(valor);
                    break;
                }
                case 'b': {
                    System.out.println("\n----==== Busca por Nome ====----");
                    System.out.print("\n Informe o Nome desejado -> ");
                    valor = le.next();
                    System.out.println();
                    arvoreAVLNOME.consultarTodasPessoasPorNome(arvoreAVLNOME.raiz, valor);
                    break;
                }
                case 'c': {
                    try {
                        System.out.println("\n----==== Busca por Data de Nascimento ====----");
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        format.setLenient(false);

                        System.out.print("\n Informe a Data Inicial (Formato: DD/MM/YYYY)  -> ");
                        var dataNascimentoInicial = le.next();
                        format.parse(dataNascimentoInicial);

                        System.out.print("\n Informe a Data Final (Formato: DD/MM/YYYY)  -> ");
                        var dataNascimentoFinal = le.next();
                        format.parse(dataNascimentoFinal);

                        System.out.println();

                        String[] dataInicialSplitted = dataNascimentoInicial.split("/");
                        int diaInicial = Integer.parseInt(dataInicialSplitted[0]);
                        int mesInicial = Integer.parseInt(dataInicialSplitted[1]);
                        int anoInicial = Integer.parseInt(dataInicialSplitted[2]);

                        String[] dataFinalSplitted = dataNascimentoFinal.split("/");
                        int diaFinal = Integer.parseInt(dataFinalSplitted[0]);
                        int mesFinal = Integer.parseInt(dataFinalSplitted[1]);
                        int anoFinal = Integer.parseInt(dataFinalSplitted[2]);

                        LocalDate dataInicial = LocalDate.of(anoInicial, mesInicial, diaInicial);
                        LocalDate dataFinal = LocalDate.of(anoFinal, mesFinal, diaFinal);

                        arvoreAVLDATA.consultarTodasPessoasPorData(arvoreAVLDATA.raiz, dataInicial, dataFinal);
                    } catch (ParseException e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                case 's': {
                    System.out.println("Saindo do programa.");
                    break;
                }
                default:
                    System.out.println("Opção inexistente");
            }
        } while (opcao != 's');
    }

    private String getMenu() {
        return "\n\n***************************************************************************************************"
                + "\n\t\t\t\t----==== Entre com a opção desejada ====----"
                + "\n\n a :-> \tConsultar uma única pessoa pelo seu CPF e exibir seus dados na tela;"
                + "\n b :-> \tConsultar todas as pessoas cujo nome comece com uma string informada pelo usuário e exibir \n"
                + "\tna tela todos os dados dessas pessoas na forma de lista"
                + "\n c :-> \tConsultar todas as pessoas cuja data de nascimento esteja em um intervalo estabelecido pelo \n"
                + "\tusuário e exibir na tela todos os dados dessas pessoas na forma de lista."
                + "\n s :-> \tSair do programa"
                + "\n\n***************************************************************************************************"
                + "\n-> ";

    }
}
