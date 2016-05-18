package br.ufes.inf.nemo.marvin.sysmap.domain;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class SysMap extends PersistentObjectSupport implements Comparable<SysMap> {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	/** The sysmap's name. */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String name;
	
	/** The sysmap's objective. */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String objective;
	
	/** The sysmap's search string. */
	@Lob
	@NotNull
	protected String searchString;
	
	/** The sysmap's period of search */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String period;
	
	/** The sysmap's field of knowledge */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String area;
	
//	public Academic getAcademic() {
//		return academic;
//	}
//
//	public void setAcademic(Academic academic) {
//		this.academic = academic;
//	}

	/** The sysmap's types of publications that are accepted */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String publicationTypes;
	
//	@ManyToOne
//	private Academic academic;
	
	protected Long academic_id;

	public Long getAcademic_id() {
		return academic_id;
	}

	public void setAcademic_id(Long academic_id) {
		this.academic_id = academic_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPublicationTypes() {
		return publicationTypes;
	}

	public void setPublicationTypes(String publicationTypes) {
		this.publicationTypes = publicationTypes;
	}
	
	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(SysMap o) {
		// Compare the persons' names
		if (name == null)
			return 1;
		if (o.name == null)
			return -1;
		int cmp = name.compareTo(o.name);
		if (cmp != 0)
			return cmp;

		// If it's the same name, check if it's the same entity.
		return uuid.compareTo(o.uuid);
	}

}