import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class TennisAppTest {

    private final TennisApp tennisApp = TennisApp.builder()
            .playerOne(Player.builder().name("player1").build())
            .playerTwo(Player.builder().name("player2").build())
            .build();

    static Stream<Arguments> providePointsOfEachPlayer(){
        return Stream.of(
                Arguments.of(0,0,"(0-0)"),
                Arguments.of(1,1,"(15-15)"),
                Arguments.of(2,2,"(30-30)"),
                Arguments.of(3,3,"deuce"),
                Arguments.of(4,3,"advantage player1"),
                Arguments.of(4,5,"advantage player2"),
                Arguments.of(4,6,"win the game player2"),
                Arguments.of(6,4,"win the game player1"),
                Arguments.of(0,1,"(0-15)"),
                Arguments.of(1,2,"(15-30)"),
                Arguments.of(4,2,"win the game player1")
                );
    }

    @ParameterizedTest
    @MethodSource("providePointsOfEachPlayer")
    public void getScoreTest(int playerOneScore, int playerTwoScore, String expectedScore){
        for (int i=0; i< playerOneScore; i++){
            tennisApp.getPlayerOneScore();
        }
        for (int i=0; i< playerTwoScore; i++){
            tennisApp.getPlayerTwoScore();
        }
        Assertions.assertEquals(expectedScore,tennisApp.getScore());
    }


}
