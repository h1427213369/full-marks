package cn.hlsxn.fullMarks.pojo;

public class User {
    private int uid;
    private String username;//用户名
    private String upassword;//密码
    private Long unumber;//手机号
    private String uemail;//邮箱
    private String uuid;//激活邮箱唯一验证码
    private int ustatus;//激活状态
    private String uname;//昵称
    private String uface;//头像
    private int ugrade;//分数
    private int ugold;//金币

    @Override
    public String toString() {
        return "UserPojo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", upassword='" + upassword + '\'' +
                ", unumber=" + unumber +
                ", uemail='" + uemail + '\'' +
                ", uuid='" + uuid + '\'' +
                ", ustatus=" + ustatus +
                ", uname='" + uname + '\'' +
                ", uface='" + uface + '\'' +
                ", ugrade=" + ugrade +
                ", ugold=" + ugold +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Long getUnumber() {
        return unumber;
    }

    public void setUnumber(Long unumber) {
        this.unumber = unumber;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUface() {
        return uface;
    }

    public void setUface(String uface) {
        this.uface = uface;
    }

    public int getUgrade() {
        return ugrade;
    }

    public void setUgrade(int ugrade) {
        this.ugrade = ugrade;
    }

    public int getUgold() {
        return ugold;
    }

    public void setUgold(int ugold) {
        this.ugold = ugold;
    }
}
