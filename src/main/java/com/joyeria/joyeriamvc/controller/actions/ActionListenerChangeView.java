/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller.actions;

import com.joyeria.joyeriamvc.view.AplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hfria
 */
public class ActionListenerChangeView implements ActionListener {

    String panelName;
    AplicationFrame aplicationFrame;

    public ActionListenerChangeView(AplicationFrame aplicationFrame, String panelName) {
        super();
        this.aplicationFrame = aplicationFrame;
        this.panelName = panelName;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aplicationFrame.changePanelView(panelName);
    }

}
