package br.ufes.inf.nemo.marvin.sysmap.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.marvin.sysmap.application.ManageControlArticleService;
import br.ufes.inf.nemo.marvin.sysmap.domain.ControlArticle;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageControlArticleController extends CrudController<ControlArticle> {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private ManageControlArticleService manageControlArticleService;
	
	@Override
	protected CrudService<ControlArticle> getCrudService() {
		return manageControlArticleService;
	}

	@Override
	protected ControlArticle createNewEntity() {
		return new ControlArticle();
	}
	
	public ManageControlArticleController() {
	    viewPath = "/core/manageControlArticle/";
	    bundleName = "msgsSM";
	}

	@Override
	protected void initFilters() {
	}

}
