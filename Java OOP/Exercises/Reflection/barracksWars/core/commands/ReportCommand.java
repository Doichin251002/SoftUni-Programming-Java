package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

@NamedCommand(commandName = "report")
public class ReportCommand extends UnitCommand{
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return this.getRepository().getStatistics();
    }
}
