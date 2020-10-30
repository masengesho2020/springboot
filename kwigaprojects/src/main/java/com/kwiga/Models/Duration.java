package com.kwiga.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="duration")
public class Duration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id", updatable = false, nullable = false)
	private long durationId;
	
	@Column(name="hours")
//	@NotEmpty 
//	@Size(min=1, message="{hours.error}")
	private String hours;
	
	@Column(name="minutes")
//	@NotEmpty 
//	@Size(min=1, message="{minutes.error}")
	private String minutes;
	
	@Column(name="seconds")
//	@NotEmpty 
//	@Size(min=1, message="{seconds.error}")
	private String second;
	
	public long getDurationId() {
		return durationId;
	}
	public void setDurationId(long durationId) {
		this.durationId = durationId;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getMinutes() {
		return minutes;
	}
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	 
	@Override
	public String toString() {
		return "Duration [durationId=" + durationId + ", hours=" + hours + ", minutes=" + minutes + ", second=" + second
				+ "]";
	}
}
