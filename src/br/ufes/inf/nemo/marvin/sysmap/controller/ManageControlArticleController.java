package br.ufes.inf.nemo.marvin.sysmap.controller;

import java.awt.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufes.inf.nemo.marvin.sysmap.application.ManageControlArticleService;
import br.ufes.inf.nemo.marvin.sysmap.application.ManageSysMapService;
import br.ufes.inf.nemo.marvin.sysmap.domain.ControlArticle;
import br.ufes.inf.nemo.marvin.sysmap.controller.ManageSysMapController;

import br.ufes.inf.nemo.marvin.sysmap.domain.SysMap;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageControlArticleController extends CrudController<ControlArticle> {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private ManageControlArticleService manageControlArticleService;
	
	@EJB 
	private ManageSysMapService manageSysMapService;
	
	@Inject 
	private ManageSysMapController manageSysMapController;
	
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
	
	protected String SMname;
	
	public String createEntity(){
			selectedEntity.setSysMap(manageSysMapService.retrieveByName(manageSysMapController.getSelectedEntity().getName()));
			//manageSysMapController.getSelectedEntity().addControlArticle(selectedEntity);
		return save();
	}

}
