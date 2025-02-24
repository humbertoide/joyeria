/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.vo;

/**
 *
 * @author hfria
 */
public class JoyaVO {

    private int id;
    private String name;
    private long price;
    private int stock;
    private String material;
    private float weight_gr;

    public JoyaVO(int id, String name, long price, int stock, String material, float weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.material = material;
        this.weight_gr = weight;
    }

    public JoyaVO(String name, long price, int stock, String material, float weight) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.material = material;
        this.weight_gr = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getMaterial() {
        return material;
    }

    public float getWeight_gr() {
        return weight_gr;
    }

    @Override
    public String toString() {
        return "JoyaVO{" + "id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", material=" + material + ", weight_gr=" + weight_gr + '}';
    }

}
