package br.gov.presidencia.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.gov.presidencia.dao.RhDAO;
import br.gov.presidencia.entity.Rh;

@Path(value = "rh")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class RhRest {
	RhDAO rhdao= new RhDAO();

	@POST
	@Path("salvar")
	public Rh salvarRh(Rh rh) {
		rhdao.incluir(rh);
		return null;
	}
	@PUT
	@Path("alterar")
	public Rh alterarRh(Rh rh) {
		rhdao.alterar(rh);
		return null;
	}

	@GET
	@Path("consultar")
	public Rh consultarRh(Rh rh) {
		rhdao.consultar(rh.getIdRh() );
		return null;
	}
	@DELETE
	@Path("excluir")	
	public Rh excluirRh(Rh rh) {
		rhdao.excluir(rh);
		return null;
	}
	
}
