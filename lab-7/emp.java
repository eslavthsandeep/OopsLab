public class emp {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public emp(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        setMonthlySalary(monthlySalary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        }
    }

    public double getYearlySalary() {
        return monthlySalary * 12;
    }

    public void giveRaise(double percentage) {
        if (percentage > 0) {
            this.monthlySalary += (monthlySalary * percentage / 100);
        }
    }

    public static void main(String[] args) {
        Q3 Q31 = new Q3("John", "Doe", 3000);
        Q3 Q32 = new Q3("Jane", "Smith", 3500);

        System.out.println("Yearly Salary of " + Q31.getFirstName() + " " + Q31.getLastName() + ": $" + Q31.getYearlySalary());
        System.out.println("Yearly Salary of " + Q32.getFirstName() + " " + Q32.getLastName() + ": $" + Q32.getYearlySalary());

        Q31.giveRaise(10);
        Q32.giveRaise(10);

        System.out.println("Yearly Salary of " + Q31.getFirstName() + " " + Q31.getLastName() + " after 10% raise: $" + Q31.getYearlySalary());
        System.out.println("Yearly Salary of " + Q32.getFirstName() + " " + Q32.getLastName() + " after 10% raise: $" + Q32.getYearlySalary());
    }
}
