/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller;

import com.joyeria.joyeriamvc.controller.inventario.IngresarJoyaController;
import com.joyeria.joyeriamvc.controller.inventario.InventarioJoyaController;
import com.joyeria.joyeriamvc.controller.inventario.InventarioMenuController;
import com.joyeria.joyeriamvc.controller.ventas.RealizarVentaController;
import com.joyeria.joyeriamvc.controller.ventas.ReporteBasicoVentasController;
import com.joyeria.joyeriamvc.controller.ventas.ReporteVentasController;
import com.joyeria.joyeriamvc.controller.ventas.VentasMenuController;
import com.joyeria.joyeriamvc.view.AplicationFrame;

/**
 *
 * @author hfria
 */
public class ControllersGenerator {
    private AplicationFrame aplicationFrame;
    
    public ControllersGenerator(AplicationFrame aplicationFrame) {
        this.aplicationFrame = aplicationFrame;
        new InventarioMenuController(aplicationFrame);
        new VentasMenuController(aplicationFrame);
        new MainMenuController(aplicationFrame);
        new IngresarJoyaController(aplicationFrame);
        new InventarioJoyaController(aplicationFrame);
        new RealizarVentaController(aplicationFrame);
        new ReporteVentasController(aplicationFrame);
        new ReporteBasicoVentasController(aplicationFrame);
        
    }
    
    
}
