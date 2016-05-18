package br.ufes.inf.nemo.marvin.sysmap.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.marvin.sysmap.domain.ControlArticle;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface ControlArticleDAO extends BaseDAO<ControlArticle> {

}
