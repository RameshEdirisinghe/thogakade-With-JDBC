/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade_new.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import thogakade_new.DBConnection.DBConnection;
import thogakade_new.Model.Customer;
import thogakade_new.Model.Item;
import thogakade_new.Model.Orders;

/**
 *
 * @author ranga
 */
public class PlaceOrderController {

    public static String getOrderID() throws SQLException {
       
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select id from orders ORDER by id DESC LIMIT 1");

        if (rst.next()) {

            int id = Integer.parseInt(rst.getString("id").substring(1, 4));
            return String.format("D%03d", id + 1);

        } else {
            return "D001";
        }

    }

    public static ArrayList getCusId() throws SQLException {
        ArrayList customerIdList = new ArrayList();
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select Id from customer Order by id ASC");

        while (rst.next()) {
            customerIdList.add(rst.getString("id"));
        }
        return customerIdList;
    }

    public static ArrayList getItemId() {
        ArrayList ItemIdList = new ArrayList();
        try {
            ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select code from Item ORDER By code ASC");
            while (rst.next()) {
                ItemIdList.add(rst.getString("code"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ItemIdList;
    }

    public static Item getItem(String itemCode) {
        Item item = null;

        try {
            ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * from Item where code='" + itemCode + "'");

            if (rst.next()) {
                item = new Item(rst.getString("code"), rst.getString("description"), rst.getDouble("unitPrice"), rst.getInt("qtyOnHand"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
    public static Customer getCustomer(String customerId){
        Customer customer = null;
        
        try {
            ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From customer where id='"+customerId+"'");
            if(rst.next( )){
                customer = new Customer(rst.getString("id"),rst.getString("name"),rst.getString("address"),rst.getDouble("salary"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }
    
    public static boolean orderPlaced(Orders order) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement("Insert into Orders values(?,?,?)");
            stm.setObject(1,order.getId());
            stm.setObject(2,order.getDate());
            stm.setObject(3, order.getCusId());
            boolean isAdded = stm.executeUpdate()>0;
            if(isAdded){
                boolean isAddedOrderDetail = OrderDetailController.addOrderDetail(order.getOrderDetailList());
                if(isAddedOrderDetail){
                    boolean isAddItem = ItemController.updateItem(order.getOrderDetailList());
                    
                    if(isAddItem){
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
     
    }
}
