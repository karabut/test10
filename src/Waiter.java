public class Waiter implements Runnable{

    private final Meal meal;
    private final Restaurant restaurant;

    Waiter(Meal meal, Restaurant restaurant){
        this.meal = meal;
        this.restaurant = restaurant;
    }


    public void serve(){
        System.out.println("Serving for " + restaurant.getNumberOfOrders() + " person");
    }

    @Override
    public void run() {

        while (restaurant.getNumberOfOrders() != 10){
            synchronized (meal){
                try
                {
                    meal.wait();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            serve();
            synchronized (meal)
            {
                meal.notify();
            }
        }

    }
}
