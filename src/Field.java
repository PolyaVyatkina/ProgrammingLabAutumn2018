public class Field {

    static boolean gameIsOver = false;

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
        System.out.println();
    }

    public Field copy() {
        Field result = new Field();
        for (int i = 0; i < HEIGHT; i++)
            System.arraycopy(this.field[i], 0, result.field[i], 0, WIDTH);
        return result;
    }

    public void addNewFigure(Figure figure) {
        int number = 0;
        switch (figure.type) {
            case 'I':
                number = 1;
                break;
            case 'J':
                number = 2;
                break;
            case 'L':
                number = 3;
                break;
            case 'O':
                number = 4;
                break;
            case 'S':
                number = 5;
                break;
            case 'T':
                number = 6;
                break;
            case 'Z':
                number = 7;
                break;
        }

        for (Figure.Part part : figure.parts)
            this.field[part.y + figure.dy][part.x + figure.dx] = number;
    }

    public int deleteCompletedLines(int deletedLines) {
        for (int i = 0; i < HEIGHT; i++) {
            boolean complete = true;
            for (int j = 0; j < WIDTH; j++)
                if (field[i][j] == 0) complete = false;
            if (complete) {
                field[i][0] = -1;
                deletedLines++;
            }
        }

        Field newField = new Field();
        int k = HEIGHT - 1;
        for (int i = HEIGHT - 1; i >= 0; i--)
            if (this.field[i][0] != -1) {
                System.arraycopy(this.field[i], 0, newField.field[k], 0, WIDTH);
                k--;
            }

        this.field = newField.field;
        return deletedLines;
    }

    public void checkForGameOver() {
        for (int i = 0; i < WIDTH; i++)
            if (field[0][i] != 0) {
                gameIsOver = true;
                break;
            }
    }
}
