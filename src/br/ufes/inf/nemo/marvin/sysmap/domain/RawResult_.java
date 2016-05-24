package br.ufes.inf.nemo.marvin.sysmap.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-23T22:40:43.979-0300")
@StaticMetamodel(RawResult.class)
public class RawResult_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<RawResult, String> source;
	public static volatile SingularAttribute<RawResult, Long> year;
	public static volatile SingularAttribute<RawResult, String> title;
	public static volatile SingularAttribute<RawResult, String> authors;
	public static volatile SingularAttribute<RawResult, String> venue;
	public static volatile SingularAttribute<RawResult, String> DOI;
	public static volatile SingularAttribute<RawResult, String> publicationAbstract;
	public static volatile SingularAttribute<RawResult, String> keywords;
}
