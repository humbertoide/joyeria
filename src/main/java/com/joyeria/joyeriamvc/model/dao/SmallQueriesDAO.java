/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.dao;

import com.joyeria.joyeriamvc.model.vo.smallQueriesObjects.FrecuentClient;
import com.joyeria.joyeriamvc.model.vo.smallQueriesObjects.PopularJewel;
import com.joyeria.joyeriamvc.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hfria
 */
public class SmallQueriesDAO {

    public List<FrecuentClient> ClientesFrecuentes() throws SQLException {
        List<FrecuentClient> clientes = new ArrayList<>();
        String query = """
                    SELECT 
                        cliente.id,
                        cliente.name,
                        COALESCE(SUM(venta.numberofjewels),0) AS cantidad_ventas
                    FROM 
                        cliente
                    JOIN 
                        venta ON cliente.id = venta.clienteid
                    GROUP BY 
                        cliente.id
                    ORDER BY 
                        cantidad_ventas DESC
                    LIMIT 3;""";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cantidad = rs.getInt("cantidad_ventas");

                clientes.add(new FrecuentClient(id, name, cantidad));
            }
        } catch (NullPointerException ex) {
            throw new SQLException();
        }
        return clientes;
    }

    public List<PopularJewel> joyasMasVendidas() throws SQLException {
        List<PopularJewel> joyas = new ArrayList<>();
        String query = """
                  SELECT 
                      joya.id,
                      joya.name,
                      COALESCE(SUM(venta.numberofjewels),0) AS cantidad_ventas
                  FROM 
                      joya
                  JOIN 
                      venta ON joya.id = venta.joyaid
                  GROUP BY 
                      joya.id
                  ORDER BY 
                      cantidad_ventas DESC
                  LIMIT 3;""";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cantidad = rs.getInt("cantidad_ventas");

                joyas.add(new PopularJewel(id, name, cantidad));
            }
        } catch (NullPointerException ex) {
            throw new SQLException();
        }
        return joyas;
    }

    public int totalVentas() throws SQLException {
        String query = """
        SELECT 
            SUM(numberofjewels) AS total_ventas
        FROM 
            venta;
        """;
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int total_ventas = rs.getInt("total_ventas");
                return total_ventas;
            }
        } catch (NullPointerException ex) {
            throw new SQLException();
        }
        return -1;
    }
}
