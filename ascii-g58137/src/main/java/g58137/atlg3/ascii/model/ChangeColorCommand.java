package g58137.atlg3.ascii.model;

/**
 * Represents the command color.
 * @author Florian Essomba
 */
public class ChangeColorCommand implements Command{
    private char newColor;
    private char oldColor;
    private Shape shape;

    /**
     * Constructs a new ChangeColorCommand which initializes a color and a shape.
     * @param newColor a given color.
     * @param shape a given shape.
     */
    public ChangeColorCommand(char newColor,Shape shape){
        this.newColor = newColor;
        this.oldColor = shape.getColor();
        this.shape = shape;
    }

    /**
     * The method that execute the command color.
     */
    @Override
    public void execute() {
        shape.setColor(newColor);
    }

    /**
     * The method that unexecute the command color.
     */
    @Override
    public void unexecute() {
        shape.setColor(oldColor);
    }
}
