/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.vo;

import java.time.LocalDateTime;

/**
 *
 * @author hfria
 *
 */
public class VentaVO {

    private int id;
    private int joyaId;
    private int clienteId;
    private long totalAmount;
    private int numberOfJewels;
    private LocalDateTime dateTime;
    // local
    // vendedor
    // metodo de pago
    // descuentos

    public VentaVO(int joyaId, int clienteId, long totalAmount, int numberOfJewels, LocalDateTime dateTime) {
        this.joyaId = joyaId;
        this.clienteId = clienteId;
        this.totalAmount = totalAmount;
        this.dateTime = dateTime;
    }

    public VentaVO(JoyaVO joya, ClienteVO cliente, int cantidad) {
        this.joyaId = joya.getId();
        this.clienteId = cliente.getId();
        this.totalAmount = cantidad * joya.getPrice();
        this.numberOfJewels = cantidad;
        this.dateTime = LocalDateTime.now();
    }

    public VentaVO(int id, int joyaId, int clienteId, long totalAmount, int numberOfJewels, LocalDateTime dateTime) {
        this.id = id;
        this.joyaId = joyaId;
        this.clienteId = clienteId;
        this.totalAmount = totalAmount;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "VentaVO{" + "id=" + id + ", joyaId=" + joyaId + ", clienteId=" + clienteId + ", totalAmount=" + totalAmount + ", numberOfJewels=" + numberOfJewels + ", dateTime=" + dateTime + '}';
    }

    public int getId() {
        return id;
    }

    public int getJoyaId() {
        return joyaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getNumberOfJewels() {
        return numberOfJewels;
    }

}
