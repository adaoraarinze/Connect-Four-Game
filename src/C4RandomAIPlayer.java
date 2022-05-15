public class C4RandomAIPlayer extends ConnectPlayer {
    @Override
    public int playerMove() {
        return (int) ((Math.random() * (7 - 1)) + 1);
    }
}
