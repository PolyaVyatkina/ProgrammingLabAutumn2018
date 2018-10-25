import java.awt.*;
import java.util.ArrayList;

public class Figure {

    int currentPosition = 1;
    char type;

    class Part {
        int x;
        int y;

        Part(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Part[] parts = new Part[4];

    Figure() {
    }

    public void moveRight() {
        for (Part part : parts) {
            if (part.x < 9) part.x += 1;
        }
    }

    public void moveLeft() {
        for (Part part : parts) {
            if (part.x > 0) part.x -= 1;
        }
    }

    public void moveDown() {
        for (Part part : parts) {
            if (part.y > 0) part.y -= 1;
        }
    }

    public void moveUp() {
        for (Part part : parts) {
            part.y += 1;
        }
    }

    public void rotateRight() {
        switch (currentPosition) {
            case 1:
                rotate12();
                break;
            case 2:
                rotate23();
                break;
            case 3:
                rotate34();
                break;
            case 4:
                rotate41();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void rotateLeft() {
        switch (currentPosition) {
            case 1:
                rotate14();
                break;
            case 2:
                rotate21();
                break;
            case 3:
                rotate32();
                break;
            case 4:
                rotate43();
                break;
            default:
                throw new IllegalArgumentException();

        }
    }

    public void rotate12() {
    }

    public void rotate23() {
    }

    public void rotate34() {
    }

    public void rotate41() {
    }

    public void rotate14() {
    }

    public void rotate21() {
    }

    public void rotate32() {
    }

    public void rotate43() {
    }

}
