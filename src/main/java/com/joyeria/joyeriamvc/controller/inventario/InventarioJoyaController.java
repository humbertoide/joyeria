/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller.inventario;

import com.joyeria.joyeriamvc.controller.AbstractController;
import com.joyeria.joyeriamvc.controller.actions.ActionListenerChangeView;
import com.joyeria.joyeriamvc.model.dao.JoyaDAO;
import com.joyeria.joyeriamvc.model.vo.JoyaVO;
import com.joyeria.joyeriamvc.util.JTableToCSVExporter;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.inventario.InventarioJoyasView;
import com.joyeria.joyeriamvc.view.inventario.InventarioMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author hfria
 */
public class InventarioJoyaController extends AbstractController {

    public InventarioJoyaController(AplicationFrame aplicationFrame) {
        super(aplicationFrame);
        this.panelView = aplicationFrame.getInventarioJoyasView();

        InventarioJoyasView inventarioJoyasView = (InventarioJoyasView) panelView;

        inventarioJoyasView.getBtnActualizarTablaJoya().addActionListener(actualizarTabla(inventarioJoyasView));

        inventarioJoyasView.getBtnEliminarJoya().addActionListener(eliminarJoya(inventarioJoyasView));
        inventarioJoyasView.getBtnModificarJoya().addActionListener(modificarJoya(inventarioJoyasView));
        
        InventarioMenuView inventarioMenuView = aplicationFrame.getInventarioMenuView();
        inventarioMenuView.getBtnToInventarioJoyas().addActionListener(actualizarTabla(inventarioJoyasView));
        
        inventarioJoyasView.getBtnBack().addActionListener(new ActionListenerChangeView(aplicationFrame,"inventarioMenuView"));
        
        inventarioJoyasView.getBtnExportCSV().addActionListener(exportCSVListener(inventarioJoyasView));
    }

    private ActionListener actualizarTabla(InventarioJoyasView inventarioJoyasView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultaActualizar();
                inventarioJoyasView.clearInputFields();
            }
        };
    }

    private ActionListener eliminarJoya(InventarioJoyasView inventarioJoyasView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JoyaDAO joyaDao = new JoyaDAO();
                int joyaId = inventarioJoyasView.getSelectedJoyaId();
                if (joyaId == -1) {
                    JOptionPane.showMessageDialog(null, "Selecciona una joya");
                } else {
                    try {
                        joyaDao.delete(joyaId);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar joya");
                    }
                    consultaActualizar();
                    inventarioJoyasView.clearInputFields();
                }
            }
        };
    }

    private ActionListener modificarJoya(InventarioJoyasView inventarioJoyasView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JoyaDAO joyaDao = new JoyaDAO();
                int joyaId = inventarioJoyasView.getSelectedJoyaId();
                if (joyaId == -1) {
                    JOptionPane.showMessageDialog(null, "Selecciona una joya");
                } else {
                    try {
                        int id = inventarioJoyasView.getSelectedJoyaId();
                        String name = inventarioJoyasView.getInputName().getText();
                        String material = inventarioJoyasView.getInputMaterial().getText();
                        String price = inventarioJoyasView.getInputPrice().getText();
                        String stock = inventarioJoyasView.getInputStock().getText();
                        String weight = inventarioJoyasView.getInputWeight().getText();

                        if (!validInputs(name, price, stock, material, weight)) {
                            throw new NumberFormatException();
                        }
                        JoyaVO joyaVo = new JoyaVO(id, name, Long.parseLong(price), Integer.parseInt(stock), material, Float.parseFloat(weight));

                        joyaDao.update(joyaVo);
                        JOptionPane.showMessageDialog(null, "Joya modificada con éxito");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        ex.printStackTrace();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Algún parámetro no es válido");
                    } finally {
                        consultaActualizar();
                        inventarioJoyasView.clearInputFields();
                    }
                }
            }
        };
    }

    private void consultaActualizar() {
        InventarioJoyasView inventarioJoyasView = (InventarioJoyasView) panelView;
        JoyaDAO joyaDao = new JoyaDAO();
        List<JoyaVO> joyas = null;
        try {
            joyas = joyaDao.getAll();
            inventarioJoyasView.updateTable(joyas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la tabla");
        }
    }

    private boolean validInputs(String name, String price, String stock, String material, String weight) throws NumberFormatException {
        if (name.isEmpty() || price.isEmpty() || stock.isEmpty() || material.isEmpty() || weight.isEmpty()) {
            return false;
        } else if (Float.parseFloat(weight) < 0) {
            return false;
        } else if (Integer.parseInt(stock) < 0) {
            return false;
        } else if (Long.parseLong(price) < 0) {
            return false;
        }
        return true;
    }
    
        private ActionListener exportCSVListener(InventarioJoyasView inventarioJoyasView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportCSV(inventarioJoyasView);

            }

        };
    }

    private void exportCSV(InventarioJoyasView realizarVentaView) {
        JTable table = realizarVentaView.getTablaInventarioJoyas();
        JTableToCSVExporter.exportToCSV(table, "joyas");
    }

}
