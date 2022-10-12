package uOtt.seg.mealer.misc;

import java.util.Date;

public class CreditCardInfo {

    String holderName;
    String cardNum;
    String expireDate;  //"Mon/Year"
    int secCode;

    public CreditCardInfo (String hoderName, String cardNum, String expireDate, int secCode) {
        this.holderName = hoderName;
        this.cardNum = cardNum;
        this.expireDate = expireDate;
        this.secCode = secCode;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getSecCode() {
        return secCode;
    }

    public void setSecCode(int secCode) {
        this.secCode = secCode;
    }



}
