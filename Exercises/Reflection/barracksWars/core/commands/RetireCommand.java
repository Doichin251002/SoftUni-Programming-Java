package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

@NamedCommand(commandName = "retire")
public class RetireCommand extends UnitCommand{
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            getRepository().removeUnit(getData()[1]);
            return getData()[1] + " retired!";
        } catch (IllegalStateException e) {
            return e.getMessage();
        }
    }
}
