import java.util.Scanner;

public  class gas {
    static class Cost {
        float miles;
        float gasolineCost;
        float avgFees;
        int tolls;
    
        Cost() {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the miles per day:");
            this.miles = s.nextFloat();
            System.out.println("Enter cost per gallon of gasoline:");
            this.gasolineCost = s.nextFloat();
            System.out.println("Enter average fees per day:");
            this.avgFees = s.nextFloat();
            System.out.println("Enter tolls per day:");
            this.tolls = s.nextInt();
        }
    
        void totalCost() {
            double gasolineCostPerDay = (miles / gasolineCost) * avgFees;
            double totalDrivingCostPerDay = gasolineCostPerDay + avgFees + tolls;
            System.out.println("The total driving cost is: " + totalDrivingCostPerDay);
        }
    }
    
    public static void main(String[] args) {
        Cost c = new Cost();
        c.totalCost();
    }
}

