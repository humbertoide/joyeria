/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.Panel;

/**
 *
 * @author hfria
 */
public class AbstractController implements Controller {

    protected AplicationFrame aplicationFrame;
    protected Panel panelView;

    public AbstractController(AplicationFrame aplicationFrame) {
        this.aplicationFrame = aplicationFrame;
    }

}
