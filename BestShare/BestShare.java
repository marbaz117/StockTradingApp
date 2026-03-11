package BestShare;

import Model.Order;
import Model.Share;
import OperationOnOrder.BookOrder;
import TradeRollback.TransactionRollback;
import java.util.ArrayList;
import java.util.List;

public class BestShare {
    private BookOrder bookOrder;
    private TransactionRollback transactionRollback;
    public BestShare(BookOrder bookOrder){
        this.bookOrder=bookOrder;
        this.transactionRollback=new TransactionRollback();
    }
    public List<Share> match(){
        List<Share> shares=new ArrayList<>();
        while(!bookOrder.buyQueue.isEmpty()&&!bookOrder.sellQueue.isEmpty()){
            Order buy=bookOrder.buyQueue.peek();
            Order sell=bookOrder.sellQueue.peek();
            if(buy.getPrice()<=sell.getPrice()){
                transactionRollback.BackUp(buy, sell);
                try{
                    int qty=Math.min(buy.getQuantity(),sell.getQuantity());
                    buy.reduceQuantity(qty);
                    sell.reduceQuantity(qty);
                    if(buy.getQuantity()==0)
                        bookOrder.buyQueue.poll();
                    if(sell.getQuantity()==0)
                        bookOrder.sellQueue.poll();
                    
                    Share share=new Share(
                        sell.getPrice(),
                        buy.getUserId(),
                        buy.getSymbol(),
                        qty,
                        sell.getUserId()
                    );
                    shares.add(share);
                } 
                catch (Exception e){
                    transactionRollback.rollback(bookOrder);
                    System.out.println("Transaction Failed : "+e.getMessage());
                }
            }
            else{
                break;
            }
        }
        transactionRollback.commit(bookOrder);
        return shares;
    }

}
