package br.ufes.inf.nemo.marvin.sysmap.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.marvin.sysmap.domain.ResearchQuestion;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface ResearchQuestionDAO extends BaseDAO<ResearchQuestion> {

}
