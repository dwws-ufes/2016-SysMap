package br.ufes.inf.nemo.marvin.sysmap.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-04-24T14:13:27.382-0300")
@StaticMetamodel(ResearchQuestion.class)
public class ResearchQuestion_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<ResearchQuestion, String> identifier;
	public static volatile SingularAttribute<ResearchQuestion, String> description;
	public static volatile SingularAttribute<ResearchQuestion, String> rationale;
	public static volatile SingularAttribute<ResearchQuestion, String> possibleAnswer;
}
