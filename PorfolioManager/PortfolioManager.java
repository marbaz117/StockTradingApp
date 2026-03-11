package PorfolioManager;

import Model.Share;
import Model.User;
import java.util.Map;

public class PortfolioManager {
    private Map<String,User> users;
    public PortfolioManager(Map<String,User> users){
        this.users=users;
    }
    public void ProcessShare(Share share){
        User buyer=users.get(share.getBuyer());
        User seller=users.get(share.getSeller());
        double amount=share.getAmount()*share.getQuantity();
        buyer.debitAmount(amount);
        seller.creditAmount(amount);
        System.out.println(buyer.getUserBalance());
        buyer.addStock(share.getCompany(), share.getQuantity());
        seller.removeStock(share.getCompany(), share.getQuantity());
        System.out.println(buyer.getHoldings());
        buyer.addShare(share);
    }
}
