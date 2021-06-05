package br.unisinos.estruturas.trabalho.gb.avl;

import static br.unisinos.estruturas.trabalho.gb.utilitarios.Ferramentas.transformarStringEmDouble;

import br.unisinos.estruturas.trabalho.gb.interfaces.ArvoreAVLImplements;

public class ArvoreAVLCPF  implements ArvoreAVLImplements {

    public Folha raiz;

    @Override
    public void inserir(String chaveAInserir) {
        Folha folha = new Folha(chaveAInserir);
        inserirAVL(this.raiz, folha);
    }

    public void inserirAVL(Folha aComparar, Folha aInserir) {
        if (aComparar == null) {
            this.raiz = aInserir;
        } else {
            Double cpfAInserir = transformarStringEmDouble(aInserir.getChave());
            Double cpfAComparar = transformarStringEmDouble(aComparar.getChave());

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
                System.out.println("[ ÁRVORA AVL CPF ]: \t Valor de CPF ( " + aInserir.getChave() + " ) já existe!");
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

    @Override
    public void buscarDados(String dado) {
        if (raiz == null) {
            System.out.println("Arvore vazia!");
            return;
        }
        // se arvore vazia
        Folha atual = raiz; // começa a procurar desde raiz

        while (!atual.getChave().equals(dado)) { // enquanto nao encontrou
            if (transformarStringEmDouble(dado) < transformarStringEmDouble(atual.getChave())) {
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
            "----==== Pessoa Encontrada ====---- \n"
                + atual));
    }

    @Override
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

    @Override
    public Folha getRaiz() {
        return this.raiz;
    }

}
