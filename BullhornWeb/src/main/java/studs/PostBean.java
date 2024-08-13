package studs;

import java.util.List;

import service.DbPostOperations;

public class PostBean {

	public PostBean() {
		// TODO Auto-generated constructor stub
	}
	public static List<Post> userPosts(long id){
	List<Post>	userposts =null;
	userposts =	DbPostOperations.listPostOfUser(id);
	return userposts;
	}
}
