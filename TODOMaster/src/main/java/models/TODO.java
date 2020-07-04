package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TODO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int todoId;
	
	private String todoName;
	private Date todoTargetDate;

	public TODO(String todoName, Date todoTargetDate) {
		super();
		this.todoName = todoName;
		this.todoTargetDate = todoTargetDate;
	}

	public TODO() {
		super();
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public Date getTodoTargetDate() {
		return todoTargetDate;
	}

	public void setTodoTargetDate(Date todoTargetDate) {
		this.todoTargetDate = todoTargetDate;
	}

	
	@Override
	public String toString() {
		return "TODO [todoId=" + todoId + ", todoName=" + todoName + ", todoTargetDate=" + todoTargetDate + "]";
	}
	
}
