import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {
    private int xPos;
    private int yPos;
    private String[][] maze;
    String name;
    int personality;
    ArrayList<String> footprints;

    public MazeSolver(String[][] unsolvedMaze,String name) {
        xPos = 0;
        yPos = 0;
        maze = unsolvedMaze;
        this.name = name;
        personality = (int) (Math.random() * 6);
        footprints  = new ArrayList<String>();
    }

    public void solveMaze()
    {
        while(!amAtEnd())
        {
            move(determineNextMove(checkPossibleMovementOptions()),true);
        }
        footprints.add(getPos());
        System.out.println("I have solved the maze!");
    }

    public void showSteps()
    {
        for(String step: footprints)
        {
            System.out.print("("+step+")"+" -> ");
        }
        System.out.print("end");
    }

    public String getPos() {
        return (yPos + "," + xPos);
    }


    public void setPos(String pos) {
        yPos = Integer.parseInt(pos.substring(0, pos.indexOf(",")));
        xPos = Integer.parseInt(pos.substring(pos.indexOf(",") + 1));
    }

    public ArrayList<String> checkPossibleMovementOptions() {
        ArrayList<String> possibleDirections = new ArrayList<String>();
        if(amAtEnd())
        {
            return possibleDirections;
        }

        if ((xPos > 0) && (maze[yPos][xPos - 1].equals("."))) //checks left
        {
            possibleDirections.add(cords(yPos, xPos - 1));
        }
        if ((xPos < maze[0].length - 1) && (maze[yPos][xPos + 1].equals("."))) //checks right
        {
            possibleDirections.add(cords(yPos, xPos + 1));
        }

        if ((yPos > 0) && (maze[yPos - 1][xPos].equals("."))) //checks up
        {
            possibleDirections.add(cords(yPos - 1,xPos));
        }
        if ((yPos < maze.length - 1) && (maze[yPos + 1][xPos].equals("."))) //checks down
        {
            possibleDirections.add(cords(yPos + 1,xPos));
        }

        return possibleDirections;

    }

    public boolean amAtEnd()
    {
        return getPos().equals((maze.length - 1) + "," + (maze[0].length - 1));
    }
    public String move(String coord, boolean speak)
    {
        footprints.add(getPos());
        setPos(coord);
        return getPos();
    }

    public String determineNextMove (ArrayList<String> possibleMoves)
    {
        if((footprints.size() != 0)) {
            for (int i = 0; i < possibleMoves.size(); ) {
                if (possibleMoves.get(i).equals(footprints.get(footprints.size() - 1))) {
                    possibleMoves.remove(i);
                } else {
                    i++;
                }
            }
        }
        if (possibleMoves.size()==1)
        {
            return possibleMoves.get(0);
        }
        return "";
    }

    public static String cords(int y, int x)
    {
        return (y + "," + x);
    }

    public void report(int type)
    {
        if (type == 0) { // report everything
            if (personality == 0) {
                System.out.println(name + " here, reporting for duty sir!");
                System.out.println("I am currently at " + getPos() + " sir!");
                System.out.println("I can go in " + checkPossibleMovementOptions().size() + " directions, Sir!");
            } else if (personality == 1) {
                System.out.println("It's me. " + name + ".");
                System.out.println("I am at " + getPos() + ".");
                System.out.println("I see " + checkPossibleMovementOptions().size() + " paths.");
            } else if (personality == 2) {
                System.out.println("Yoyoyoyoyoyoyoyooooooooo  it's " + name + "!!!!!! wsg son!!!");
                System.out.println("I'm at " + getPos() + " rn pullup!!!!");
                System.out.println("I can go in like, " + checkPossibleMovementOptions().size() + " different ways bruh.");
            } else if (personality == 3) {
                System.out.println("Guess who");
                System.out.println("Guess where I'm at");
                System.out.println("I might be at a dead end, maybe");
            }
        }
        if (type == 1) { // report name
            if (personality == 0) {
                System.out.println(name + " here, reporting for duty sir!");
            } else if (personality == 1) {
                System.out.println("It's me. " + name + ".");
            } else if (personality == 2) {
                System.out.println("Yoyoyoyoyoyoyoyooooooooo  it's ya boy " + name + "!");
            } else if (personality == 3) {
                System.out.println("Guess who");
            }
            else
            {
                System.out.println("nah bruh :skull:");
            }
        }
        if (type == 1) { // report posistion
            if (personality == 0) {
                System.out.println("I am currently at " + getPos() + " sir!");
            } else if (personality == 1) {
                System.out.println("At " + getPos() + ".");
            } else if (personality == 2) {
                System.out.println("Yoyoyoyoyoyoyoyooooooooo  it's " + name + "!!!!!! wsg son!!!");
            } else if (personality == 3) {
                System.out.println("Guess who");
            }
            else
            {
                System.out.println("nah bruh :skull:");
            }
        }

    }
}


