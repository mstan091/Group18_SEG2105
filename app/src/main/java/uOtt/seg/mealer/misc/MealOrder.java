package uOtt.seg.mealer.misc;

import java.util.Date;

import uOtt.seg.mealer.enums.EnumOrderStatus;
import uOtt.seg.mealer.users.MealerUserClinet;

public class MealOrder {

    private int orderNum;
    private Meal meal;
    private Date orderTime;
    private Date pickupTime;
    private EnumOrderStatus status;

    private MealerUserClinet client;
    private int rate;
    private String complaintMsg;

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }


    public EnumOrderStatus getStatus() {
        return status;
    }

    public void setStatus(EnumOrderStatus status) {
        this.status = status;
    }


    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComplaintMsg() {
        return  complaintMsg;
    }

    public void setComplaintMsg(String msg) {
        this.complaintMsg = complaintMsg;
    }

}
