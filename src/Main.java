/*
*
* Задача на многопоточность:
* У вас есть ресторан, в котором один шеф-повар и один официант.
* Официант должен ждать, пока повар приготовит блюдо.
* Как только повар заканчивает готовить блюдо, он дает официанту сигнал. Повар ждет, пока официант забирает блюдо.
* Официант забирает блюдо, доставляет его потребителю и возвращается к ожиданию следующего блюда.
* Ресторан делает 10 заказов, а после чего закрывается.
* Реализуйте класс Meal(ресурс), класс Waiter (официант\потребитель), класс Chef (производитель) и класс Restaurant.
*
* */


public class Main {


    public static void main(String[] args)
    {
        Meal meal = new Meal();
        Restaurant restaurant = new Restaurant();
        Thread waiter = new Thread(new Waiter(meal, restaurant));
        Thread chef = new Thread(new Chef(meal, restaurant));

        waiter.start();
        chef.start();
    }
}
