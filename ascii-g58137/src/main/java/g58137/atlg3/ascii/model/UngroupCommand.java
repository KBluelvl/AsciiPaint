package g58137.atlg3.ascii.model;

import java.util.List;

/**
 * Represents the command ungroup.
 * @author Florian Essomba
 */
public class UngroupCommand implements Command{
    private Group group;
    private Drawing drawing;
    private int index;
    private List<Integer> indexes;

    /**
     * Constructs a new UngroupCommand which initializes a group, a drawing and the state.
     * @param group a given Group.
     * @param drawing a given Drawing.
     */
    public UngroupCommand(List<Integer> indexes,int index,Group group,Drawing drawing){
        this.group = group;
        this.drawing = drawing;
        this.index = index;
        this.indexes = indexes;
    }

    /**
     * The method that execute the command.
     */
    @Override
    public void execute() {
        drawing.remove(group);
        for (int i = 0; i < group.getShapes().size(); i++) {
            drawing.addShape(group.getShapes().get(i));
        }
    }

    /**
     * The method that unexecute the Command.
     */
    @Override
    public void unexecute() {
        drawing.addShapeAt(group,index);
        for (int i = 0; i < group.getShapes().size(); i++) {
            drawing.remove(group.getShapes().get(i));
        }
    }
}
