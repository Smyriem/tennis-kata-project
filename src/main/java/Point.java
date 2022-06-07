import java.util.Arrays;

public enum Point {

    ZERO(0,"0"),
    FIFTEEN(1,"15"),
    THIRTY(2,"30"),
    FORTY(3,"40");

    private final int incrementPoint;
    private final String scorePoint;

    Point(int incrementPoint, String scorePoint) {
       this.incrementPoint = incrementPoint;
       this.scorePoint = scorePoint;
    }

    public int getIncrementPoint() {
        return incrementPoint;
    }

    public String getScorePoint() {
        return scorePoint;
    }

    public static Point getPointByIncrementPoint(int incrementPoint){
        return Arrays.stream(values())
                .filter(p -> p.incrementPoint == incrementPoint)
                .findFirst().orElse(null);
    }
}
