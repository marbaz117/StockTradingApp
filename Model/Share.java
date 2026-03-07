package Model;

public class Share {
    private String buyer;
    private String seller;
    private String company;
    private int quantity;
    private double amount;

    public Share(double amount, String buyer, String company, int quantity, String seller) {
        this.amount = amount;
        this.buyer = buyer;
        this.company = company;
        this.quantity = quantity;
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Share [buyer=" + buyer + ", seller=" + seller + ", company=" + company + ", quantity=" + quantity
                + ", amount=" + amount + "]";
    }


}
