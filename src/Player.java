public abstract class Player {
    private FieldValue chip;

    public FieldValue getChip() {
        return chip;
    }

    public void setChip(FieldValue chip) {
        this.chip = chip;
    }

    public int move() throws Exception {
        System.out.println("Choose column from 1 to " + Desk.getColumns() + " :)");
        return 0;
    }

}