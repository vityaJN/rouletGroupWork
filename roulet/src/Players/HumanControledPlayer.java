package Players;

public class HumanControledPlayer  extends Player{
    private boolean wannaPlayMore;

    public HumanControledPlayer() {
        this.wannaPlayMore = true;
        howManyMoneyDoYouHave();

    }

    public boolean isWannaPlayMore() {
        return wannaPlayMore;
    }





    public void setWannaPlayMore(boolean wannaPlayMore) {
        this.wannaPlayMore = wannaPlayMore;
    }
}
