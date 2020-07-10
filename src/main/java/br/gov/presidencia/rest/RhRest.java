package br.gov.presidencia.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.gov.presidencia.dao.RhDAO;
import br.gov.presidencia.entity.Rh;
import br.gov.presidencia.util.Response;

@Path(value = "rh")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class RhRest {
	RhDAO rhdao= new RhDAO();

	@POST	
	@Path("salvarRh")
	public Response salvarRh(Rh rh) {
	try {
		rhdao.incluir(rh);
		return new Response("RH Salvo com Sucesso",1);
	} catch (Exception e) {
		return new Response("Erro ao salvar RH",2);
	}
	}
	
	@PUT
	@Path("editarRh")
	public Response alterarRh(Rh rh) {
	try {
		rhdao.alterar(rh);
		return new Response("RH Alterado com sucesso!",1);
	} catch (Exception e) {
		return new Response("Erro ao Alterar RH",2);
	}	
	}

	@GET
	@Path("consultarRh")
	public Rh consultarRh(Rh rh) {
		rhdao.consultar(rh.getIdRh() );
		return null;
	}
	@DELETE
	@Path("excluirRh/{id}")	
	public Response excluirRh(@PathParam("id") Integer id ) {
		try {
			rhdao.excluir(id);
			return new Response("RH excluido com sucesso!",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir RH!",2);
		}
	}
	 
	@GET
	@Path("consultarRhPorFuncionario/{id}")
	public Rh consultarRhPorFuncionario(@PathParam("id") Integer id ) {
		try {
			return rhdao.consultarPorFuncionario(id);
		} catch (Exception e) {
			return new Rh();
		}
	}
	
}
