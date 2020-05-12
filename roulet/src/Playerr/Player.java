package Playerr;

import Casino.Casino;

import java.util.Scanner;

public class Player {
    private int money;
    private int bet;
    private int betPos;
    private boolean wannaPlayMore;

    public boolean isWannaPlayMore() {
        return wannaPlayMore;
    }

    public void setWannaPlayMore(boolean wannaPlayMore) {
        this.wannaPlayMore = wannaPlayMore;
    }

    public Player() {
        wannaPlayMore = true;
        howManyMoneyDoYouHave();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void howManyMoneyDoYouHave() {
        Scanner sc = new Scanner(System.in);
        System.out.println("how many money do u have?");
        int money = 0;
        try {
            money = sc.nextInt();
            if (money < Casino.MIN_MONEY_TO_ENTER_CASINO){
                System.out.println("you dont have enough money to enter");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("invalid input");
        }
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
}
