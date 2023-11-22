package g58137.atlg3.ascii.model;

/**
 * Represents the command add.
 * @author Florian Essomba
 */
public class AddCommand implements Command{
    private Shape shape;
    private Drawing drawing;

    /**
     * Constructs a new AddCommend which initializes the shape and drawing attributes.
     * @param shape a given shape.
     * @param drawing a given drawing.
     */
    public AddCommand(Shape shape,Drawing drawing){
        this.shape = shape;
        this.drawing = drawing;
    }

    /**
     * The method that execute the AddCommand.
     */
    @Override
    public void execute() {
        drawing.addShape(shape);
    }

    /**
     * The method that unexecute the AddCommand.
     */
    @Override
    public void unexecute() {
        drawing.remove(shape);
    }
}
