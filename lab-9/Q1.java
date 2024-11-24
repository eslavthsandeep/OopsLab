import java.util.Scanner;

public class Q1 {
    public static boolean checkPassword(String password){
        if(password.length()<5 || password.length()>12){
            return false;
        }
        boolean hasLower = false, hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isLowerCase(ch)) {
                hasLower = true;
            }
            else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            else if (Character.isUpperCase(ch) || !Character.isLetterOrDigit(ch)) {
                return false;
            }

            for (int len = 1; len <= (i + 1) / 2; len++) {
                String firstPart = password.substring(i - len + 1, i + 1); 
                String secondPart = password.substring(i - 2 * len + 1, i - len + 1);
                if (firstPart.equals(secondPart)) {
                    return false;
                }
            }
        }
        return hasDigit && hasLower;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String pass=s.next();
        if(checkPassword(pass)){
            System.out.println("The password is acceptble");
        }else{
            System.out.println("The password is not acceptable");
        }
    }
}
