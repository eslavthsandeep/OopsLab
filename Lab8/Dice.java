package Lab8;
import java.util.Scanner;

class Craps {
    int dice1 = 0;
    int dice2 = 0;

    void play() {
        System.out.println("Start the game");
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the value od dice 1");
        dice1 = s.nextInt() ;
        System.out.println("Enter the value od dice 2");
        dice2 = s.nextInt() ;
        if (dice1 + dice2 == 7 || dice1 + dice2 == 11) {
            System.out.println("Congrats you Won!!");
        } else if (dice1 + dice2 == 2 || dice1 + dice2 == 3 || dice1 + dice2 == 12) {
            System.out.println("Craps !! You Lose");
        } else {
            int point = dice1 + dice2;
           do {
                System.out.println("Enter the value od dice 1");
                dice1 = s.nextInt() ;
                System.out.println("Enter the value od dice 2");
                dice2 = s.nextInt() ;
            } while (dice1 + dice2 != point && dice1 + dice2 != 7);
            if (dice1 + dice2 == point) {
                System.out.println("Congrats you Won!!");
            }else{
                System.out.println("You Lose!!");
            }
        }
    }
}

public class Dice {
    public static void main(String[] args) {
        Craps c=new Craps();
        c.play();
            
        
    }
}
