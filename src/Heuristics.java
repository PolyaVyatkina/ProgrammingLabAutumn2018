public class Heuristics {
    private static final int WIDTH = Field.WIDTH;
    private static final int HEIGHT = Field.HEIGHT;
    private static final double A = -0.510066;
    private static final double B = 0.760666;
    private static final double C = -0.35663;
    private static final double D = -0.184483;

    private int aggregateHeight;
    private int completedLines;
    private int holes;
    private int bumpiness;
    private int[][] field;
    private int[] heights;
    private int maxHeight;

    double score;

    Heuristics(int[][] field) {
        this.field = field;
        maxHeight = 0;
        heights = new int[WIDTH];
        for (int j = 0; j < WIDTH; j++) {
            int i = 0;
            while (field[i][j] == 0 && i < HEIGHT - 1) i++;
            heights[j] = HEIGHT - i;
            if (heights[j] > maxHeight) maxHeight = heights[j];
        }
        score = computeScore();
    }

    private double computeScore() {
        computeAggregateHeight();
        computeBumpiness();
        computeCompletedLines();
        computeHoles();

        return A * aggregateHeight + B * completedLines + C * holes + D * bumpiness;
    }

    private void computeAggregateHeight() {
        aggregateHeight = 0;
        for (int height : heights) aggregateHeight += height;
    }

    private void computeCompletedLines() {
        completedLines = 0;
        for (int i = HEIGHT - 1; i >= maxHeight; i--) {
            boolean complete = true;
            for (int j = 0; j < WIDTH; j++)
                if (field[i][j] == 0) complete = false;
            if (complete) completedLines++;
        }
    }

    private void computeBumpiness() {
        bumpiness = 0;
        for (int j = 0; j < WIDTH - 1; j++) bumpiness += Math.abs(heights[j] - heights[j + 1]);
    }

    private void computeHoles() {
        holes = 0;
        boolean hole = false;
        for (int i = HEIGHT - 1; i > 0; i--)
            for (int j = 0; j < WIDTH; j++) {
                if (field[i][j] == 0 && field[i - 1][j] != 0 && !hole) hole = true;
                if (hole && field[i][j] == 0 && field[i - 1][j] == 0) hole = false;
                if (hole && field[i][j] != 0) {
                    hole = false;
                    holes++;
                }
            }
    }
}













