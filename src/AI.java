import java.util.Random;

public class AI extends Player {
    private FieldValue chip;

    public AI(FieldValue chip) {
        this.chip = chip;
        super.setChip(this.chip);
    }

    @Override
    public int move() throws Exception {
        super.move();
        Random r = new Random();
        int chosenColumn = r.nextInt(Desk.getColumns()) + 1;

        System.out.println(((chip == FieldValue.O) ? "First Player: " : "Second Player: ") + (chosenColumn) + ". column");
        return (chosenColumn);
    }
}