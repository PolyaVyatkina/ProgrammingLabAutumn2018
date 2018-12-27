public class Solver {

    void start() {
        Field field = new Field();
        Randomizer random = new Randomizer();
        int score = 0;
        Field extraFirst;
        Field extraSecond;
        Field bestField = new Field();
        Double bestScore = -10000000.0;
        Heuristics heuristics;

        Figure firstFigure = random.nextFigure();
        while (!Field.gameIsOver) {
            Figure secondFigure = random.nextFigure();
            while (firstFigure.onField()) {
                for (int i = 0; i < firstFigure.existingPositions; i++) {
                    extraFirst = field.copy();
                    firstFigure.moveDownIfPossible(extraFirst);
                    extraFirst.addNewFigure(firstFigure);
                    while (secondFigure.onField()) {
                        for (int j = 0; j < secondFigure.existingPositions; j++) {
                            extraSecond = extraFirst.copy();
                            secondFigure.moveDownIfPossible(extraSecond);
                            extraSecond.addNewFigure(secondFigure);
                            heuristics = new Heuristics(extraSecond.field);
                            if (heuristics.score > bestScore) {
                                bestScore = heuristics.score;
                                bestField = extraFirst;
                            }
                            secondFigure.dy = 0;
                            secondFigure.transpose();
                            if (j == secondFigure.existingPositions / 2 - 1 && secondFigure.dx >= Field.WIDTH - secondFigure.size + 1) {
                                while (secondFigure.currentPosition != 0) secondFigure.transpose();
                                break;
                            }
                        }
                        secondFigure.dx++;
                    }
                    secondFigure.dx = 0;
                    firstFigure.dy = 0;
                    firstFigure.transpose();
                    if (i == firstFigure.existingPositions / 2 - 1 && firstFigure.dx >= Field.WIDTH - firstFigure.size + 1) {
                        while (firstFigure.currentPosition != 0) firstFigure.transpose();
                        break;
                    }
                }
                firstFigure.dx++;
            }
            bestScore = Double.MAX_VALUE * (-1.0);
            firstFigure = secondFigure;
            score = bestField.deleteCompletedLines(score);
            System.out.println(score);
            field = bestField.copy();
            field.toConsole();
            field.checkForGameOver();
        }
    }
}
