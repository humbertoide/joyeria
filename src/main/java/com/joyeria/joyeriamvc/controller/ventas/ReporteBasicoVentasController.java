/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.controller.ventas;

import com.joyeria.joyeriamvc.controller.AbstractController;
import com.joyeria.joyeriamvc.controller.actions.ActionListenerChangeView;
import com.joyeria.joyeriamvc.model.dao.SmallQueriesDAO;
import com.joyeria.joyeriamvc.model.vo.smallQueriesObjects.FrecuentClient;
import com.joyeria.joyeriamvc.model.vo.smallQueriesObjects.PopularJewel;
import com.joyeria.joyeriamvc.view.AplicationFrame;
import com.joyeria.joyeriamvc.view.venta.ReporteBasicoVentasView;
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
public class ReporteBasicoVentasController extends AbstractController {

    public ReporteBasicoVentasController(AplicationFrame aplicationFrame) {
        super(aplicationFrame);

        this.panelView = aplicationFrame.getReporteBasicoVentasView();
        ReporteBasicoVentasView reporteBasicoVentasView = (ReporteBasicoVentasView) panelView;

        VentasMenuView ventasMenuView = aplicationFrame.getVentasMenuView();
        ventasMenuView.getBtnReporteBasicoVentas().addActionListener(actualizarDatosListener(reporteBasicoVentasView));
        reporteBasicoVentasView.getBtnBack().addActionListener(new ActionListenerChangeView(aplicationFrame,"ventasMenuView"));
    }

    private ActionListener actualizarDatosListener(ReporteBasicoVentasView reporteBasicoVentasView) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatos(reporteBasicoVentasView);

            }

        };
    }

    private void actualizarDatos(ReporteBasicoVentasView reporteBasicoVentasView) {
        SmallQueriesDAO smallQueriesDAO = new SmallQueriesDAO();

        try {
            List<FrecuentClient> clientesFrecuentes = smallQueriesDAO.ClientesFrecuentes();
            List<PopularJewel> joyasPopulares = smallQueriesDAO.joyasMasVendidas();
            int ventasRealizadas = smallQueriesDAO.totalVentas();
            
            reporteBasicoVentasView.updateData(clientesFrecuentes,joyasPopulares,ventasRealizadas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en base de datos");
        }

    }

}
