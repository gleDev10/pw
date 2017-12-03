/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.DAOVeiculo;
import fw.Data;
import java.sql.Connection;
import java.util.List;
import to.TOVeiculo;

/**
 *
 * @author usuario
 */
public class BOVeiculo {

    public static void inserir(TOVeiculo u) throws Exception {
        try (Connection c = Data.openConnection()) {

            DAOVeiculo.inserir(c, u);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOVeiculo.excluir(c, id);
        }
    }

    public static void alterar(TOVeiculo t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOVeiculo.alterar(c, t);
        }
    }

    public static List<TOVeiculo> lista(String filtro) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOVeiculo.lista(c, filtro);
        }
    }

    public static TOVeiculo obterFiltro(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOVeiculo.obterFiltro(c, id);
        }
    }

}
