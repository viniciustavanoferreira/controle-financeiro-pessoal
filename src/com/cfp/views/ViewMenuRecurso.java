package com.cfp.views;

//Sessão de importação.
import com.cfp.controllers.ControllerReceita;
import com.cfp.controllers.ControllerUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import com.cfp.models.User;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Classe que define a tela ~ Acesso.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 20/08/2017
 */
public class ViewMenuRecurso extends javax.swing.JFrame {

    User user = new User();  
    
    public ViewMenuRecurso(User user) {
        initComponents();
        this.user = user;
        this.lbCodUser.setText(this.user.getCodUser());
        this.lbDescName.setText(this.user.getDescName());
    }

    private ViewMenuRecurso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCabMenu = new javax.swing.JPanel();
        lbCabecalhoMenu = new javax.swing.JLabel();
        painelLinhaMenu = new javax.swing.JPanel();
        painelMenu = new javax.swing.JPanel();
        painelBotoes = new javax.swing.JPanel();
        btPercentualAtividade = new javax.swing.JButton();
        btModificarSenha = new javax.swing.JButton();
        painelCabNomeRE = new javax.swing.JPanel();
        lbOla = new javax.swing.JLabel();
        lbCodNameDesc = new javax.swing.JLabel();
        lbCodUser = new javax.swing.JLabel();
        lbDescName = new javax.swing.JLabel();
        lbBusinessMan = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        painelCabMenu.setBackground(new java.awt.Color(255, 255, 255));

        lbCabecalhoMenu.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        lbCabecalhoMenu.setForeground(new java.awt.Color(0, 153, 255));
        lbCabecalhoMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCabecalhoMenu.setText("Menu");
        lbCabecalhoMenu.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        painelLinhaMenu.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout painelLinhaMenuLayout = new javax.swing.GroupLayout(painelLinhaMenu);
        painelLinhaMenu.setLayout(painelLinhaMenuLayout);
        painelLinhaMenuLayout.setHorizontalGroup(
            painelLinhaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelLinhaMenuLayout.setVerticalGroup(
            painelLinhaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelCabMenuLayout = new javax.swing.GroupLayout(painelCabMenu);
        painelCabMenu.setLayout(painelCabMenuLayout);
        painelCabMenuLayout.setHorizontalGroup(
            painelCabMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelLinhaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCabMenuLayout.createSequentialGroup()
                .addContainerGap(680, Short.MAX_VALUE)
                .addComponent(lbCabecalhoMenu)
                .addContainerGap())
        );
        painelCabMenuLayout.setVerticalGroup(
            painelCabMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabMenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbCabecalhoMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelLinhaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        painelMenu.setBackground(new java.awt.Color(255, 255, 255));

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        btPercentualAtividade.setBackground(new java.awt.Color(102, 102, 102));
        btPercentualAtividade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btPercentualAtividade.setForeground(new java.awt.Color(255, 255, 255));
        btPercentualAtividade.setText("Atualizar Percentuais");
        btPercentualAtividade.setToolTipText("Click para atualizar percentuais de atividades");
        btPercentualAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPercentualAtividadeActionPerformed(evt);
            }
        });

        btModificarSenha.setBackground(new java.awt.Color(102, 102, 102));
        btModificarSenha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btModificarSenha.setForeground(new java.awt.Color(255, 255, 255));
        btModificarSenha.setText("Modificar Senha");
        btModificarSenha.setToolTipText("Click para modificar sua senha");
        btModificarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPercentualAtividade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btModificarSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btPercentualAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btModificarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        painelCabNomeRE.setBackground(new java.awt.Color(255, 255, 255));
        painelCabNomeRE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        lbOla.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbOla.setForeground(new java.awt.Color(102, 102, 102));
        lbOla.setText("Olá,");

        lbCodNameDesc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbCodNameDesc.setForeground(new java.awt.Color(102, 102, 102));
        lbCodNameDesc.setText("ID:");

        lbCodUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCodUser.setForeground(new java.awt.Color(102, 102, 102));
        lbCodUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCodUser.setText("ID");

        lbDescName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDescName.setForeground(new java.awt.Color(102, 102, 102));
        lbDescName.setText("Nome Usuario");

        lbBusinessMan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/businessman72.png"))); // NOI18N

        javax.swing.GroupLayout painelCabNomeRELayout = new javax.swing.GroupLayout(painelCabNomeRE);
        painelCabNomeRE.setLayout(painelCabNomeRELayout);
        painelCabNomeRELayout.setHorizontalGroup(
            painelCabNomeRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCabNomeRELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBusinessMan)
                .addGap(18, 18, 18)
                .addComponent(lbOla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescName, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCodNameDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCodUser, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelCabNomeRELayout.setVerticalGroup(
            painelCabNomeRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabNomeRELayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(painelCabNomeRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBusinessMan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelCabNomeRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCodNameDesc)
                        .addComponent(lbOla)
                        .addComponent(lbDescName)
                        .addComponent(lbCodUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btSair.setBackground(new java.awt.Color(102, 102, 102));
        btSair.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btSair.setForeground(new java.awt.Color(255, 255, 255));
        btSair.setText("Sair");
        btSair.setToolTipText("Click para sair do sistema");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelMenuLayout = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(painelMenuLayout);
        painelMenuLayout.setHorizontalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMenuLayout.createSequentialGroup()
                        .addComponent(painelCabNomeRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMenuLayout.createSequentialGroup()
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        painelMenuLayout.setVerticalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(painelCabNomeRE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCabMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(778, 470));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPercentualAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPercentualAtividadeActionPerformed
        new ViewPercentualAtividade(this.user).setVisible(true);
        this.dispose();
                    
    }//GEN-LAST:event_btPercentualAtividadeActionPerformed

    private void btModificarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarSenhaActionPerformed
        new ViewSenha(this.user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btModificarSenhaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        //Invoca a tela ~ ViewMenuRelatorio.
        new ViewUser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenuRecurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewMenuRecurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btModificarSenha;
    private javax.swing.JButton btPercentualAtividade;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel lbBusinessMan;
    private javax.swing.JLabel lbCabecalhoMenu;
    private javax.swing.JLabel lbCodNameDesc;
    private javax.swing.JLabel lbCodUser;
    private javax.swing.JLabel lbDescName;
    private javax.swing.JLabel lbOla;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelCabMenu;
    private javax.swing.JPanel painelCabNomeRE;
    private javax.swing.JPanel painelLinhaMenu;
    private javax.swing.JPanel painelMenu;
    // End of variables declaration//GEN-END:variables
}
