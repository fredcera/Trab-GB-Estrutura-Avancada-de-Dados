package br.unisinos.estruturas.trabalho.gb.interfaces;

import br.unisinos.estruturas.trabalho.gb.avl.Folha;

public interface ArvoreAVLImplements {

    void inserir(String chave);

    void buscarDados(String dado);

    void imprimeAVL(Folha pagina);

    Folha getRaiz();

}
