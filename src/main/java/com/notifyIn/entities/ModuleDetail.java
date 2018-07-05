package com.notifyIn.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the module_details database table.
 * 
 */
@Entity
@Table(name="module_details")
@NamedQuery(name="ModuleDetail.findAll", query="SELECT m FROM ModuleDetail m")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope=ModuleDetail.class)
public class ModuleDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="module_id")
	private int id;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String description;

	@Column(name="is_active")
	private boolean isActive;

	@Column(name="module_name")
	private String moduleName;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="created_by")
	private User moduleUer;

	//bi-directional many-to-one association to ClientDetail
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="client_id")
	private ClientDetail clientDetail;

	//bi-directional many-to-one association to SmsTemplate
	@OneToMany(mappedBy="moduleDetail")
	private List<SmsTemplate> smsTemplates;

	public ModuleDetail() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public User getModuleUer() {
		return this.moduleUer;
	}

	public void setModuleUer(User moduleUer) {
		this.moduleUer = moduleUer;
	}

	public ClientDetail getClientDetail() {
		return this.clientDetail;
	}

	public void setClientDetail(ClientDetail clientDetail) {
		this.clientDetail = clientDetail;
	}

	public List<SmsTemplate> getSmsTemplates() {
		return this.smsTemplates;
	}

	public void setSmsTemplates(List<SmsTemplate> smsTemplates) {
		this.smsTemplates = smsTemplates;
	}

	public SmsTemplate addSmsTemplate(SmsTemplate smsTemplate) {
		getSmsTemplates().add(smsTemplate);
		smsTemplate.setModuleDetail(this);

		return smsTemplate;
	}

	public SmsTemplate removeSmsTemplate(SmsTemplate smsTemplate) {
		getSmsTemplates().remove(smsTemplate);
		smsTemplate.setModuleDetail(null);

		return smsTemplate;
	}

}