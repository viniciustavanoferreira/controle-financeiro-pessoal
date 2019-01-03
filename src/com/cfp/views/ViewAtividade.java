package com.cfp.views;

// Sessão de importação.
import com.cfp.controllers.ControllerRecurso;
import com.cfp.controllers.ControllerAtividade;
import com.cfp.controllers.ControllerReceita;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cfp.models.Recurso;
import com.cfp.models.Atividade;
import com.cfp.models.Receita;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.cfp.models.User;

/**
 * Classe que define a tela ~ Acesso.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 15/09/2017
 */
public class ViewAtividade extends javax.swing.JFrame {

    private List<Atividade> atividades;
    private List<Recurso> funcionarios;
    private List<Receita> projetos;
    private Atividade atividade;
    private final User user;
    
    /**
     * Creates new form FormImplantacao
     */
    public ViewAtividade(User user) {
        initComponents();
        this.user = user;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setLocation(400,100);//(x,y)
        this.atualizarTabela();
        this.limparCampos();        
        this.popularCombos();
        this.cbProjeto.setSelectedIndex(-1);
        this.cbFuncionario.setSelectedIndex(-1);
        this.btExcluir.setEnabled(false);
        this.btLimpar.setEnabled(false);
    }

    private ViewAtividade() {
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

        jPanel1 = new javax.swing.JPanel();
        lbProjeto = new javax.swing.JLabel();
        lbFuncionario = new javax.swing.JLabel();
        lbInicio = new javax.swing.JLabel();
        lbFim = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        cbFuncionario = new javax.swing.JComboBox<>();
        cbProjeto = new javax.swing.JComboBox<>();
        dcInicio = new com.toedter.calendar.JDateChooser();
        dcFim = new com.toedter.calendar.JDateChooser();
        lbVlHr = new javax.swing.JLabel();
        cbHora = new javax.swing.JComboBox<>();
        lbAtividade = new javax.swing.JLabel();
        cbAtividade = new javax.swing.JComboBox<>();
        btGerarRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAtividades = new javax.swing.JTable();
        painelBotoes = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btMenu = new javax.swing.JButton();
        btListagemAtividades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Atividade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        lbProjeto.setForeground(new java.awt.Color(0, 153, 255));
        lbProjeto.setText("Projeto:");
        lbProjeto.setToolTipText("");

        lbFuncionario.setForeground(new java.awt.Color(0, 153, 255));
        lbFuncionario.setText("Funcionário:");

        lbInicio.setForeground(new java.awt.Color(0, 153, 255));
        lbInicio.setText("Data de início:");

        lbFim.setForeground(new java.awt.Color(0, 153, 255));
        lbFim.setText("Data de fim:");

        lbStatus.setForeground(new java.awt.Color(0, 153, 255));
        lbStatus.setText("Status (%):");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100" }));
        cbStatus.setSelectedIndex(-1);

        cbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFuncionarioMouseClicked(evt);
            }
        });
        cbFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFuncionarioActionPerformed(evt);
            }
        });

        cbProjeto.setName(""); // NOI18N

        lbVlHr.setForeground(new java.awt.Color(0, 153, 255));
        lbVlHr.setText("Horas estimadas:");

        cbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200", "210", "220", "230", "240", "250", "260", "270", "280", "290", "300" }));
        cbHora.setSelectedIndex(-1);

        lbAtividade.setForeground(new java.awt.Color(0, 153, 255));
        lbAtividade.setText("Atividade:");

        cbAtividade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Levantamento de requisitos", "Análise dos requisitos do software", "Projeto da arquitetura do software", "Projeto detalhado do software", "Implementação", "Codificação e testes do software", "Integração do software", "Teste de qualificação do software", "Instalação do software", "Testagem e aprovação do software" }));
        cbAtividade.setSelectedIndex(-1);
        cbAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAtividadeActionPerformed(evt);
            }
        });

        btGerarRelatorio.setBackground(new java.awt.Color(102, 102, 102));
        btGerarRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btGerarRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        btGerarRelatorio.setText("Indicadores");
        btGerarRelatorio.setToolTipText("Click para gerar relatórios");
        btGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbInicio)
                    .addComponent(lbFim)
                    .addComponent(lbFuncionario)
                    .addComponent(lbProjeto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbProjeto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbVlHr, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dcFim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(dcInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbAtividade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btGerarRelatorio, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbVlHr)
                        .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbProjeto)
                        .addComponent(cbProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFuncionario)
                        .addComponent(cbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbStatus)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbAtividade)
                        .addComponent(cbAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbInicio)
                    .addComponent(dcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbFim, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dcFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btGerarRelatorio))
                .addContainerGap())
        );

        tbAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Projeto", "Funcionario", "Data inicio", "Data fim", "Atividade", "Status", "Horas est."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAtividadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAtividades);

        painelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        painelBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(0, 153, 255));
        btSalvar.setText("Salvar");
        btSalvar.setToolTipText("Incluir ou modificar uma atividade");
        btSalvar.setName("btSalvar"); // NOI18N
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(0, 153, 255));
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Deletar uma atividade");
        btExcluir.setName("btSalvar"); // NOI18N
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btLimpar.setForeground(new java.awt.Color(0, 153, 255));
        btLimpar.setText("Limpar");
        btLimpar.setToolTipText("Limpar os campos da tela");
        btLimpar.setName("btSalvar"); // NOI18N
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btMenu.setForeground(new java.awt.Color(0, 153, 255));
        btMenu.setText("Voltar");
        btMenu.setToolTipText("Voltar à tela de menu");
        btMenu.setName("btSalvar"); // NOI18N
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });

        btListagemAtividades.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btListagemAtividades.setForeground(new java.awt.Color(0, 153, 255));
        btListagemAtividades.setText("Listagem");
        btListagemAtividades.setToolTipText("Listar todas as atividades");
        btListagemAtividades.setName("btSalvar"); // NOI18N
        btListagemAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListagemAtividadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btListagemAtividades)
                .addGap(52, 52, 52)
                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btExcluir)
                    .addComponent(btLimpar)
                    .addComponent(btMenu)
                    .addComponent(btListagemAtividades))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(588, 433));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        this.salvarAtividade();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        this.removerImplantacao();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        //Invoca a tela ~ Cockpit.
        new ViewMenu(this.user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btMenuActionPerformed

    private void tbAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAtividadesMouseClicked
        int row = this.tbAtividades.getSelectedRow();
        this.atividade = this.atividades.get(row);
        //System.out.println(this.atividade);
        //System.out.println(this.atividade.getCodigo());
        this.popularCampos();
    }//GEN-LAST:event_tbAtividadesMouseClicked

    private void cbFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFuncionarioMouseClicked
//        int funcionarioIndex = this.funcionarios.indexOf(this.cbFuncionario.getSelectedIndex());
//        if (funcionarioIndex >= 0)
//            this.tfVlHrFunc.setText(this.funcionarios.get(funcionarioIndex).getVlHr().toString());        
    }//GEN-LAST:event_cbFuncionarioMouseClicked

    private void cbFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFuncionarioActionPerformed
        
    }//GEN-LAST:event_cbFuncionarioActionPerformed

    private void btListagemAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListagemAtividadesActionPerformed
        ResultSet rs;
        String listagem = "Projeto\t\tFuncionário\t\tData início\tData fim\tAtividade\t\t\tStatus\tHoras est.";
        listagem = listagem + "\n=======================================================================================";
        try {
            rs = ControllerAtividade.buscarTodasAtividades();
            while (rs.next()) {
                listagem = listagem + "\n"
                        + rs.getString("projeto") + "\t\t"
                        + rs.getString("funcionario") + "\t"
                        + rs.getString("inicio") + "\t"
                        + rs.getString("fim") + "\t"
                        + rs.getString("atividade") + "\t"
                        + rs.getString("status") + "\t"
                        + rs.getString("horas");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewAtividade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewListagem flo = new ViewListagem(listagem, this, true);
        flo.setVisible(true);
    }//GEN-LAST:event_btListagemAtividadesActionPerformed

    private void cbAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAtividadeActionPerformed

    private void btGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarRelatorioActionPerformed
        new ViewMenuRelatorio(this.user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btGerarRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAtividade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGerarRelatorio;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btListagemAtividades;
    private javax.swing.JButton btMenu;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbAtividade;
    private javax.swing.JComboBox<String> cbFuncionario;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbProjeto;
    private javax.swing.JComboBox<String> cbStatus;
    private com.toedter.calendar.JDateChooser dcFim;
    private com.toedter.calendar.JDateChooser dcInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAtividade;
    private javax.swing.JLabel lbFim;
    private javax.swing.JLabel lbFuncionario;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbProjeto;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbVlHr;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JTable tbAtividades;
    // End of variables declaration//GEN-END:variables
    
    private void limparCampos() {
        this.atividade = null;
        this.cbProjeto.setSelectedIndex(-1);
	this.cbFuncionario.setSelectedIndex(-1);
	this.dcInicio.setDate(null);
        this.dcFim.setDate(null);
        this.cbAtividade.setSelectedIndex(-1);
	this.cbStatus.setSelectedIndex(-1);        
        this.btExcluir.setEnabled(false);
        this.btLimpar.setEnabled(false);
        this.cbHora.setSelectedIndex(-1);
        
    }

    private boolean isCamposValidos() {
        boolean isValido = false;
        
        if (this.cbProjeto.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Projeto é obrigatório");
        } else if (this.cbFuncionario.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Funcionário é obrigatório");
        } else if (this.cbHora.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Qtde. horas é obrigatório");
        } else if (this.cbStatus.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Status é obrigatório");      
        } else if (this.dcInicio.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Data de início é obrigatório");    
        } else if (this.dcFim.getDate() == null) {
             JOptionPane.showMessageDialog(this, "Data de fim é obrigatório"); 
        } else if (this.dcFim.getDate().before(this.dcInicio.getDate())) {
            JOptionPane.showMessageDialog(this, "Data de fim é maior do que a data início"); 
        } else if (this.cbAtividade.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Atividade é obrigatório");
        } else {
            isValido = true;
        } 
        return isValido;
    }

    private void atualizarTabela() {
        String[] colunas = {"Projeto", "Funcionário", "Início", "Fim", "Atividade", "Status", "Horas est." };
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(colunas);
        
        try {
            this.atividades = ControllerAtividade.lista();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (Atividade i : this.atividades) {
            tableModel.addRow(i.getValueAsObject());
        }
        this.tbAtividades.setModel(tableModel);
    }

    private void popularCombos() {
        try {
            this.funcionarios = ControllerRecurso.lista();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        for (Recurso funcionario : this.funcionarios) {
            this.cbFuncionario.addItem(funcionario.getNome());
        }
        
        try {
            this.projetos = ControllerReceita.lista();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        for (Receita projeto : this.projetos) {
            this.cbProjeto.addItem(projeto.getStrDescricao());
        }
        this.btExcluir.setEnabled(true);
        this.btLimpar.setEnabled(true);
    }//Fim do metodo popularCombos

    private void popularCampos() {
        
        if (this.atividade != null) {
            
            int projetoIndex = this.projetos.indexOf(this.atividade.getProjeto());
            this.cbProjeto.setSelectedIndex(projetoIndex);
                       
            int funcionarioIndex = this.funcionarios.indexOf(this.atividade.getFuncionario());
            this.cbFuncionario.setSelectedIndex(funcionarioIndex);
                        
            this.dcInicio.setDate(this.atividade.getInicio());
            this.dcFim.setDate(this.atividade.getFim());            
            this.cbStatus.setSelectedItem(this.atividade.getStatus().toString());
            this.cbAtividade.setSelectedItem(this.atividade.getAtividade());
            this.cbHora.setSelectedItem(this.atividade.getHoras().toString());
            
        }
        this.btExcluir.setEnabled(true);
        this.btLimpar.setEnabled(true);
    }//Fim do metodo popularCampos
    
    private void salvarAtividade(){     
        if (!isCamposValidos()) {
            return;
        }
        Receita projeto = this.projetos.get(this.cbProjeto.getSelectedIndex());
        Recurso funcionario = this.funcionarios.get(this.cbFuncionario.getSelectedIndex());
        Date inicio = this.dcInicio.getDate();
        Date fim = this.dcFim.getDate();
        //String status = (String) this.cbStatus.getSelectedItem();
        int status = Integer.valueOf((String) this.cbStatus.getSelectedItem());
        String atv = (String) this.cbAtividade.getSelectedItem();
        int horas = Integer.valueOf((String) this.cbHora.getSelectedItem());

        if (this.atividade == null) {
            this.atividade = new Atividade();
        }
        
        this.atividade.setProjeto(projeto);
        this.atividade.setFuncionario(funcionario);
        this.atividade.setInicio(inicio);
        this.atividade.setFim(fim);
        this.atividade.setAtividade(atv);
        this.atividade.setStatus(status);
        this.atividade.setHoras(horas);
        
        try {
            ControllerAtividade.salvarAtividade(this.atividade);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAtividade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limparCampos();
        this.atualizarTabela();
    }//Fim do metodo salvarAtividade

    private void removerImplantacao() {
        
        try {
            ControllerAtividade.excluirAtividade(this.atividade.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(ViewAtividade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limparCampos();
        this.atualizarTabela();
    }

}//Fim da classe ViewAtividade.
