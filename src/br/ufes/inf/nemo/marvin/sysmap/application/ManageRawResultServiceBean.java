package br.ufes.inf.nemo.marvin.sysmap.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.marvin.sysmap.domain.RawResult;
import br.ufes.inf.nemo.marvin.sysmap.persistence.RawResultDao;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageRawResultServiceBean extends CrudServiceBean<RawResult> implements ManageRawResultService {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RawResultDao rawResultDao;

	@Override
	public BaseDAO<RawResult> getDAO() {
		return rawResultDao;
	}

	@Override
	protected RawResult createNewEntity() {
		return new RawResult();
	}

}
