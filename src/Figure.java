public class Figure {

    int currentPosition = 1;
    char type;
    int size;
    int[][] matrix;
    Part[] parts = new Part[4];
    int dx;
    int dy;

    class Part {
        int x;
        int y;

        Part(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Figure() { }

    public void moveRight() {
        boolean perm = true;
        for (Part part : parts)
            if (part.x + dx + 1 >= Field.WIDTH) {
                perm = false;
                break;
            }
        if (perm) dx++;
    }

    public void moveLeft() {
        if (dx > 0) dx--;
    }

    public void moveDown() {
        boolean perm = true;
        for (Part part : parts)
            if (part.y + dy + 1 >= Field.HEIGHT) {
                perm = false;
                break;
            }
        if (perm) dy++;
    }


    public void moveUp() {
        if (dy > 0) dy--;
    }

    public void matrixToString() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        for (Part part : parts) {
            System.out.println(part.x + " " + part.y);
            System.out.println(dx + " " + dy);
            System.out.println();
        }
    }

    public void transpose() {
        if (dx <= Field.WIDTH - size && dy <= Field.HEIGHT - size) {
            for (int i = 0; i < size / 2; i++)
                for (int j = i; j < size - i - 1; j++) {
                    int c = matrix[i][j];
                    matrix[i][j] = matrix[size - j - 1][i];
                    matrix[size - j - 1][i] = matrix[size - i - 1][size - j - 1];
                    matrix[size - i - 1][size - j - 1] = matrix[j][size - i - 1];
                    matrix[j][size - i - 1] = c;
                }

            int element = 0;
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    if (matrix[i][j] == 1) {
                        parts[element].x = i;
                        parts[element].y = j;
                        element++;
                    }

            currentPosition = (currentPosition + 1) % 4;
        }
    }


}
