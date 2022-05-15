public abstract class ConnectPlayer {
    private String chip;
    abstract public int playerMove();

    public void setPlayerChip(String chip){
        this.chip = chip;
    }

    public String getPlayerChip(){
        return chip;
    }

    public void playerWins(String player) {
        System.out.println(player + " won the game!");
    }
}
