/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller.inventario;

import com.joyeria.joyeriamvc.controller.AbstractController;
import com.joyeria.joyeriamvc.controller.actions.ActionListenerChangeView;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.inventario.InventarioMenuView;

/**
 *
 * @author hfria
 */
public class InventarioMenuController extends AbstractController{
    
    public InventarioMenuController(AplicationFrame aplicationFrame) {
        super(aplicationFrame);
        this.panelView = aplicationFrame.getInventarioMenuView();
        
        InventarioMenuView inventarioMenuView = (InventarioMenuView) panelView;
        
        inventarioMenuView.getBtnToIngresarJoya().addActionListener(new ActionListenerChangeView(aplicationFrame,"ingresarJoyaView"));
        inventarioMenuView.getBtnToInventarioJoyas().addActionListener(new ActionListenerChangeView(aplicationFrame,"inventarioJoyasView"));
        inventarioMenuView.getBtnBack().addActionListener(new ActionListenerChangeView(aplicationFrame,"mainMenu"));
    }
    
    
}
