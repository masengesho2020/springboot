package com.kwiga.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="material")
public class Material {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long materialId;
	
	@Column(name="materiallink")
//	@NotEmpty 
	private String materialLink;
	
	@Column(name="materialname")
//	@NotEmpty 
	private String materialMedias;
	
	@Column(name="materialaddeddate")
//	@NotEmpty 
	private Date materialAddedDate;
	
	@Column(name="materiallivestatus")
//	@NotEmpty 
	private int materialLiveStatus;
	
	public long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}
	public String getMaterialLink() {
		return materialLink;
	}
	public void setMaterialLink(String materialLink) {
		this.materialLink = materialLink;
	}
	public String getMaterialMedias() {
		return materialMedias;
	}
	public void setMaterialMedias(String materialMedias) {
		this.materialMedias = materialMedias;
	}
	public Date getMaterialAddedDate() {
		return materialAddedDate;
	}
	public void setMaterialAddedDate(Date materialAddedDate) {
		this.materialAddedDate = materialAddedDate;
	}
	public int isMaterialLiveStatus() {
		return materialLiveStatus;
	}
	public void setMaterialLiveStatus(int materialLiveStatus) {
		this.materialLiveStatus = materialLiveStatus;
	}
	public int getMaterialLiveStatus() {
		return materialLiveStatus;
	}
	
	@Override
	public String toString() {
		return "Material [materialId=" + materialId + ", materialLink=" + materialLink + ", materialMedias="
				+ materialMedias + ", materialAddedDate=" + materialAddedDate + ", materialLiveStatus="
				+ materialLiveStatus + "]";
	}
}
