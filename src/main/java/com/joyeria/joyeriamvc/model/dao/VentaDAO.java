/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.dao;

import com.joyeria.joyeriamvc.model.vo.VentaVO;
import com.joyeria.joyeriamvc.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hfria
 */
public class VentaDAO {



    private void update(VentaVO venta) throws SQLException {
        String query = "UPDATE SET venta (joyaid,clienteid,totalamount,numberofjewels,datetime) VALUES (?,?,?,?,?) WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, venta.getJoyaId());
            stmt.setInt(2, venta.getClienteId());
            stmt.setLong(3, venta.getTotalAmount());
            stmt.setInt(4, venta.getNumberOfJewels());
            stmt.setObject(5, venta.getDateTime());
            stmt.setObject(6, venta.getId());

        }catch (NullPointerException ex){
            throw new SQLException();
        }

    }

    public List<VentaVO> getAll() throws SQLException {
        List<VentaVO> ventas = new ArrayList<>();
        String query = "SELECT id,name FROM cliente";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int joyaId = rs.getInt("joyaid");
                int clienteId = rs.getInt("clienteid");;
                long totalAmount = rs.getLong("totalamount");;
                int numberOfJewels = rs.getInt("numberofJewels");
                LocalDateTime dateTime = rs.getTimestamp("datetime").toLocalDateTime();

                ventas.add(new VentaVO(joyaId, clienteId, totalAmount, numberOfJewels, dateTime));
            }
        }catch (NullPointerException ex){
            throw new SQLException();
        }
        return ventas;
    }

    public void getById() throws SQLException {
        String query = "SELECT joyaid,clienteid,totalamount,numberofjewels,datetime FROM venta WHERE id=?";
    }

    public void create(VentaVO venta) throws SQLException {
        String queryInsert = "INSERT INTO venta (joyaid,clienteid,totalamount,numberofjewels,datetime) VALUES (?,?,?,?,?)";
        String queryUpdate = "UPDATE joya SET stock = stock - ? WHERE id=?";
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement stmt1 = conn.prepareStatement(queryUpdate); PreparedStatement stmt2 = conn.prepareStatement(queryInsert)) {

                stmt1.setInt(1, venta.getNumberOfJewels());
                stmt1.setInt(2, venta.getJoyaId());
                
                stmt1.executeUpdate();
                
                stmt2.setInt(1, venta.getJoyaId());
                stmt2.setInt(2, venta.getClienteId());
                stmt2.setLong(3, venta.getTotalAmount());
                stmt2.setInt(4, venta.getNumberOfJewels());
                stmt2.setObject(5, venta.getDateTime());
                
                stmt2.executeUpdate();

                conn.commit();

            } catch (SQLException e) {
                if (conn != null) {
                    conn.rollback();
                    conn.setAutoCommit(true);
                    conn.close();
                }
                throw new SQLException();
            }
        } catch (SQLException e) {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
            throw new SQLException();
        }catch (NullPointerException ex){
            throw new SQLException();
        }
        finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    throw new SQLException();
                }
            }
        }
    }
}
