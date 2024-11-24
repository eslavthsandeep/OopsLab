package Lab8;

import java.util.Scanner;

class Tata{
    String model;
    Tata(){
        System.out.println("Enter the category :");
        Scanner s=new Scanner(System.in);
        model=s.nextLine();
    }
    void findModel(){
        if(model.equals("SUV")){
            System.out.println("Car Model available TATA SAFARI");
        }else if(model.equals("SEDAN")){
            System.out.println("Car Model available TATA INDIGO");
        }else if(model.equals("ECONOMY")){
            System.out.println("Car Model available TATA INDICA");
        }else if(model.equals("MINI")){
            System.out.println("Car Model available TATA NANO");
        }else{
            System.out.println("Wrong input!!");
        }
    }
}
public class carModel {
    
    public static void main(String[] args) {
        Tata t=new Tata();
        t.findModel();
    }
}
