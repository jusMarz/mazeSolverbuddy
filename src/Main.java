import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        String[][] maze = getMaze(".idea/TestCase.txt");
        printMaze(maze);
        MazeSolver Jack = new MazeSolver(maze,"Jack");
//        Adner.solveMaze();
//        Adner.showSteps();

        Jack.report(0);
        Jack.solveMaze();
        Jack.report(0);
        Jack.showSteps();

        }
    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }

    public static void printMaze(String[][] maze)
    {
        for(String[] row: maze) {
            for (String colum : row)
            {
                System.out.print(colum);
            }
            System.out.println();
        }
    }

}