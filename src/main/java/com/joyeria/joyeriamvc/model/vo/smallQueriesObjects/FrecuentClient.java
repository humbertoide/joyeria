/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.vo.smallQueriesObjects;

/**
 *
 * @author hfria
 */
public class FrecuentClient {
    private int id;
    private String name;
    private int purchases;

    public FrecuentClient(int id, String name, int purchases) {
        this.id = id;
        this.name = name;
        this.purchases = purchases;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPurchases() {
        return purchases;
    }
}
