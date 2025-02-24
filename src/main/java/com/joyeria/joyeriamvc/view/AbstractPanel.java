/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.view;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author hfria
 */
public abstract class AbstractPanel extends javax.swing.JPanel implements Panel{

    protected JPanel parentPanel;
    protected CardLayout cardLayout;

    @Override
    public void setParentComponents(JPanel parentPanel, CardLayout cardLayout) {
        this.parentPanel = parentPanel;
        this.cardLayout = cardLayout;

    }
    

}
