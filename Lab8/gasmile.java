package Lab8;

import java.util.Scanner;

class GasMileage {
    float miles[];
    int noOfTrips;
    float gallones[];
    float m = 0;
    GasMileage(int t) {
        miles = new float[t];
        noOfTrips = t;
        gallones = new float[t];
    }

    void getMiles() {
        System.out.println("Enter the miles:");
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < noOfTrips; i++) {
            miles[i] = s.nextFloat();
        }
        System.out.println("Enter the gallones:");
        for (int i = 0; i < noOfTrips; i++) {
            gallones[i] = s.nextFloat();
        }
    }

    void mileagePerTrip() {
        for (int i = 0; i < noOfTrips; i++) {
            float mileage = miles[i] / gallones[i];
            m += mileage;
            System.out.println("Mileage of " + (i + 1) + " is " + mileage);
        }
    }

    float avgMileage() {
        return m / noOfTrips;
    }

}

public class gasmile {
    public static void main(String[] args) {
        GasMileage g=new GasMileage(4);
        g.getMiles();
        g.mileagePerTrip();
        System.out.println("Avg mileage is "+g.avgMileage());
    }
}
