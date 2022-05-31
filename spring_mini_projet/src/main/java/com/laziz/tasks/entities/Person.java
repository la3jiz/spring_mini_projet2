package com.laziz.tasks.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class Person {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idP;

private String nomP;
private String descriptionP;
@JsonIgnore
@OneToMany(mappedBy = "person")
private List<Task> Tasks;

public Person(Long idP,String nomP, String descriptionP, List<Task> Tasks) 
{
super();
this.idP=idP;
this.nomP= nomP;
this.descriptionP= descriptionP;
this.Tasks = Tasks;
}
public Long getIdP() {
return idP;
}
public void setIdP(Long idP) {
this.idP= idP;
}
public String getNomP() {
return nomP;
}
public void setNomP(String nomP) {
this.nomP= nomP;
}
public String getDescriptionP() {
return descriptionP;
}
public void setDescriptionCat(String descriptionP) {
this.descriptionP= descriptionP;
}
public List<Task> getTasks() {
return Tasks;
}
public void setTasks(List<Task> Tasks) {
this.Tasks = Tasks;
}
@Override
public String toString() {
	return "Person [idP=" + idP+ ", nomP=" + nomP+ ", descriptionP=" + descriptionP+ "]";
}
}