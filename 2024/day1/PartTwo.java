import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartTwo {

    public static final String FILE = "input.txt";

    public static void main(String[] args) {
        int bucket = 0;
        ArrayList<String> leftList = getLeft(FILE);
        ArrayList<String> rightList = getRight(FILE);
        for (int j = 0; j < leftList.size(); j++) {
            int result = Integer.parseInt(leftList.get(j)) * getNumberCount(Integer.parseInt(leftList.get(j)), rightList);
            System.out.println(leftList.get(j) + "*" + getNumberCount(Integer.parseInt(rightList.get(j)), rightList));
            //System.out.println(result);
            bucket += result;
        }
        
        System.out.println(bucket);
        
    }

    private static int getNumberCount(int numberToCount, ArrayList<String> array) {
        int result = 0;

        for (String num : array) {
            if (Integer.parseInt(num) == numberToCount) result++;
        }

        return result;
    }

    private static ArrayList<String> getLeft(String input) {
        ArrayList<String> bucket = new ArrayList<>();

        try {

            File inputFile = new File(FILE);

            Scanner reader = new Scanner(inputFile);

            while(reader.hasNext()) {
                bucket.add(reader.next());
                reader.next();
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured: " + e.getMessage());
        }

        return bucket;
    }

    private static ArrayList<String> getRight(String input) {
        ArrayList<String> bucket = new ArrayList<>();

        try {

            File inputFile = new File(FILE);

            Scanner reader = new Scanner(inputFile);

            while(reader.hasNext()) {
                reader.next();
                bucket.add(reader.next());
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured: " + e.getMessage());
        }

        return bucket;
    }
}