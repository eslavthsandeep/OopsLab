import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2 {
    public static void findCharactersExceedingThreshold(String input, int n) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > n) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the value of the n : ");
        int n=s.nextInt();
        System.out.println("Enter the string: ");
        String str=s.next();
        findCharactersExceedingThreshold(str, n);

    }
}
