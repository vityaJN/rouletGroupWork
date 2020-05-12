package Simulation.GetCPUPlayerWithRandomTactics.Factory;

public abstract class Computer implements Strategys {
    protected int bet;
    protected int money;
    protected int betPos;

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public void setBetPos(int betPos) {
        this.betPos = betPos;
    }
}
