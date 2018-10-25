public class FigureI extends Figure {

    FigureI() {
        type = 'I';
        parts[0] = new Part(4, 19);
        parts[1] = new Part(4, 18);
        parts[2] = new Part(4, 17);
        parts[3] = new Part(4, 16);
    }

    public void rotate12() {
        parts[0].x += 2;
        parts[0].y -= 1;
        parts[1].x += 1;
        parts[2].y -= 1;
        parts[3].x -= 1;
        parts[3].y += 2;
    }
}
