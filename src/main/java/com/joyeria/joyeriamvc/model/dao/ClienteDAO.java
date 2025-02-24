/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.dao;

import com.joyeria.joyeriamvc.model.vo.ClienteVO;
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
public class ClienteDAO {
    private void create(ClienteVO cliente) throws SQLException {
        String query = "INSERT INTO cliente (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cliente.getName().trim());
            stmt.executeUpdate();

        } catch (NullPointerException ex) {
            throw new SQLException();
        }

    }

    public List<ClienteVO> getAll() throws SQLException {
        List<ClienteVO> clientes = new ArrayList<>();
        String query = "SELECT id,name FROM cliente";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                clientes.add(new ClienteVO(id, name));
            }
        } catch (NullPointerException ex) {
            throw new SQLException();
        }
        return clientes;
    }

    public ClienteVO getById(int id) throws SQLException {
        String query = "SELECT id,name FROM cliente WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ClienteVO(id, rs.getString("name"));
            } else {
                return null;
            }
        } catch (NullPointerException ex) {
            throw new SQLException();
        }

    }

}
