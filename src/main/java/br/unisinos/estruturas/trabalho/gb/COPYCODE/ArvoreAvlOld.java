//package br.unisinos.estruturas.trabalho.gb.COPYCODE;
//
//import br.unisinos.estruturas.trabalho.gb.avl.Folha;
//
//public class ArvoreAvlOld {
//    protected Folha raiz;
//
//    public void inserir(int chaveAInserir) {
//        Folha folha = new Folha(chaveAInserir);
//        inserirAVL(this.raiz, folha);
//    }
//
//    private void inserirAVL(Folha aComparar, Folha aInserir) {
//
//        if (aComparar == null) {
//            this.raiz = aInserir;
//        } else {
//            //tenta inserir a esquerda se for menor que o pai
//            if (aInserir.getChave() < aComparar.getChave()) {
//                if (aComparar.getEsquerda() == null) {
//                    aComparar.setEsquerda(aInserir);
//                    aInserir.setPai(aComparar);
//                    verificarBalanceamento(aComparar);
//                } else {
//                    inserirAVL(aComparar.getEsquerda(), aInserir);
//                }
//
//            }
//            //tenta inserir a direita se for maior que o pai
//            else if (aInserir.getChave() > aComparar.getChave()) {
//                if (aComparar.getDireita() == null) {
//                    aComparar.setDireita(aInserir);
//                    aInserir.setPai(aComparar);
//                    verificarBalanceamento(aComparar);
//                } else {
//                    inserirAVL(aComparar.getDireita(), aInserir);
//                }
//
//            }
//            //se ja existir a chave avisa que ja existe
//            else {
//                System.out.printf("Nó ja existe!");
//            }
//        }
//    }
//
//    // valida o balanceamento o refazendo caso haja balanceamento igual a 2 ou -2
//    private void verificarBalanceamento(Folha aComparar) {
//        setBalanceamento(aComparar);
//        int balanceamento = aComparar.getBalanceamento();
//
//        if (balanceamento == -2) {//arvore pendida para a esquerda
//
//            if (altura(aComparar.getEsquerda().getEsquerda()) >= altura(aComparar.getEsquerda().getDireita())) {
//                aComparar = rotacaoDireita(aComparar); //rotação simples a direita
//
//            } else {
//                aComparar = duplaRotacaoEsquerdaDireita(aComparar); //rotação dupla a direita
//            }
//
//        } else if (balanceamento == 2) { // arvore pendida pra direita
//
//            if (altura(aComparar.getDireita().getDireita()) >= altura(aComparar.getDireita().getEsquerda())) {
//                aComparar = rotacaoEsquerda(aComparar); // rotação simples a esquerda
//
//            } else {
//                aComparar = duplaRotacaoDireitaEsquerda(aComparar); // rotação dupla a esquerda
//            }
//        }
//
//        if (aComparar.getPai() != null) {
//            verificarBalanceamento(aComparar.getPai()); //balanceamento recursivo até chegar na raiz
//        } else {
//            this.raiz = aComparar;
//        }
//    }
//
//    //rotação simples a esquerda
//    private Folha rotacaoEsquerda(Folha inicial) {
//
//        Folha direita = inicial.getDireita();
//        direita.setPai(inicial.getPai());
//
//        inicial.setDireita(direita.getEsquerda());
//
//        if (inicial.getDireita() != null) {
//            inicial.getDireita().setPai(inicial);
//        }
//
//        direita.setEsquerda(inicial);
//        inicial.setPai(direita);
//
//        if (direita.getPai() != null) {
//
//            if (direita.getPai().getDireita() == inicial) {
//                direita.getPai().setDireita(direita);
//
//            } else if (direita.getPai().getEsquerda() == inicial) {
//                direita.getPai().setEsquerda(direita);
//            }
//        }
//
//        setBalanceamento(inicial);
//        setBalanceamento(direita);
//
//        return direita;
//    }
//
//    //rotação simples a direita
//    private Folha rotacaoDireita(Folha inicial) {
//
//        Folha esquerda = inicial.getEsquerda();
//        esquerda.setPai(inicial.getPai());
//
//        inicial.setEsquerda(esquerda.getDireita());
//
//        if (inicial.getEsquerda() != null) {
//            inicial.getEsquerda().setPai(inicial);
//        }
//
//        esquerda.setDireita(inicial);
//        inicial.setPai(esquerda);
//
//        if (esquerda.getPai() != null) {
//
//            if (esquerda.getPai().getDireita() == inicial) {
//                esquerda.getPai().setDireita(esquerda);
//
//            } else if (esquerda.getPai().getEsquerda() == inicial) {
//                esquerda.getPai().setEsquerda(esquerda);
//            }
//        }
//
//        setBalanceamento(inicial);
//        setBalanceamento(esquerda);
//
//        return esquerda;
//    }
//
//    private Folha duplaRotacaoEsquerdaDireita(Folha inicial) {
//        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
//        return rotacaoDireita(inicial);
//    }
//
//    private Folha duplaRotacaoDireitaEsquerda(Folha inicial) {
//        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
//        return rotacaoEsquerda(inicial);
//    }
//
//    //Remover um nó a partir da chave
//    public void remover(int numeroARemover) {
//        removerAVL(this.raiz, numeroARemover);
//    }
//
//    //procura percorrendo a arvore até achar o nó que deve ser removido
//    private void removerAVL(Folha atual, int chaveARemover) {
//        if (atual == null) {
//            System.out.println("Não encontrado para remover");
//            return;
//
//        } else {
//
//            if (atual.getChave() > chaveARemover) {
//                removerAVL(atual.getEsquerda(), chaveARemover);
//
//            } else if (atual.getChave() < chaveARemover) {
//                removerAVL(atual.getDireita(), chaveARemover);
//
//            } else if (atual.getChave() == chaveARemover) {
//                removerNoEncontrado(atual);
//            }
//        }
//    }
//
//    private void removerNoEncontrado(Folha aRemover) {
//        Folha r;
//
//        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) { // sem nada na esquerda ou direita
//
//            if (aRemover.getPai() == null) { //valida se a folha a remover é a raiz
//                this.raiz = null;
//                aRemover = null;
//                return; //termina a função de remoção aqui saindo da função
//            }
//            r = aRemover;
//
//        } else {
//            r = sucessor(aRemover); //procura o sucessor do que deve ser removido
//            aRemover.setChave(r.getChave()); //seta a chave do que deve ser removido como a chave do sucessor
//        }
//
//        Folha p;
//        if (r.getEsquerda() != null) { //verifica se tem alguem na esquerda
//            p = r.getEsquerda();
//        } else { //caso contrario
//            p = r.getDireita();
//        }
//
//        if (p != null) { // se p for null
//            p.setPai(r.getPai()); // seta pai de p passando o pai de r
//        }
//
//        if (r.getPai() == null) { // se for a raiz
//            this.raiz = p; // passa a raiz para p
//        } else {
//            if (r == r.getPai().getEsquerda()) { // se r for igual a ao que esta a esqueda do pai dele mesmo
//                r.getPai().setEsquerda(p); // seta o a esquerda de de pai de r como p
//            } else {
//                r.getPai().setDireita(p); // sera o a direita do de pai de r como p
//            }
//            verificarBalanceamento(r.getPai()); //função de verificar balanceamento
//        }
//        r = null;
//
//    }
//
//    //procura os sucessores de um nó passado como parametro, começando pela direita e caso não tenha vai pro da esquerda
//    private Folha sucessor(Folha q) {
//        if (q.getDireita() != null) {//caso tenha nó a direita
//            Folha r = q.getDireita();
//            while (r.getEsquerda() != null) {//enquanto o nó a esqueda de r é diferente de null
//                r = r.getEsquerda(); //r recebe o nó a esquerda dele mesmo
//            }
//            return r;
//        } else { //caso tenha não tenha nó a direita
//            Folha p = q.getPai(); //q passa o pai dele para p
//            while (p != null && q == p.getDireita()) { //enquanto p não é null e q é igual ao nó direito de p
//                q = p; // q recebe p
//                p = q.getPai(); // p recebe o pai de q
//            }
//            return p;
//        }
//    }
//
//    //seta o balanceamento do no fazendo o calculo de fator
//    private void setBalanceamento(Folha no) {
//        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
//    }
//
//    private int altura(Folha atual) {
//        if (atual == null) {
//            return -1;
//        }
//        if (atual.getEsquerda() == null && atual.getDireita() == null) {
//            return 0;
//        } else if (atual.getEsquerda() == null) {
//            return 1 + altura(atual.getDireita());
//        } else if (atual.getDireita() == null) {
//            return 1 + altura(atual.getEsquerda());
//        } else {//recursão caso não seja null dos dois lados, pegando o maximo entre os dois
//            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
//        }
//    }
//
//    public void buscar(int chave) {
//        if (raiz == null) {
//            System.out.println("Arvore vazia!");
//            return;
//        }
//        // se arvore vazia
//        Folha atual = raiz;  // começa a procurar desde raiz
//
//        printarConsulta(atual);
//        while (atual.getChave() != chave) { // enquanto nao encontrou
//            if (chave < atual.getChave()) {
//                atual = atual.getEsquerda(); // caminha para esquerda
//                printarConsulta(atual);
//            } else {
//                atual = atual.getDireita(); // caminha para direita
//                printarConsulta(atual);
//            }
//            if (atual == null) {
//                System.out.println("Não esta na árvore!");
//                return;// encontrou em uma folha -> sai
//            }
//        } // fim laço while
//        System.out.println(atual.toString());
//    }
//
//    private void printarConsulta(Folha folha) {
//        if (folha != null) {
//            System.out.println(String.format("Consultado nodo : %s", folha.getChave()));
//        }
//    }
//
//    public void imprimirEmOrdem() {
//        ArrayList<Folha> emOrdem;
//        emOrdem = inOrder();
//
//        for (Folha folha : emOrdem) {
//            System.out.println(folha);
//        }
//        imprimirLinhaDeTracos();
//    }
//
//    public void imprimirPosOrdem() {
//        ArrayList<Folha> posOrdem;
//        posOrdem = posOrder();
//
//        for (Folha folha : posOrdem) {
//            System.out.println(folha);
//        }
//        imprimirLinhaDeTracos();
//    }
//
//    public void imprimirPreOrdem() {
//        ArrayList<Folha> preOrdem;
//        preOrdem = preOrder();
//
//        for (Folha folha : preOrdem) {
//            System.out.println(folha);
//        }
//        imprimirLinhaDeTracos();
//    }
//
//    private void imprimirLinhaDeTracos() {
//        System.out.println("—————————————————————");
//    }
//
//    private ArrayList<Folha> inOrder() {
//        System.out.println("Impressão em ordem:");
//        ArrayList<Folha> ret = new ArrayList<Folha>();
//        inOrder(raiz, ret);
//        return ret;
//    }
//
//    private void inOrder(Folha no, ArrayList<Folha> lista) {
//        if (no == null) {
//            return;
//        }
//        inOrder(no.getEsquerda(), lista);
//        lista.add(no);
//        inOrder(no.getDireita(), lista);
//    }
//
//    private ArrayList<Folha> posOrder() {
//        System.out.println("Impressão Pós-ordem:");
//        ArrayList<Folha> ret = new ArrayList<Folha>();
//        posOrder(raiz, ret);
//        return ret;
//    }
//
//    private void posOrder(Folha no, ArrayList<Folha> lista) {
//        if (no == null) {
//            return;
//        }
//        posOrder(no.getEsquerda(), lista);
//        posOrder(no.getDireita(), lista);
//        lista.add(no);
//    }
//
//    private ArrayList<Folha> preOrder() {
//        System.out.println("Impressão Pré-ordem:");
//        ArrayList<Folha> ret = new ArrayList<Folha>();
//        preOrder(raiz, ret);
//        return ret;
//    }
//
//    private void preOrder(Folha no, ArrayList<Folha> lista) {
//        if (no == null) {
//            return;
//        }
//        lista.add(no);
//        preOrder(no.getEsquerda(), lista);
//        preOrder(no.getDireita(), lista);
//
//    }
//
//    public void imprimeAVL(Folha pagina) {
//
//        if (pagina == null) {
//            System.out.print("-");
//        } else {
//            System.out.print("(");
//            imprimeAVL(pagina.getEsquerda());
//            System.out.print(" " + pagina.getChave() + " ");
//            imprimeAVL(pagina.getDireita());
//            System.out.print(")");
//        }
//    }
//}
