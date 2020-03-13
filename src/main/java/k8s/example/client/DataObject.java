package k8s.example.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.kubernetes.client.openapi.models.V1ObjectMeta;

public class DataObject {
	
	public static class LoginInDO {
    	private String id;
    	private String password;
    	
    	public String getId() { return id; }    	
    	public String getPassword() { return password; }
    }
	
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class TokenCR {
    	private String apiVersion = "tmax.co.kr/v1";
    	private String kind = "Token";
    	private V1ObjectMeta metadata;
    	private String accessToken;
    	private String refreshToken;
    	
    	public String getApiVersion() { return apiVersion; }
    	public String getKind() { return kind; }
    	public V1ObjectMeta getMetadata() { return metadata; }
    	public String getAccessToken() { return accessToken; }
    	public String getRefreshToken() { return refreshToken; }
    	
    	public void setApiVersion(String apiVersion) { this.apiVersion = apiVersion; }
    	public void setKind(String kind) { this.kind = kind; }
    	public void setMetadata(V1ObjectMeta metadata) { this.metadata = metadata; }
    	public void setAccessToken(String accessToken) { this.accessToken = accessToken; }    	
    	public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }
    }
    
    public static class Token {
    	private String accessToken;
    	private String refreshToken;
    	
    	public String getAccessToken() { return accessToken; }    	
    	public String getRefreshToken() { return refreshToken; }
    	
    	public void setAccessToken(String accessToken) { this.accessToken = accessToken; }    	
    	public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserCR {
    	private String apiVersion;
    	private String kind;
    	private V1ObjectMeta metadata;
    	private User userInfo;
    	private String status;
    	
    	public String getApiVersion() { return apiVersion; }
    	public String getKind() { return kind; }
    	public V1ObjectMeta getMetadata() { return metadata; }
    	public User getUserInfo() { return userInfo; }
    	public String getStatus() { return status; }
    	
    	public void setUserInfo(User userInfo) { this.userInfo = userInfo; }
    	public void setStatus(String status) { this.status = status; }
    }
    
    public static class User {
    	private String name;
    	private String password;
    	private String passwordSalt;
    	private String email;
    	private String phone;
    	private String department;
    	private String position;
    	private String description;
    	
    	public String getName() { return name; }
    	public String getPassword() { return password; }
    	public String getPasswordSalt() { return passwordSalt; }
    	public String getEmail() { return email; }
    	public String getPhone() { return phone; }
    	public String getDepartment() { return department; }
    	public String getPosition() { return position; }
    	public String getDescription() { return description; }
    	
    	public void setName(String name) { this.name = name; }
    	public void setPassword(String password) { this.password = password; }
    	public void setPasswordSalt(String passwordSalt) { this.passwordSalt = passwordSalt; }
    	public void setEmail(String email) { this.email = email; }
    	public void setPhone(String phone) { this.phone = phone; }
    	public void setDepartment(String department) { this.department = department; }
    	public void setPosition(String position) { this.position = position; }
    	public void setDescription(String description) { this.description = description; }
    }
    
    public static class TokenReview {
    	private String apiVersion = "authentication.k8s.io/v1beta1";
    	private String kind = "TokenReview";
    	private TokenReviewStatus status;
    	
    	public void setStatus(TokenReviewStatus status) { this.status = status; }    	
    }
    
    public static class TokenReviewStatus {
    	private boolean authenticated;
    	private TokenReviewUser user;
    	
    	public void setAuthenticated(boolean authenticated) { this.authenticated = authenticated; }    	
    	public void setUser(TokenReviewUser user) { this.user = user; }
    }
    
    public static class TokenReviewUser {
    	private String username;
    	private String uid;
    	
    	public void setUsername(String username) { this.username = username; }    	
    	public void setUid(String uid)	{ this.uid = uid; }
    }
    
}