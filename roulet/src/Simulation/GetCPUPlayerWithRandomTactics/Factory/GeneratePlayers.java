package Simulation.GetCPUPlayerWithRandomTactics.Factory;

import Players.HumanControledPlayer;
import Players.Player;

import java.util.ArrayList;
import java.util.List;

public class GeneratePlayers {

    public static List<Player> getPlayers(){
        List<Player> playerList = new ArrayList<>();
        int a = (int) (Math.random() * 5);

        for (int i = 0; i < a; i++) {
            Player dg = new DumbGuy();
            dg.setAmIAHuman(false);
            playerList.add(dg);
        }
        HumanControledPlayer humanControledPlayer = new HumanControledPlayer();
        humanControledPlayer.setAmIAHuman(true);
        playerList.add(humanControledPlayer);
        return playerList;
    }



}
