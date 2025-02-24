/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.joyeria.joyeriamvc;

import com.joyeria.joyeriamvc.controller.ControllersGenerator;
import com.joyeria.joyeriamvc.view.AplicationFrame;


/**
 *
 * @author hfria
 */
public class JoyeriaMVC {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AplicationFrame aplicationFrame = new AplicationFrame();
            ControllersGenerator mainController = new ControllersGenerator(aplicationFrame);
            aplicationFrame.setVisible(true);
        });
    }
}
