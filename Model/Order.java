package Model;

import java.time.LocalDateTime;

public class Order {

    private String orderId;
    private String userId;
    private String symbol;
    private int quantity;
    private double price;
    private Type type;
    private LocalDateTime localTime;
    public Order(String orderId,String userId,String symbol,int quantity,double price,Type type) {
        this.localTime = LocalDateTime.now();
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
        this.symbol = symbol;
        this.type = type;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getLocalTime() {
        return localTime;
    }
    public enum Type{
        BUY,
        SELL
    }
    public void reduceQuantity(int qty){
        this.quantity-=qty;
    }


}
