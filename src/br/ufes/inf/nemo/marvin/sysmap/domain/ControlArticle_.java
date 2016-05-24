package br.ufes.inf.nemo.marvin.sysmap.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-22T23:31:27.155-0300")
@StaticMetamodel(ControlArticle.class)
public class ControlArticle_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<ControlArticle, String> identifier;
	public static volatile SingularAttribute<ControlArticle, String> description;
	public static volatile SingularAttribute<ControlArticle, String> source;
	public static volatile SingularAttribute<ControlArticle, SysMap> sysmap;
}
