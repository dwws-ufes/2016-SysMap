package br.ufes.inf.nemo.marvin.sysmap.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class ControlArticle extends PersistentObjectSupport implements Comparable<ControlArticle> {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	/** The control article's identifier. */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String identifier;
	
	/** The control article's description. */
	@Basic
	@NotNull
	@Size(max = 255)
	protected String description;
	
	/** The control article's source. */
	@Basic
	@NotNull
	@Size(max = 100)
	protected String source;

	@ManyToOne
	protected SysMap sysmap;
	
	public SysMap getSysMap(){
		return sysmap;
	}
	
	public void setSysMap(SysMap sys){
		this.sysmap = sys;
	}
	
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(ControlArticle o) {
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
