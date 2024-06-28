
package miniquizgame;

/**
 *
 * @author ismail
 */
public class HighScore {
    
    private String userName;
    private int answerCorret;
    private long completeTime;
    
    public HighScore (String userName, int answerCorrect, long completeTime) {
        this.userName = userName;
        this.answerCorret = answerCorrect;
        this.completeTime = completeTime;
    }

    public String getUserName() {
        return userName;
    }

    public int getAnswerCorret() {
        return answerCorret;
    }

    public long getCompleteTime() {
        return completeTime;
    }
}
