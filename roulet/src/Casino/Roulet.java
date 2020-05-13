package Casino;

import Players.HumanControledPlayer;
import Players.Player;

import java.util.*;

public class Roulet {
    public static final int MAX_BET = 100000;
    public static final int MIN_BET = 10;
    public static final int MIN_MONEY_TO_ENTER_CASINO = 200;

    protected int ballPosition;
    Map<Integer, String> ballPositionOnTheTable;
    List<Player> playersList;
    Player actualPlayerWhosPlaying;

    private boolean doesItAHumanPlayerRound;
    private int onWhichRoundDoesThePlayerMakeAMove;
    private int actualPlayerIndex;


    public Roulet(List<Player> playersList) {
        ballPositionOnTheTable = new HashMap<>();
        this.playersList = new ArrayList<>();
        this.playersList = playersList;

        fillTheCasinoTable();

        for (int i = 0; i < playersList.size(); i++) {
            actualPlayerIndex = i;
            play();
        }

    }


}

    public void play() {
        if (playersList.get(actualPlayerIndex) instanceof HumanControledPlayer) {
            do {

                setBet();
                printTheMenu();
                whichPositionToBet();
                spinTheRoulette();

                result();
                statistics();
                doUWantToPlayMore();

            } while (humanControlledPlayer.getMoney() > MIN_BET && humanControlledPlayer.isWannaPlayMore());
        } else {
            playersList.get(actualPlayerIndex).setBet();

        }

    }

        public void doUWantToPlayMore () {
            Scanner sc = new Scanner(System.in);
            int choose = 0;
            System.out.println("do you want to play more?");
            System.out.println("Yes[0] No [1]");
            do {
                choose = sc.nextInt();

            } while (choose != 1 && choose != 0);

            switch (choose) {
                case 0:
                    humanControlledPlayer.setWannaPlayMore(true);
                    break;
                case 1:
                    humanControlledPlayer.setWannaPlayMore(false);
                    break;
            }

        }


        public void spinTheRoulette () {
            ballPosition = (int) (Math.random() * 37);
        }

        public void setBet () {
            Scanner sc = new Scanner(System.in);
            System.out.println("Kérem adja meg a tétet!");
            do {
                try {
                    humanControlledPlayer.setBet(sc.nextInt());
                    if (humanControlledPlayer.getBet() < 10) {
                        System.out.println("A minimális tét 10 dollár, kérem növelje e tétet!");
                    } else if (humanControlledPlayer.getBet() > 100000) {
                        System.out.println("A maximális tét 100000, kérem csökkentse a tétet!");
                    } else if (humanControlledPlayer.getBet() > humanControlledPlayer.getMoney()) {
                        System.out.println("nem tudsz többet felrakni mint amennyid van");
                    }

                } catch (Exception e) {
                    sc.nextLine();
                    System.out.println("bad input");
                }
            } while (!(humanControlledPlayer.getBet() <= humanControlledPlayer.getMoney() && humanControlledPlayer.getBet() > 10 && humanControlledPlayer.getBet() < 100000));
        }


        public void whichPositionToBet () {
            Scanner sc = new Scanner(System.in);
            do {
                try {
                    System.out.println("Melyik mezőre szeretnél rakni?");
                    humanControlledPlayer.setBetPos(sc.nextInt());

                } catch (Exception e) {
                    System.out.println("error");
                    printTheMenu();
                }
                System.out.println(humanControlledPlayer.getBetPos());
        } while (!(humanControlledPlayer.getBetPos() > 0 && humanControlledPlayer.getBetPos() < 48));
        }


        public void result () {
            humanControlledPlayer.setBeforeSpinMoney(humanControlledPlayer.getMoney());

            if (humanControlledPlayer.getBetPos() == ballPosition) {
                humanControlledPlayer.setMoney((int) (humanControlledPlayer.getMoney() * 1.2));
            } else if (humanControlledPlayer.getBetPos() == 37 && ballPosition > 0 && ballPosition < 13) {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() * 2);

            } else if (humanControlledPlayer.getBetPos() == 38 && ballPosition > 0 && ballPosition < 19) {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() * 2);

            } else if (humanControlledPlayer.getBetPos() == 39 && ballPosition > 12 && ballPosition < 25) {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() * 2);

            } else if (humanControlledPlayer.getBetPos() == 40 && ballPosition > 18 && ballPosition < 37) {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() * 2);

            } else if (humanControlledPlayer.getBetPos() == 41 && ballPosition > 24 && ballPosition <= 36) {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() * 2);

            } else if (humanControlledPlayer.getBetPos() == 42 && ballPosition == 0) {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() * 2);

            } else if (humanControlledPlayer.getBetPos() == 43 && ballPositionOnTheTable.get(ballPosition).equals("Red")) {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() * 2);

            } else if (humanControlledPlayer.getBetPos() == 44 && ballPositionOnTheTable.get(ballPosition).equals("Black")) {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() * 2);

            } else {
                humanControlledPlayer.setMoney(humanControlledPlayer.getMoney() - humanControlledPlayer.getBet());
            }
        }


        public void seperator () {
            System.out.println("-----------------------------------------------------------");
        }

        public void printTheMenu () {
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

        public void statistics () {
            seperator();


            System.out.println("roulet ball position: " + ballPosition);
            System.out.println("roulet ball landed on " + ballPositionOnTheTable.get(ballPosition) + " color");
            System.out.println("you have been bet  " + humanControlledPlayer.getBet() + " forint");
            System.out.println("Before the spin u had " + humanControlledPlayer.getBeforeSpinMoney() + " forint");

            if (humanControlledPlayer.getMoney() < humanControlledPlayer.getBeforeSpinMoney()) {
                System.out.println("you lost " + humanControlledPlayer.getBet() + " forint");
            } else {
                System.out.println("you won " + (humanControlledPlayer.getMoney() - humanControlledPlayer.getBeforeSpinMoney()));
            }
            System.out.println("now your money is:" + humanControlledPlayer.getMoney() + " forint");

            seperator();


        }


        public void fillTheCasinoTable () {
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

