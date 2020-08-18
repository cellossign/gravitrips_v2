import java.util.Random;

public class AI extends Player {

    public AI(FieldValue chip) {
        super.setChip(chip);
    }

    @Override
    public int move() throws Exception {
        super.move();
        int chosenColumn = getRandom();
        moveMessage(chosenColumn);
        return (chosenColumn);
    }

    private int getRandom() {
        Random r = new Random();
        return r.nextInt(Desk.getColumns()) + 1;
    }
}