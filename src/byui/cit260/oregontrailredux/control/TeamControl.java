package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Oxen;
import byui.cit260.oregontrailredux.model.Person;
import byui.cit260.oregontrailredux.model.Team;
import byui.cit260.oregontrailredux.model.Wagon;
import byui.cit260.oregontrailredux.model.enums.Pace;

public final class TeamControl {

    private TeamControl() {
    }

    public static Team create() {
        Team team = new Team();
        team.setMoney(500);
        return team;
    }

    public static boolean canTravel(final Team team) {
        Person leader = team.getLeader();
        Oxen oxen = team.getOxen();
        Wagon wagon = team.getWagon();

        int weight = WagonControl.calculateTotalWeight(wagon);

        return PersonControl.isAlive(leader)
                && TeamControl.hasOxen(team)
                && OxenControl.canPull(oxen)
                && OxenControl.canPullWeight(oxen, weight);
    }

    public static boolean hasOxen(final Team team) {
        return OxenControl.count(team.getOxen()) > 0;
    }

    public static void setMoney(final Team team, final int initialMoney,
            final double multiplier) {
        team.setMoney((int) (initialMoney * multiplier));
    }

    public static void setPace(final Team team, final Pace pace) {
        team.setPace(pace);
    }
}
