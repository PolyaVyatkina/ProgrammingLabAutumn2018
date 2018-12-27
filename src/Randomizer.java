import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Randomizer {
    private List<Character> bag;
    private int index;

    Randomizer() {
        this.bag = Arrays.asList('I', 'J', 'L', 'O', 'S', 'T', 'Z');

        Collections.shuffle(this.bag);
        this.index = -1;
    }

    private Character nextFigureType() {
        this.index++;
        if (this.index >= this.bag.size()) {
            Collections.shuffle(this.bag);
            this.index = 0;
        }
        return this.bag.get(this.index);
    }

    Figure nextFigure() {
        Figure figure;
        Character type = nextFigureType();
        switch (type) {
            case 'I':
                figure = new FigureI();
                break;
            case 'J':
                figure = new FigureJ();
                break;
            case 'L':
                figure = new FigureL();
                break;
            case 'O':
                figure = new FigureO();
                break;
            case 'S':
                figure = new FigureS();
                break;
            case 'T':
                figure = new FigureT();
                break;
            case 'Z':
                figure = new FigureZ();
                break;
            default:
                figure = new FigureI();
                break;
        }
        return figure;
    }
}
