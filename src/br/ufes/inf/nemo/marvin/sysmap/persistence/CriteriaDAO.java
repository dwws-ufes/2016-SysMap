package br.ufes.inf.nemo.marvin.sysmap.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.marvin.sysmap.domain.Criteria;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface CriteriaDAO extends BaseDAO<Criteria> {

}
