import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3 {
    public static void findPerfectString(String input) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Not a Perfect String");
                return;
            }
        }
        System.out.println("Perfect string");
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str=s.next();
        findPerfectString(str);
    }
}
