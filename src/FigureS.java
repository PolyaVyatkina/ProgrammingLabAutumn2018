public class FigureS extends Figure{

    private static final int SIZE = 3;

    FigureS() {
        type = 'S';
        size = SIZE;
        dx = 0;
        dy = 0;
        parts[0] = new Part(1, 0);
        parts[1] = new Part(2, 0);
        parts[2] = new Part(0, 1);
        parts[3] = new Part(1, 1);
        matrix  = new int[size][size];
        matrix[1][0] = 1;
        matrix[2][0] = 1;
        matrix[0][1] = 1;
        matrix[1][1] = 1;
    }
}
