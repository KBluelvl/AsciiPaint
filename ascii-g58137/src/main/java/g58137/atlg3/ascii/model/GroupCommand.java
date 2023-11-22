package g58137.atlg3.ascii.model;

/**
 * Represents the command group.
 * @author Florian Essomba
 */
public class GroupCommand implements Command{
    private Group group;
    private Drawing drawing;

    /**
     * Constructs a new GroupCommand which initializes a list of shape and a drawing.
     * @param group a given group.
     * @param drawing a given drawing.
     */
    public GroupCommand(Drawing drawing,Group group){
        this.group = group;
        this.drawing = drawing;
    }

    /**
     * The method that execute the command.
     */
    @Override
    public void execute() {
        drawing.addShape(group);
        for (int i = 0;i<group.getShapes().size();i++) {
            drawing.remove(group.getShapes().get(i));
        }
    }

    /**
     * The method that unexecute the Command.
     */
    @Override
    public void unexecute() {
        drawing.remove(group);
        for (int i = 0; i < group.getShapes().size(); i++) {
            drawing.addShapeAt(group.getShapes().get(i),group.getIndexes().get(i));
        }
    }
}
