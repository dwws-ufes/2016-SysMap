package br.ufes.inf.nemo.marvin.sysmap.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.marvin.sysmap.domain.RawResult;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class RawResultJPADAO extends BaseJPADAO<RawResult> implements RawResultDao {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Class<RawResult> getDomainClass() {
		return RawResult.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
