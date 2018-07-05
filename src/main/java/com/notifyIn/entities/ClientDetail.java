package com.notifyIn.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the client_details database table.
 * 
 */
@Entity
@Table(name="client_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope=ClientDetail.class)
public class ClientDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="client_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="access_key")
	private String accessKey;

	@Column(name="client_name")
	private String clientName;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String decription;

	@Column(name="is_active")
	private boolean isActive;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User clientUser;

	//bi-directional many-to-one association to ModuleDetail
	@OneToMany(mappedBy="clientDetail")
	private List<ModuleDetail> moduleDetails;

	//bi-directional many-to-one association to SmsTemplate
	@OneToMany(mappedBy="clientDetail")
	private List<SmsTemplate> smsTemplates;

	public ClientDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessKey() {
		return this.accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getDecription() {
		return this.decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getClientUser() {
		return this.clientUser;
	}

	public void setClientUser(User clientUser) {
		this.clientUser = clientUser;
	}

	public List<ModuleDetail> getModuleDetails() {
		return this.moduleDetails;
	}

	public void setModuleDetails(List<ModuleDetail> moduleDetails) {
		this.moduleDetails = moduleDetails;
	}

	public ModuleDetail addModuleDetail(ModuleDetail moduleDetail) {
		getModuleDetails().add(moduleDetail);
		moduleDetail.setClientDetail(this);

		return moduleDetail;
	}

	public ModuleDetail removeModuleDetail(ModuleDetail moduleDetail) {
		getModuleDetails().remove(moduleDetail);
		moduleDetail.setClientDetail(null);

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
		smsTemplate.setClientDetail(this);

		return smsTemplate;
	}

	public SmsTemplate removeSmsTemplate(SmsTemplate smsTemplate) {
		getSmsTemplates().remove(smsTemplate);
		smsTemplate.setClientDetail(null);

		return smsTemplate;
	}
}