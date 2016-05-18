package br.ufes.inf.nemo.marvin.sysmap.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.marvin.sysmap.domain.ControlArticle;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ControlArticleJPADAO extends BaseJPADAO<ControlArticle> implements ControlArticleDAO {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Class<ControlArticle> getDomainClass() {
		return ControlArticle.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
