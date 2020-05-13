package Simulation.GetCPUPlayerWithRandomTactics.Factory;

import Players.Player;

public class CPUFactory {

    public static Player getOneCPU_Player (){
        int randNum = (int)(Math.random() * 2);

        if (randNum == 0){
            Player sp = new DumbGuy();
            return sp;
        }else {
            Player sp = new DumbGuy();
            return sp;
        }
    }
}
