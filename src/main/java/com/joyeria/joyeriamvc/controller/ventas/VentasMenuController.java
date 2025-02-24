/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller.ventas;

import com.joyeria.joyeriamvc.controller.AbstractController;
import com.joyeria.joyeriamvc.controller.actions.ActionListenerChangeView;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.venta.VentasMenuView;
/**
 *
 * @author hfria
 */
public class VentasMenuController extends AbstractController{
    
    public VentasMenuController(AplicationFrame aplicationFrame) {
        super(aplicationFrame);
        
        this.panelView = aplicationFrame.getVentasMenuView();
        
        VentasMenuView ventasMenuView = aplicationFrame.getVentasMenuView();   
        ventasMenuView.getBtnRealizarVenta().addActionListener(new ActionListenerChangeView(aplicationFrame,"realizarVentaView"));
        ventasMenuView.getBtnReporteVentas().addActionListener(new ActionListenerChangeView(aplicationFrame,"reporteVentasView"));
        ventasMenuView.getBtnReporteBasicoVentas().addActionListener(new ActionListenerChangeView(aplicationFrame,"reporteBasicoVentasView"));
        ventasMenuView.getBtnBack().addActionListener(new ActionListenerChangeView(aplicationFrame,"mainMenu"));
    }
    
    
}
