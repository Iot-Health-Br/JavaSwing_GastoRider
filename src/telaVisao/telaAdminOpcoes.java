/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telaVisao;

/**
 *
 * @author bruno
 */
public class telaAdminOpcoes extends javax.swing.JFrame {

    /**
     * Creates new form telaAdminOpcoes
     */
    public telaAdminOpcoes() {
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
        Bt_Cad_Veiculos = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Bt_Cad_Marcas = new javax.swing.JButton();
        Bt_Cad_Modelos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Consulta");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Bem vindo ao Gasto Rider !");

        Bt_Cad_Veiculos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Bt_Cad_Veiculos.setText("Cadastrar veículos");
        Bt_Cad_Veiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_Cad_VeiculosActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Buscar veículos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Bt_Cad_Marcas.setText("Cadastrar Marcas");
        Bt_Cad_Marcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_Cad_MarcasActionPerformed(evt);
            }
        });

        Bt_Cad_Modelos.setText("Cadastrar Modelos");
        Bt_Cad_Modelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_Cad_ModelosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Bt_Cad_Modelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bt_Cad_Veiculos, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(Bt_Cad_Marcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Bt_Cad_Marcas, Bt_Cad_Modelos, Bt_Cad_Veiculos});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bt_Cad_Veiculos)
                .addGap(15, 15, 15)
                .addComponent(Bt_Cad_Modelos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bt_Cad_Marcas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jButton2)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Bt_Cad_Marcas, Bt_Cad_Modelos, Bt_Cad_Veiculos});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bt_Cad_VeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_Cad_VeiculosActionPerformed
        // TODO add your handling code here:
        
        //telaAdminCadVeiculo f = new telaAdminCadVeiculo();
            TelaDeVeiculos f = new TelaDeVeiculos();
            this.dispose();
            f.setVisible(true);
    }//GEN-LAST:event_Bt_Cad_VeiculosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        telaAdminBuscarVeiculo b = new telaAdminBuscarVeiculo();
            this.dispose();
            b.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Bt_Cad_MarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_Cad_MarcasActionPerformed
            //telaAdminCadVeiculo f = new telaAdminCadVeiculo();
            TelaDeMarcas f = new TelaDeMarcas();
            this.dispose();
            f.setVisible(true);
    }//GEN-LAST:event_Bt_Cad_MarcasActionPerformed

    private void Bt_Cad_ModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_Cad_ModelosActionPerformed
            TelaDeModelos f = new TelaDeModelos();
            this.dispose();
            f.setVisible(true);
    }//GEN-LAST:event_Bt_Cad_ModelosActionPerformed

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
            java.util.logging.Logger.getLogger(telaAdminOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAdminOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAdminOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAdminOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAdminOpcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bt_Cad_Marcas;
    private javax.swing.JButton Bt_Cad_Modelos;
    private javax.swing.JButton Bt_Cad_Veiculos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
