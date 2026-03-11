package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String userId;
    private Double userBalance;
    private Map<String,Integer> holdings=new HashMap<>();
    private List<Share> sharesHistory=new ArrayList<>();
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
        this.userBalance-=amount;
    }
    public void creditAmount(double amount){
        this.userBalance+=amount;
    }
    public Map<String, Integer> getHoldings() {
        return holdings;
    }
    public void addStock(String symbol,int qty){
        holdings.put(symbol,holdings.getOrDefault(symbol,0)+qty);
    }
    public void removeStock(String symbol,int qty){
        holdings.put(symbol,holdings.getOrDefault(symbol, 0)-qty);
    }
    public void addShare(Share share){
        sharesHistory.add(share);
    }
    public List<Share> getShareHistory(){
        return sharesHistory;
    }
}