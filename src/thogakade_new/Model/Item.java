/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade_new.Model;

/**
 *
 * @author ranga
 */
public class Item {
    private String code;
    private String Desc;
    private Double price;
    private int qtOnHand;

    public Item(String code, String Desc, Double price, int qtOnHand) {
        this.code = code;
        this.Desc = Desc;
        this.price = price;
        this.qtOnHand = qtOnHand;
    }

    public Item() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQtOnHand() {
        return qtOnHand;
    }

    public void setQtOnHand(int qtOnHand) {
        this.qtOnHand = qtOnHand;
    }

    @Override
    public String toString() {
        return "Item{" + "code=" + code + ", Desc=" + Desc + ", price=" + price + ", qtOnHand=" + qtOnHand + '}';
    }
    
    
}
