package zh.base.pojo.po;

import java.util.List;

public class Tuser {
	
	
	private List<Tuserrole> userRoles;
	
    public List<Tuserrole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Tuserrole> userRoles) {
		this.userRoles = userRoles;
	}

	private String id;

    private String username;

    private String pwd;

    private String usercode;

    private String salt;

    private String locked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked == null ? null : locked.trim();
    }
}