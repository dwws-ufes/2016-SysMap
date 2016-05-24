package br.ufes.inf.nemo.marvin.sysmap.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.marvin.sysmap.application.ManageRawResultService;
import br.ufes.inf.nemo.marvin.sysmap.domain.RawResult;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageRawResultController extends CrudController<RawResult> {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageRawResultService manageRawResultService;
	
	@Override
	protected CrudService<RawResult> getCrudService() {
		return manageRawResultService;
	}

	@Override
	protected RawResult createNewEntity() {
		return new RawResult();
	}
	
	public ManageRawResultController() {
	    viewPath = "/core/manageRawResult/";
	    bundleName = "msgsSM";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
	}

}
