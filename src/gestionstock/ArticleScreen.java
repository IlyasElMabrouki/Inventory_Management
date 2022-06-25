package gestionstock;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ArticleScreen extends javax.swing.JFrame {

    private DefaultTableModel modele;
    connection article = new connection();

    public ArticleScreen() {
        initComponents();
    }

    // le role de charger est de actualiser les données du Jtable et il vient toujours directement apres le code de insert-upsate-delete
    // pour afficher les nouveaux données sur le JTable.
    private void charger() {
        try {
            modele = new DefaultTableModel();
            String[] nomclomne = {"CODE BARRES", "NOM", "QUANTITE INITIAL", "TOTAL IN", "TOTAL OUT"};
            modele.setColumnIdentifiers(nomclomne);
            
            Statement st = article.con.createStatement();
            String sql = "Select * from Artcile";
            ResultSet res = st.executeQuery(sql);
            modele.setRowCount(0);
            while (res.next()) {
                modele.addRow(new Object[]{res.getLong(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5)});
            }
           
            tabArticle.setModel(modele);
            txtcodebarre.requestFocus();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // cette methode nous permet de vider tous les textboxes et de positionner le curseur sur le textbox de code barres pour
    // simpliciter la tache d'ajouter un autre article.
    private void vider() {
        txtnom.setText("");
        txtquantiteinitial.setText("");
        txtcodebarre.setText("");
        txtcodebarre.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabArticle = new javax.swing.JTable();
        txtcodebarre = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtquantiteinitial = new javax.swing.JTextField();
        btnajouter = new javax.swing.JButton();
        btnmodifier = new javax.swing.JButton();
        torapprt = new javax.swing.JButton();
        toaction = new javax.swing.JButton();
        btnsupprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ARTICLE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        background.setBackground(new java.awt.Color(153, 153, 255));
        background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        background.setPreferredSize(new java.awt.Dimension(696, 578));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ARTICLE");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 280, 40));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setText("Code à Barres");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, 70));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("Nom");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 50, 80));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText("Quantité Initiale");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 80));

        tabArticle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODE BARRES", "NOM", "QUANTITE INITIAL", "TOTAL IN", "TOTAL OUT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabArticle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabArticleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabArticle);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 670, 180));

        txtcodebarre.setBackground(new java.awt.Color(204, 204, 255));
        txtcodebarre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcodebarre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodebarre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtcodebarre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodebarreActionPerformed(evt);
            }
        });
        background.add(txtcodebarre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 150, 40));

        txtnom.setBackground(new java.awt.Color(204, 204, 255));
        txtnom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtnom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });
        background.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 150, 40));

        txtquantiteinitial.setBackground(new java.awt.Color(204, 204, 255));
        txtquantiteinitial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtquantiteinitial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtquantiteinitial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtquantiteinitial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquantiteinitialActionPerformed(evt);
            }
        });
        background.add(txtquantiteinitial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 150, 40));

        btnajouter.setBackground(new java.awt.Color(0, 0, 0));
        btnajouter.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnajouter.setForeground(new java.awt.Color(255, 255, 255));
        btnajouter.setText("AJOUTER");
        btnajouter.setBorder(null);
        btnajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajouterActionPerformed(evt);
            }
        });
        background.add(btnajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 140, 40));

        btnmodifier.setBackground(new java.awt.Color(0, 0, 0));
        btnmodifier.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnmodifier.setForeground(new java.awt.Color(255, 255, 255));
        btnmodifier.setText("MODIFIER");
        btnmodifier.setBorder(null);
        btnmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifierActionPerformed(evt);
            }
        });
        background.add(btnmodifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 140, 40));

        torapprt.setBackground(new java.awt.Color(255, 255, 255));
        torapprt.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        torapprt.setText("RAPPORT");
        torapprt.setBorder(null);
        torapprt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torapprtActionPerformed(evt);
            }
        });
        background.add(torapprt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 140, 40));

        toaction.setBackground(new java.awt.Color(255, 255, 255));
        toaction.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        toaction.setText("ACTION");
        toaction.setBorder(null);
        toaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toactionActionPerformed(evt);
            }
        });
        background.add(toaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 130, 40));

        btnsupprimer.setBackground(new java.awt.Color(0, 0, 0));
        btnsupprimer.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnsupprimer.setForeground(new java.awt.Color(255, 255, 255));
        btnsupprimer.setText("SUPPRIMER");
        btnsupprimer.setBorder(null);
        btnsupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupprimerActionPerformed(evt);
            }
        });
        background.add(btnsupprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void txtcodebarreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodebarreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodebarreActionPerformed

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void txtquantiteinitialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantiteinitialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantiteinitialActionPerformed

    private void torapprtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torapprtActionPerformed
        Rapport toRapport = new Rapport();
        toRapport.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_torapprtActionPerformed

    private void toactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toactionActionPerformed
        ActionScreen toAction = new ActionScreen();
        toAction.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toactionActionPerformed

    private void btnajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajouterActionPerformed
        try {
            // cette condition test si l'utilisateur a entre une valeur dans le textbox de nom une valeur et une quantité plus grande que 0.
            if (txtnom.getText().trim().equals("") || Integer.parseInt(txtquantiteinitial.getText()) < 0) {
                throw new Exception();
            }
            
            Integer.parseInt(txtcodebarre.getText()); // pour tester si l'utilisateur a vraiment entrer un nombre et non 
            Integer.parseInt(txtquantiteinitial.getText()); // le vide ou un text.

            for (int i = 0; i < modele.getRowCount(); i++) { // pour tester si l'utilisateur a entré un nom qui existent deja ce qui est incorrecte.
                if (txtcodebarre.getText().equals(modele.getValueAt(i, 0).toString()) || txtnom.getText().equals(modele.getValueAt(i, 1).toString())) {
                    throw new SQLException();
                }
            }

            // nous permet d'inserer les valeurs rassemblés à la table Artcile.
            Statement st = article.con.createStatement();
            String sql = "Insert into Artcile Values ('" + txtcodebarre.getText() + "','" + txtnom.getText() + "','" + txtquantiteinitial.getText() + "','" + 0 + "','" + 0 + "')";
            st.executeUpdate(sql);
            vider();
            charger();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "CE ARTICLE EXISTE DEJA", "AJOUTER", JOptionPane.ERROR_MESSAGE);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ENTRER DES DONNEES VALIDES", "AJOUTER", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnajouterActionPerformed

    private void btnmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifierActionPerformed
        int index = tabArticle.getSelectedRow();
        if (index == -1) {  // nous permet de tester si l'utilisateur a clicker sur une ligne ou non.
            JOptionPane.showMessageDialog(this, "SELECTIONNER UNE LIGNE", "MODIFIER", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // cette condition test si l'utilisateur a entre une valeur dans txtnom et une quantité plus grande que 0 dans txtquantiteinitial.
                if (txtnom.getText().trim().equals("") || Integer.parseInt(txtquantiteinitial.getText()) < 0) {
                    throw new Exception();
                }

                Integer.parseInt(txtcodebarre.getText()); // pour tester si l'utilisateur a vraiment entrer un nombre et non 
                Integer.parseInt(txtquantiteinitial.getText()); // le vide ou un text.

                for (int i = 0; i < modele.getRowCount(); i++) { // pour tester si l'utilisateur a entré un nom qui existe deja ce qui est incorrecte.
                    if (txtcodebarre.getText().equals(modele.getValueAt(i, 0).toString()) || txtnom.getText().equals(modele.getValueAt(i, 1).toString())) {
                        if (i == index) {
                            continue;
                        }
                        throw new SQLException();
                    }
                }

                // nous permet de modifier des données d'une ligne selectionné.
                Statement st = article.con.createStatement();
                String sql = "update Artcile set CodeBarres ='" + txtcodebarre.getText() + "',Nom='" + txtnom.getText() + "',Quantiteinitiale='" + txtquantiteinitial.getText() + "' where CodeBarres = '" + modele.getValueAt(index, 0).toString() + "' ";
                st.executeUpdate(sql);

                // nous permet de modifier le nom de la données dans la table history.
                String sql1 = "update history set codebarre ='" + txtcodebarre.getText() + "',Nom ='" + txtnom.getText() + "' where codebarre = '" + modele.getValueAt(index, 0).toString() + "' ";
                st.executeUpdate(sql1);

                vider();
                charger();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "CE ARTICLE EXISTE DEJA", "MODIFIER", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ENTRER DES DONNEES VALIDES", "MODIFIER", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnmodifierActionPerformed

    private void btnsupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupprimerActionPerformed
        int index = tabArticle.getSelectedRow();
        if (index == -1) {  // nous permet de tester si l'utilisateur a clicker sur une ligne ou non.
            JOptionPane.showMessageDialog(this, "SELECTIONNER UNE LIGNE", "SUPPRIMER", JOptionPane.ERROR_MESSAGE);
        } 
        else {
            try {
                // nous permet de supprimer la ligne selectionné.
                Statement st = article.con.createStatement();
                String sql = "Delete from Artcile where CodeBarres = '" + modele.getValueAt(index, 0).toString() + "'";
                st.executeUpdate(sql);

                String sql1 = "Delete from history where codebarre = '" + modele.getValueAt(index, 0).toString() + "'";
                st.executeUpdate(sql1);

                vider();
                charger();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_btnsupprimerActionPerformed

    private void tabArticleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabArticleMouseClicked
        // nous permet d'affciher les données affichées dans le JTable dans les textBoxes.
        int index = tabArticle.getSelectedRow();
        txtcodebarre.setText(modele.getValueAt(index, 0).toString()); // on recolte une donnée en utilisant l'index de row et column.
        txtnom.setText(modele.getValueAt(index, 1).toString());
        txtquantiteinitial.setText(modele.getValueAt(index, 2).toString());
    }//GEN-LAST:event_tabArticleMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        article.connecter();
        charger();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ArticleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArticleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArticleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArticleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArticleScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnajouter;
    private javax.swing.JButton btnmodifier;
    private javax.swing.JButton btnsupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabArticle;
    private javax.swing.JButton toaction;
    private javax.swing.JButton torapprt;
    private javax.swing.JTextField txtcodebarre;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtquantiteinitial;
    // End of variables declaration//GEN-END:variables
}
