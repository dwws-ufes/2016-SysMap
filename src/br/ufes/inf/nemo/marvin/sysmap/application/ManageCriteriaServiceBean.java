package br.ufes.inf.nemo.marvin.sysmap.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.marvin.sysmap.domain.Criteria;
import br.ufes.inf.nemo.marvin.sysmap.persistence.CriteriaDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageCriteriaServiceBean extends CrudServiceBean<Criteria> implements ManageCriteriaService {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CriteriaDAO criteriaDAO;
	
	@Override
	public BaseDAO<Criteria> getDAO() {
		return criteriaDAO;
	}

	@Override
	protected Criteria createNewEntity() {
		return new Criteria();
	}

}
