public class FigureL extends Figure {

    static final int SIZE = 3;

    FigureL() {
        type = 'L';
        size = SIZE;
        dx = 0;
        dy = 0;
        parts[0] = new Part(0, 0);
        parts[1] = new Part(0, 1);
        parts[2] = new Part(0, 2);
        parts[3] = new Part(1, 2);
        matrix  = new int[size][size];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][2] = 1;
    }
}
