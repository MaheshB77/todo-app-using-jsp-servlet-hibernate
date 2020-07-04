package models;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	private String userName;
	private String userEmail;
	private Date userBirthDate;
	private String userPassword;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private List<TODO> todos=new LinkedList<TODO>();

	public Users(int userId, String userName, String userEmail, Date userBirthDate, String userPassword,
			List<TODO> todos) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userBirthDate = userBirthDate;
		this.userPassword = userPassword;
		this.todos = todos;
	}

	public Users(String userName, String userEmail, Date userBirthDate, String userPassword, List<TODO> todos) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userBirthDate = userBirthDate;
		this.userPassword = userPassword;
		this.todos = todos;
	}

	public Users(String userName, String userEmail, Date userBirthDate, String userPassword) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userBirthDate = userBirthDate;
		this.userPassword = userPassword;
	}

	public Users() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserBirthDate() {
		return userBirthDate;
	}

	public void setUserBirthDate(Date userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<TODO> getTodos() {
		return todos;
	}

	public void setTodos(List<TODO> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userBirthDate="
				+ userBirthDate + ", userPassword=" + userPassword + ", todos=" + todos + "]";
	}

	
}
