package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Companions;
import byui.cit260.oregontrailredux.model.Person;
import java.util.concurrent.atomic.AtomicInteger;

public class RemoveCompanionMenu extends AbstractMenu implements ViewInterface {

    public RemoveCompanionMenu(final Companions companions) {
        this.title = "Remove companion";
        this.prompt = "Remove which companion?";

        final AtomicInteger i = new AtomicInteger(1);

        companions.getMembers().forEach((final Person person) -> {
            final char symbol = Character.forDigit(i.getAndIncrement(), 10);
            this.addOption(symbol, person.getName(), () -> {
                companions.getMembers().remove(person);
                ViewController.getInstance()
                        .changeTo(new CustomizeCompanionsMenu(companions));
            });
        });

        this.addOption('N', "Nevermind", () -> ViewController.getInstance()
                .changeTo(new CustomizeCompanionsMenu(companions)));
    }

}
