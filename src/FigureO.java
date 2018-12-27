public class FigureO extends Figure {

    private static final int SIZE = 3;

    FigureO() {
        type = 'O';
        size = SIZE;
        dx = 0;
        dy = 0;
        existingPositions = 1;
        parts[0] = new Part(0, 0);
        parts[1] = new Part(0, 1);
        parts[2] = new Part(1, 0);
        parts[3] = new Part(1, 1);
        matrix = new int[size][size];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 1;
    }

    @Override
    public void transpose() {
    }
}
