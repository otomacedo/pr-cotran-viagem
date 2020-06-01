package br.gov.presidencia.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.gov.presidencia.dao.FuncionarioDAO;
import br.gov.presidencia.entity.Funcionario;
import br.gov.presidencia.util.Response;

@Path("/funcionario")
public class FuncionarioRest {
	
	
	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	@POST
	@Path("salvar")
	public Funcionario salvarFuncionario(String funcionario) {
//		funcionarioDAO.incluir(f);
		return null;
	}
	
	@DELETE
	@Path("excluir/{id}")
	public Funcionario excluirFuncionario(@PathParam("id") Integer id) {
		funcionarioDAO.excluir(id);
		return null;
	}
	
	@GET
	@Path("consultar")
	public Funcionario consultarFuncionario(Funcionario funcionario) {
		funcionarioDAO.consultar(funcionario.getIdFuncionario());
		return null;
	}

	@GET
	@Path("/listar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listarFuncionarios() {
		return funcionarioDAO.listar();
	}
	@PUT
	@Path("alterar")
	public Response alterarFuncionario(Funcionario funcionario) {
		funcionarioDAO.alterar(funcionario);
		return null;
	}
	
}
