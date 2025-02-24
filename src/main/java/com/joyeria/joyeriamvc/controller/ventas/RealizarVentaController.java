/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller.ventas;

import com.joyeria.joyeriamvc.controller.AbstractController;
import com.joyeria.joyeriamvc.controller.actions.ActionListenerChangeView;
import com.joyeria.joyeriamvc.model.dao.ClienteDAO;
import com.joyeria.joyeriamvc.model.dao.JoyaDAO;
import com.joyeria.joyeriamvc.model.dao.VentaDAO;
import com.joyeria.joyeriamvc.model.vo.ClienteVO;
import com.joyeria.joyeriamvc.model.vo.JoyaVO;
import com.joyeria.joyeriamvc.model.vo.VentaVO;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.venta.RealizarVentaView;
import com.joyeria.joyeriamvc.view.venta.VentasMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hfria
 */
public class RealizarVentaController extends AbstractController {

    ClienteVO selectedCliente = null;
    JoyaVO selectedJoya = null;

    public RealizarVentaController(AplicationFrame aplicationFrame) {
        super(aplicationFrame);
        this.panelView = aplicationFrame.getRealizarVentaView();

        RealizarVentaView realizarVentaView = (RealizarVentaView) panelView;

        realizarVentaView.getBtnConfirmarVenta().addActionListener(realizarVenta(realizarVentaView));

        VentasMenuView ventasMenuView = aplicationFrame.getVentasMenuView();
        ventasMenuView.getBtnRealizarVenta().addActionListener(actualizarDatosListener(realizarVentaView));
        realizarVentaView.getBtnActualizarDatos().addActionListener(actualizarDatosListener(realizarVentaView));
        realizarVentaView.getBtnBack().addActionListener(new ActionListenerChangeView(aplicationFrame, "ventasMenuView"));

    }

    private ActionListener actualizarDatosListener(RealizarVentaView realizarVentaView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatos(realizarVentaView);

            }
        };
    }

    private ActionListener realizarVenta(RealizarVentaView realizarVentaView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cantidadString = realizarVentaView.getInputCantidad().getText();
                int cantidad;
                if (-1 == realizarVentaView.getComboBoxJoya().getSelectedIndex()) {
                    JOptionPane.showMessageDialog(null, "Selecciona Joya");
                    return;
                } else if (-1 == realizarVentaView.getComboBoxCliente().getSelectedIndex()) {
                    JOptionPane.showMessageDialog(null, "Selecciona Cliente");
                    return;
                } else if (cantidadString == null) {
                    JOptionPane.showMessageDialog(null, "Ingrese cantidad");
                    return;
                }
                cantidad = Integer.parseInt(cantidadString);
                if (cantidad < 1) {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser positiva");
                    return;
                }
                JoyaVO joya = (JoyaVO) realizarVentaView.getComboBoxJoya().getSelectedItem();
                ClienteVO cliente = (ClienteVO) realizarVentaView.getComboBoxCliente().getSelectedItem();
                if (cantidad > joya.getStock()) {
                    JOptionPane.showMessageDialog(null, "No hay stock sufuciente para esa cantidad");
                    return;
//                }
                } else {
                    VentaVO ventaVo = new VentaVO(joya, cliente, cantidad);
                    VentaDAO ventaDao = new VentaDAO();
                    try {
                        ventaDao.create(ventaVo);
                        JOptionPane.showMessageDialog(null, "Venta registrada con éxito");
                        actualizarDatos(realizarVentaView);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al registrar venta, actualiza e intenta nuevamente");
                    }

                }
            }

        ;

    }

    ;
    }
    private void actualizarDatos(RealizarVentaView realizarVentaView) {
        JoyaDAO joyaDao = new JoyaDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        try {
            List<JoyaVO> joyas = joyaDao.getAll();
            List<ClienteVO> clientes = clienteDao.getAll();
            realizarVentaView.fillComboBoxCliente(clientes);
            realizarVentaView.fillComboBoxJoya(joyas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en base de datos");
        }
    }
}
