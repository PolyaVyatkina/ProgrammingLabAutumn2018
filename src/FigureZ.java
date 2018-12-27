public class FigureZ extends Figure {

    private static final int SIZE = 3;

    FigureZ() {
        type = 'Z';
        size = SIZE;
        dx = 0;
        dy = 0;
        existingPositions = 2;
        parts[0] = new Part(1, 0);
        parts[1] = new Part(0, 1);
        parts[2] = new Part(1, 1);
        parts[3] = new Part(0, 2);
        matrix = new int[size][size];
        matrix[0][0] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 1;
        matrix[2][1] = 1;
    }

    @Override
    public void transpose() {
        if (dx >= Field.WIDTH - size + 1) {
            parts[0].x = 1; parts[0].y = 0;
            parts[1].x = 0; parts[1].y = 1;
            parts[2].x = 1; parts[2].y = 1;
            parts[3].x = 0; parts[3].y = 2;
        }
        else {
            if (currentPosition == 0) {
                parts[0].x = 0; parts[0].y = 0;
                parts[1].x = 1; parts[1].y = 0;
                parts[2].x = 1; parts[2].y = 1;
                parts[3].x = 2; parts[3].y = 1;
            }
            else{
                parts[0].x = 1; parts[0].y = 0;
                parts[1].x = 0; parts[1].y = 1;
                parts[2].x = 1; parts[2].y = 1;
                parts[3].x = 0; parts[3].y = 2;
            }
        }
        currentPosition = (currentPosition + 1) % existingPositions;
    }
}
