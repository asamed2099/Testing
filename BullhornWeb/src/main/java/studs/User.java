package studs;



import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="bhusers")
@DynamicUpdate(value = true)
public class User {
		private int bhuser_id;
		@Id
		@Column(name="bhuser_id")
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		public int getBhuser_id() {
			return bhuser_id;
		}
		public void setBhuser_id(int bhuser_id) {
			this.bhuser_id = bhuser_id;
		}
		@Column(name="fullname")
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		@Column(name="password")
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Column(name="email")
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Column(name="phone")
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		@Column(name="motto")
		public String getMotto() {
			return motto;
		}
		public void setMotto(String motto) {
			this.motto = motto;
		}
		@Column(name="gender")
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		@Column(name="dob")
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		@Column(name="joindate")
		public Date getJoindate() {
			return joindate;
		}
		public void setJoindate(Date joindate) {
			this.joindate = joindate;
		}
		
		public User(String fullname, String password, String email,String phone,String gender,String dob,  String motto, Date joindate) {
			super();
			this.fullname = fullname;
			this.password = password;
			this.email = email;
			this.phone = phone;
			this.gender = gender;
			this.dob = dob;
			this.motto = motto;
			this.joindate = joindate;
		}
		private String fullname;
		public User(String fullname, String email, String phone, String dob, String motto) {
			super();
			this.fullname = fullname;
			this.email = email;
			this.phone = phone;
			this.dob = dob;
			this.motto = motto;
		}
		private String password;
		private String email; 
		private String phone ;
		private String gender ;
		private String dob;
		private String motto;
		private Date joindate;
		
	
	public User() {
		
	}

}
