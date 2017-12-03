/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bo.BOVeiculo;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import to.TORetorno;
import to.TOVeiculo;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("veiculo")
public class ServiceVeiculo {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceUsuario
     */
    public ServiceVeiculo() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public TOVeiculo inserir(TOVeiculo veiculo) throws Exception {
        BOVeiculo.inserir(veiculo);
        return veiculo;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public TOVeiculo alterar(TOVeiculo veiculo) throws Exception {

        BOVeiculo.alterar(veiculo);

        return veiculo;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TOVeiculo> obterVeiculos() throws Exception {
        return BOVeiculo.lista("");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TOVeiculo obterFiltro(@PathParam("id") int id) throws Exception {
        return BOVeiculo.obterFiltro(id);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TORetorno excluir(@PathParam("id") int id) throws Exception {
        TORetorno r = new TORetorno();

        try {
            BOVeiculo.excluir(id);
            r.setSucesso(true);
        } catch (Exception e) {
            r.setSucesso(false);
        }
        return r;
    }

}
