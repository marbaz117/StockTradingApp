

package OperationOnOrder;
import Model.Order;
import java.util.PriorityQueue;

public class BookOrder {
    public PriorityQueue<Order> buyQueue;
    public PriorityQueue<Order> sellQueue;
    public BookOrder(){
        buyQueue=new PriorityQueue<>(
            (a,b)->{
                int diff=Double.compare(a.getPrice(), b.getPrice());
                if(diff!=0)
                    return diff;
                return a.getLocalTime().compareTo(b.getLocalTime());
            }
        );
        sellQueue=new PriorityQueue<>(
            (a,b)->{
                int diff=Double.compare(b.getPrice(), a.getPrice());
                if(diff!=0)
                    return diff;
                return a.getLocalTime().compareTo(b.getLocalTime());
            }
        );
    }
    public synchronized void addOrder(Order order){
        if(order.getType()==Order.Type.BUY){
            buyQueue.add(order);
        }
        else{
            sellQueue.add(order);
        }
    }
}
