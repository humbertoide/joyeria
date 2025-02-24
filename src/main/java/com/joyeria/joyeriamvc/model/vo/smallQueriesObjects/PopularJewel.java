/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.vo.smallQueriesObjects;

/**
 *
 * @author hfria
 */
public class PopularJewel {
    private int id;
    private String name;
    private int timesSold;

    public PopularJewel(int id, String name, int timesSold) {
        this.id = id;
        this.name = name;
        this.timesSold = timesSold;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTimesSold() {
        return timesSold;
    }
    
}
