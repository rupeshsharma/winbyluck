package com.wbl.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "J_USER")
public class UserModel implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3893301874833723552L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CONTACT")
	private String contact;

	@Column(name = "ENABLED")
	private Boolean enabled;

	@Column(name = "ACCOUN_NON_EXPIRED")
	private Boolean accountNonExpired;

	@Column(name = "ACCOUN_NON_LOCKED")
	private Boolean accountNonLocked;

	@Column(name = "CREDENTIALS_NON_EXPIRED")
	private Boolean credentialsNonExpired;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "J_USER_ROLE_MAPPING", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	private Set<RoleModel> roles = new HashSet<RoleModel>();

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "J_USER_TICKET_MAPPING", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "TICKET_ID") })
	private Set<TicketModel> tickets = new HashSet<TicketModel>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "J_USER_ADDRESS_MAPPING", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
	private Set<AddressModel> addresses = new HashSet<AddressModel>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleModel role : this.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<TicketModel> getTickets() {
		return tickets;
	}

	public void setTickets(Set<TicketModel> tickets) {
		this.tickets = tickets;
	}

	public Set<AddressModel> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressModel> addresses) {
		this.addresses = addresses;
	}

}
