package uOtt.seg.mealer.misc;

import uOtt.seg.mealer.users.MealerUserCook;

public class Meal {
    private short mealID;
    private String mealName;
    private String mealType;
    private String cuisineType;

    private float price;
    private float rating;
    private MealerUserCook cook;


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }






}
