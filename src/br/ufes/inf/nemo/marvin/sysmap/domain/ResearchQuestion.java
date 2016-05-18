package br.ufes.inf.nemo.marvin.sysmap.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class ResearchQuestion extends PersistentObjectSupport implements Comparable<ResearchQuestion>{
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	/** The reserch question's identifier. */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String identifier;
	
	/** The reserch question's description. */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String description;
	
	/** The reserch question's rationale. */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String rationale;
	
	/** The reserch question's possible answer. */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String possibleAnswer;

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

	public String getRationale() {
		return rationale;
	}

	public void setRationale(String rationale) {
		this.rationale = rationale;
	}

	public String getPossibleAnswer() {
		return possibleAnswer;
	}

	public void setPossibleAnswer(String possibleAnswer) {
		this.possibleAnswer = possibleAnswer;
	}
	
	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(ResearchQuestion o) {
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
