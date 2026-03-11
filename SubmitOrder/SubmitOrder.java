package SubmitOrder;

import Model.Order;
import OperationOnOrder.BookOrder;
import java.util.UUID;

public class SubmitOrder implements Runnable{
    private BookOrder bookOrder;
    private String user;
    public SubmitOrder(BookOrder bookOrder, String user) {
        this.bookOrder = bookOrder;
        this.user = user;
    }

    public void run(){
        for(int i=0;i<5;i++){
            Order order=new Order(
                UUID.randomUUID().toString(),
                user,
                "TCS",
                i+1,
                3900+i,
                i%2==0 ? Order.Type.BUY : Order.Type.SELL
            );  
            bookOrder.addOrder(order);
            System.out.println("Order Added : "+order.getType());
        }
    }
}
