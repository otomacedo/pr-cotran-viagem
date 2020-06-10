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
import javax.ws.rs.core.Request;

import br.gov.presidencia.dao.FuncionarioDAO;
import br.gov.presidencia.entity.Funcionario;
import br.gov.presidencia.util.Response;

@Path("/funcionario")
public class FuncionarioRest {
	
	
	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	@POST
	@Path("salvar")
	public Response salvarFuncionario(Funcionario funcionario) {
     try {
    	funcionarioDAO.incluir(funcionario);
 		return new Response("salvo com sucesso",1);
	} catch (Exception e) {
		return new Response("Erro ao salvar Funcionário", 12);
	}
		
	}
	
	@DELETE
	@Path("excluir/{id}")
	public Response excluirFuncionario(@PathParam("id") Integer id) {
		try {
			funcionarioDAO.excluir(id);
			return new Response("excluído com sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir",1);
		}
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
	@Path("editar")
	public Response alterarFuncionario(Funcionario funcionario) {
	try {
		funcionarioDAO.alterar(funcionario);
		return new Response("Alterado com sucesso",1);
	} catch (Exception e) {
		return new Response("Erro ao alterar",2);
	}
	}
	
}
