/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.DAOCliente;
import fw.Data;
import java.sql.Connection;
import java.util.List;
import to.TOCliente;

/**
 *
 * @author Máquina
 */
public class BOCliente {
    
    public static List<TOCliente> getLista(String filtro) throws Exception{
        try (Connection c = Data.openConnection()){
            return DAOCliente.getLista(c, filtro);
        }
    }
    
}
