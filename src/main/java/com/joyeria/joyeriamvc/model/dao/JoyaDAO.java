/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.dao;

import com.joyeria.joyeriamvc.model.vo.JoyaVO;
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
public class JoyaDAO {

    public void create(JoyaVO joya) throws SQLException {
        String query = "INSERT INTO joya (name,price,stock,material,weight_gr) VALUES (?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, joya.getName().trim());
            stmt.setLong(2, joya.getPrice());
            stmt.setInt(3, joya.getStock());
            stmt.setString(4, joya.getMaterial().trim());
            stmt.setFloat(5, joya.getWeight_gr());
            stmt.executeUpdate();

        } catch (NullPointerException ex) {
            throw new SQLException();
        }
    }

    public void update(JoyaVO joya) throws SQLException {
        String query = "UPDATE joya SET name = ?, price = ?, stock = ?, material = ?, weight_gr = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, joya.getName().trim());
            stmt.setLong(2, joya.getPrice());
            stmt.setInt(3, joya.getStock());
            stmt.setString(4, joya.getMaterial().trim());
            stmt.setFloat(5, joya.getWeight_gr());
            stmt.setInt(6, joya.getId());
            stmt.executeUpdate();
        } catch (NullPointerException ex) {
            throw new SQLException();
        }
    }

    public void delete(int joyaId) throws SQLException {
        String query = "DELETE FROM joya WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, joyaId);
            stmt.executeUpdate();
        } catch (NullPointerException ex) {
            throw new SQLException();
        }
    }

    public List<JoyaVO> getAll() throws SQLException {
        List<JoyaVO> joyas = new ArrayList<>();
        String query = "SELECT id,name,price,stock,material,weight_gr FROM joya";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Long price = rs.getLong("price");
                int stock = rs.getInt("stock");
                String material = rs.getString("material");
                Float weight = rs.getFloat("weight_gr");

                joyas.add(new JoyaVO(id, name, price, stock, material, weight));
            }
        } catch (NullPointerException ex) {
            throw new SQLException();
        }
        return joyas;
    }

    public JoyaVO getById(int id) throws SQLException {
        String query = "SELECT id,name,price,stock,material,weight_gr FROM joya WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                Long price = rs.getLong("price");
                int stock = rs.getInt("stock");
                String material = rs.getString("material");
                Float weight = rs.getFloat("weight_gr");
                return new JoyaVO(id, name, price, stock, material, weight);
            } else {
                return null;
            }
        } catch (NullPointerException ex) {
            throw new SQLException();
        }
    }

}
