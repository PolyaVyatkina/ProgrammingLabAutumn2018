public class Field {

    static final int WIDTH = 10;
    static final int HEIGHT = 20;

    int[][] field;

    Field() {
        field = new int[HEIGHT][WIDTH];
    }

    public void toConsole() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++)
                System.out.print(field[i][j] + " ");
            System.out.println();
        }
    }
}
