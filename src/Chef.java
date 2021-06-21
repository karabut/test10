public class Chef implements Runnable{

    private final Meal meal;
    private final Restaurant restaurant;

    public Chef(Meal meal, Restaurant restaurant){
        this.meal = meal;
        this.restaurant = restaurant;
    }


    public void cook(){
        restaurant.orderIsDone();
        System.out.println("Cooking for " + restaurant.getNumberOfOrders() + " person");

    }

    @Override
    public void run() {
        while (restaurant.getNumberOfOrders() != 10)
        {
            cook();
            synchronized (meal)
            {
                meal.notify();
                try
                {
                    meal.wait();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }


    }

