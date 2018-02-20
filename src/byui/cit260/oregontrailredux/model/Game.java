package byui.cit260.oregontrailredux.model;

import java.io.Serializable;
import java.util.Objects;

public class Game implements Serializable {
    private Player  player;
    private Map     map;
    private boolean running;
    
    public Game() {
        this.player  = new Player();
        this.map     = new Map();
        this.running = true;
    }
    
    public Game(Player player, Map map) {
        this.player  = player;
        this.map     = map;
        this.running = true;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.player);
        hash = 37 * hash + Objects.hashCode(this.map);
        hash = 37 * hash + (this.running ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.running != other.running) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + player + ", map=" + map + ", running=" + running + '}';
    }
}