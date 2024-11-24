public class Voice {
    public static void main(String[] args) {
        Invoice invoice1 = new Invoice("A123", "Hammer", 5, 12.99);
        Invoice invoice2 = new Invoice("B456", "Screwdriver", -3, -10.0);

        System.out.println("Invoice 1 Amount: " + invoice1.getInvoiceAmount());
        System.out.println("Part Number: " + invoice1.getPartNumber());
        System.out.println("Part Description: " + invoice1.getPartDescription());
        System.out.println("Quantity: " + invoice1.getQuantity());
        System.out.println("Price Per Item: " + invoice1.getPricePerItem());

        System.out.println("Invoice 2 Amount: " + invoice2.getInvoiceAmount());
        System.out.println("Part Number: " + invoice2.getPartNumber());
        System.out.println("Part Description: " + invoice2.getPartDescription());
        System.out.println("Quantity: " + invoice2.getQuantity());
        System.out.println("Price Per Item: " + invoice2.getPricePerItem());
    }
}

class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem > 0) {
            this.pricePerItem = pricePerItem;
        } else {
            this.pricePerItem = 0.0;
        }
    }

    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }
}
