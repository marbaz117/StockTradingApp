package ValidAmount;

import Model.Order;
import Model.User;

public class ValidAmount {
    public boolean ValidAmount(Order order,User user){
        if(Order.Type.BUY==order.getType()){
            double cost=order.getPrice()*order.getQuantity();
            return cost<=user.getUserBalance();
        }
        return true;
    }    
}
