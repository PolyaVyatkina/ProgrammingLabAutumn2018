public class FigureJ extends Figure{

    FigureJ() {
        parts[0] = new Part(3, 19);
        parts[1] = new Part(3, 18);
        parts[2] = new Part(4, 18);
        parts[3] = new Part(5, 18);
        size = 3;
        matrix  = new int[size][size];
        matrix[1][0] = 1;
        matrix[1][1] = 1;
        matrix[1][2] = 1;
        matrix[0][2] = 1;
    }

}
