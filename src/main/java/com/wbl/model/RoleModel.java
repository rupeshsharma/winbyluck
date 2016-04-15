package com.wbl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "J_ROLE")
public class RoleModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6434134348180711504L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "alias")
	private String alias;

	public RoleModel(Long id) {
		this.id = id;
	}

	public RoleModel() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
