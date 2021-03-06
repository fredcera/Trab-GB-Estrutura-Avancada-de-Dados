package br.unisinos.estruturas.trabalho.gb.gui;

import br.unisinos.estruturas.trabalho.gb.utilitarios.Ferramentas;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form AbrirArquivoJF
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuItemAbrirAquivo = new javax.swing.JMenuItem();
        menuItemCadastrarPessoa = new javax.swing.JMenuItem();
        menuItemPesquisar = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU - ESTRUTURAS AVANÇADAS DE DADOS | TRABALHO");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/unisinos.png"))); // NOI18N

        menuArquivo.setText("Arquivo");

        menuItemAbrirAquivo.setText("Abrir Arquivo");
        menuItemAbrirAquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAbrirAquivoActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemAbrirAquivo);

        menuItemCadastrarPessoa.setText("Adicionar Pessoa");
        menuItemCadastrarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastrarPessoaActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemCadastrarPessoa);

        menuItemPesquisar.setText("Pesquisar");
        menuItemPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPesquisarActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemPesquisar);

        jMenuBar1.add(menuArquivo);

        menuAjuda.setText("Ajuda");
        menuAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjudaActionPerformed(evt);
            }
        });

        menuItemSobre.setText("Sobre");
        menuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(menuItemSobre);

        jMenuBar1.add(menuAjuda);
        menuAjuda.getAccessibleContext().setAccessibleParent(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjudaActionPerformed
        // TODO add your handling code here:
       

    }//GEN-LAST:event_menuAjudaActionPerformed

    private void menuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSobreActionPerformed
        // TODO add your handling code here:
        String mensagem = String.format("Membros do Grupo\n* %s\n* %s\n* %s\n* %s\n",
                "Artur Nílson",
                "Bruno Kayser",
                "Diego Neves",
                "Frederico Cera");
        
        JOptionPane.showMessageDialog(null, mensagem.toString(),"TRABALHO PRÁTICO GRAU B",1);

    }//GEN-LAST:event_menuItemSobreActionPerformed

    private void menuItemAbrirAquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAbrirAquivoActionPerformed

        JFileChooser abrirArquivo = new JFileChooser();
        abrirArquivo.showOpenDialog(null);
        
        File arquivo = abrirArquivo.getSelectedFile();
        String caminhoDoAquivo = arquivo.getAbsolutePath();
        
        TelaDeConsultaJF telaDeConsulta = new TelaDeConsultaJF();
        telaDeConsulta.setVisible(true);

        ferramentas.setCaminhoDoArquivo(caminhoDoAquivo);
        ferramentas.carregaDoArquivo(caminhoDoAquivo);
        JOptionPane.showMessageDialog(null, "Leitura do Arquivo Completa!");
    }//GEN-LAST:event_menuItemAbrirAquivoActionPerformed

    private void menuItemCadastrarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastrarPessoaActionPerformed

        CadastraPessoaJF cadastrarPessoa = new CadastraPessoaJF();
        cadastrarPessoa.setVisible(true);
    }//GEN-LAST:event_menuItemCadastrarPessoaActionPerformed

    private void menuItemPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPesquisarActionPerformed

        TelaDeConsultaJF telaDeConsulta = new TelaDeConsultaJF();
        telaDeConsulta.setVisible(true);
    }//GEN-LAST:event_menuItemPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    public static Ferramentas ferramentas = new Ferramentas();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuItemAbrirAquivo;
    private javax.swing.JMenuItem menuItemCadastrarPessoa;
    private javax.swing.JMenuItem menuItemPesquisar;
    private javax.swing.JMenuItem menuItemSobre;
    // End of variables declaration//GEN-END:variables
}
