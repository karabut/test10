public class Restaurant {

    private int numberOfOrders = 0;

    public void orderIsDone(){
        numberOfOrders++;
    }

    public int getNumberOfOrders(){
        return numberOfOrders;
    }
}
