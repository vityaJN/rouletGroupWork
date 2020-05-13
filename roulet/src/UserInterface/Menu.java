package UserInterface;

import Players.GeneratePlayers;
import Players.HumanControledPlayer;

import java.util.Scanner;

public class Menu {
    int chooseMenuPoint;

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
                int withHowManyPlayersU_WannaPlay = 3;
                System.out.println();
                System.out.println();
                HumanControledPlayer hp = new HumanControledPlayer();




                break;

            case 2:
                System.exit(0);
        }
    }
}
