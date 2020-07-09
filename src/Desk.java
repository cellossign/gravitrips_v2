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

    public boolean checkIfIsFull() {
        boolean isFull = true;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (fields[i][j] == FieldValue.c) {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }


    public boolean checkWinnerByRows() {
        int score = 0;
        boolean won = false;

        for (int i = 0; i < 6; i++) {
            int count = 1;
            for (int j = 0; j < 5; j++) {
                if ((fields[i][j] == fields[i][j + 1])
                        &&
                        ((fields[i][j] == FieldValue.O) || (fields[i][j] == FieldValue.X))
                ) {
                    count++;
                    // System.out.println("the same in " + (i + 1) + " row: " + count);
                    if (count > 3) {
                        score = count;
                    }
                } else {
                    count = 1;
                }
            }
            if (score > 3) {
                won = true;
                System.out.println("Same chips in the " + (i + 1) + ". row: " + count);
//
                break;
            }
        }
        return won;
    }

    public boolean checkWinnerByColumns() {
        int score = 0;
        boolean won = false;
        for (int j = 0; j < 6; j++) {
            int count = 1;
            for (int i = 0; i < 5; i++) {
                if ((fields[i][j] == fields[i + 1][j])
                        &&
                        ((fields[i][j] == FieldValue.O) || (fields[i][j] == FieldValue.X))
                ) {
                    count++;
//                    System.out.println("The same in " + (j + 1) + " column: " + count);
                    if (count > 3) {
                        score = count;
                    }
                } else {
                    count = 1;
                }
            }
            if (score > 3) {
                System.out.println("The same in " + (j + 1) + " column: " + count);
//
                won = true;
                break;
            }
        }
        return won;
    }

    public boolean checkWinnerByDiagonal() {
        boolean won = false;

        for (int i = 5; i > 2; i--) {
            for (int j = 0; j < 3; j++) {
                if (((fields[i][j] == fields[i - 1][j + 1]) &&
                        (fields[i][j] == fields[i - 2][j + 2]) &&
                        (fields[i][j] == fields[i - 3][j + 3]))
                        &&
                        ((fields[i][j] == FieldValue.O) || (fields[i][j] == FieldValue.X))
                ) {
                    System.out.println("the same are in diagonal [" + (i - 2) + "][" + (j + 4) + "]");
                    won = true;
                }
            }
            for (int j = 3; j < 6; j++) {
                if (((fields[i][j] == fields[i - 1][j - 1]) &&
                        (fields[i][j] == fields[i - 2][j - 2]) &&
                        (fields[i][j] == fields[i - 3][j - 3]))
                        &&
                        ((fields[i][j] == FieldValue.O) || (fields[i][j] == FieldValue.X))
                ) {
                    System.out.println("the same are in diagonal [" + (i - 2) + "][" + (j - 3) + "]");
                    won = true;
                }
            }
        }
        return won;
    }


    public static int getColumns() {
        return columns;
    }

}
