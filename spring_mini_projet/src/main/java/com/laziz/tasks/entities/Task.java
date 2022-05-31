package com.laziz.tasks.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idTask;

@NotNull
private String nomTask;

public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;

@ManyToOne
private Person person;

public Task() {
super();
}
public Task(String nomTask, Date dateCreation,Person person) {
super();
this.nomTask= nomTask;

this.dateCreation = dateCreation;
this.person=person;

}
public Long getIdTask() {
return idTask;
}
public void setIdTask(Long idTask) {
this.idTask= idTask;
}
public String getNomTask() {
return nomTask;
}
public void setNomTask(String nomTask) {
this.nomTask= nomTask;
}

public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;

}


@Override
public String toString() {
	return "Task [idTask=" + idTask+ ", nomTask=" + nomTask+", dateCreation=" + dateCreation + ", person=" + person + "]";
}

}
