
import BestShare.BestShare;
import FileStorage.FileStorage;
import Model.Share;
import Model.User;
import OperationOnOrder.BookOrder;
import PorfolioManager.PortfolioManager;
import SubmitOrder.SubmitOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StockTradingApp {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("User1", new User("User1", 100000.0));
        users.put("User2", new User("User2", 100000.0));
        users.put("User3", new User("User3",  100000.0));

        BookOrder bookOrder = new BookOrder();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new SubmitOrder(bookOrder, "User1"));
        executor.submit(new SubmitOrder(bookOrder, "User2"));
        executor.submit(new SubmitOrder(bookOrder, "User3"));
        executor.shutdown();
        
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        BestShare bestShares=new BestShare(bookOrder);
        List<Share> shares=bestShares.match();
        PortfolioManager portfolio=new PortfolioManager(users);
        for(Share share:shares){
            System.out.println(share);
            portfolio.ProcessShare(share);
            FileStorage.logTrade(share.toString());
        }
        int i=1;
        for(User u:users.values()){
            System.out.print("The "+i+" Person Id is : ");
            System.out.println(u.getUserId());
            System.out.println(u.getUserBalance());
            System.out.println(u.getHoldings());
            System.out.println("Trades are : ");
            for(Share share:u.getShareHistory()){
                System.out.println(share);
            }
            i++;
        }
    }
}
