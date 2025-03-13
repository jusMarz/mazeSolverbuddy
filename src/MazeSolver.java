import java.util.ArrayList;
public class MazeSolver {
    private int xPos;
    private int yPos;
    private String[][] maze;
    String name;
    int personality;

    ArrayList<String> footprints = new ArrayList<String>();

    public MazeSolver(String[][] unsolvedMaze,String name) {
        xPos = 0;
        yPos = 0;
        maze = unsolvedMaze;
        this.name = name;
        personality = (int) (Math.random() * 3);
    }

    public String getPos() {
        return (xPos + "," + yPos);
    }


    public void setPos(String pos) {
        xPos = Integer.parseInt(pos.substring(0, pos.indexOf(",")));
        yPos = Integer.parseInt(pos.substring(pos.indexOf(",") + 1));
    }

    public ArrayList<String> checkPossibleMovementOptions() {
        ArrayList<String> possibleDirections = new ArrayList<String>();

        if ((xPos > 0) && (maze[xPos - 1][yPos].equals("."))) //checks left
        {
            possibleDirections.add(cords(xPos - 1,yPos));
        }
        if ((xPos < maze[0].length - 1) && (maze[xPos + 1][yPos].equals("."))) //checks right
        {
            possibleDirections.add(cords(xPos + 1,yPos));
        }

        if ((yPos > 0) && (maze[xPos][yPos - 1].equals("."))) //checks up
        {
            possibleDirections.add(cords(xPos,yPos - 1));
        }
        if ((yPos < maze.length) && (maze[xPos][yPos + 1].equals("."))) //checks up
        {
            possibleDirections.add(cords(xPos,yPos + 1));
        }

        return possibleDirections;

    }

//    public int

    public String move(String coord, boolean speak)
    {
        footprints.add(getPos());
        if (speak)
        {
            System.out.println("Moving myself to " + coord.substring(0,coord.indexOf(",")) + "," + coord.substring(coord.indexOf(",") + 1) + " sir!");
        }
        setPos(coord);
        return getPos();
    }

    public boolean determineNextMove (ArrayList<String> possibleMoves)
    {
        if(getPos().equals(maze[0].length + maze.length))
        {
            System.out.println("We made it.");
            return true;
        }
        if((footprints.size() != 0)) {
            for (int i = 0; i < possibleMoves.size(); ) {
                if (possibleMoves.get(i).equals(footprints.get(footprints.size() - 1))) {
                    possibleMoves.remove(i);
                } else {
                    i++;
                }
            }
        }
        System.out.println(possibleMoves.size()==1);
        System.out.println(possibleMoves.size());
        System.out.println(possibleMoves);
        if (possibleMoves.size()==1)
        {
            move(possibleMoves.get(0),true);
        }
        return false;
    }

    public int getxPos()
    {
        return xPos;
    }

    public int getyPos()
    {
        return xPos;
    }

    public static String cords(int x, int y)
    {
        return (x + "," + y);
    }

    public void report()
    {
        if (personality == 0)
        {
            System.out.println(name + " here, reporting for duty sir!");
            System.out.println("I am currently at " + getPos() + " sir!");
            System.out.println("I can go in " + checkPossibleMovementOptions().size() + " directions, Sir!");
        }
        else if (personality == 1)
        {
            System.out.println("It's me. " + name + ".");
            System.out.println("I am at " + getPos() + ".");
            System.out.println("I see " + checkPossibleMovementOptions().size() + " paths.");
        }
        else if (personality == 2)
        {
            System.out.println("Yoyoyoyoyoyoyoyooooooooo  it's " + name + "!!!!!! wsg son!!!");
            System.out.println("I'm at " + getPos() + " rn pullup!!!!");
            System.out.println("I can go in like, " + checkPossibleMovementOptions().size() + " different ways bruh.");
        }

    }
}


