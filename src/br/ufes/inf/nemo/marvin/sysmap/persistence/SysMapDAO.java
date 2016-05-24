package br.ufes.inf.nemo.marvin.sysmap.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.marvin.sysmap.domain.SysMap;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface SysMapDAO extends BaseDAO<SysMap> {
	public SysMap retrieveByName(String x);
}
