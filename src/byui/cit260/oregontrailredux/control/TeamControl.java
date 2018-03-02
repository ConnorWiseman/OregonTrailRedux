package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Oxen;
import byui.cit260.oregontrailredux.model.Team;
import byui.cit260.oregontrailredux.model.Wagon;

public abstract class TeamControl {

    public static Team create() {
        Team team = new Team();
        team.setMoney(500);
        return team;
    }

    public static boolean canTravel(final Team team) {
        Oxen oxen = team.getOxen();
        Wagon wagon = team.getWagon();
        int weight = WagonControl.calculateTotalWeight(wagon);

        return TeamControl.hasOxen(team)
                && OxenControl.canPull(oxen)
                && OxenControl.canPullWeight(oxen, weight);
    }

    public static boolean hasOxen(final Team team) {
        return OxenControl.count(team.getOxen()) > 0;
    }
}
