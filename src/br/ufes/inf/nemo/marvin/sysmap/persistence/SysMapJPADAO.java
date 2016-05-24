package br.ufes.inf.nemo.marvin.sysmap.persistence;

import java.awt.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	//Retorna sysmap com o nome selecionado
	public SysMap retrieveByName(String x){
		String quer = "select s from SysMap s where s.name = :x";
		TypedQuery<SysMap> query = entityManager.createQuery(quer, SysMap.class);
		query.setParameter("x", x);
		return query.getSingleResult();
	}

}
