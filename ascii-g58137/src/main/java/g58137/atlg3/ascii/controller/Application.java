package g58137.atlg3.ascii.controller;

import g58137.atlg3.ascii.model.AsciiPaint;
import g58137.atlg3.ascii.model.Group;
import g58137.atlg3.ascii.model.Shape;
import g58137.atlg3.ascii.view.AsciiView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The application.
 *
 * @author Florian Essomba
 */
public class Application {
    private AsciiPaint paint;
    private AsciiView view;
    private final String DRAWING_PATTERN = "\\d+\s\\d+";
    private final String CIRCLE_PATTERN = "add circle\s\\d+\s\\d+\s\\d+\s.";
    private final String RECTANGLE_PATTERN = "add rectangle\s\\d+\s\\d+\s\\d+\s\\d+\s.";
    private final String SQUARE_PATTERN = "add square\s\\d+\s\\d+\s\\d+\s.";
    private final String LINE_PATTERN = "add line\s\\d+\s\\d+\s\\d+\s\\d+\s.";
    private final String GROUP_PATTERN = "group\s*";
    private final String UNGROUP_PATTERN = "ungroup\s\\d+";
    private final String COLOR_PATTERN = "color\s\\d+\s.";
    private final String DELETE_PATTERN = "delete\s\\d+";
    private final String MOVE_PATTERN = "move\s\\d+\s\\d+\s\\d+";

    /**
     * The method that starts the programme.
     */
    public void start(){
        view = new AsciiView();
        Scanner clavier = new Scanner(System.in);
        boolean suite = false;

        while(!suite){
            view.displaySize();
            String size = clavier.nextLine();
            if(Pattern.matches(DRAWING_PATTERN,size)){
                suite = true;
                String[] tailles = size.split(" ");
                int width = Integer.parseInt(tailles[0]);
                int height = Integer.parseInt(tailles[1]);
                paint = new AsciiPaint(width, height);
            }
        }
        view.display();
        boolean fin = false;
        while(!fin) {
            try {
                String response = clavier.nextLine().toLowerCase();
                if (Pattern.matches(CIRCLE_PATTERN, response)) { // add a circle.
                    response = response.replaceFirst("add circle", "");
                    String[] data = response.split("\s");
                    paint.newCircle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4].charAt(0));
                } else if (Pattern.matches(RECTANGLE_PATTERN, response)) { // add a rectangle.
                    response = response.replaceFirst("add rectangle", "");
                    String[] data = response.split("\s");
                    paint.newRectangle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5].charAt(0));
                }else if(Pattern.matches(SQUARE_PATTERN, response)){ // add a square.
                    response = response.replaceFirst("add square", "");
                    String[] data = response.split("\s");
                    paint.newSquare(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4].charAt(0));
                } else if(Pattern.matches(LINE_PATTERN, response)){
                    response = response.replaceFirst("add line", "");
                    String[] data = response.split("\s");
                    paint.newLine(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]),data[5].charAt(0));
                } else if(response.length() >= 5 && Pattern.matches(GROUP_PATTERN, response.substring(0,5))){
                    response = response.replaceFirst("group","");
                    String[] data = response.split("\s");
                    List<Shape> shapes = new ArrayList<>();
                    List indexes = new ArrayList<>();
                    for (int i = 1; i < data.length; i++) {
                        shapes.add(paint.getDrawing().getShapeAt(Integer.parseInt(data[i])));
                        indexes.add(Integer.parseInt(data[i]));
                    }
                    paint.newGroup(indexes,shapes);
                } else if (Pattern.matches(UNGROUP_PATTERN,response)) {
                    response = response.replaceFirst("ungroup","");
                    String[] data = response.split("\s");
                    Group group = (Group) paint.getDrawing().getShapeAt(Integer.parseInt(data[1]));
                    paint.ungroup(group.getIndexes(),Integer.parseInt(data[1]),group);
                } else if (Pattern.matches(COLOR_PATTERN, response)) {
                        response = response.replaceFirst("color", "");
                        String[] data = response.split("\s");
                        paint.changeColor(Integer.parseInt(data[1]), data[2].charAt(0));
                } else if (Pattern.matches(DELETE_PATTERN, response)) {
                        response = response.replaceFirst("delete", "");
                        String[] data = response.split("\s");
                        paint.deleteShape(Integer.parseInt(data[1]));
                } else if (Pattern.matches(MOVE_PATTERN, response)) {
                        response = response.replaceFirst("move","");
                        String[] data = response.split("\s");
                        paint.moveShape(Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]));
                } else if (response.equals("show")) {
                    view.displayDrawing(paint.getDrawing());
                } else if (response.equals("erase")) {
                    paint = new AsciiPaint();
                } else if (response.equals("help")) {
                    view.displayHelp();
                } else if (response.equals("exit") || response.equals("quit")) {
                    fin = true;
                } else if (response.equals("list")) {
                    view.displayList(paint.getDrawing().getShapes());
                } else if (response.equals("undo")) {
                    paint.undo();
                } else if (response.equals("redo")) {
                    paint.redo();
                } else{
                    view.displayFail();
                }
            }catch (Exception e){
                view.displayError(e);
            }
        }
    }

    //the method main
    public static void main(String[] args) {
        Application play = new Application();
        play.start();
    }
}

