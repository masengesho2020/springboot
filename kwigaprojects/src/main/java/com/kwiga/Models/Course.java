package com.kwiga.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long courseId;
	
	@Column(name="coursename")
//	@NotEmpty 
//	@Size(min=6, max=25, message="{courseName.error}")
	private String courseName;
	
	@Column(name="coursedescription")
//	@NotEmpty 
//	@Size(min=6, max=25, message="{courseDescription.error}")
	private String courseDescription;
	
	@Column(name="courseprice")
//	@NotEmpty 
	private double coursePrice;
	
	@Column(name="coursedate")
//	@NotEmpty 
	//@JsonDate("dd/MM/yyyy")
	@JsonFormat(pattern="yyyy-MM-dd")
	
	private Date courseAddedDate;
	
//	@OneToMany
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	@OneToMany( cascade = CascadeType.ALL)
//	@JsonIgnore 
//	@Valid
	private List<Lesson> lesson;
	
//	@OneToOne
	@OneToOne(cascade =  CascadeType.ALL)
//	@Valid
	private Duration courseDuration;
	
//	@ManyToOne
    @ManyToOne(cascade = CascadeType.ALL)
	private User courseTeacher;
    
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
      @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private List<User> courseStudents;
    
    @Column(name="courseapprovedstatus")
//	@NotEmpty 
	private int courseApprovedStatus;
    @Column(name="courselivestatus")
//  @NotEmpty 
	private int courseLiveStatus;
    
    @Column(name="courserate")
//  @NotEmpty 
	private int courseRate;
    
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public double getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}
	public Date getCourseAddedDate() {
		return courseAddedDate;
	}
	public void setCourseAddedDate(Date courseAddedDate) {
		this.courseAddedDate = courseAddedDate;
	}
	public List<Lesson> getLesson() {
		return lesson;
	}
	public void setLesson(List<Lesson> lesson) {
		this.lesson = lesson;
	}
	public Duration getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(Duration courseDuration) {
		this.courseDuration = courseDuration;
	}
	public User getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(User courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public List<User> getCourseStudents() {
		return courseStudents;
	}
	public void setCourseStudents(List<User> courseStudents) {
		this.courseStudents = courseStudents;
	}
	public int isCourseApprovedStatus() {
		return courseApprovedStatus;
	}
	public void setCourseApprovedStatus(int courseApprovedStatus) {
		this.courseApprovedStatus = courseApprovedStatus;
	}
	public int isCourseLiveStatus() {
		return courseLiveStatus;
	}
	public void setCourseLiveStatus(int courseLiveStatus) {
		this.courseLiveStatus = courseLiveStatus;
	}
	public int getCourseRate() {
		return courseRate;
	}
	public void setCourseRate(int courseRate) {
		this.courseRate = courseRate;
	}
	
	public int getCourseApprovedStatus() {
		return courseApprovedStatus;
	}
	public int getCourseLiveStatus() {
		return courseLiveStatus;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", coursePrice=" + coursePrice + ", courseAddedDate=" + courseAddedDate
				+ ", lesson=" + lesson + ", courseDuration=" + courseDuration + ", courseTeacher=" + courseTeacher
				+ ", courseStudents=" + courseStudents + ", courseApprovedStatus=" + courseApprovedStatus
				+ ", courseLiveStatus=" + courseLiveStatus + ", courseRate=" + courseRate + "]";
	}
	
}
