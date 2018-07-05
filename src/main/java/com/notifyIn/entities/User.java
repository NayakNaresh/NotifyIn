package com.notifyIn.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private Long id;

	private String email;

	@Column(name="is_active")
	private boolean isActive;

	private String password;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to ClientDetail
	@OneToMany(mappedBy="clientUser")
	@JsonIgnore
	private List<ClientDetail> clientDetails;

	//bi-directional many-to-one association to ModuleDetail
	@OneToMany(mappedBy="moduleUer")
	@JsonIgnore
	private List<ModuleDetail> moduleDetails;

	//bi-directional many-to-one association to SmsTemplate
	@OneToMany(mappedBy="smsUser")
	@JsonIgnore
	private List<SmsTemplate> smsTemplates;
	
	//bi-directional many-to-one association to SmsTemplate
		@OneToMany(mappedBy="emailUser")
		@JsonIgnore
		private List<EmailTemplate> emailTemplates;

	public User() {
	}

	
	
	public List<EmailTemplate> getEmailTemplates() {
		return emailTemplates;
	}



	public void setEmailTemplates(List<EmailTemplate> emailTemplates) {
		this.emailTemplates = emailTemplates;
	}



	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<ClientDetail> getClientDetails() {
		return this.clientDetails;
	}

	public void setClientDetails(List<ClientDetail> clientDetails) {
		this.clientDetails = clientDetails;
	}

	public ClientDetail addClientDetail(ClientDetail clientDetail) {
		getClientDetails().add(clientDetail);
		clientDetail.setClientUser(this);

		return clientDetail;
	}

	public ClientDetail removeClientDetail(ClientDetail clientDetail) {
		getClientDetails().remove(clientDetail);
		clientDetail.setClientUser(null);

		return clientDetail;
	}

	public List<ModuleDetail> getModuleDetails() {
		return this.moduleDetails;
	}

	public void setModuleDetails(List<ModuleDetail> moduleDetails) {
		this.moduleDetails = moduleDetails;
	}

	public ModuleDetail addModuleDetail(ModuleDetail moduleDetail) {
		getModuleDetails().add(moduleDetail);
		moduleDetail.setModuleUer(this);

		return moduleDetail;
	}

	public ModuleDetail removeModuleDetail(ModuleDetail moduleDetail) {
		getModuleDetails().remove(moduleDetail);
		moduleDetail.setModuleUer(null);

		return moduleDetail;
	}

	public List<SmsTemplate> getSmsTemplates() {
		return this.smsTemplates;
	}

	public void setSmsTemplates(List<SmsTemplate> smsTemplates) {
		this.smsTemplates = smsTemplates;
	}

	public SmsTemplate addSmsTemplate(SmsTemplate smsTemplate) {
		getSmsTemplates().add(smsTemplate);
		smsTemplate.setSmsUser(this);

		return smsTemplate;
	}

	public SmsTemplate removeSmsTemplate(SmsTemplate smsTemplate) {
		getSmsTemplates().remove(smsTemplate);
		smsTemplate.setSmsUser(null);

		return smsTemplate;
	}
}