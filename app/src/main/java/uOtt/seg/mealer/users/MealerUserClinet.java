package uOtt.seg.mealer.users;

import java.util.List;

import uOtt.seg.mealer.enums.EnumRegisterStatus;
import uOtt.seg.mealer.misc.CreditCardInfo;
import uOtt.seg.mealer.misc.Meal;
import uOtt.seg.mealer.misc.MealOrder;

public class MealerUserClinet extends  MealerUser{

    private CreditCardInfo cardInfo;


    private List<MealOrder> currentOrder;
    private List<MealOrder> historyOrder;

    public MealerUserClinet(String fName, String lName, String email, String pwd, String addr) {
        super(fName, lName, email, pwd, addr);
    }

    @Override
    public EnumRegisterStatus register() {
        EnumRegisterStatus regStatus = EnumRegisterStatus.SUCCESS;

        return regStatus;
    }

    public void rateOrder(MealOrder order, float rate) {
        Meal meal = order.getMeal();
        meal.setRating(rate);
    }

    public void complaint(MealOrder order, String msg) {
        order.setComplaintMsg(msg);
    }

}
