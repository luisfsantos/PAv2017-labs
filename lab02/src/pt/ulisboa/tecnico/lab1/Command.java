package pt.ulisboa.tecnico.lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lads on 09/03/2017.
 */
public abstract class Command {
    private List<String> arguments;

    public Command() {
        this(new ArrayList<String>());
    }

    public Command(List<String> args) {
        arguments = args;
    }
    public abstract void execute();
}
