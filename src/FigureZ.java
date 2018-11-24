public class FigureZ extends Figure {

    static final int SIZE = 3;

    FigureZ() {
        type = 'Z';
        size = SIZE;
        dx = 0;
        dy = 0;
        parts[0] = new Part(0, 0);
        parts[1] = new Part(1, 0);
        parts[2] = new Part(1, 1);
        parts[3] = new Part(2, 2);
        matrix  = new int[size][size];
        matrix[0][0] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 1;
        matrix[2][2] = 1;
    }
}
