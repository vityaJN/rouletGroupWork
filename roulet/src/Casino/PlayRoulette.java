package Casino;

import Playerr.Player;

import java.util.Scanner;

public class PlayRoulette extends Casino {


    Player p;

    public PlayRoulette(Player player) {
        this.p = player;
        play();
    }

    public void play() {

        do {
            System.out.println("Kérem adja meg a tétet!");
            setBet();
            System.out.println("Melyik mezőre szeretnél rakni?");
            printTheMenu();
            whichPositionToBet();
            spinTheRoulette();
            result();
            doUWantToPlayMore();

        } while (p.getMoney() > Casino.MIN_BET && p.isWannaPlayMore());


    }

    private void doUWantToPlayMore() {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        try {

            do {
                choose = sc.nextInt();
                if (choose > 1 || choose < 0){
                    throw new Exception();
                }

            } while (choose != 0  && choose != 1);

        } catch (Exception e) {
            System.out.println("bad input");
        }

        switch (choose){
            case 0:
                p.setWannaPlayMore(false);
                break;
            case 1:
                p.setWannaPlayMore(true);
                break;
        }

    }

    private void printTheMenu() {
        System.out.println("| Bet                    | Pays | Probability Win | House Edge |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| Red                    | 1    | 47.37%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| Black                  | 1    | 47.37%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| Odd                    | 1    | 47.37%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("|Even                    | 1    | 47.37%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| 1 to 18                | 1    | 47.37%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| 19 to 36               | 1    | 47.37%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| 1 to 12                | 2    | 31.58%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| 13 to 24               | 2    | 31.58%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| 25 to 36               | 2    | 31.58%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| Six line (6 numbers)   | 5    | 15.79%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| First five (5 numbers) | 6    | 13.16           | 7.89%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| Corner (4 numbers)     | 8    | 10.53%          | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| Street (3 numbers)     | 11   | 7.895           | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| Split (2 numbers)      | 17   | 5.26%           | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");
        System.out.println("| Any one number         | 35   | 2.62%           | 5.26%      |");
        System.out.println("+------------------------+------+-----------------+------------+");

    }


    private void spinTheRoulette() {
        super.ballPosition = (int) (Math.random() * 37);
    }

    private void setBet() {
        Scanner sc = new Scanner(System.in);


        do {
            try {
                p.setBet(sc.nextInt());
                if (p.getBet() < MIN_BET) {
                    System.out.println("A minimális tét " + Casino.MIN_BET + " dollár, kérem növelje e tétet!");
                } else if (p.getBet() > MAX_BET) {
                    System.out.println("A maximális tét " + Casino.MAX_BET + " kérem csökkentse a tétet!");
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        } while (p.getBet() <= p.getMoney() && p.getBet() <= MIN_BET || p.getBet() >= MAX_BET);


    }

    private void whichPositionToBet() {
        Scanner sc = new Scanner(System.in);

        do {
            try {
                p.setBetPos(sc.nextInt());

            } catch (Exception e) {
                System.out.println("error");
                printTheMenu();
            }
            System.out.println(p.getBetPos());
        } while (!(p.getBetPos() > 0 && p.getBetPos() < 48));


    }


    private void result() {
        System.out.println(p.getMoney() + " ez az");

        if (p.getBetPos() > 0 && p.getBetPos() < 37) {
            p.setMoney((int) (p.getMoney() * 1.2));
        } else if (p.getBetPos() == 37 && super.ballPosition > 0 && super.ballPosition < 13) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 38 && super.ballPosition > 0 && super.ballPosition < 19) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 39 && super.ballPosition > 12 && super.ballPosition < 25) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 40 && super.ballPosition > 18 && super.ballPosition < 37) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 41 && super.ballPosition > 24 && super.ballPosition <= 36) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 42 && super.ballPosition == 0) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 43 && super.ballPositionOnTheTable.get(super.ballPosition).equals("Fekete")) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 43 && super.ballPositionOnTheTable.get(super.ballPosition).equals("Piros")) {
            p.setMoney(p.getMoney() * 2);

        } else {
            p.setMoney(p.getMoney() - p.getBet());
        }
        System.out.println(p.getMoney() + " ez az");

    }


}

