/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade_new.Controller;

import java.sql.*;
import java.util.ArrayList;
import thogakade_new.DBConnection.DBConnection;
import thogakade_new.Model.OrderDetail;
import thogakade_new.Model.Orders;

/**
 *
 * @author ranga
 */
public class OrderDetailController {
    
    public static boolean addOrderDetail(ArrayList<OrderDetail> orderDetailList) throws SQLException{
        for(OrderDetail odrDetail:orderDetailList){
            boolean isadd= addOrderDetail(odrDetail);
            
            if(!isadd){
                return false;
            }
        }
        return !orderDetailList.isEmpty();
    }
    
    public static boolean addOrderDetail(OrderDetail orderDetail) throws SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into Orderdetail values (?,?,?,?)");
        stm.setObject(1,orderDetail.getOrderId());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getQty());
        stm.setObject(4, orderDetail.getUnitPrice());
        
        boolean isAdded = stm.executeUpdate()>0;
        
        return isAdded;
    }
}
