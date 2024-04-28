package api.endpoints;

public class Routes {
	/* 
	Create User	Post	https://petstore.swagger.io/v2/user/
	Get User 	https://Get	petstore.swagger.io/v2/user/{username}
	Update User	PUT	https://petstore.swagger.io/v2/user/{username}
	Delete User	Delete	https://petstore.swagger.io/v2/user/{username}
	 */
	public static String base_url = "https://petstore.swagger.io/v2";
	// user module urls
	public static String post_url = base_url + "/user/";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String del_url = base_url + "/user/{username}";
	

}


// we can maintain url in this class 