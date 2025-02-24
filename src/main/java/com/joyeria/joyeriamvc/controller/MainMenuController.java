/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller;

import com.joyeria.joyeriamvc.controller.actions.ActionListenerChangeView;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.MainMenuView;

/**
 *
 * @author hfria
 */
public class MainMenuController extends AbstractController {

    public MainMenuController(AplicationFrame aplicationFrame) {
        super(aplicationFrame);
        this.panelView = aplicationFrame.getMainMenuPanel();

        MainMenuView mainMenuView = (MainMenuView) panelView;
        
        mainMenuView.getBtnInventario().addActionListener(new ActionListenerChangeView(aplicationFrame,"inventarioMenuView"));
        mainMenuView.getBtnVentas().addActionListener(new ActionListenerChangeView(aplicationFrame,"ventasMenuView"));
    
    }

}
