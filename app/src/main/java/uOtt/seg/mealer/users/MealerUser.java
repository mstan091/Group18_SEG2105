package uOtt.seg.mealer.users;

import uOtt.seg.mealer.enums.EnumLoginStatus;
import uOtt.seg.mealer.enums.EnumRegisterStatus;
import uOtt.seg.mealer.enums.EnumUserType;

public abstract class MealerUser {

    private short userID;
    private String fName;
    private String lName;
    private String email;
    private String pwd;
    private String Addr;

    private EnumUserType userType;

    public MealerUser(String fName, String lName, String email, String pwd, String addr) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.pwd = pwd;
        Addr = addr;
    }

    public short getUserID() {
        return userID;
    }

    public void setUserID(short userID) {
        this.userID = userID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public EnumUserType getUserType() {
        return userType;
    }

    public void setUserType(EnumUserType userType) {
        this.userType = userType;
    }



    public EnumLoginStatus login() {
        EnumLoginStatus loginStatus = EnumLoginStatus.SUCCESS;

        return loginStatus;
    }

    public abstract EnumRegisterStatus register();


}
