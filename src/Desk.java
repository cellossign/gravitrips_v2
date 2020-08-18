public class Desk {

    private static int columns;
    private FieldValue[][] fields;
    private static final Desk instance = new Desk();

    private Desk() {
    }

    public static Desk getInstance() {
        return instance;
    }

    public FieldValue[][] getFields() {
        return fields;
    }

    public void init(int rows, int columns) {
        Desk.columns = columns;
        this.fields = new FieldValue[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fields[i][j] = FieldValue.c;
            }
        }
    }

    public void showDesk() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(fields[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void putChipInColumn(int column, FieldValue chip) {
        for (int i = (columns - 1); i >= 0; i--) {
            if (fields[i][column - 1] == FieldValue.c) {
                fields[i][column - 1] = chip;
                break;
            }
        }
    }

    public boolean deskIfIsFull() {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                if (fields[i][j] == FieldValue.c) return false;
            }
        }
        return true;
    }


    public boolean checkWinnerByRows() {
        for (int i = 0; i < 6; i++) {
            int count = 1;
            for (int j = 0; j < 5; j++) {
                count = identicalsInRow(count, i, j);
                if (count > 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private int identicalsInRow(int count, int i, int j) {
        if (fields[i][j] == FieldValue.c) return count;
        else if (fields[i][j] == fields[i][j + 1]) {
            count++;
//            System.out.println(count + " identical chips in row #" + (i + 1) + "\n");
        } else count = 1;
        return count;
    }

    public boolean checkWinnerByColumns() {
        for (int j = 0; j < 6; j++) {
            int count = 1;
            for (int i = 0; i < 5; i++) {
                count = identicalsInColumn(count, i, j);
                if (count > 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private int identicalsInColumn(int count, int i, int j) {
        if (fields[i][j] == FieldValue.c) return count;
        else if (fields[i][j] == fields[i + 1][j]) {
            count++;
//            System.out.println(count + " identical chips in column #" + (j + 1) + "\n");
        } else count = 1;
        return count;
    }

    public boolean checkWinnerByDiagonal() {
        for (int i = 5; i > 2; i--) {
            for (int j = 0; j < 3; j++) {
                if (validDiagonalToLeft(i, j)) {
//                    System.out.println("Identical chips in diagonal from [" +
//                            (i - 2) + "][" + (j + 4) + "] to the left down");
                    return true;
                }
            }
            for (int j = 3; j < 6; j++) {
                if (validDiagonalToRight(i, j)) {
//                    System.out.println("Identical chips in diagonal from [" +
//                            (i - 2) + "][" + (j - 2) + "] to the right");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean validDiagonalToLeft(int i, int j) {
        if (fields[i][j] == FieldValue.c) return false;
        else return ((fields[i][j] == fields[i - 1][j + 1]) &&
                (fields[i][j] == fields[i - 2][j + 2]) &&
                (fields[i][j] == fields[i - 3][j + 3]));
    }

    private boolean validDiagonalToRight(int i, int j) {
        if (fields[i][j] == FieldValue.c) return false;
        else return (fields[i][j] == fields[i - 1][j - 1]) &&
                (fields[i][j] == fields[i - 2][j - 2]) &&
                (fields[i][j] == fields[i - 3][j - 3]);
    }

    public static int getColumns() {
        return columns;
    }

}
