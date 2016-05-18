package br.ufes.inf.nemo.marvin.sysmap.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.ufes.inf.nemo.marvin.sysmap.application.ManageCriteriaService;
import br.ufes.inf.nemo.marvin.sysmap.domain.Criteria;
import br.ufes.inf.nemo.marvin.sysmap.domain.CriteriaType;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageCriteriaController extends CrudController<Criteria> {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private ManageCriteriaService manageCriteriaService;
	
	private static List<SelectItem> listCriteriaType;
	
	@Override
	protected CrudService<Criteria> getCrudService() {
		return manageCriteriaService;
	}

	@Override
	protected Criteria createNewEntity() {
		return new Criteria();
	}
	
	public ManageCriteriaController() {
	    viewPath = "/core/manageCriteria/";
	    bundleName = "msgsSM";
	}

	@Override
	protected void initFilters() {

	}
	
	public List<SelectItem> getList() {
		if (listCriteriaType == null) {
			listCriteriaType = new ArrayList<SelectItem>();
			CriteriaType[] tiposEquipamento = CriteriaType.values();
			for(CriteriaType tipoEquipamento : tiposEquipamento){
				listCriteriaType.add(new SelectItem(tipoEquipamento));
			}
		}
		return listCriteriaType;
	}

	public static List<SelectItem> getListCriteriaType() {
		return listCriteriaType;
	}

	public static void setListCriteriaType(List<SelectItem> listCriteriaType) {
		ManageCriteriaController.listCriteriaType = listCriteriaType;
	}

}
