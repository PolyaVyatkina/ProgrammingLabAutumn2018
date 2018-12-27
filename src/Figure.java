public class Figure {

    int currentPosition = 0;
    int existingPositions;
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

    Figure() {
    }

    public Boolean onField() {
        boolean perm = true;
        for (Part part : parts)
            if (part.x + dx >= Field.WIDTH || part.y + dy >= Field.WIDTH) {
                perm = false;
                break;
            }
        return perm;
    }

    public void moveDownIfPossible(Field field) {
        boolean perm = true;
        while (perm) {
            for (Part part : parts) {
                if (part.y + dy + 1 >= Field.HEIGHT || field.field[part.y + dy + 1][part.x + dx] != 0) {
                    perm = false;
                    break;
                }
            }
            if (perm) {
                dy++;
            }
        }
    }

    public void transpose() {
        if (dx == Field.WIDTH - size + 1) {
            for (int i = 0; i < size / 2; i++)
                for (int j = i; j < size - i - 1; j++) {
                    int c = matrix[i][j];
                    matrix[i][j] = matrix[size - j - 1][i];
                    matrix[size - j - 1][i] = matrix[size - i - 1][size - j - 1];
                    matrix[size - i - 1][size - j - 1] = matrix[j][size - i - 1];
                    matrix[j][size - i - 1] = c;
                }
            currentPosition++;
        }
        if (dx <= Field.WIDTH - size + 1 && dy <= Field.HEIGHT - size) {
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
            currentPosition = (currentPosition + 1) % existingPositions;
            correct();
        }
    }

    protected void correct() {
    }

}
