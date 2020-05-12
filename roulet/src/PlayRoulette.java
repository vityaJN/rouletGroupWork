import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayRoulette extends Casino {

    private int betPos;
    private int bet;

    Player p;


    public PlayRoulette(Player player) {
        this.p = player;
        play();
        
    }

    public void play() {
        System.out.println("Kérem adja meg a tétet!");
        setBet();
        System.out.println("Melyik mezőre szeretnél rakni?");
        System.out.println("[0 -41]");
        System.out.println("1-12 [37]");
        whichPositionToBet();
        spinTheRoulette();
        result();

    }

    private void spinTheRoulette() {
        super.ballPosition = (int) (Math.random() * 37);
    }

    private void setBet() {
        Scanner sc = new Scanner(System.in);
        while (bet <= 10 || bet >= 100000) {
            bet = sc.nextInt();
            if (bet < 10) {
                System.out.println("A minimális tét 10 dollár, kérem növelje e tétet!");
            } else if (bet > 100000) {
                System.out.println("A maximális tét 100000, kérem csökkentse a tétet!");
            }
        }

    }

    private void whichPositionToBet() {
        Scanner sc = new Scanner(System.in);
        betPos = sc.nextInt();

    }


    private void result() {
        if (betPos > 0 && betPos < 37) {
            p.setMoney(p.getMoney() * 10);
        } else if (betPos == 37 && super.ballPosition > 0 && super.ballPosition < 13) {
            p.setMoney(p.getMoney() * 2);


        } else if (betPos == 38 && super.ballPosition > 0 && super.ballPosition < 19) {
            p.setMoney(p.getMoney() * 2);

        } else if (betPos == 39 && super.ballPosition > 12 && super.ballPosition < 25) {
            p.setMoney(p.getMoney() * 2);


        } else if (betPos == 40 && super.ballPosition > 18 && super.ballPosition < 37) {
            p.setMoney(p.getMoney() * 2);

        } else if (betPos == 41 && super.ballPosition > 24 && super.ballPosition <= 36) {
            p.setMoney(p.getMoney() * 2);

        } else if (betPos == 42 && super.ballPosition == 0) {
            p.setMoney(p.getMoney() * 2);

        } else if (betPos == 43 && super.ballPositionOnTheTable.get(super.ballPosition).equals("Fekete")) {
            p.setMoney(p.getMoney() * 2);

        } else if (betPos == 43 && super.ballPositionOnTheTable.get(super.ballPosition).equals("Piros")) {
            p.setMoney(p.getMoney() * 2);

        }else {
            p.setMoney(p.getMoney() - bet);
        }

    }



}

