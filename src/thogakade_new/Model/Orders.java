/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade_new.Model;

import java.util.ArrayList;

/**
 *
 * @author ranga
 */
public class Orders {
    private String id;
    private String date;
    private String cusId;
    private ArrayList<OrderDetail> orderDetailList;

    public Orders() {
    }

    public Orders(String id, String date, String cusId, ArrayList<OrderDetail> orderDetailList) {
        this.id = id;
        this.date = date;
        this.cusId = cusId;
        this.orderDetailList = orderDetailList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public ArrayList<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(ArrayList<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        return id+","+date+","+cusId+","+orderDetailList;
    }
}
