package uOtt.seg.mealer.users;

import android.media.Image;

import java.util.List;

import uOtt.seg.mealer.enums.EnumOrderStatus;
import uOtt.seg.mealer.enums.EnumRegisterStatus;
import uOtt.seg.mealer.misc.MealOrder;

public class MealerUserCook extends  MealerUser{

    private String cookDescription;
    private Image imgCheck;

    private List<MealOrder> orders;

    public MealerUserCook(String fName, String lName, String email, String pwd, String addr) {
        super(fName, lName, email, pwd, addr);
    }

    @Override
    public EnumRegisterStatus register() {
        EnumRegisterStatus regStatus = EnumRegisterStatus.SUCCESS;

        return regStatus;
    }

    public void processOrder(MealOrder order, EnumOrderStatus status) {
        order.setStatus(status);
    }

    public void updateOrder(MealOrder order, EnumOrderStatus status) {
        order.setStatus(status);
    }

}
