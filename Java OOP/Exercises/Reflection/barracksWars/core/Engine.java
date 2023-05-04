package barracksWars.core;

import barracksWars.core.commands.NamedCommand;
import barracksWars.core.commands.UnitCommand;
import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;
	private List<Class<?>> registeredCommands = new ArrayList<>();

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void registerCommand(Class<?> commandClass) {
		NamedCommand annotation = commandClass.getAnnotation(NamedCommand.class);
		if (annotation == null)
			throw new IllegalArgumentException("Expected " + commandClass.getSimpleName() + " to have a " + NamedCommand.class.getSimpleName() + " annotation");

		registeredCommands.add(commandClass);
	}
	private String interpretCommand(String[] data, String commandName) {
		UnitCommand command = buildCommand(data, commandName);

		if (command == null) {
			throw new IllegalArgumentException("Cannot find command " + commandName);
		}
		return command.execute();
	}

	private UnitCommand buildCommand(String[] data, String commandName) {
		UnitCommand command = null;
		for (Class<?> registeredCommand : registeredCommands) {
			NamedCommand annotation = registeredCommand.getAnnotation(NamedCommand.class);
			if (annotation.commandName().equals(commandName)) {
				try {
					command = (UnitCommand) registeredCommand.getConstructor(String[].class, Repository.class, UnitFactory.class)
							.newInstance(data, repository, unitFactory);
				} catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
						 IllegalAccessException e) {
					throw new IllegalStateException(e);
				}
			}
		}
		return command;
	}
}
