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
import br.gov.presidencia.entity.TipoGratificacao;
import br.gov.presidencia.util.Response;

@Path("/administracao")
public class AdministracaoRest {
	
	AtividadeDAO atividadeDAO = new AtividadeDAO();
	DepartamentoDAO departamentoDAO = new DepartamentoDAO();
	SetorDAO setorDAO = new SetorDAO();
	GraduacaoDAO graduacaoDAO = new GraduacaoDAO();
	GratificacaoDAO gratificacaoDAO = new GratificacaoDAO();
	TipoGratificacaoDAO TipoGratificacaoDAO = new TipoGratificacaoDAO();
	
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
	@Path("listarPorGratificacao/{id}")
	public List<TipoGratificacao> listarPorGratificacao(@PathParam("id") Integer id) {
		try {
			return TipoGratificacaoDAO.listarTiposPorGratificacao(id);
		} catch (Exception e) {
			return null;
		}
	}
}