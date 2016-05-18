package br.ufes.inf.nemo.marvin.sysmap.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.marvin.sysmap.domain.ResearchQuestion;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ResearcherQuestionJPADAO extends BaseJPADAO<ResearchQuestion> implements ResearchQuestionDAO {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Class<ResearchQuestion> getDomainClass() {
		return ResearchQuestion.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
