package BestShare;

import Model.Order;
import Model.Share;
import OperationOnOrder.BookOrder;
import java.util.ArrayList;
import java.util.List;

public class BestShare {
    private BookOrder bookOrder;
    public BestShare(BookOrder bookOrder){
        this.bookOrder=bookOrder;
    }
    public List<Share> match(){
        List<Share> shares=new ArrayList<>();
        while(!bookOrder.buyQueue.isEmpty()&&!bookOrder.sellQueue.isEmpty()){
            Order buy=bookOrder.buyQueue.peek();
            Order sell=bookOrder.sellQueue.peek();
            if(buy.getPrice()>=sell.getPrice()){
                int qty=Math.min(buy.getQuantity(),sell.getQuantity());
                buy.reduceQuantity(qty);
                sell.reduceQuantity(qty);
                Share share=new Share(
                    sell.getPrice(),
                    buy.getUserId(),
                    buy.getSymbol(),
                    qty,
                    sell.getUserId()
                );
                shares.add(share);
                if(buy.getQuantity()==0)
                    bookOrder.buyQueue.poll();
                if(sell.getQuantity()==0)
                    bookOrder.sellQueue.poll();
            }
            else{
                break;
            }
        }
        return shares;
    }

}
