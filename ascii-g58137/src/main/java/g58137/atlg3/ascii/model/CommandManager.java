package g58137.atlg3.ascii.model;

import java.util.Stack;

/**
 * Configure the command.
 * @author Florian Essomba
 */
public class CommandManager {
    private Stack<Command> redoStack = new Stack<>();
    private Stack<Command> undoStack = new Stack<>();

    /**
     * Cancel the previous command.
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }
    /**
     * Do the command again.
     */
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    /**
     * Add the command in the CommandList.
     * @param command a given command.
     */
    public void register(Command command){
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }
}
