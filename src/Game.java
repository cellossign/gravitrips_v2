import java.util.Arrays;
import java.util.InputMismatchException;

public class Game {
    private static Desk desk;
    private static Player player1;
    private static Player player2;
    private static Player currentPlayer;

    public static void letsPlay() {
        setDesk();
        setPlayers();
        start();
    }

    private static void start() {
        int countChances = 1;
        while (true) {
            if (countChances > 7) {
                interrupt();
                break;
            }
            try {
                int playerChosenColumn = currentPlayer.move();
                if (isAvailable(playerChosenColumn)) {
                    countChances = 1;
                    makeMove(playerChosenColumn);
                    if (existsWinner() || deskIsFull()) {
                        Human.sc.close();
                        break;
                    }
                    changePlayer();
                } else {
                    fullColumnErrorMessage();
                    countChances++;
                }
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("\n Please enter number in range 1 - " + Desk.getColumns() + "!" + "\n");
                countChances++;
            } catch (Exception e) {
                System.out.println("Oops! Undefiend exception: " + Arrays.toString(e.getStackTrace()));
            }

        }
    }

    private static boolean isAvailable(int playerChosenColumn) {
        return desk.getFields()[0][playerChosenColumn - 1] == FieldValue.c;
    }

    private static boolean deskIsFull() {
        boolean isFull = desk.checkIfIsFull();
        if (isFull) {
            interruptAsNoWinner();
        }
        return isFull;
    }

    private static boolean existsWinner() {
        boolean winnerExist = ((desk.checkWinnerByRows()) || (desk.checkWinnerByColumns()) || (desk.checkWinnerByDiagonal()));
        if (winnerExist) {
            showWinnerMessage();
        }
        return winnerExist;
    }

    private static void showWinnerMessage() {
        System.out.println();
        System.out.println("Game over. " + ((currentPlayer.getChip() == FieldValue.O) ? "First Player" : "Second Player") + " wins!");
    }

    private static void interruptAsNoWinner() {
        System.out.println("Game over. Nobody wins");
    }

    private static void interrupt() {
        System.out.println("Oh, it's enough!..");
    }

    private static void fullColumnErrorMessage() {
        System.out.println("\n This column is full! Please, choose another column.");
        System.out.println();
    }

    private static void setPlayers() {
        player1 = new Human(FieldValue.O);
        player2 = new AI(FieldValue.X);
        currentPlayer = player1;
    }

    private static void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private static void makeMove(int chosenColumnPlayer1) {
        desk.putChipInColumn(chosenColumnPlayer1, currentPlayer.getChip());
        desk.showDesk();
    }

    private static void setDesk() {
        int rows = 6;
        int columns = 6;
        desk = Desk.getInstance();
        desk.init(rows, columns);
    }

}
