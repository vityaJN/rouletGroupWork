package Casino;

import Players.Player;

import java.util.*;

public class Roulet {
    public static final int MAX_BET = 100000;
    public static final int MIN_BET = 10;
    public static final int MIN_MONEY_TO_ENTER_CASINO = 200;

    protected int ballPosition;
    Map<Integer, String> ballPositionOnTheTable;
    Player player;


    public Roulet(Player player) {
        ballPositionOnTheTable = new HashMap<>();
        this.player = player;

        fillTheCasinoTable();
        play();
    }


    public void play() {

        do {

            setBet();
            printTheMenu();
            whichPositionToBet();
            spinTheRoulette();

            result();
            statistics();
            doUWantToPlayMore();

        } while (player.getMoney() > MIN_BET && player.isWannaPlayMore());
    }


    public void doUWantToPlayMore() {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        System.out.println("Szeretnél még játszani?");
        System.out.println("Igen[0] Nem [1]");
        do {
            choose = sc.nextInt();

        } while (choose != 1 && choose != 0);

        switch (choose) {
            case 0:
                player.setWannaPlayMore(true);
                break;
            case 1:
                player.setWannaPlayMore(false);
                break;
        }
    }


    public void spinTheRoulette() {
        ballPosition = (int) (Math.random() * 37);
    }

    public void setBet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem adja meg a tétet!");
        do {
            try {
                player.setBet(sc.nextInt());
                if (player.getBet() < 10) {
                    System.out.println("A minimális tét 10 forint, kérem növelje e tétet!");
                } else if (player.getBet() > 100000) {
                    System.out.println("A maximális tét 100000, kérem csökkentse a tétet!");
                } else if (player.getBet() > player.getMoney()) {
                    System.out.println("Nem tudsz többet felrakni mint amennyid van.");
                }

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("bad input");
            }
        } while (!(player.getBet() <= player.getMoney() && player.getBet() > 10 && player.getBet() < 100000));
    }


    public void whichPositionToBet() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Melyik mezőre szeretnél rakni?");
                player.setBetPos(sc.nextInt());

            } catch (Exception e) {
                System.out.println("error");
                printTheMenu();
            }
            System.out.println(player.getBetPos());
        } while (!(player.getBetPos() > 0 && player.getBetPos() < 48));
    }


    public void result() {
        player.setBeforeSpinMoney(player.getMoney());

        if (player.getBetPos() == ballPosition) {
            player.setMoney((int) (player.getMoney() * 1.2));
        } else if (player.getBetPos() == 37 && ballPosition > 0 && ballPosition < 13) {
            player.setMoney(player.getMoney() + (player.getBet() * 2));

        } else if (player.getBetPos() == 38 && ballPosition > 0 && ballPosition < 19) {
            player.setMoney(player.getMoney() + (player.getBet() * 2));

        } else if (player.getBetPos() == 39 && ballPosition > 12 && ballPosition < 25) {
            player.setMoney(player.getMoney() + (player.getBet() * 2));

        } else if (player.getBetPos() == 40 && ballPosition > 18 && ballPosition < 37) {
            player.setMoney(player.getMoney() + (player.getBet() * 2));

        } else if (player.getBetPos() == 41 && ballPosition > 24 && ballPosition <= 36) {
            player.setMoney(player.getMoney() + (player.getBet() * 2));

        } else if (player.getBetPos() == 42 && ballPosition == 0) {
            player.setMoney(player.getMoney() + (player.getBet() * 2));

        } else if (player.getBetPos() == 43 && ballPositionOnTheTable.get(ballPosition).equals("Piros")) {
            player.setMoney(player.getMoney() + (player.getBet() * 2));

        } else if (player.getBetPos() == 44 && ballPositionOnTheTable.get(ballPosition).equals("Fekete")) {
            player.setMoney(player.getMoney() + (player.getBet() * 2));

        } else {
            player.setMoney(player.getMoney() - player.getBet());
        }
    }


    public void seperator() {
        System.out.println("-----------------------------------------------------------");
    }

    public void printTheMenu() {
        seperator();
        System.out.println("0 -tól 36 -ig lévő mezőkre tudsz rakni.");
        System.out.println("0 - 13 [37]");
        System.out.println("0 - 19 [38]");
        System.out.println("12 - 25 [39]");
        System.out.println("18 - 37 [40]");
        System.out.println("24 - 36 [41]");
        System.out.println("0 [42]");
        System.out.println("Piros [43]");
        System.out.println("Fekete [44]");
        seperator();

        /*

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
         */


    }

    public void statistics() {
        seperator();


        System.out.println("Rulett golyó pozicíója: " + ballPosition);
        System.out.println("A rulett golyó a " + ballPositionOnTheTable.get(ballPosition) + " színű mezőn landolt.");
        System.out.println("A felrakott téted  " + player.getBet() + " forint.");
        System.out.println("A pörgetés előtti pénzed: " + player.getBeforeSpinMoney() + " forint.");

        if (player.getMoney() < player.getBeforeSpinMoney()) {
            System.out.println("Vesztettél " + player.getBet() + " forintot.");
        } else {
            System.out.println("Nyertél " + (player.getMoney() - player.getBeforeSpinMoney()));
        }
        System.out.println("A jelenlegi pénzed:" + player.getMoney() + " forint.");

        seperator();


    }


    public void fillTheCasinoTable() {
        for (int i = 1; i < 37; i++) {
            if (i > 1 && i < 11) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Fekete" : "Piros");
            } else if (i > 10 && i < 19) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Piros" : "Fekete");

            } else if (i > 18 && i < 29) {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Fekete" : "Piros");

            } else {
                ballPositionOnTheTable.put(i, i % 2 == 0 ? "Piros" : "Fekete");
            }
        }
        ballPositionOnTheTable.put(0, "Fehér");
    }

}

