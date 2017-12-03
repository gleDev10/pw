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
import to.TOVeiculo;

/**
 *
 * @author usuario
 */
public class DAOVeiculo {

    public static void inserir(Connection c, TOVeiculo t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" Insert Into veiculo (marca, modelo, placa, cor) ");
        sql.append(" values (?, ?, ?, ?) ");

        Data.executeUpdate(c, sql.toString(),
                t.getMarca(), t.getModelo(), t.getPlaca(), t.getCor());
    }

    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from veiculo  ");
        sql.append(" where id= ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }

    public static TOVeiculo obterFiltro(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, marca, modelo, placa, cor from veiculo ");
        sql.append(" where id= ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TOVeiculo(rs);
            } else {
                return null;
            }
        }
    }

    public static void alterar(Connection c, TOVeiculo t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update veiculo ");
        sql.append(" set marca = ?, modelo = ?, placa = ?, cor = ? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(),
                t.getMarca(),
                t.getModelo(),
                t.getPlaca(),
                t.getCor(),
                t.getId());
    }

    public static List<TOVeiculo> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, marca, modelo, placa, cor from veiculo ");
        sql.append(" order by marca ");

        List<TOVeiculo> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                l.add(new TOVeiculo(rs));
            }
        }
        return l;
    }

}
