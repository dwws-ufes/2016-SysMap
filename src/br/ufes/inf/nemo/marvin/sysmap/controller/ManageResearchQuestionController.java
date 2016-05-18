package br.ufes.inf.nemo.marvin.sysmap.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.marvin.sysmap.application.ManageResearchQuestionService;
import br.ufes.inf.nemo.marvin.sysmap.domain.ResearchQuestion;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageResearchQuestionController extends CrudController<ResearchQuestion> {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private ManageResearchQuestionService manageResearchQuestionService;
	
	@Override
	protected CrudService<ResearchQuestion> getCrudService() {
		return manageResearchQuestionService;
	}

	@Override
	protected ResearchQuestion createNewEntity() {
		return new ResearchQuestion();
	}
	
	public ManageResearchQuestionController() {
	    viewPath = "/core/manageResearchQuestion/";
	    bundleName = "msgsSM";
	}

	@Override
	protected void initFilters() {

	}

}
