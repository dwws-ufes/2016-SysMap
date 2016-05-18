package br.ufes.inf.nemo.marvin.sysmap.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-04-24T11:46:33.967-0300")
@StaticMetamodel(SysMap.class)
public class SysMap_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<SysMap, String> name;
	public static volatile SingularAttribute<SysMap, String> objective;
	public static volatile SingularAttribute<SysMap, String> searchString;
	public static volatile SingularAttribute<SysMap, String> period;
	public static volatile SingularAttribute<SysMap, String> area;
	public static volatile SingularAttribute<SysMap, String> publicationTypes;
	public static volatile SingularAttribute<SysMap, Long> academic_id;
}
