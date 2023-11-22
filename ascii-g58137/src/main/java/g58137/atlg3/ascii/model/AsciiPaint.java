package g58137.atlg3.ascii.model;

import java.util.Arrays;
import java.util.List;

/**
 * Configure the drawing.
 * @author Florian Essomba
 */
public class AsciiPaint {
    private Drawing drawing;
    private CommandManager commandManager = new CommandManager();

    /**
     * Constructs a new AsciiPaint which initializes the drawing attribute.
     */
    public AsciiPaint(){
        drawing = new Drawing();
    }

    /**
     * Constructs a new AsciiPaint which initializes the width and height of the drawing attribute.
     * @param width = the Width of the drawing attribute.
     * @param height = the Width of the drawing attribute.
     */
    public AsciiPaint(int width, int height){
        drawing = new Drawing(width, height);
    }

    /**
     * Cancel the previous command.
     */
    public void undo(){
        commandManager.undo();
    }

    /**
     * Do the command again.
     */
    public void redo(){
        commandManager.redo();
    }

    /**
     * Add a Circle in the Drawing.
     * @param x = the X coordinate of the Circle.
     * @param y = the Y coordinate of the Circle.
     * @param radius = the radius of the Circle
     * @param color = the Color of the Circle.
     */
    public void newCircle(int x, int y, double radius, char color){
        if(radius <0) {
            throw new IllegalArgumentException("radius must be positive: " + radius);
        }
        Circle circle = new Circle(new Point(x, y), radius, color);
        Command command =  new AddCommand(circle,drawing);
        commandManager.register(command);
    }

    /**
     * Add a Rectangle in the Drawing.
     * @param x = the X coordinate of the Rectangle.
     * @param y = the Y coordinate of the Rectangle.
     * @param width = the Width of the Rectangle.
     * @param height = the Height of the Rectangle.
     * @param color = the Color of the Rectangle.
     */
    public void newRectangle(int x, int y, double width, double height, char color){
        if(width < 0 || height < 0){
            throw new IllegalArgumentException("width : "+width+" and height : "+height+" must be positive");
        }
        Point upperLeft = new Point(x, y);
        Rectangle rectangle = new Rectangle(upperLeft, width, height, color);
        Command command =  new AddCommand(rectangle,drawing);
        commandManager.register(command);
    }

    /**
     * Add a Square in the drawing.
     * @param x = the X coordinate of the Square.
     * @param y = the Y coordinate of the Square.
     * @param side = the side of the Square.
     * @param color = the color of the Square.
     */
    public void newSquare(int x, int y, double side, char color){
        if(side < 0){
            throw new IllegalArgumentException("side : "+side+" must be positive");
        }
        Point upperLeft = new Point(x, y);
        Square square = new Square(upperLeft, side, color);
        Command command =  new AddCommand(square,drawing);
        commandManager.register(command);
    }

    /**
     * Add a line in the drawing.
     * @param x1 the position x of the point A.
     * @param y1 the position y of the point A.
     * @param x2 the position x of the point B.
     * @param y2 the position y of the point B.
     * @param color the color of the Line.
     */
    public void newLine(int x1,int y1,int x2,int y2,char color){
        Line line = new Line(x1,y1,x2,y2,color);
        Command command = new AddCommand(line,drawing);
        commandManager.register(command);
    }


    public void newGroup(List<Integer> indexes,List<Shape> shapes){
        Group group = new Group(indexes,shapes,shapes.get(0).getColor());
        Command command = new GroupCommand(drawing,group);
        commandManager.register(command);
    }

    /**
     * Change the color of a shape.
     * @param index a given index.
     * @param color a given color.
     */
    public void changeColor(int index,char color){
        Command command = new ChangeColorCommand(color,drawing.getShapeAt(index));
        commandManager.register(command);
    }

    /**
     * Delete a shape.
     * @param index a given index.
     */
    public void deleteShape(int index){
        Command command = new DeleteCommand(index,drawing);
        commandManager.register(command);
    }

    /**
     * Move a shape.
     * @param index a given index.
     * @param dx a given x.
     * @param dy a given y.
     */
    public void moveShape(int index,int dx,int dy){
        Command command = new MoveCommand(drawing.getShapeAt(index),dx,dy);
        commandManager.register(command);
    }

    /**
     * Remove a group.
     * @param group a given group.
     */
    public void ungroup(List<Integer> indexes,int index,Group group){
        Command command = new UngroupCommand(indexes,index,group,drawing);
        commandManager.register(command);
    }

    /**
     * Return the Drawing.
     * @return the Drawing.
     */
    public Drawing getDrawing() {
        return drawing;
    }
}
