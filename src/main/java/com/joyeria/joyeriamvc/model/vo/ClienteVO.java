/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.vo;

/**
 *
 * @author hfria
 */
public class ClienteVO {

    private int id;
    private String name;
    //private String rut;
    //fecha de creacion
    //

    @Override
    public String toString() {
        return name;
    }

    public ClienteVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
