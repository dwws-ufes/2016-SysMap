package br.ufes.inf.nemo.marvin.sysmap.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.marvin.sysmap.application.ManageCriteriaService;
import br.ufes.inf.nemo.marvin.sysmap.application.ManageSysMapService;
import br.ufes.inf.nemo.marvin.sysmap.domain.SysMap;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageSysMapController extends CrudController<SysMap> {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private ManageSysMapService manageSysMapService;
	
	@Override
	protected CrudService<SysMap> getCrudService() {
		return manageSysMapService;
	}
	
	public ManageSysMapController() {
	    viewPath = "/core/manageSysMap/";
	    bundleName = "msgsSM";
	}

	@Override
	protected SysMap createNewEntity() {
		return new SysMap();
	}

	@Override
	protected void initFilters() {

	}

}
