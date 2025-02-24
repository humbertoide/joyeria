/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller.inventario;

import com.joyeria.joyeriamvc.controller.AbstractController;
import com.joyeria.joyeriamvc.controller.actions.ActionListenerChangeView;
import com.joyeria.joyeriamvc.model.dao.JoyaDAO;
import com.joyeria.joyeriamvc.model.vo.JoyaVO;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.inventario.IngresarJoyaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hfria
 */
public class IngresarJoyaController extends AbstractController {

    public IngresarJoyaController(AplicationFrame aplicationFrame) {
        super(aplicationFrame);
        this.panelView = aplicationFrame.getIngresarJoyaView();

        IngresarJoyaView ingresarJoyaView = (IngresarJoyaView) panelView;

        ingresarJoyaView.getBtnGuardarJoya().addActionListener(guardarJoya(ingresarJoyaView));
        ingresarJoyaView.getBtnBack().addActionListener(new ActionListenerChangeView(aplicationFrame,"inventarioMenuView"));
    }

    private ActionListener guardarJoya(IngresarJoyaView ingresarJoyaView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String name = ingresarJoyaView.getInputName().getText();
                    String material = ingresarJoyaView.getInputMaterial().getText();
                    String price = ingresarJoyaView.getInputPrice().getText();
                    String stock = ingresarJoyaView.getInputStock().getText();
                    String weight = ingresarJoyaView.getInputWeight().getText();
                    if (!validInputs(name, price, stock, material, weight)) {
                        throw new NumberFormatException();
                    }
                    JoyaVO joyaVo = new JoyaVO(name, Long.parseLong(price), Integer.parseInt(stock), material, Float.parseFloat(weight));
                    JoyaDAO joyaDao = new JoyaDAO();

                    joyaDao.create(joyaVo);

                    JOptionPane.showMessageDialog(null, "joya guardada con éxito");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error a nivel base de datos");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Algún parámetro no es válido");
                }
            }
        };
    }
    
    private boolean validInputs(String name, String price, String stock, String material, String weight) throws NumberFormatException {
        if (name.isEmpty() || price.isEmpty() || stock.isEmpty() || material.isEmpty() || weight.isEmpty()) {
            return false;
        } else if (Float.parseFloat(weight) < 0) {
            return false;
        } else if (Integer.parseInt(stock) < 0) {
            return false;
        }
        else if (Long.parseLong(price) < 0) {
            return false;
        }
        return true;
    }
}
