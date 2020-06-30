package br.gov.presidencia.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import br.gov.presidencia.dao.AtividadeDAO;
import br.gov.presidencia.dao.DepartamentoDAO;
import br.gov.presidencia.dao.GraduacaoDAO;
import br.gov.presidencia.dao.GratificacaoDAO;
import br.gov.presidencia.dao.SetorDAO;
import br.gov.presidencia.dao.TipoGratificacaoDAO;
import br.gov.presidencia.entity.Atividade;
import br.gov.presidencia.entity.Departamento;
import br.gov.presidencia.entity.Graduacao;
import br.gov.presidencia.entity.Gratificacao;
import br.gov.presidencia.entity.Setor;
import br.gov.presidencia.entity.TipoGratificacao;
import br.gov.presidencia.util.Response;

@Path("/administracao")
public class AdministracaoRest {
	
	AtividadeDAO atividadeDAO = new AtividadeDAO();
	DepartamentoDAO departamentoDAO = new DepartamentoDAO();
	SetorDAO setorDAO = new SetorDAO();
	GraduacaoDAO graduacaoDAO = new GraduacaoDAO();
	GratificacaoDAO gratificacaoDAO = new GratificacaoDAO();
	TipoGratificacaoDAO tipoGratificacaoDAO = new TipoGratificacaoDAO();
	
	@POST
	@Path("salvarAtividade")
	public Response salvarAtividade(Atividade atividade) {
	     try {
	    	atividadeDAO.incluir(atividade);
	 		return new Response("Atividade salva com sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar Atividade", 12);
		}
}
	@GET
	@Path("listarAtividade/{id}")
	public List<Atividade> listarAtividade(@PathParam("id")Integer id){
		try {
			return atividadeDAO.listar(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Path("listarPorGratificacao/{id}")
	public List<TipoGratificacao> listarPorGratificacao(@PathParam("id") Integer id) {
		try {
			return tipoGratificacaoDAO.listarTiposPorGratificacao(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@POST
	@Path("salvarTipoGratificacao")
	public Response salvatTipoGratificacao(TipoGratificacao tipoGratificacao) {
	try {
		tipoGratificacaoDAO.incluir(tipoGratificacao);
		return new Response("Tipo Gratificação salva com Sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar Tipo Gratificação",2);
		}
	}
	
	@GET
	@Path("listarSetor/{id}")
	public List<Setor> listarSetor(@PathParam("id") Integer id){
		try {
			return setorDAO.listar(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@POST
	@Path("salvarSetor")
	public Response salvarSetor(Setor setor) {
		try {
			setorDAO.incluir(setor);
			return new Response("Setor Salvo com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar Setor",2);
		}
	}
	
	@POST
	@Path("salvarDepartamento")
	public Response salvarDepartamento(Departamento departamento) {
		try {
			departamentoDAO.incluir(departamento);
			return new Response("Departamento Salvo com Sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao Salvar Departamento",2);
		}
	}
	
	@POST
	@Path("salvarGratificacao")
	public Response salvarGratificacao(Gratificacao gratificacao) {
		try {
			gratificacaoDAO.incluir(gratificacao);
			return new Response("Gratificação Salva com Sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao Salvar Gratificação",2);
		}
	}
	
	@POST
	@Path("salvarGraduacao")
	public Response salvarGraduacao(Graduacao graduacao) {
		try {
			graduacaoDAO.incluir(graduacao);
			return new Response("Graduação Salva com Sucesso.",1);			
		} catch (Exception e) {
			return new Response("Erro ao salvar Graduação",2);
		}
	}
	
	





















}