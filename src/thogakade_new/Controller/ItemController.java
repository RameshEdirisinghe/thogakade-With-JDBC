/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade_new.Controller;
import  java.sql.*;
import java.util.ArrayList;
import thogakade_new.DBConnection.DBConnection;
import thogakade_new.Model.OrderDetail;
/**
 *
 * @author ranga
 */
public class ItemController {
    
    public static boolean updateItem(ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException{
        for (OrderDetail orderDetail : orderDetailList) {
            boolean isUpdateStock = updateItem(orderDetail);
            if(!isUpdateStock){
                return false;
            }            
        }
        return !orderDetailList.isEmpty();
    }
    
    public static boolean updateItem(OrderDetail orderDetail) throws ClassNotFoundException, SQLException{
        PreparedStatement prepareStm = DBConnection.getInstance().getConnection().prepareStatement("UPDATE item SET qtyOnHand=qtyOnHand-? WHERE code=?");
        prepareStm.setObject(1, orderDetail.getQty());
        prepareStm.setObject(2, orderDetail.getItemCode());
        
        return prepareStm.executeUpdate()>0;
    }
}
