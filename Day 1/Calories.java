import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern integerPattern = Pattern.compile("[1-9][0-9]*");
        ArrayList<Integer> elvesAL = new ArrayList<Integer>();
        int sum = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            boolean matches = integerPattern.matcher(line).find();
            if (matches) {
                sum += Integer.parseInt(line);
            } else {
                elvesAL.add(sum);
                sum = 0;
            }
        }
        int[] elves = new int[elvesAL.size()];
        for (int i = 0; i < elves.length; i++) {
            elves[i] = elvesAL.get(i);
            StdOut.println("Elf " + i + ": " + elves[i]);
        }
    }
}
