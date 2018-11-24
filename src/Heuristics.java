public class Heuristics {
    static final int WIDTH = Field.WIDTH;
    static final double A = -0.510066;
    static final double B = 0.760666;
    static final double C = -0.35663;
    static final double D = -0.184483;

    int aggregateHeight;
    int completeLines;
    int holes;
    int bumpiness;

    int[][] field;
    int[] heights;
    int maxHeight;

    Heuristics(int[][] field) {
        this.field = field;

        heights = new int[WIDTH];
        for (int j = 0; j < WIDTH; j++) {
            int i = Field.HEIGHT - 1;
            while (field[i][j] == 0) i--;
            heights[j] = i;
            if (i > maxHeight) maxHeight = i;
        }

        maxHeight = 0;

        aggregateHeight = 0;
        completeLines = 0;
        holes = 0;
        bumpiness = 0;
    }

    public Double computeScore() {
        computeAggregateHeight();
        computeBumpiness();
        computeCompleteLines();
        computeHoles();

        return A * aggregateHeight + B * completeLines + C * holes + D * bumpiness;

    }

    private void computeAggregateHeight() {
        for (int height : heights) aggregateHeight += height;
    }

    private void computeCompleteLines() {
        for (int i = 0; i <= maxHeight; i++) {
            boolean complete = true;
            for (int j = 0; j < WIDTH; j++)
                if (field[i][j] == 0) complete = false;
            if (complete) completeLines++;
        }
    }

    private void computeBumpiness() {
        for (int j = 0; j < WIDTH - 1; j++) bumpiness += Math.abs(heights[j] - heights[j + 1]);
    }

    private void computeHoles() {
        for (int i = 0; i <= maxHeight; i++)
            for (int j = 0; j < WIDTH; j++)
                if ((i == 0 || field[i - 1][j] != 0) && (i == Field.HEIGHT - 1 || field[i + 1][j] != 0)
                     && (j == WIDTH - 1 || field[i][j + 1] != 0)  && (j == 0 || field[i][j - 1] != 0) && (field[i][j] == 0))
                    holes++;
    }
}
