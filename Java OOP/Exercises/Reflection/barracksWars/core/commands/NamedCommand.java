package barracksWars.core.commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface NamedCommand {
    String commandName();
}
