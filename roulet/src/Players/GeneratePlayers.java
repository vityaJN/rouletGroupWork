package Players;

import Simulation.GetCPUPlayerWithRandomTactics.Factory.CPUFactory;

import java.util.ArrayList;
import java.util.List;

public class GeneratePlayers {

    public GeneratePlayers() {
    }

    public static List<Player> GeneratePlayers(int withHowManyCPU_PlayersWannaPlay) {
        List<Player> playersList = new ArrayList<>();

        for (int i = 0; i < withHowManyCPU_PlayersWannaPlay; i++) {
            Player cpu = CPUFactory.getOneCPU_Player();
            playersList.add(cpu);
        }

        return playersList;
    }
}
