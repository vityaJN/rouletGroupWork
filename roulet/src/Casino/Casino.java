package Casino;

import Playerr.Player;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Casino {
    int beforeSpinMoney;
    Player p;

    protected int ballPosition;
    public static final int MAX_BET = 100000;
    public static final int MIN_BET = 10;
    public static final int MIN_MONEY_TO_ENTER_CASINO = 200;
    Map<Integer, String> ballPositionOnTheTable = new HashMap<>();


    public Casino(Player player) {
        this.p = player;
        fillTheCasinoTable();
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
            statistics();
            doUWantToPlayMore();

        } while (p.getMoney() > MIN_BET && p.isWannaPlayMore());


    }

    private void doUWantToPlayMore() {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        System.out.println("do you want to play more?");
        System.out.println("Yes[0] No [1]");
        do {
            choose = sc.nextInt();

        } while (choose != 1 && choose != 0);

        switch (choose) {
            case 0:
                p.setWannaPlayMore(true);
                break;
            case 1:
                p.setWannaPlayMore(false);
                break;
        }

    }

    private void printTheMenu() {
        seperator();
        System.out.println("from 0 to 36 u can choose a unique number to bet on");
        System.out.println("0 - 13 [37]");
        System.out.println("0 - 19 [38]");
        System.out.println("12 - 25 [39]");
        System.out.println("18 - 37 [40]");
        System.out.println("24 - 36 [41]");
        System.out.println("0 [42]");
        System.out.println("RED [43]");
        System.out.println("BLACK [44]");
        seperator();
    }


    private void spinTheRoulette() {
        ballPosition = (int) (Math.random() * 37);
    }

    private void setBet() {
        Scanner sc = new Scanner(System.in);

        do {
            try {
                p.setBet(sc.nextInt());
                if (p.getBet() < 10) {
                    System.out.println("A minimális tét 10 dollár, kérem növelje e tétet!");
                } else if (p.getBet() > 100000) {
                    System.out.println("A maximális tét 100000, kérem csökkentse a tétet!");
                } else if (p.getBet() > p.getMoney()) {
                    System.out.println("nem tudsz többet felrakni mint amennyid van");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("bad input");
            }
        } while (!(p.getBet() <= p.getMoney() && p.getBet() > 10 && p.getBet() < 100000));


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
        beforeSpinMoney = p.getMoney();

        if (p.getBetPos() == ballPosition) {
            p.setMoney((int) (p.getMoney() * 1.2));
        } else if (p.getBetPos() == 37 && ballPosition > 0 && ballPosition < 13) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 38 && ballPosition > 0 && ballPosition < 19) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 39 && ballPosition > 12 && ballPosition < 25) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 40 && ballPosition > 18 && ballPosition < 37) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 41 && ballPosition > 24 && ballPosition <= 36) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 42 && ballPosition == 0) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 43 && ballPositionOnTheTable.get(ballPosition).equals("Red")) {
            p.setMoney(p.getMoney() * 2);

        } else if (p.getBetPos() == 44 && ballPositionOnTheTable.get(ballPosition).equals("Black")) {
            p.setMoney(p.getMoney() * 2);

        } else {
            p.setMoney(p.getMoney() - p.getBet());
        }


        seperator();seperator();seperator();seperator();seperator();
        System.out.println("DEBUG DEBUG DEBUG ");

        System.out.println(p.getBetPos());

        System.out.println("DEBUG DEBUG DEBUG ");
        seperator();seperator();seperator();seperator();seperator();
    }


    private void seperator() {
        System.out.println("-----------------------------------------------------------");
    }

    private void statistics() {
        seperator();



        System.out.println("roulet ball position: " + ballPosition);
        System.out.println("roulet ball landed on " + ballPositionOnTheTable.get(ballPosition) + " color");
        System.out.println("you have been bet  " + p.getBet() + " forint");
        System.out.println("Before the spin u had " + beforeSpinMoney + " forint");

        if ( p.getMoney() < beforeSpinMoney ) {
            System.out.println("you lost " + p.getBet() + " forint");
        } else {
            System.out.println("you won " + (p.getMoney() +
                    - beforeSpinMoney));
        }
        System.out.println("now your money is:" + p.getMoney() + " forint");







        seperator();


    }


    private void fillTheCasinoTable() {
        for (int i = 1; i < 37; i++) {
            if (i > 1 && i < 11) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Black" : "Red");
            } else if (i > 10 && i < 19) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Red" : "Black");

            } else if (i > 18 && i < 29) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Black" : "Red");

            } else {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Red" : "Black");
            }
        }
        ballPositionOnTheTable.put(0, "White");
    }

}

