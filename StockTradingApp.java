
import BestShare.BestShare;
import FileStorage.FileStorage;
import Model.Share;
import OperationOnOrder.BookOrder;
import SubmitOrder.SubmitOrder;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StockTradingApp {
    public static void main(String[] args) {
        BookOrder book=new BookOrder();
        ExecutorService executor=Executors.newFixedThreadPool(3);
        executor.submit(new SubmitOrder(book,"user1"));
        executor.submit(new SubmitOrder(book,"user2"));
        executor.submit(new SubmitOrder(book,"user3"));
        executor.shutdown();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        BestShare bestShares=new BestShare(book);
        List<Share> shares=bestShares.match();
        for(Share share:shares){
            System.out.println(share);
            FileStorage.logTrade(share.toString());
        }
    }
    

}
