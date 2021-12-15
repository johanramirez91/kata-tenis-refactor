package katatenis;

public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equalsIgnoreCase(player1Name))
            scorePlayer1 += 1;
        if (playerName.equalsIgnoreCase(player2Name))
            scorePlayer2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (isEqualScore()) getScorePlayer1(score);
        else if (isUpTo4Points()) getAdvantage(score);
        else if (isBetween1And3Points())
            for (int point = 1; point < 3; point++) getResultScore(score, point);
        return score.toString();
    }

    private void getResultScore(StringBuilder score, int point) {
        int temporalScore;
        if (point == 1) temporalScore = scorePlayer1;
        else {
            score.append("-");
            temporalScore = scorePlayer2;
        }
        getScoreDescription(score, temporalScore);
    }

    private void getScoreDescription(StringBuilder score, int temporalScore) {
        switch (temporalScore){
            case 0:
                score.append("Love");
                break;
            case 1:
                score.append("Fifteen");
                break;
            case 2:
                score.append("Thirty");
                break;
            case 3:
                score.append("Forty");
                break;
            default:
                score.append("");
        }
    }

    private boolean isBetween1And3Points() {
        return playerScoreIsBetween1And3Points(scorePlayer1) || playerScoreIsBetween1And3Points(scorePlayer2);
    }

    private boolean playerScoreIsBetween1And3Points(int scorePlayer) {
        return scorePlayer >= 1 || scorePlayer < 3;
    }

    private void getAdvantage(StringBuilder score) {
        if (scoreDifference() == 1) score.append("Advantage player1");
        else if (scoreDifference() == -1) score.append("Advantage player2");
        else if (scoreDifference() >= 2) score.append("Win for player1");
        else score.append("Win for player2");
    }

    private int scoreDifference(){
        return scorePlayer1 - scorePlayer2;
    }

    private boolean isUpTo4Points() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private boolean isEqualScore() {
        return scorePlayer1 == scorePlayer2;
    }

    private void getScorePlayer1(StringBuilder score) {
        switch (scorePlayer1) {
            case 0:
                score.append("Love-All");
                break;
            case 1:
                score.append("Fifteen-All");
                break;
            case 2:
                score.append("Thirty-All");
                break;
            default:
                score.append("Deuce");
                break;
        }
    }
}