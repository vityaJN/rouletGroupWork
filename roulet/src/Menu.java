import java.util.Scanner;

public class Menu {
    /*

    Játék esetén kérdezzük meg a felhasználót, hogy mekkora kezdő-összeggel indul,

    majd minden pörgetés előtt, hogy hova szeretne tétet tenni
    egy tétet tud felrakni pörgetésenként


 Szimuláció esetén a bemenetünk legyen a legkisebb rakható és a legnagyobb rakható tét,
  az, hogy összesen hány pörgetés legyen az adott szimulációban és az, hogy milyen
  stratégiát használ a játékban résztvevő egy darab játékos (minimum egy stratégiát,
   a Martingel-startégiát valósítsunk meg!).

Ez után indítsuk el a szimulációt, a szimuláció egyes lépéseit írjuk ki
(hányas szám jött ki, mennyit nyert, mennyit veszített a fogadó, mennyi a
 szumma nyereség) és végül írjuk ki a játékos záró-egyenlegét.
     */

    public void menu() {
        int chooseMenuPoint;

        Scanner sc = new Scanner(System.in);
        chooseMenuPoint = sc.nextInt();

        System.out.println("Rulett [0] Szimuláció [1]");
        switch (chooseMenuPoint) {

            case 0:
                PlayRoulette pr = new PlayRoulette(createOnePlayer());
                break;
            case 1:
                Simulation sl = new Simulation();
        }
    }

    public Player createOnePlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi pénzed van?");
        int money = 0;
        try {
            money = sc.nextInt();
        } catch (Exception e) {
            System.out.println("invalid input");
        }
        Player p = new Player(money);
        return p;
    }



}
