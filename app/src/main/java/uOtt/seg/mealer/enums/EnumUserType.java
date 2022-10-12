package uOtt.seg.mealer.enums;

public enum EnumUserType {
    Client("Client"),
    Cook("Cook"),
    Admin("Administrator");

    private String userType;
    private EnumUserType(String userType) {

        this.userType = userType;
    }

    @Override
    public String toString(){
        return userType;
    }

}
