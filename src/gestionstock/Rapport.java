package gestionstock;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Rapport extends javax.swing.JFrame {

    connection rapport = new connection();

    public Rapport() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        btngenererrapport = new javax.swing.JButton();
        toarticle = new javax.swing.JButton();
        toaction = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nomrapport = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RAPPORT");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        background.setBackground(new java.awt.Color(153, 153, 255));
        background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        background.setPreferredSize(new java.awt.Dimension(696, 578));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btngenererrapport.setBackground(new java.awt.Color(0, 0, 0));
        btngenererrapport.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btngenererrapport.setForeground(new java.awt.Color(255, 255, 255));
        btngenererrapport.setText("GENERER LE RAPPORT");
        btngenererrapport.setBorder(null);
        btngenererrapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenererrapportActionPerformed(evt);
            }
        });
        background.add(btngenererrapport, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 230, 40));

        toarticle.setBackground(new java.awt.Color(255, 255, 255));
        toarticle.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        toarticle.setText("ARTICLE");
        toarticle.setBorder(null);
        toarticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toarticleActionPerformed(evt);
            }
        });
        background.add(toarticle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 140, 40));

        toaction.setBackground(new java.awt.Color(255, 255, 255));
        toaction.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        toaction.setText("ACTION");
        toaction.setBorder(null);
        toaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toactionActionPerformed(evt);
            }
        });
        background.add(toaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 130, 40));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RAPPORT");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 120, 40));

        nomrapport.setBackground(new java.awt.Color(204, 204, 255));
        nomrapport.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nomrapport.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomrapport.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        nomrapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomrapportActionPerformed(evt);
            }
        });
        background.add(nomrapport, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 130, 40));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("Date ");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 130, 70));

        tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODE BARRES", "NOM ARTICLE", "TYPE ACTION", "QUANTITE", "DATE ACTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableau);
        if (tableau.getColumnModel().getColumnCount() > 0) {
            tableau.getColumnModel().getColumn(0).setResizable(false);
            tableau.getColumnModel().getColumn(1).setResizable(false);
            tableau.getColumnModel().getColumn(2).setResizable(false);
            tableau.getColumnModel().getColumn(3).setResizable(false);
            tableau.getColumnModel().getColumn(4).setResizable(false);
        }

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 460, 490));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText("Nom Rapport");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, 70));
        background.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void charger() {
        try {
            DefaultTableModel modele = new DefaultTableModel();
            
            String[] nomclomne = {"CODE BARRES", "NOM", "TYPE ACTION", "QUANTITE", "DATE ACTION"};
            modele.setColumnIdentifiers(nomclomne);
            
            Statement st = rapport.con.createStatement();
            String sql = "Select * from history";
            ResultSet res = st.executeQuery(sql);
            modele.setRowCount(0);
            while (res.next()) {
                modele.addRow(new Object[]{res.getInt("codebarre"), res.getString("Nom"), res.getString("typeaction"), res.getInt("quantity"), res.getDate("dateaction")});
            }
            
            tableau.setModel(modele);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void btngenererrapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenererrapportActionPerformed
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // date actuelle
        LocalDateTime now = LocalDateTime.now();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  // date entreé par utilisateur qui est formé comme la date actuelle
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd"); // date entreé par utilisateur qui est formé comme la date SQL
        
        if (tableau.getRowCount() == 0 ) {
            nomrapport.setText("");
            JOptionPane.showMessageDialog(this, "IL N'EXISTE AUCUNE ACTION", "VIDE", JOptionPane.ERROR_MESSAGE);
        } 
        else if (nomrapport.getText().trim().equals("")) {
            nomrapport.requestFocus();
            JOptionPane.showMessageDialog(this, "ENTRER UN NOM DU RAPPORT", "NOM", JOptionPane.ERROR_MESSAGE);
        } 
        else if (date.getDate() == null) {
            JOptionPane.showMessageDialog(this, "ENTRER UNE DATE", "DATE", JOptionPane.ERROR_MESSAGE);
        } 
        else {
            try {
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream(nomrapport.getText() + ".pdf"));
                doc.open();

                Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK);
                Chunk chunk = new Chunk("              Historiques Des Actions Du " + dateFormat.format(date.getDate()) + " Jusqu'au " + dtf.format(now), font);
                doc.add(chunk);

                Paragraph par = new Paragraph("\n");
                doc.add(par);

                Font font1 = FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK);
                Chunk chunk1 = new Chunk("                        Générer Le " + dtf.format(now), font1);
                doc.add(chunk1);

                Paragraph par1 = new Paragraph("\n");
                doc.add(par1);

                PdfPTable table = new PdfPTable(5);

                PdfPCell header0 = new PdfPCell();
                header0.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header0.setPhrase(new Phrase("CODE BARRES"));
                table.addCell(header0);

                PdfPCell header1 = new PdfPCell();
                header1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header1.setPhrase(new Phrase("NOM ARTICLE"));
                table.addCell(header1);

                PdfPCell header2 = new PdfPCell();
                header2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header2.setPhrase(new Phrase("TYPE ACTION"));
                table.addCell(header2);

                PdfPCell header3 = new PdfPCell();
                header3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header3.setPhrase(new Phrase("QUANTITE"));
                table.addCell(header3);

                PdfPCell header4 = new PdfPCell();
                header4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header4.setPhrase(new Phrase("DATE ACTION"));
                table.addCell(header4);

                String sql = "Select * from history where dateaction between '" + dateFormat1.format(date.getDate()) + "'and current_date";
                Statement st = rapport.con.createStatement();
                ResultSet res = st.executeQuery(sql);

                while (res.next()) {
                    table.addCell(String.valueOf(res.getInt("codebarre")));
                    table.addCell(res.getString("Nom"));
                    table.addCell(res.getString("typeaction"));
                    table.addCell(String.valueOf(res.getInt("quantity")));
                    table.addCell(String.valueOf(res.getDate("dateaction")));
                }

                doc.add(table);
                doc.close();

                nomrapport.setText("");
                nomrapport.requestFocus();
                JOptionPane.showMessageDialog(this, "RAPPORT CREE", "RAPPORT", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_btngenererrapportActionPerformed

    private void toactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toactionActionPerformed
        ActionScreen toAction = new ActionScreen();
        toAction.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toactionActionPerformed

    private void toarticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toarticleActionPerformed
        ArticleScreen toArticle = new ArticleScreen();
        toArticle.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toarticleActionPerformed

    private void nomrapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomrapportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomrapportActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       rapport.connecter();
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
            java.util.logging.Logger.getLogger(Rapport.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rapport.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rapport.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rapport.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rapport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btngenererrapport;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomrapport;
    private javax.swing.JTable tableau;
    private javax.swing.JButton toaction;
    private javax.swing.JButton toarticle;
    // End of variables declaration//GEN-END:variables
}
