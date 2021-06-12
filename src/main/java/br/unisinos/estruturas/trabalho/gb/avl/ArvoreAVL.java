package br.unisinos.estruturas.trabalho.gb.avl;

import static br.unisinos.estruturas.trabalho.gb.utilitarios.Ferramentas.transformarStringEmDouble;

import br.unisinos.estruturas.trabalho.gb.enumerador.Tipo;
import br.unisinos.estruturas.trabalho.gb.gui.TelaDeConsultaJF;
import br.unisinos.estruturas.trabalho.gb.utilitarios.GetDadosPessoa;
import br.unisinos.estruturas.trabalho.gb.utilitarios.Ferramentas;
import java.time.LocalDate;
import java.util.Locale;

public class ArvoreAVL {

    public Folha raiz;
    private Tipo tipo;
    private int contadorDePessoas = 1;

    public ArvoreAVL(Tipo tipo) {
        this.tipo = tipo;
    }

    public void inserir(String chaveAInserir) {

        if (tipo == Tipo.CPF) {
            Folha folha = new Folha(chaveAInserir);
            inserirAVL(this.raiz, folha);
        }
        if (tipo == Tipo.NOME) {
            Folha folha = new Folha(chaveAInserir);
            inserirAVL(this.raiz, folha);
        }
        if (tipo == Tipo.DATA) {
            Folha folha = new Folha(chaveAInserir);
            inserirAVL(this.raiz, folha);
        }
    }

    private void inserirAVL(Folha aComparar, Folha aInserir) {

        if (aComparar == null) {
            this.raiz = aInserir;
        } else {
            if (tipo == Tipo.CPF) { // ================== Inserir atravez da CPF como índice ========================
                // tenta inserir a esquerda se for menor que o pai
                Double cpfAInserir = transformarStringEmDouble(aInserir.getChave());
                Double cpfAComparar = transformarStringEmDouble(aComparar.getChave());

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
                    System.out.println("[Árvore " + tipo + "]: \t Valor de CPF ( " + aInserir.getChave() + " ) já existe!");
                }
            } else if (tipo == Tipo.NOME) { // ================== Inserir atravez da Nome como índice ========================
                int valorComparado = aInserir.getChave().compareTo(aComparar.getChave());
                // carregar CPFs do nome João para comparar se existe o mesmo cpf para esse João
                if (valorComparado < 0) {
                    if (aComparar.getEsquerda() == null) {
                        aComparar.setEsquerda(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getEsquerda(), aInserir);
                    }
                }
                // tenta inserir a direita se for maior que o pai
                else if (valorComparado > 0) {
                    if (aComparar.getDireita() == null) {
                        aComparar.setDireita(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getDireita(), aInserir);
                    }
                    //Caso nome for igual e cpf menor, vai inserir a esquerda
                } else {
                    System.out.println("[Árvore " + tipo + "]:\t Valor de Nome ( " + aInserir.getChave() + " ) já existe!");
                }

            } else if (tipo == Tipo.DATA) { // ================== Inserir atravez da Data como índice ========================
                //Caso a data  da pessoa a inserir seja menor que a pessoa existente, vai para esquerda
                LocalDate dataAInserir = transformarEmLocalDate(aInserir);
                LocalDate dataAComparar = transformarEmLocalDate(aComparar);

                if (dataAInserir.isBefore(dataAComparar)) {
                    if (aComparar.getEsquerda() == null) {
                        aComparar.setEsquerda(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getEsquerda(), aInserir);
                    }
                    //Caso a data  da pessoa a inserir seja maior que a pessoa existente, vai para direita
                } else if (dataAComparar.isBefore(dataAInserir)) {
                    if (aComparar.getDireita() == null) {
                        aComparar.setDireita(aInserir);
                        aInserir.setPai(aComparar);
                        verificarBalanceamento(aComparar);
                    } else {
                        inserirAVL(aComparar.getDireita(), aInserir);
                    }
                } else {
                    System.out.println("[Árvore " + tipo + "]:\t Valor de Data ( " + aInserir.getChave() + " ) já existe!");
                }
            }

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

    public Boolean buscarPeloCPF(String cpf) {
        if (raiz == null) {
            System.out.println("Arvore vazia!");
            return Boolean.TRUE;
        }
        // se arvore vazia
        Folha atual = raiz; // começa a procurar desde raiz

        while (!atual.getChave().equals(cpf)) { // enquanto nao encontrou
            if (transformarStringEmDouble(cpf) < transformarStringEmDouble(atual.getChave())) {
                atual = atual.getEsquerda(); // caminha para esquerda
            } else {
                atual = atual.getDireita(); // caminha para direita
            }
            if (atual == null) {
                System.out.println("Não esta na árvore!");
                return Boolean.TRUE;// encontrou em uma folha -> sai
            }
        } // fim laço while
      
        GetDadosPessoa.getPessoa(atual.getChave(), Tipo.CPF);
        TelaDeConsultaJF.retornoDasBuscas += atual.getChave() + ";";
        return Boolean.FALSE;
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

    public void imprimeAVLData(Folha pagina) {

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

    public void buscarAsPessoasNaAVLPorNomeEImprimirEmOrdem(Folha pagina, String nome) {
        emOrdem(pagina, nome);
        contadorDePessoas = 1;
    }

    private void emOrdem(Folha pagina, String nome) {
        if (pagina == null) {
            return;
        }

        emOrdem(pagina.getEsquerda(), nome);
        String nomeDaPessoaNaFolha = pagina.getChave().toLowerCase(Locale.ROOT);
        String nomeAPesquisar = nome.toLowerCase(Locale.ROOT);

        // verificar se uma palavra é maior que a outra
        int criterioDeParada = nomeDaPessoaNaFolha.substring(0, nome.length()).compareTo(nomeAPesquisar);

        if (criterioDeParada == 0) {
            GetDadosPessoa.getPessoa(pagina.getChave(), Tipo.NOME);
            TelaDeConsultaJF.retornoDasBuscas += pagina.getChave() + ";";
            contadorDePessoas++;
        }

        if(criterioDeParada > 0){
            return;
        }

        emOrdem(pagina.getDireita(), nome);

    }

    public void consultarTodasPessoasPorDataEmOrdem(Folha pagina, LocalDate dataInicial, LocalDate dataDinal) {
        emOrdemPorData(pagina, dataInicial, dataDinal);
        contadorDePessoas = 1;
    }

    private void emOrdemPorData(Folha pagina, LocalDate dataInicial, LocalDate dataFinal) {

        if (pagina == null) {
            return;
        }
        emOrdemPorData(pagina.getEsquerda(), dataInicial, dataFinal);
        LocalDate dataDaPagina = transformarEmLocalDate(pagina);

        if (dataDaPagina.isAfter(dataInicial) && dataDaPagina.isBefore(dataFinal)) {
            GetDadosPessoa.getPessoa(pagina.getChave(), Tipo.DATA);
            TelaDeConsultaJF.retornoDasBuscas += pagina.getChave() + ";";
            contadorDePessoas++;
        }

        if(dataDaPagina.isAfter(dataFinal)){
            return;
        }

        emOrdemPorData(pagina.getDireita(), dataInicial, dataFinal);

    }

    private LocalDate transformarEmLocalDate(Folha pagina) {
        return Ferramentas.transformarEmLocalDate(pagina.getChave());
    }

}
