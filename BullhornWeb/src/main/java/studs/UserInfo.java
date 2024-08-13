package studs;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "userinfo")
@DynamicUpdate(value = true)
public class UserInfo {
	

	public UserInfo(String jobtitle, String photo, String address, String city, String country, String bio,
			int userid, Date now) {
		super();
		this.jobtitle = jobtitle;
		this.photo = photo;
		this.address = address;
		this.city = city;
		this.country = country;
		this.bio = bio;
		this.userid = userid;
		this.updatedate =now;
	}

	@Id
	@Column(name="info_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	@Column(name="jobtitle")
	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	@Column(name="photo")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="bio")
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	@Column(name="userid")
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Column(name="updatedate")
	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	private int info_id;
	private String jobtitle; 
	private String photo ;
	private String address ;
	private String city;
	private String  country;
	private String bio;
	private int userid;
	private Date updatedate;

	public UserInfo() {
		
	}

}
