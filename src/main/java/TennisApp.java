import lombok.*;


@Builder
@Getter
@Setter
public class TennisApp {

    private final String DEUCE = "deuce";
    private final String ADVANTAGE = "advantage";
    private final String WINNER_MSG ="win the game";
    private int playerOneScore;
    private int playerTwoScore;
    private Player playerOne;
    private Player playerTwo;


    public String getScore() {
        if(playerOneScore == playerTwoScore){
            Point pointToDisplay = Point.getPointByIncrementPoint(playerOneScore);
            return (playerOneScore == Point.FORTY.getIncrementPoint())? DEUCE : displayScore(pointToDisplay,pointToDisplay);
        } else if(Math.max(playerOneScore,playerTwoScore) > 3){
            int diffPoints = Math.abs(playerOneScore - playerTwoScore);
            return (diffPoints == 1) ? ADVANTAGE +" "+ retrievePlayerName() : WINNER_MSG +" "+ retrievePlayerName();
        }
        return displayScore(Point.getPointByIncrementPoint(playerOneScore), Point.getPointByIncrementPoint(playerTwoScore));

    }

    private String retrievePlayerName() {
        return playerOneScore > playerTwoScore ? playerOne.getName() : playerTwo.getName();
    }

    private String displayScore(Point point1, Point point2) {
        return "(" +point1.getScorePoint() + "-" + point2.getScorePoint()+")";
    }

    public void getPlayerOneScore() {
        playerOneScore++;
    }

    public void getPlayerTwoScore() {
        playerTwoScore++;
    }
}
