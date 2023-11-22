package g58137.atlg3.ascii.model;

/**
 * Represents the command delete.
 * @author Florian Essomba
 */
public class DeleteCommand implements Command{
    private Drawing drawing;
    private int index;
    private Shape shape;

    /**
     * Constructs a new DeleteCommand which initializes a index and a drawing.
     * @param index a given index.
     * @param drawing a given drawing.
     */
    public DeleteCommand(int index, Drawing drawing){
        this.drawing = drawing;
        this.index = index;
        shape = drawing.getShapeAt(index);
    }

    /**
     * The method that execute the command.
     */
    @Override
    public void execute() {
        drawing.remove(shape);
    }

    /**
     * The method that unexecute the Command.
     */
    @Override
    public void unexecute() {
        drawing.addShapeAt(shape,index);
    }
}
