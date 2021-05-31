package br.unisinos.estruturas.trabalho.gb.avl;

import static br.unisinos.estruturas.trabalho.gb.utilitarios.Ferramentas.transformarStringEmDouble;

import br.unisinos.estruturas.trabalho.gb.entity.Pessoa;
import br.unisinos.estruturas.trabalho.gb.enumerador.Tipo;

import br.unisinos.estruturas.trabalho.gb.utilitarios.Ferramentas;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ArvoreAVL {

    public Folha raiz;
    private Tipo tipo;
    private int contadorDeNomes = 1;

    public ArvoreAVL(Tipo tipo) {
        this.tipo = tipo;
    }

    public void inserir(Pessoa chaveAInserir) {

        if (tipo == Tipo.CPF) {
            Folha folha = new Folha(chaveAInserir, chaveAInserir.getCpf());
            inserirAVL(this.raiz, folha);
        }
        if (tipo == Tipo.NOME) {
            Folha folha = new Folha(chaveAInserir, chaveAInserir.getNome());
            inserirAVL(this.raiz, folha);
        }
        if (tipo == Tipo.DATA) {
            Folha folha = new Folha(chaveAInserir, chaveAInserir.getData().toString());
            inserirAVL(this.raiz, folha);
        }

    }

    private void inserirAVL(Folha aComparar, Folha aInserir) {

        if (aComparar == null) {
            this.raiz = aInserir;
        } else {
            Double cpfAInserir = transformarStringEmDouble(aInserir.getPessoa().getCpf());
            Double cpfAComparar = transformarStringEmDouble(aComparar.getPessoa().getCpf());

            if (tipo == Tipo.CPF) { // ================== Inserir atravez da CPF como índice ========================
                // tenta inserir a esquerda se for menor que o pai

                if (cpfAInserir < cpfAComparar) {
                    if (aComparar.getEsquerda() == null) {
                        aComparar.setEsquerda(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getEsquerda(), aInserir);
                    }
                }
                // tenta inserir a direita se for maior que o pai
                else if (cpfAInserir > cpfAComparar) {
                    if (aComparar.getDireita() == null) {
                        aComparar.setDireita(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getDireita(), aInserir);
                    }
                }
                // index de CPF ja existente na arvore
                else {
                    System.out.println("Valor de CPF já existe!");
                }
            } else if (tipo == Tipo.NOME) { // ================== Inserir atravez da Nome como índice ========================
                int valorComparado = aInserir.getPessoa().getNome().compareTo(aComparar.getPessoa().getNome());

                if (valorComparado <= -1 && !aInserir.getPessoa().getCpf().equals(aComparar.getPessoa().getCpf())) {
                    if (aComparar.getEsquerda() == null) {
                        aComparar.setEsquerda(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getEsquerda(), aInserir);
                    }
                }
                // tenta inserir a direita se for maior que o pai
                else if (valorComparado >= 1 && !aInserir.getPessoa().getCpf().equals(aComparar.getPessoa().getCpf())) {
                    if (aComparar.getDireita() == null) {
                        aComparar.setDireita(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getDireita(), aInserir);
                    }
                    //Caso nome for igual e cpf menor, vai inserir a esquerda
                } else if (valorComparado == 0 && cpfAInserir < cpfAComparar) {
                    if (aComparar.getEsquerda() == null) {
                        aComparar.setEsquerda(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getEsquerda(), aInserir);
                    }
                    //Caso nome for igual, e cpf da pessoa a inserir for maior que da pessoa existente, insere na direita
                } else if (valorComparado == 0 && cpfAInserir > cpfAComparar) {
                    if (aComparar.getDireita() == null) {
                        aComparar.setDireita(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getDireita(), aInserir);
                    }
                    //Não atendendo aos requisitos acima, significa que essa pessoa ja existe.
                } else {
                    System.out.println("Valor de nome (" + aInserir.getPessoa().getNome() + ") ja existe!");
                }

            } else if (tipo == Tipo.DATA) { // ================== Inserir atravez da Data como índice ========================

                //Caso a data  da pessoa a inserir seja menor que a pessoa existente, vai para esquerda
                if (aInserir.getPessoa().getData().isBefore(aComparar.getPessoa().getData())
                    && !aInserir.getPessoa().getCpf().equals(aComparar.getPessoa().getCpf())) {
                    if (aComparar.getEsquerda() == null) {
                        aComparar.setEsquerda(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getEsquerda(), aInserir);
                    }
                    //Caso a data  da pessoa a inserir seja maior que a pessoa existente, vai para direita
                } else if (aComparar.getPessoa().getData().isBefore(aInserir.getPessoa().getData())
                    && !aInserir.getPessoa().getCpf().equals(aComparar.getPessoa().getCpf())) {
                    if (aComparar.getDireita() == null) {
                        aComparar.setDireita(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getDireita(), aInserir);
                    }
                    //Caso as datas forem iguais, e cpf da pessoa a inserir seja menor que da pessoa existente, insere na esquerda
                } else if (aInserir.getPessoa().getData().isEqual(aComparar.getPessoa().getData()) && cpfAInserir < cpfAComparar) {
                    if (aComparar.getEsquerda() == null) {
                        aComparar.setEsquerda(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getEsquerda(), aInserir);
                    }
                    //Caso as datas forem iguais, e cpf da pessoa a inserir for maior que da pessoa existente, insere na direita
                } else if (aInserir.getPessoa().getData().isEqual(aComparar.getPessoa().getData()) && cpfAInserir > cpfAComparar) {
                    if (aComparar.getDireita() == null) {
                        aComparar.setDireita(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getDireita(), aInserir);
                    }
                    //Não atendendo aos requisitos acima, significa que essa pessoa ja existe.
                } else {
                    System.out.println("Valor de data ja existe!");
                }

            }
//            // se ja existir a chave, avisa que ja existe
//            else {
//                System.out.printf("Nó ja existe!");
//            }
        }
    }

    // valida o balanceamento o refazendo caso haja balanceamento igual a 2 ou -2
    private void verificarBalanceamento(Folha aComparar) {
        setBalanceamento(aComparar);
        int balanceamento = aComparar.getBalanceamento();

        if (balanceamento == -2) {// arvore pendida para a direita

            if (altura(aComparar.getEsquerda().getEsquerda()) >= altura(aComparar.getEsquerda().getDireita())) {
                aComparar = rotacaoDireita(aComparar); // rotação simples a direita

            } else {
                aComparar = duplaRotacaoEsquerdaDireita(aComparar); // rotação dupla a direita
            }

        } else if (balanceamento == 2) { // arvore pendida pra esquerda

            if (altura(aComparar.getDireita().getDireita()) >= altura(aComparar.getDireita().getEsquerda())) {
                aComparar = rotacaoEsquerda(aComparar); // rotação simples a esquerda

            } else {
                aComparar = duplaRotacaoDireitaEsquerda(aComparar); // rotação dupla a esquerda
            }
        }

        if (aComparar.getPai() != null) {
            verificarBalanceamento(aComparar.getPai());
        } else {
            this.raiz = aComparar;
        }
    }

    // rotação simples a esquerda
    private Folha rotacaoEsquerda(Folha inicial) {

        Folha direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    // rotação simples a direita
    private Folha rotacaoDireita(Folha inicial) {

        Folha esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    private Folha duplaRotacaoEsquerdaDireita(Folha inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    private Folha duplaRotacaoDireitaEsquerda(Folha inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }


    // seta o balanceamento do no fazendo o calculo de fator
    private void setBalanceamento(Folha no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    private int altura(Folha atual) {
        if (atual == null) { // caso seja null, a árvore está vazia
            return -1;
        }
        if (atual.getEsquerda() == null && atual.getDireita() == null) { // caso seja null significa que é uma folha
            return 0;
        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());
        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());
        } else {// recursão caso não seja null dos dois lados, pegando o maximo entre os dois
            // retorna qual lado da árvore está mais desbalanceado
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    public void buscarPeloCPF(String cpf) {
        if (raiz == null) {
            System.out.println("Arvore vazia!");
            return;
        }
        // se arvore vazia
        Folha atual = raiz; // começa a procurar desde raiz

        while (!atual.getPessoa().getCpf().equals(cpf)) { // enquanto nao encontrou
            if (transformarStringEmDouble(cpf) < transformarStringEmDouble(atual.getChave())) {
                atual = atual.getEsquerda(); // caminha para esquerda
            } else {
                atual = atual.getDireita(); // caminha para direita
            }
            if (atual == null) {
                System.out.println("Não esta na árvore!");
                return;// encontrou em uma folha -> sai
            }
        } // fim laço while
        System.out.println(String.format(
            "PESSOA ENCONTRADA \n"
                + atual));
    }

    private void printarConsulta(Folha folha) {
        if (folha != null) {
            System.out.println(String.format("Consultado nodo : %s", folha.getChave()));
        }
    }

    public void imprimirEmOrdem() {
        ArrayList<Folha> emOrdem;
        emOrdem = inOrder();

        for (Folha folha : emOrdem) {
            System.out.println(folha);
        }
        imprimirLinhaDeTracos();
    }

    public void imprimirPosOrdem() {
        ArrayList<Folha> posOrdem;
        posOrdem = posOrder();

        for (Folha folha : posOrdem) {
            System.out.println(folha);
        }
        imprimirLinhaDeTracos();
    }

    public void imprimirPreOrdem() {
        ArrayList<Folha> preOrdem;
        preOrdem = preOrder();

        for (Folha folha : preOrdem) {
            System.out.println(folha);
        }
        imprimirLinhaDeTracos();
    }

    private void imprimirLinhaDeTracos() {
        System.out.println("—————————————————————");
    }

    private ArrayList<Folha> inOrder() {
        System.out.println("Impressão em ordem:");
        ArrayList<Folha> ret = new ArrayList<Folha>();
        inOrder(raiz, ret);
        return ret;
    }

    private void inOrder(Folha no, ArrayList<Folha> lista) {
        if (no == null) {
            return;
        }
        inOrder(no.getEsquerda(), lista);
        lista.add(no);
        inOrder(no.getDireita(), lista);
    }

    private ArrayList<Folha> posOrder() {
        System.out.println("Impressão Pós-ordem:");
        ArrayList<Folha> ret = new ArrayList<Folha>();
        posOrder(raiz, ret);
        return ret;
    }

    private void posOrder(Folha no, ArrayList<Folha> lista) {
        if (no == null) {
            return;
        }
        posOrder(no.getEsquerda(), lista);
        posOrder(no.getDireita(), lista);
        lista.add(no);
    }

    private ArrayList<Folha> preOrder() {
        System.out.println("Impressão Pré-ordem:");
        ArrayList<Folha> ret = new ArrayList<Folha>();
        preOrder(raiz, ret);
        return ret;
    }

    private void preOrder(Folha no, ArrayList<Folha> lista) {
        if (no == null) {
            return;
        }
        lista.add(no);
        preOrder(no.getEsquerda(), lista);
        preOrder(no.getDireita(), lista);

    }

    public void imprimeAVL(Folha pagina) {

        if (pagina == null) {
            System.out.print("-");
        } else {
            System.out.print("(");
            imprimeAVL(pagina.getEsquerda());
            System.out.print(" " + pagina.getChave() + " ");
            imprimeAVL(pagina.getDireita());
            System.out.print(")");
        }
    }

    public void consultarTodasPessoasPorNome(Folha pagina, String nome) {
        buscarAsPessoasNaAVL(pagina, nome);
        contadorDeNomes =1;
    }

    private void buscarAsPessoasNaAVL(Folha pagina, String nome) {

        if (pagina != null) {
            buscarAsPessoasNaAVL(pagina.getEsquerda(), nome);
            String nomeDaPessoaNaFolha = pagina.getPessoa().getNome().toLowerCase(Locale.ROOT);
            String nomeAPesquisar = nome.toLowerCase(Locale.ROOT);
            if (nomeDaPessoaNaFolha.contains(nomeAPesquisar)) {
                System.out.println("====================== Pessoa " + contadorDeNomes);
                System.out.println(pagina.getPessoa());
                contadorDeNomes++;
            }
            buscarAsPessoasNaAVL(pagina.getDireita(), nome);
        }
    }

}
