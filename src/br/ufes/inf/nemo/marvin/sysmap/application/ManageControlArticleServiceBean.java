package br.ufes.inf.nemo.marvin.sysmap.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.marvin.sysmap.domain.ControlArticle;
import br.ufes.inf.nemo.marvin.sysmap.persistence.ControlArticleDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageControlArticleServiceBean extends CrudServiceBean<ControlArticle>
		implements ManageControlArticleService {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ControlArticleDAO controlArticleDAO;
	
	@Override
	public BaseDAO<ControlArticle> getDAO() {
		return controlArticleDAO;
	}
	
	public List<ControlArticle> listArticles(){
		return controlArticleDAO.retrieveAll();
	}

	@Override
	protected ControlArticle createNewEntity() {
		return new ControlArticle();
	}

}
