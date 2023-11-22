package g58137.atlg3.ascii.view;

import g58137.atlg3.ascii.model.Drawing;
import g58137.atlg3.ascii.model.Point;
import g58137.atlg3.ascii.model.Shape;

import java.util.List;

/**
 * Configure the drawing view.
 * @author Florian Essomba
 */
public class AsciiView {
    /**
     * Show the commands.
     */
    public void displayHelp(){
        System.out.println("Add a circle -> add circle x y radius color");
        System.out.println("Add a rectangle -> add rectangle x y longueur hauteur color");
        System.out.println("Add a square -> add square x y side color");
        System.out.println("Add a line -> add line x1 y1 x2 y2 color");
        System.out.println("Delete a shape -> delete number");
        System.out.println("Delete all shape -> erase");
        System.out.println("Move a shape -> move number dx dy");
        System.out.println("Get the list of all shape -> list");
        System.out.println("Change the color of a shape -> color number color");
        System.out.println("Need help ? -> help");
        System.out.println("Print the shapes -> show");
        System.out.println("Group two shape -> group number number");
        System.out.println("Break up a group -> ungroup number");
        System.out.println("When you have finished -> quit or exit");
    }

    /**
     * Display the drawing.
     */
    public void displayDrawing(Drawing drawing){
        for(int i = 0;i < drawing.getHeight();i++){
            for(int width = 0;width < drawing.getWidth();width++){
                Point point = new Point(width,drawing.getHeight()-i-1);
                Shape shape = drawing.getShapeAt(point);
                if(shape != null){
                    System.out.print(shape.getColor());
                }
                else{
                    System.out.print(" ");
                }
            }
            if(i != drawing.getHeight()-1) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Show a message.
     */
    public void display(){
        System.out.println("Enter a command: add, move, show, group, ungroup, color, list, help, delete, erase, undo, redo, exit, quit");
    }

    /**
     * Ask the size of the drawing.
     */
    public void displaySize(){
        System.out.println("Can you give the size of the drawing. (width height)");
    }

    /**
     * Display the exception.
     */
    public void displayError(Exception e){
        System.out.println(e.getMessage());
    }

    /**
     * Dislay the list of shape in the drawing.
     * @param shapes
     */
    public void displayList(List<Shape> shapes){
        for(int i = 0;i<shapes.size();i++){
            System.out.println(shapes.get(i).toString()+" : "+(i+1));
        }
    }

    /**
     * Display an error message.
     */
    public void displayFail(){
        System.out.println("No matching command found. (You can use the command -> help)");
    }

}
