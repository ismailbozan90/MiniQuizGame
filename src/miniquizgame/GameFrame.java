package miniquizgame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismail
 */
public class GameFrame extends javax.swing.JFrame {

    public String userName;
    public String correctAnswer;
    public long startTime;
    public int questionCount = 12;
    public int questionNumber = 1;
    public List<Question> cacheData;
    public List<Question> oldQuestions;

    public GameFrame() {
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        try {
            getQuestions();
            startGame();
        } catch (SQLException ex) {
            Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpAnswer = new javax.swing.ButtonGroup();
        lblQuestionTitle = new javax.swing.JLabel();
        rdAnswer1 = new javax.swing.JRadioButton();
        rdAnswer2 = new javax.swing.JRadioButton();
        rdAnswer3 = new javax.swing.JRadioButton();
        rdAnswer4 = new javax.swing.JRadioButton();
        btnAnswer = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tQuestion = new javax.swing.JTextArea();
        btnGameOver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bilgi Yarışması");
        setResizable(false);

        lblQuestionTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblQuestionTitle.setText("jLabel1");

        grpAnswer.add(rdAnswer1);

        grpAnswer.add(rdAnswer2);

        grpAnswer.add(rdAnswer3);

        grpAnswer.add(rdAnswer4);

        btnAnswer.setText("Cevapla");
        btnAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });

        tQuestion.setEditable(false);
        tQuestion.setColumns(20);
        tQuestion.setLineWrap(true);
        tQuestion.setRows(5);
        tQuestion.setAutoscrolls(false);
        jScrollPane1.setViewportView(tQuestion);

        btnGameOver.setText("Oyunu Bitir");
        btnGameOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameOverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuestionTitle)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(rdAnswer3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdAnswer4))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rdAnswer1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdAnswer2))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(btnGameOver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestionTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdAnswer1)
                    .addComponent(rdAnswer2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdAnswer3)
                    .addComponent(rdAnswer4))
                .addGap(18, 18, 18)
                .addComponent(btnAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGameOver)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerActionPerformed
        String answer = grpAnswer.getSelection().getActionCommand();
        if (answer == null ? correctAnswer == null : answer.equals(correctAnswer)) {
            questionNumber += 1;
            if (questionNumber <= questionCount) {
                startGame();
            } else {
                endGame();
            }
        } else {
            endGame();
        }
        grpAnswer.clearSelection();
    }//GEN-LAST:event_btnAnswerActionPerformed

    private void btnGameOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameOverActionPerformed
        endGame();
    }//GEN-LAST:event_btnGameOverActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    public void setUserName(String userName) {
        this.userName = userName;
        this.startTime = System.currentTimeMillis();
        lblUserName.setText("Hoşgeldin, " + userName);

    }

    public void getQuestions() throws SQLException {
        clearData();

        cacheData = new ArrayList<Question>();
        oldQuestions = new ArrayList<Question>();

        DbHelper dbHelper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement("SELECT * FROM question");
            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                cacheData.add(new Question(resultSet.getString("question"), resultSet.getString("answer1"), resultSet.getString("answer2"), resultSet.getString("answer3"), resultSet.getString("answer4"), resultSet.getString("correctAnswer")));
                count++;
            }
            if (count < questionCount) {
                questionCount = count;
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception, "getQuestions");
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                System.out.println(exception);
            }
        }
    }

    public void endGame() {
        EndFrame endScreen = new EndFrame();
        endScreen.setVisible(true);
        endScreen.userInfo(userName, questionNumber - 1, startTime);
        this.setVisible(false);
        clearData();
    }

    public void startGame() {
        if (cacheData == null) {
            return;
        }

        Collections.shuffle(cacheData);
        boolean isComplete = false;
        for (Question question : cacheData) {
            while (checkQuestion(question)) {
                oldQuestions.add(question);
                lblQuestionTitle.setText("Soru " + questionNumber + " / " + questionCount);
                tQuestion.setText(question.getQuestion());
                rdAnswer1.setText(question.getAnswer1());
                rdAnswer1.setActionCommand(question.getAnswer1());
                rdAnswer2.setText(question.getAnswer2());
                rdAnswer2.setActionCommand(question.getAnswer2());
                rdAnswer3.setText(question.getAnswer3());
                rdAnswer3.setActionCommand(question.getAnswer3());
                rdAnswer4.setText(question.getAnswer4());
                rdAnswer4.setActionCommand(question.getAnswer4());
                this.correctAnswer = question.getCorrectAnswer();
                isComplete = true;
                break;
            }
            if (isComplete) {
                break;
            }
        }
    }

    public boolean checkQuestion(Question q) {
        for (Question question : oldQuestions) {
            if (question.getQuestion() == null ? q.getQuestion() == null : question.getQuestion().equals(q.getQuestion())) {
                return false;
            }
        }
        return true;
    }

    public void clearData() {
        if (cacheData != null) {
            cacheData.removeAll(cacheData);
        }

        if (oldQuestions != null) {
            oldQuestions.removeAll(oldQuestions);
        }
        this.questionNumber = 1;
        this.correctAnswer = "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswer;
    private javax.swing.JButton btnGameOver;
    private javax.swing.ButtonGroup grpAnswer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuestionTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JRadioButton rdAnswer1;
    private javax.swing.JRadioButton rdAnswer2;
    private javax.swing.JRadioButton rdAnswer3;
    private javax.swing.JRadioButton rdAnswer4;
    private javax.swing.JTextArea tQuestion;
    // End of variables declaration//GEN-END:variables
}
