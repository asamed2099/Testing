package studs;
import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name="bhposts")
@DynamicUpdate(value = true)
public class Post {
	private int post_id;
	private Date postdate;
	private String posttext ;
	private int bhuserId;
	private User user;


	public Post(Date postdate, String posttext,User user) {
		super();
		this.postdate = postdate;
		this.posttext = posttext;
		this.user = user;
	}
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	@Column(name="postdate")
	@Temporal(TemporalType.DATE)
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	@Column(name="posttext")
	public String getPosttext() {
		return posttext;
	}
	public void setPosttext(String posttext) {
		this.posttext = posttext;
	}
	
	/*@Column(name="bhuserId")
	public int getBhuserId() {
		return bhuserId;
	}
	public void setBhuserId(int bhuserId) {
		this.bhuserId = bhuserId;
	}
	*/
	// bi-directional many to one association user
	@ManyToOne
	@JoinColumn(name="bhuserId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Post() {
		
	}

}
