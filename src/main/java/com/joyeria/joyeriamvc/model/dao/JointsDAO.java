/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joyeria.joyeriamvc.model.dao;

import com.joyeria.joyeriamvc.model.vo.JointsVO;
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
public class JointsDAO {

    public List<JointsVO> getAll() throws SQLException {
        List<JointsVO> joints = new ArrayList<>();
        String query
                = """
                  SELECT 
                  	venta.id,
                      venta.clienteid, 
                      venta.joyaid, 
                      cliente.name AS nombre_cliente, 
                      joya.name AS nombre_joya,
                  	venta.totalamount,
                  	venta.numberofjewels,
                  	venta.datetime
                  FROM 
                      venta
                  JOIN 
                      cliente ON venta.clienteid = cliente.id
                  JOIN 
                      joya ON venta.joyaid = joya.id;""";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("clienteid");
                int joyaId = rs.getInt("joyaid");
                String clienteName = rs.getString("nombre_cliente");
                String joyaName = rs.getString("nombre_joya");
                int numberOfJewels = rs.getInt("numberofjewels");
                Long totalAmount = rs.getLong("totalamount");
                LocalDateTime dateTime = rs.getTimestamp("datetime").toLocalDateTime();

                joints.add(new JointsVO(id, clienteId, joyaId, clienteName, joyaName, totalAmount, numberOfJewels, dateTime));
            }
        }catch (NullPointerException ex){
            throw new SQLException();
        }

        return joints;
    }

}
