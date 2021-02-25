import java.io.*;
import java.util.*;

public class SherlockTheValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] letters = new int[26];
        Arrays.fill(letters, 0);
        for (int i = 0; i < s.length(); i ++){
            int asciiVal = s.charAt(i);
            letters[asciiVal - 97]++;
        }
        int i = 0;
        int value = 0;
        while (true){
            if (letters[i] > 0){
                value = letters[i];
                break;
            }
            i++;
        }
        /* letters[26]
        example bbbbccccdddde
        {0, 4, 4, 4, 1, 0, 0, ..., 0}*/
        int count = 0;
        for (; i < letters.length; i++){
            if (letters[i] > 0 && letters[i] != value){
                count++;
            }
        }
        if (count < 2){
            return "YES";
        } else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

