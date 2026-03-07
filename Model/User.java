package Model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String userId;
    private Double userBalance;
    private Map<String,Integer> holdings=new HashMap<>();
    public User(String userId,Double userBalance){
        this.userId=userId;
        this.userBalance=userBalance;
    }

    public String getUserId() {
        return userId;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void debitAmount(double amount){
        userBalance-=amount;
    }
    public void creditAmount(double amount){
        userBalance+=amount;
    }
    public Map<String, Integer> getHoldings() {
        return holdings;
    }
    public void addStock(String symbol,int qty){
        holdings.put(symbol,holdings.getOrDefault(qty,0)+qty);
    }
}