/*
 * Gameplan:
 * create function to read some line n from a file
 * loop through the file to analyze every line
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {

    public static final File FILE = new File("input.txt");

    public static void main(String[] args) throws FileNotFoundException {
        final int NUM_LINES_IN_FILE = 1000;
        
        int count = 0;

        // Loop through file
        for (int i = 1; i <= NUM_LINES_IN_FILE; i++) {
            ArrayList<Integer> array = getNumbers(FILE, i);

            if ((isIncreasingOrDecreasing(array, true) || isIncreasingOrDecreasing(array, false)) && isWithinBounds(array)) {
                count++;
            }
            

            
        }

        System.out.println(count);
        
    }

    private static boolean isWithinBounds(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            int difference = Math.abs(array.get(i) - array.get(i + 1));
            if (difference < 1 || difference > 3) {
                return false;
            }
        }
        return true;
    }

    // Method to detect increasing/decreasing retroactively
    private static boolean isIncreasingOrDecreasing(ArrayList<Integer> array, boolean checkIncreasing) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (checkIncreasing) {
                if (array.get(i) >= array.get(i + 1)) {
                    return false;
                }
            } else {
                if (array.get(i) <= array.get(i + 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static ArrayList<Integer> getNumbers(File file, int lineNumber) throws FileNotFoundException {
        ArrayList<Integer> nums = new ArrayList<>();
        
        // Declare scanner for THIS function only
        Scanner reader = new Scanner(file);

        int currentLine = 1;
        String line = "";

        // Find line in file (will be used to loop up above)
        while (reader.hasNextLine() && currentLine <= lineNumber) {
            line = reader.nextLine();

            if (currentLine == lineNumber) {
                reader.close();
                String[] tempNums = line.split(" "); // get numbers from line

                for (int i = 0; i < tempNums.length; i++) {
                    nums.add(Integer.parseInt(tempNums[i]));
                }

                return nums;
            }
            currentLine++;
        }

        reader.close();

        throw new IllegalArgumentException("Line " + lineNumber + " not found in file");

        
    }
}