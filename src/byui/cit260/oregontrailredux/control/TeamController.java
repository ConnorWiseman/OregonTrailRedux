package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Team;

public final class TeamController {

    private final Team team;


    public TeamController(final Team team) {
        this.team = team;
    }
    

    public static Team create() {
        Team newTeam = new Team();

        newTeam.setWagon(WagonController.create());
        newTeam.setMoney(500);
        
        return newTeam;
    }

    public boolean canTravel() {
        final PersonController pc = new PersonController(this.team.getLeader());
        final WagonController wc = new WagonController(this.team.getWagon());
        final OxenController oc = new OxenController(this.team.getOxen());

        return pc.isAlive()
                && this.hasOxen()
                && oc.canPull()
                && oc.canPullWeight(wc.calculateTotalWeight());
    }

    public boolean hasOxen() {
        return new OxenController(this.team.getOxen()).count() > 0;
    }

    public void setMoney(final int initial, final double multiplier) {
        this.team.setMoney((int) (initial * multiplier));
    }
}
