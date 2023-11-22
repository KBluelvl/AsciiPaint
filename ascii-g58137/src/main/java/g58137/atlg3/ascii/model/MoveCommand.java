package g58137.atlg3.ascii.model;
/**
 * Represents the command move.
 * @author Florian Essomba
 */
public class MoveCommand implements Command{
    private int dx;
    private int dy;
    private Shape shape;

    /**
     * Constructs a new MoveCommand which initializes a shape and an x and y direction.
     * @param shape a given shape.
     * @param dx a given distance x.
     * @param dy a given distance y.
     */
    public MoveCommand(Shape shape ,int dx,int dy){
        this.dx = dx;
        this.dy = dy;
        this.shape = shape;
    }

    /**
     * The method that execute the command.
     */
    @Override
    public void execute() {
        shape.move(dx,dy);
    }

    /**
     * The method that unexecute the Command.
     */
    @Override
    public void unexecute() {
        shape.move(-dx,-dy);
    }
}
