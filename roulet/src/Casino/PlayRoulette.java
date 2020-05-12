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
            System.out.println("[0 -41]");
            System.out.println("1-12 [37]");


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
        System.out.println("Melyik mezőre szeretnél rakni?");
        System.out.println("[0 -41]");
        System.out.println("1-12 [37]");

    }


    private void spinTheRoulette() {
        super.ballPosition = (int) (Math.random() * 37);
    }

    private void setBet() {
        Scanner sc = new Scanner(System.in);

        int bet = 0;

        do {
            try {
                bet = sc.nextInt();
                if (p.getBet() < 10) {
                    System.out.println("A minimális tét 10 dollár, kérem növelje e tétet!");
                } else if (bet > 100000) {
                    System.out.println("A maximális tét 100000, kérem csökkentse a tétet!");
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        } while (bet <= p.getMoney() && p.getBet() <= 10 || p.getBet() >= 100000);

        p.setBet(sc.nextInt());


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

        } while (p.getBetPos() > -1 || p.getBetPos() < 48);


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

