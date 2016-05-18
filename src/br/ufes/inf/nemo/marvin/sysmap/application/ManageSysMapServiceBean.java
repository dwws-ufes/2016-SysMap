package br.ufes.inf.nemo.marvin.sysmap.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.marvin.sysmap.domain.SysMap;
import br.ufes.inf.nemo.marvin.sysmap.persistence.SysMapDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageSysMapServiceBean extends CrudServiceBean<SysMap> implements ManageSysMapService {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	/** The DAO for SysMap objects. */
	@EJB
	private SysMapDAO sysMapDAO;
	
	@Override
	public BaseDAO<SysMap> getDAO() {
		return sysMapDAO;
	}

	@Override
	protected SysMap createNewEntity() {
		return new SysMap();
	}

}
