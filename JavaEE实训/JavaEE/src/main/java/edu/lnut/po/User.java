package edu.lnut.po;
/*
 * 用户信息表对象
 * */
public class User 
{
    private Integer userid;
    private String username;
    private String password;
    private String email;
    public Integer getUserid()
    {
        return userid;
    }
    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
}