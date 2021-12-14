package katatenis;

public class TennisGame3 implements TennisGame {

    private int scorePlayer1;
    private int scorePlayer2;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (scoresComparing()) return scoreResult();
        if (isTieBreak()) return "Deuce";
        return getWinner();
    }

    public void wonPoint(String playerName) {
        if (playerName.equalsIgnoreCase("player1"))
            this.scorePlayer1 += 1;
        if (playerName.equalsIgnoreCase("player2"))
            this.scorePlayer2 += 1;
    }

    private boolean isTieBreak() {
        return scorePlayer1 == scorePlayer2;
    }

    private boolean isAdvantageOrWin(){
        return Math.pow((scorePlayer2 - scorePlayer1), 2) == 1;
    }

    public String getWinner(){
        return isAdvantageOrWin() ? "Advantage " + playerAdvantage() : "Win for " + playerAdvantage();
    }

    public String playerAdvantage(){
        return scorePlayer2 > scorePlayer1 ? player2Name : player1Name;
    }

    private boolean scoresComparing() {
        return (isLessThan4(scorePlayer2) && isLessThan4(scorePlayer1) && isDifferentTo6());
    }

    private boolean isLessThan4(int scorePlayer) {
        return scorePlayer < 4;
    }

    private boolean isDifferentTo6() {
        return (scorePlayer1 + scorePlayer2 != 6);
    }

    public String scoreResult() {
        String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (scorePlayer2 == scorePlayer1) ?
                scores[scorePlayer1] + "-All"
                :
                scores[scorePlayer1] + "-" + scores[scorePlayer2];
    }
}
