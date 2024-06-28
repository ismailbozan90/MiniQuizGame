package miniquizgame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ismail
 */
public class EndFrame extends javax.swing.JFrame {

    DefaultTableModel model;

    public EndFrame() {
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHighScore = new javax.swing.JTable();
        lblGameOver = new javax.swing.JLabel();
        lblCorrectAnswer = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblHighScore = new javax.swing.JLabel();
        btnNewGame = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bilgi Yarışması");
        setResizable(false);

        tblHighScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sıra", "İsim", "Puan", "Süre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHighScore);
        if (tblHighScore.getColumnModel().getColumnCount() > 0) {
            tblHighScore.getColumnModel().getColumn(0).setResizable(false);
            tblHighScore.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblHighScore.getColumnModel().getColumn(1).setResizable(false);
            tblHighScore.getColumnModel().getColumn(2).setResizable(false);
            tblHighScore.getColumnModel().getColumn(2).setPreferredWidth(30);
            tblHighScore.getColumnModel().getColumn(3).setResizable(false);
        }

        lblGameOver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGameOver.setText("OYUN BİTTİ");

        lblCorrectAnswer.setText("Doğru cevaplanan soru sayısı :");

        lblTime.setText("Süre :");

        lblHighScore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHighScore.setText("SIRALAMA");

        btnNewGame.setText("YENİ OYUN");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        lblUserName.setText("Kullanıcı Adı :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(lblGameOver))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTime)
                                    .addComponent(lblCorrectAnswer)
                                    .addComponent(lblUserName))))
                        .addComponent(lblHighScore))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblGameOver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUserName)
                .addGap(5, 5, 5)
                .addComponent(lblCorrectAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTime)
                .addGap(18, 18, 18)
                .addComponent(btnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHighScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        WelcomeFrame welcomeScreen = new WelcomeFrame();
        welcomeScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNewGameActionPerformed

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
            java.util.logging.Logger.getLogger(EndFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EndFrame().setVisible(true);
            }
        });
    }

    public void userInfo(String userName, int correctAnswer, long startTime) {
        lblUserName.setText("Kullanıcı adı : " + userName);
        lblCorrectAnswer.setText("Doğru cevaplanan soru sayısı : " + correctAnswer);
        long endTime = System.currentTimeMillis() - startTime;
        lblTime.setText("Süre : " + convertTime(endTime));

        if (correctAnswer > 0) {
            insertNewScore(userName, correctAnswer, endTime);
        }

        getHighScoreList();

    }

    public void insertNewScore(String userName, int correctAnswer, long startTime) {
        DbHelper dbHelper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement("INSERT INTO highscore (userName, score, completeTime) VALUES (?,?,?)");
            statement.setString(1, userName);
            statement.setInt(2, correctAnswer);
            statement.setLong(3, startTime);
            statement.executeUpdate();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception, "insertNewScore");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                System.out.println(exception);
            }
        }
    }

    public void getHighScoreList() {
        ArrayList<HighScore> list = new ArrayList();
        DbHelper dbHelper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement("SELECT * FROM highscore ORDER BY score DESC, completeTime");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new HighScore(resultSet.getString("userName"), resultSet.getInt("score"), resultSet.getLong("completeTime")));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception, "getHighScoreList");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                System.out.println(exception);
            }
        }

        model = (DefaultTableModel) tblHighScore.getModel();
        int i = 1;
        for (HighScore stock : list) {
            Object[] row = {i, stock.getUserName(), stock.getAnswerCorret(), convertTime(stock.getCompleteTime())};
            model.addRow(row);
            i++;
        }
    }

    public String convertTime(long time) {

        long seconds = time / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        String result = minutes % 60 + " Dakika " + seconds % 60 + " Saniye";

        if (hours > 0) {
            result = hours % 24 + " Saat " + result;
        }

        if (days > 0) {
            result = days + " Gün " + hours % 24 + " Saat " + minutes % 60 + " Dakika " + seconds % 60 + " Saniye";
        }

        return result;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewGame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCorrectAnswer;
    private javax.swing.JLabel lblGameOver;
    private javax.swing.JLabel lblHighScore;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblHighScore;
    // End of variables declaration//GEN-END:variables
}
