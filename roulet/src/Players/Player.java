package Players;

import Casino.Roulet;
import java.util.Scanner;

public abstract class Player {
    protected int money;
    protected int bet;
    protected int betPos;
    protected int beforeSpinMoney;
    protected boolean amIAHuman;

    public Player() {
    }



    public void howManyMoneyDoYouHave() {
        Scanner sc = new Scanner(System.in);
        System.out.println("how many money do u have?");

        try {
            this.money = sc.nextInt();
            if (this.money < Roulet.MIN_MONEY_TO_ENTER_CASINO){
                System.out.println("you dont have enough money to enter");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("invalid input");
        }
        System.out.println(this.money + " debug ocska geci");
    }




    public boolean isAmIAHuman() {
        return amIAHuman;
    }

    public void setAmIAHuman(boolean amIAHuman) {
        this.amIAHuman = amIAHuman;
    }
    public int getBeforeSpinMoney() {
        return beforeSpinMoney;
    }
    public void setBeforeSpinMoney(int beforeSpinMoney) {
        this.beforeSpinMoney = beforeSpinMoney;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getBet() {
        return bet;
    }
    public void setBet(int bet) {
        this.bet = bet;
    }
    public int getBetPos() {
        return betPos;
    }
    public void setBetPos(int betPos) {
        this.betPos = betPos;
    }
    public void setBet(){

    }
    public abstract boolean isWannaPlayMore();

    public abstract void setWannaPlayMore(boolean b);
}
