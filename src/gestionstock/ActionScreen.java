package gestionstock;

import java.sql.*;
import javax.swing.JOptionPane;

public class ActionScreen extends javax.swing.JFrame {

    int code, quantite, now, in, out; // utilisé pour calculer la quantité actuel d'un article donnée
    connection action = new connection();

    public ActionScreen() {
        initComponents();
    }

    // Les roles principales de cette Form sont :
    // Gérer apres chaque action la quantité actuel du stock 
    // Récumuler les données en utilisant plusieurs objects pour créer la table history.
    
    //le role de cette methode est d'obtenire les données necessaires d'un article selon son code pour calculer aprés la quantité actuel en stock.
    public void dataactuel() {
        try {
            code = Integer.parseInt(codebarre.getText());
            Statement st = action.con.createStatement();
            String sql = "Select Nom,Quantiteinitiale,entrée,sortie from Artcile where CodeBarres = '" + code + "' ";
            ResultSet res = st.executeQuery(sql);
            res.next();
            nomarticle1.setText(res.getString("Nom"));
            now = res.getInt("Quantiteinitiale");
            in = res.getInt("entrée");
            out = res.getInt("sortie");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // cette methode sert à modifier la valeur de in d'un produit pour bien calculer la quantité actuel
    private void ajouter() {
        try {
            Statement st = action.con.createStatement();
            in = in + Integer.parseInt(txtquantiteentree.getText());
            String sql = "update Artcile set entrée = " + in + " where CodeBarres = '" + code + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // cette methode sert à modifier la valeur de in d'un produit pour bien calculer la quantité actuel
    private void supprimer() {
        try {
            Statement st = action.con.createStatement();
            out = out + Integer.parseInt(txtquantiteentree.getText());
            String sql = "update Artcile set sortie = " + out + " where CodeBarres = '" + code + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // le role de cette methode est d'inserer les données rassemblés (checkbox,textbox,current_date,combobox) à la table history 
    // j'ai créer une autre table car pour la simple raison on peut pas dupliquer le PRIMARY KEY du table master
    // ce qu'il sera absolument fait par l'utilisateur dans le cas ou il veut faire un in ou out du meme produit.
    private void creerhistory() {
        String type;

        if (checkin.isSelected()) {
            type = "IN";
            ajouter();

        } else {
            type = "OUT";
            supprimer();
        }

        try {
            Statement st = action.con.createStatement();
            String sql = "Insert into history Values ('" + type + "' ,'" + txtquantiteentree.getText() + "',current_date,'" + nomarticle1.getText() + "'," + codebarre.getText() + ")";
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void vider() {
        codebarre.setText("");
        codebarre.requestFocus();
        txtquantiteentree.setText("");
        nomarticle1.setText("");
        quantityinitial1.setText("");
        txtquantiteentree.setEditable(false);
        btnenregistrer.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        txtquantiteentree1 = new javax.swing.JTextField();
        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        toarticle = new javax.swing.JButton();
        torapprt = new javax.swing.JButton();
        checkout = new javax.swing.JCheckBox();
        checkin = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        btnenregistrer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        quantityinitial1 = new javax.swing.JLabel();
        txtquantiteentree = new javax.swing.JTextField();
        chercher = new javax.swing.JButton();
        codebarre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nomarticle1 = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setText("Quantité Initiale");

        txtquantiteentree1.setBackground(new java.awt.Color(204, 204, 255));
        txtquantiteentree1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtquantiteentree1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtquantiteentree1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtquantiteentree1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquantiteentree1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACTION");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        background.setBackground(new java.awt.Color(153, 153, 255));
        background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ACTIONS");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 100, 40));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel4.setText("Type D'action");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 210, 70));

        toarticle.setBackground(new java.awt.Color(255, 255, 255));
        toarticle.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        toarticle.setText("ARTICLE");
        toarticle.setBorder(null);
        toarticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toarticleActionPerformed(evt);
            }
        });
        background.add(toarticle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 140, 40));

        torapprt.setBackground(new java.awt.Color(255, 255, 255));
        torapprt.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        torapprt.setText("RAPPORT");
        torapprt.setBorder(null);
        torapprt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torapprtActionPerformed(evt);
            }
        });
        background.add(torapprt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 130, 40));

        buttonGroup1.add(checkout);
        checkout.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        checkout.setText("OUT");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        background.add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 60, 40));

        buttonGroup1.add(checkin);
        checkin.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        checkin.setSelected(true);
        checkin.setText(" IN");
        checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinActionPerformed(evt);
            }
        });
        background.add(checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 50, 40));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel5.setText("Quantité");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 150, 80));

        btnenregistrer.setBackground(new java.awt.Color(0, 0, 0));
        btnenregistrer.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnenregistrer.setForeground(new java.awt.Color(255, 255, 255));
        btnenregistrer.setText("ENREGISTRER");
        btnenregistrer.setBorder(null);
        btnenregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenregistrerActionPerformed(evt);
            }
        });
        background.add(btnenregistrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 190, 40));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel2.setText("Code Barres D'aticle");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 200, 20));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel9.setText("Quantité En Stock :");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 210, 30));

        quantityinitial1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        quantityinitial1.setForeground(new java.awt.Color(255, 255, 255));
        background.add(quantityinitial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 60, 50));

        txtquantiteentree.setBackground(new java.awt.Color(204, 204, 255));
        txtquantiteentree.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtquantiteentree.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtquantiteentree.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtquantiteentree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquantiteentreeActionPerformed(evt);
            }
        });
        background.add(txtquantiteentree, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 130, 40));

        chercher.setBackground(new java.awt.Color(0, 0, 0));
        chercher.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        chercher.setForeground(new java.awt.Color(255, 255, 255));
        chercher.setText("CHERCHER");
        chercher.setBorder(null);
        chercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chercherActionPerformed(evt);
            }
        });
        background.add(chercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 90, 40));

        codebarre.setBackground(new java.awt.Color(204, 204, 255));
        codebarre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        codebarre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codebarre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        codebarre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        background.add(codebarre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 130, 40));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel3.setText("Nom D'article");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 130, 20));

        nomarticle1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        nomarticle1.setForeground(new java.awt.Color(255, 255, 255));
        background.add(nomarticle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void torapprtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torapprtActionPerformed
        Rapport toRapport = new Rapport();
        toRapport.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_torapprtActionPerformed

    private void toarticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toarticleActionPerformed
        ArticleScreen toArticle = new ArticleScreen();
        toArticle.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toarticleActionPerformed

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkoutActionPerformed

    private void checkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkinActionPerformed

    private void btnenregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenregistrerActionPerformed
        try {
            int quantite1 = Integer.parseInt(txtquantiteentree.getText());
            if (quantite1 <= 0) {
                throw new Exception();
            }
            if (checkout.isSelected()) {
            if (Integer.parseInt(quantityinitial1.getText()) < Integer.parseInt(txtquantiteentree.getText())) {
                txtquantiteentree.setText("");
                txtquantiteentree.requestFocus();
                JOptionPane.showMessageDialog(this, "ACTION IMPOSSIBLE", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                creerhistory();
                vider();
            }
        } else {
            creerhistory();
            vider();
        }
        } 
        catch (Exception e) {
            txtquantiteentree.setText("");
            txtquantiteentree.requestFocus();
            JOptionPane.showMessageDialog(this, "ENTRER UNE QUANTITE VALIDE", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnenregistrerActionPerformed

    private void txtquantiteentree1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantiteentree1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantiteentree1ActionPerformed

    private void txtquantiteentreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantiteentreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantiteentreeActionPerformed

    private void chercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercherActionPerformed
        try {
            int codebar = Integer.parseInt(codebarre.getText());

            Statement st = action.con.createStatement();
            String sql = "Select CodeBarres from Artcile where CodeBarres = " + codebar;
            ResultSet res = st.executeQuery(sql);

            if (!res.next()){
                vider();
                JOptionPane.showMessageDialog(this, "CE ARTICLE N'EXSITE PAS", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                dataactuel();
                quantityinitial1.setText(String.valueOf((now + in) - out));
                txtquantiteentree.setEditable(true);
                btnenregistrer.setEnabled(true);
                txtquantiteentree.requestFocus();
            }

        } catch (Exception e) {
            vider();
            JOptionPane.showMessageDialog(this, "ENTRER UN CODEBARRES VALIDE", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_chercherActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        action.connecter();
        codebarre.requestFocus();
        txtquantiteentree.setEditable(false);
        btnenregistrer.setEnabled(false);
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
            java.util.logging.Logger.getLogger(ActionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActionScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnenregistrer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkin;
    private javax.swing.JCheckBox checkout;
    private javax.swing.JButton chercher;
    private javax.swing.JTextField codebarre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel nomarticle1;
    private javax.swing.JLabel quantityinitial1;
    private javax.swing.JButton toarticle;
    private javax.swing.JButton torapprt;
    private javax.swing.JTextField txtquantiteentree;
    private javax.swing.JTextField txtquantiteentree1;
    // End of variables declaration//GEN-END:variables
}
