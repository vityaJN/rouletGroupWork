package UserInterface;

import Casino.Casino;
import Playerr.Player;
import Simulation.Simulation;

import java.util.Scanner;

public class Menu {
    int chooseMenuPoint;
    /*


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
        Scanner sc = new Scanner(System.in);

        System.out.println("playRoulete [0]\nSimulation [1]\nExit [2]");

        do {
            try {
                chooseMenuPoint = sc.nextInt();

                if (chooseMenuPoint != 0 && chooseMenuPoint != 1 && chooseMenuPoint != 2) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Wrong Input");
            }

        } while (chooseMenuPoint != 0 && chooseMenuPoint != 1 && chooseMenuPoint != 2);

        switch (chooseMenuPoint) {

            case 0:
                Player asd = new Player();
                Casino pr = new Casino(asd);
                break;
            case 1:
                Simulation sl = new Simulation();
                break;

            case 2:
                System.exit(0);
        }

    }


}
