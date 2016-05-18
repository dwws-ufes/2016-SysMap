package br.ufes.inf.nemo.marvin.sysmap.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.marvin.sysmap.domain.ResearchQuestion;
import br.ufes.inf.nemo.marvin.sysmap.persistence.ResearchQuestionDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageResearchQuestionServiceBean extends CrudServiceBean<ResearchQuestion>
		implements ManageResearchQuestionService {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ResearchQuestionDAO researchQuestionDAO; 
	
	@Override
	public BaseDAO<ResearchQuestion> getDAO() {
		return researchQuestionDAO;
	}

	@Override
	protected ResearchQuestion createNewEntity() {
		return new ResearchQuestion();
	}

}
