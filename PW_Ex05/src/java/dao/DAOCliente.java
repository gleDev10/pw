/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fw.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import to.TOCliente;

/**
 *
 * @author Máquina
 */
public class DAOCliente {
    public static List<TOCliente> getLista(Connection c, String filtro) throws Exception{
        
        
        List<TOCliente> l = new ArrayList<>();
        
        
        StringBuilder sql = new StringBuilder();
        sql.append("  select id, nome, sobrenome, sexo, email, from cliente " );
        sql.append("  where nome like concat(concat('%',?),'%' " );
        sql.append("  order by nome, sobrenome " );
        
        try(ResultSet rs = Data.executeQuery(c, sql.toString(), filtro)) {
            while(rs.next()) {
                TOCliente cliente = new TOCliente(rs);
                l.add(cliente);
            }
        }
        return l;
    }
}
