package br.ufes.inf.nemo.marvin.sysmap.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.marvin.sysmap.domain.ResearchQuestion;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageResearchQuestionService extends CrudService<ResearchQuestion> {

}
