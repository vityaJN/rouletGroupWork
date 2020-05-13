package Simulation.GetCPUPlayerWithRandomTactics.Factory;

import Players.Player;

public class CPU_Player extends Player {

    public CPU_Player() {

    }

    @Override
    public boolean isWannaPlayMore() {
        return false;
    }

    @Override
    public void setWannaPlayMore(boolean b) {

    }
}
