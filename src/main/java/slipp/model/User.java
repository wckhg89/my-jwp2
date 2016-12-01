package slipp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true, length=20, nullable=false)
	private String userId;
	
	@Column(length=20, nullable=false)
	private String password;
	
	@Column(length=20, nullable=false)
	private String name;
	
	@Column(length=30)
	private String email;
	
	public void update(User user) {
		if(!password.equals(user.password)) {
			throw new IllegalArgumentException("비밀번호가 다릅니다.");
		}
			
		this.name = user.name;
		this.email = user.email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}


	
}
