package br.ufes.inf.nemo.marvin.sysmap.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Criteria extends PersistentObjectSupport implements Comparable<Criteria> {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	/** The criteria's identifier. */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String identifier;
	
	/** The criteria's description. */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String description;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	protected CriteriaType criteriaType;
	
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CriteriaType getCriteriaType() {
		return criteriaType;
	}

	public void setCriteriaType(CriteriaType criteriaType) {
		this.criteriaType = criteriaType;
	}
	
	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(Criteria o) {
		// Compare the persons' names
		if (identifier == null)
			return 1;
		if (o.identifier == null)
			return -1;
		int cmp = identifier.compareTo(o.identifier);
		if (cmp != 0)
			return cmp;

		// If it's the same name, check if it's the same entity.
		return uuid.compareTo(o.uuid);
	}
	
	
}
