/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller.ventas;

import com.joyeria.joyeriamvc.controller.AbstractController;
import com.joyeria.joyeriamvc.controller.actions.ActionListenerChangeView;
import com.joyeria.joyeriamvc.model.dao.JointsDAO;
import com.joyeria.joyeriamvc.model.vo.JointsVO;
import com.joyeria.joyeriamvc.util.JTableToCSVExporter;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.venta.ReporteVentasView;
import com.joyeria.joyeriamvc.view.venta.VentasMenuView;
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
public class ReporteVentasController extends AbstractController {

    public ReporteVentasController(AplicationFrame aplicationFrame) {
        super(aplicationFrame);

        this.panelView = aplicationFrame.getReporteVentasView();

        ReporteVentasView reporteVentasView = (ReporteVentasView) panelView;

        VentasMenuView ventasMenuView = aplicationFrame.getVentasMenuView();
        ventasMenuView.getBtnReporteVentas().addActionListener(actualizarDatosListener(reporteVentasView));

        reporteVentasView.getBtnBack().addActionListener(new ActionListenerChangeView(aplicationFrame, "ventasMenuView"));

    }

    private ActionListener actualizarDatosListener(ReporteVentasView reporteVentasView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatos(reporteVentasView);

            }

        };
    }

    private void actualizarDatos(ReporteVentasView realizarVentaView) {
        JointsDAO jointDao = new JointsDAO();
        try {
            List<JointsVO> joints = jointDao.getAll();
            realizarVentaView.updateTable(joints);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en base de datos");
        }
    }



}
