

package OperationOnOrder;
import java.util.PriorityQueue;

import Model.Order;

public class BookOrder {
    public PriorityQueue<Order> buyQueue;
    public PriorityQueue<Order> sellQueue;
    public BookOrder(){
        buyQueue=new PriorityQueue<>(
            (a,b)->Double.compare(b.getPrice(), a.getPrice())
        );
        sellQueue=new PriorityQueue<>(
            (a,b)->Double.compare(a.getPrice(), b.getPrice())
        );
    }
    public void addOrder(Order order){
        if(order.getType()==Order.Type.BUY){
            buyQueue.add(order);
        }
        else{
            sellQueue.add(order);
        }
    }
}
