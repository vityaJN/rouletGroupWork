package Simulation.GetCPUPlayerWithRandomTactics.Factory;

import Players.Player;

/**
 * SimpleStrategy Tactics
 * always bet on red until he is run out of money OR he won
 * if he loses he's going to double his bet
 * if he won he's going to leave the casino
 */

public class DumbGuy  extends Player {
    private boolean didILostThePreviousMatch;







    public void setBet() {
        if (didILostThePreviousMatch){
            super.setBet(super.getBet() * 2);

        }else {

        }


    }

    @Override
    public boolean isWannaPlayMore() {
        return false;
    }

    @Override
    public void setWannaPlayMore(boolean b) {

    }







 /*
    Az a stratégia, hogy mindig a pirosra tesz, és ha veszít, akkor megduplázza a tétet és újra a pirosra tesz
    Ezt egész addig csinálja, amíg egyszer nem nyer legkisebb téttel kezd
     */


}
