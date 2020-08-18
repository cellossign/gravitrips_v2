import java.util.Scanner;

public class Human extends Player {
    public static Scanner sc;

    public Human(FieldValue chip) {
        super.setChip(chip);
    }

    @Override
    public int move() throws Exception {
        super.move();
        sc = new Scanner(System.in);
        int chosenColumn = sc.nextInt();
        moveMessage(chosenColumn);
        return chosenColumn;
    }
}