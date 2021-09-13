import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

// Example for Reading from File
// T will store number of test cases

public class MyProgram
{
    public static String INPUT_FILE_NAME = "Prob21.in.txt";

    public static void main(String[] args) {
        try {
            // prepare to read the file
            File inFile = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            String inLine = null;

            // get the number of test cases
            int T = Integer.parseInt(br.readLine());

            // loop through test cases
            for (int i = 0; i < T; i++) {
                // Get the Line
                inLine = br.readLine();

                String[] line = inLine.split(" ");

                // Getting all of the walls
                ArrayList<Line> walls = new ArrayList<Line>();
                for (int l = 0; l < Integer.parseInt(line[4]); l++) {
                    String[] newLine = br.readLine().split(" ");

                    // Start and end coordinates
                    Coordinate coordinate1 = new Coordinate(Double.parseDouble(newLine[0]),Double.parseDouble(newLine[1]));
                    Coordinate coordinate2 = new Coordinate(Double.parseDouble(newLine[2]), Double.parseDouble(newLine[3]));
                    Line wall = new Line(coordinate1, coordinate2);

                    // Adding to the walls arraylist
                    walls.add(wall);
                }

                // LOGIC
                Intersecting intersecting = new Intersecting(new Line(new Coordinate(Double.parseDouble(line[0]), Double.parseDouble(line[1])), new Coordinate(Double.parseDouble(line[2]), Double.parseDouble(line[3]))));

                // Print the line
                boolean spotted = true;
                for (int l = 0; l < walls.size(); l++) {
                    if (!intersecting.isIntersecting(walls.get(l))) {
                        spotted = false;
                    }
                }
                if (spotted) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

            // clean up
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}