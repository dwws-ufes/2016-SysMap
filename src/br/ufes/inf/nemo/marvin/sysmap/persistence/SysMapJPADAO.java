package br.ufes.inf.nemo.marvin.sysmap.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.marvin.sysmap.domain.SysMap;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class SysMapJPADAO extends BaseJPADAO<SysMap> implements SysMapDAO {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext 
	private EntityManager entityManager;

	@Override
	public Class<SysMap> getDomainClass() {
		return SysMap.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
