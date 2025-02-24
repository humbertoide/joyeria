/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.vo;

import java.time.LocalDateTime;

/**
 *
 * @author hfria
 */
public class JointsVO {
    private int ventaId;
    private int clienteId;
    private int joyaId;
    private String clienteName;
    private String joyaName;
    private long totalAmount;
    private int numberOfJewels;
    private LocalDateTime datetime;
    
    public JointsVO(int ventaId, int clienteId, int joyaId, String clienteName, String joyaName, long totalAmount, int numberOfJewels, LocalDateTime dateTime) {
        this.ventaId = ventaId;
        this.clienteId = clienteId;
        this.joyaId = joyaId;
        this.clienteName = clienteName;
        this.joyaName = joyaName;
        this.totalAmount = totalAmount;
        this.numberOfJewels = numberOfJewels;
        this.datetime = dateTime;
    }

    public int getVentaId() {
        return ventaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getJoyaId() {
        return joyaId;
    }

    public String getClienteName() {
        return clienteName;
    }

    public String getJoyaName() {
        return joyaName;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public int getNumberOfJewels() {
        return numberOfJewels;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    
}
