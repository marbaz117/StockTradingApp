package TradeRollback;

import Model.Order;
import OperationOnOrder.BookOrder;
import java.util.Stack;


public class TransactionRollback {
    Stack<Order> recentBuy=new Stack<>();
    Stack<Order> recentSell=new Stack<>();

    public void BackUp(Order buy,Order sell){
        recentBuy.push(
            new Order(
                buy.getOrderId(),
                buy.getUserId(),
                buy.getSymbol(),
                buy.getQuantity(),
                buy.getPrice(),
                buy.getType(),
                buy.getLocalTime()
            )
        );
        recentSell.push(
            new Order(
                sell.getOrderId(),
                sell.getUserId(),
                sell.getSymbol(),
                sell.getQuantity(),
                sell.getPrice(),
                sell.getType(),
                sell.getLocalTime()
            )
        );
    }
    public void rollback(BookOrder bookOrder){
        if(!recentBuy.isEmpty()){
            bookOrder.buyQueue.add(recentBuy.pop());
        }
        if(!recentSell.isEmpty()){
            bookOrder.sellQueue.add(recentSell.pop());
        }
        System.out.println("Transactions Roll Back.");
    }
    public void commit(BookOrder bookOrder){
        recentBuy.clear();
        recentSell.clear();
    }
}