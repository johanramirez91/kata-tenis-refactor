package katatenis;

import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame {
    public int player1points = 0;
    public int player2points = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (isTieBreak()) {
            score.append(equalScores());
        } else if (playerScoreGreaterThan4()) {
            int scoreDifference = player1points - player2points;
            score.append(advantage(scoreDifference));
        } else {
            score.append(getScorePlayer(player1points)).append("-").append(getScorePlayer(player2points));
        }
        return score.toString();
    }

    private boolean playerScoreGreaterThan4() {
        return player1points >= 4 || player2points >= 4;
    }

    public boolean isTieBreak() {
        return player1points == player2points;
    }

    public void wonPoint(String player) {
        if (player.equalsIgnoreCase(player1Name)) player1points++;
        if (player.equalsIgnoreCase(player2Name)) player2points++;
    }

    public String equalScores() {
        List<String> scoresList = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return scoresList.get(player1points);
    }

    public String getScorePlayer(int scorePlayer) {
        List<String> scoresList = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
        return scoresList.get(scorePlayer);
    }

    public String advantage(int scoreDifference) {
        switch (scoreDifference) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (scoreDifference >= 2) ? "Win for player1" : "Win for player2";
        }
    }
}