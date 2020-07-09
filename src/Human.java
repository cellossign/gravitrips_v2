import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {
    private FieldValue chip;
    public static Scanner sc = new Scanner(System.in);

    public Human(FieldValue chip) {
        this.chip = chip;
        super.setChip(this.chip);
    }

    @Override
    public int move() throws Exception {
        super.move();
        //Scanner sc = new Scanner(System.in);
        int chosenColumn = sc.nextInt();
        System.out.println(((chip == FieldValue.O) ? "First Player: " : "Second Player") + chosenColumn + " .column");
        // sc.close();
        return chosenColumn;
    }
}