public class FigureS extends Figure{

    private static final int SIZE = 3;

    FigureS() {
        type = 'S';
        size = SIZE;
        dx = 0;
        dy = 0;
        existingPositions = 2;
        parts[0] = new Part(0, 0);
        parts[1] = new Part(0, 1);
        parts[2] = new Part(1, 1);
        parts[3] = new Part(1, 2);
        matrix = new int[size][size];
        matrix[1][0] = 1;
        matrix[2][0] = 1;
        matrix[0][1] = 1;
        matrix[1][1] = 1;
    }

    @Override
    public void transpose() {
        if (dx >= Field.WIDTH - size + 1) {
            parts[0].x = 0; parts[0].y = 0;
            parts[1].x = 0; parts[1].y = 1;
            parts[2].x = 1; parts[2].y = 1;
            parts[3].x = 1; parts[3].y = 2;
        }
        else {
            if (currentPosition == 1) {
                parts[0].x = 0; parts[0].y = 0;
                parts[1].x = 0; parts[1].y = 1;
                parts[2].x = 1; parts[2].y = 1;
                parts[3].x = 1; parts[3].y = 2;
            }
            else{
                parts[0].x = 1; parts[0].y = 0;
                parts[1].x = 2; parts[1].y = 0;
                parts[2].x = 0; parts[2].y = 1;
                parts[3].x = 1; parts[3].y = 1;
            }
        }
        currentPosition = (currentPosition + 1) % existingPositions;
    }
}
