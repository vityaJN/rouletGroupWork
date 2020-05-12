import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayRoulette extends Casino {

    private int betPos;
    private int bet;
    Player p;


    public PlayRoulette() {

    }

    public void play() {
        System.out.println("Kérem adja meg a tétet!");
        setBet();
        System.out.println("Kérem adja meg a tét helyét: 0 - 41");
        spinTheRoulette();


    }

    private void spinTheRoulette() {
        super.ballPosition = (int)( Math.random() * 36);
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


        System.out.println("0-36");
        System.out.println("1-12[37] 1-18[38] 13-24[39] 19-36[40] 25-36[41]");
        betPos = sc.nextInt();


        // 0 - 36
        if (betPos > 0 && betPos < 37) {
            p.setMoney(p.getMoney() * 2);
        } else if (betPos == 38) {
            oneToTwelve();
        }


    }


    private void oneToTwelve() {

        if (super.ballPosition > 0 && super.ballPosition < 13) {
            System.out.println("Nyert");
        }

    }

    private void oneToEigtheen() {
        if (super.ballPosition > 0 && super.ballPosition < 19) {
            System.out.println("Nyert");
        }
    }

    private void thirteenToTwentyfour() {
        if (super.ballPosition > 12 && super.ballPosition < 25) {
            System.out.println("Nyert");
        }
    }

    private void nighteenToThirtysix() {
        if (super.ballPosition > 18 && super.ballPosition < 37) {
            System.out.println("Nyert");
        }
    }

    private void twentyfiveToThirtysix() {
        if (super.ballPosition > 24 && super.ballPosition <= 36) {
            System.out.println("Nyert");
        }
    }
}

