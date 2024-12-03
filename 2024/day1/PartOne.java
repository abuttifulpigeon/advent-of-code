import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {

    public static final String FILE = "input.txt";

    public static void main(String[] args) {
        int bucket = 0;
        for (int j = 0; j < getSmallestNum(getLeft(FILE)).size(); j++) {
            int result = Math.abs(getSmallestNum(getLeft(FILE)).get(j) - getSmallestNum(getRight(FILE)).get(j));
            //System.out.println(result);
            bucket += result;
        }
        System.out.println(bucket);
        
    }

    private static ArrayList<Integer> getSmallestNum(ArrayList<String> array) {
        ArrayList<String> nums = new ArrayList<>(array);
        ArrayList<Integer> result = new ArrayList<>();

        while (!nums.isEmpty()) {
            int smallestNum = Integer.parseInt(nums.get(0));
            int smallestIndex = 0;

            for (int i = 0; i < nums.size(); i++) {
                int index = Integer.parseInt(nums.get(i));
                if (index < smallestNum) {
                    smallestNum = index;
                    smallestIndex = i;
                }
            }

            nums.remove(smallestIndex);

            result.add(smallestNum);
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