package uOtt.seg.mealer.enums;

public enum EnumLoginStatus {
    SUCCESS("Success"),
    USER_NOT_FOUND("UserNotFound"),
    INVALID_PWD("InvalidPwd");

    private String loginStatus;
    EnumLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return loginStatus;
    }

}
