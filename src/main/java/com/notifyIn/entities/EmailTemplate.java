package com.notifyIn.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the sms_templates database table.
 * 
 */
@Entity
@Table(name="email_templates")
@NamedQuery(name="EmailTemplate.findAll", query="SELECT s FROM EmailTemplate s")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope=EmailTemplate.class)
public class EmailTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="template_id")
	private int id;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private boolean isActive;

	@Column(name="template_name")
	private String templateName;

	@Column(name="template_text")
	private String templateText;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="created_by")
	private User emailUser;

	//bi-directional many-to-one association to ClientDetail
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="client_id")
	private ClientDetail clientDetail;

	//bi-directional many-to-one association to ModuleDetail
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="module_id")
	private ModuleDetail moduleDetail;

	public EmailTemplate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateText() {
		return this.templateText;
	}

	public void setTemplateText(String templateText) {
		this.templateText = templateText;
	}


	public User getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(User emailUser) {
		this.emailUser = emailUser;
	}

	public ClientDetail getClientDetail() {
		return this.clientDetail;
	}

	public void setClientDetail(ClientDetail clientDetail) {
		this.clientDetail = clientDetail;
	}

	public ModuleDetail getModuleDetail() {
		return this.moduleDetail;
	}

	public void setModuleDetail(ModuleDetail moduleDetail) {
		this.moduleDetail = moduleDetail;
	}

}