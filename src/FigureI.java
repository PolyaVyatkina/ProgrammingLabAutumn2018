class FigureI extends Figure {

    private static final int SIZE = 4;

    FigureI() {
        type = 'I';
        size = SIZE;
        dx = 0;
        dy = 0;
        existingPositions = 2;
        parts[0] = new Part(0, 0);
        parts[1] = new Part(0, 1);
        parts[2] = new Part(0, 2);
        parts[3] = new Part(0, 3);
        matrix  = new int[size][size];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[0][3] = 1;


    }

    @Override
    public void transpose() {
        if (dx >= Field.WIDTH - size + 1) {
            parts[1].x = 0; parts[1].y = 1;
            parts[2].x = 0; parts[2].y = 2;
            parts[3].x = 0; parts[3].y = 3;

        }
        else  {
            if (currentPosition == 0) {
                parts[1].x = 1; parts[1].y = 0;
                parts[2].x = 2; parts[2].y = 0;
                parts[3].x = 3; parts[3].y = 0;
            }
            else{
                parts[1].x = 0; parts[1].y = 1;
                parts[2].x = 0; parts[2].y = 2;
                parts[3].x = 0; parts[3].y = 3;
            }
        }
        currentPosition = (currentPosition + 1) % existingPositions;
    }
}
