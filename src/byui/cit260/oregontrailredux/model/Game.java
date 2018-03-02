package byui.cit260.oregontrailredux.model;

import byui.cit260.oregontrailredux.model.enums.Difficulty;
import java.io.Serializable;
import java.util.Objects;

public final class Game implements Serializable {

    private Difficulty difficulty;
    private Player player;
    private Map map;
    private Team team;
    private boolean running;

    public Game() {
        this.difficulty = Difficulty.EASY;
        this.running = false;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(final Difficulty mode) {
        this.difficulty = mode;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(final Player player) {
        this.player = player;
    }

    public Map getMap() {
        return this.map;
    }

    public void setMap(final Map map) {
        this.map = map;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(final boolean running) {
        this.running = running;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.difficulty);
        hash = 37 * hash + Objects.hashCode(this.player);
        hash = 37 * hash + Objects.hashCode(this.map);
        hash = 37 * hash + Objects.hashCode(this.team);
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
        if (this.difficulty != other.difficulty) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.team, other.team)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "mode=" + difficulty + ", player=" + player + ", map=" + map + ", team=" + team + ", running=" + running + '}';
    }
}
