package com.kwiga.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lesson")
public class Lesson  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long lessonId;
	
	@Column(name="lessontopic")
//	@NotEmpty 
//	@Size(min=6, max=100, message="{lessonTopic.error}")
	private String lessonTopic;
	
	@Column(name="lessondescription")
//	@NotEmpty 
//	@Size(min=50, max=1000, message="{lessonDescription.error}")
	private String lessonDescription;
	
	@Column(name="lessonMaterial")
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Material> lessonMaterial;
	
//	@OneToOne
//	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@OneToOne(cascade = CascadeType.ALL)
//	@JsonIgnore 
	private Duration duration;
	
	@Column(name="lessonlivestatus")
//	@NotEmpty 
	private int lessonLiveStatus;
	
	public long getLessonId() {
		return lessonId;
	}
	public void setLessonId(long lessonId) {
		this.lessonId = lessonId;
	}
	public String getLessonTopic() {
		return lessonTopic;
	}
	public void setLessonTopic(String lessonTopic) {
		this.lessonTopic = lessonTopic;
	}
	public String getLessonDescription() {
		return lessonDescription;
	}
	public void setLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}
	public List<Material> getLessonMaterial() {
		return lessonMaterial;
	}
	public void setLessonMaterial(List<Material> lessonMaterial) {
		this.lessonMaterial = lessonMaterial;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public int isLessonLiveStatus() {
		return lessonLiveStatus;
	}
	public void setLessonLiveStatus(int lessonLiveStatus) {
		this.lessonLiveStatus = lessonLiveStatus;
	}
	
	public int getLessonLiveStatus() {
		return lessonLiveStatus;
	}
	
	@Override
	public String toString() {
		return "Lesson [lessonId=" + lessonId + ", lessonTopic=" + lessonTopic + ", lessonDescription="
				+ lessonDescription + ", lessonMaterial=" + lessonMaterial + ", duration=" + duration
				+ ", lessonLiveStatus=" + lessonLiveStatus + "]";
	}

}
