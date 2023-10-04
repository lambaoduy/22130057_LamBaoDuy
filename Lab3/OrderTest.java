package Lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class OrderTest {
	
	public static void main(String[] args) {
		Product p1 = new Product("0001", "Sting", 10000, "Drink");
		Product p2 = new Product("0002", "Coca", 10000, "Drink");
		Product p3 = new Product("0003", "Chicken", 20000, "Food");
		Product p4 = new Product("0004", "Meat", 50000, "Food");
		Product p5 = new Product("0005", "Chocolate", 5000, "Candy");
		
		OrderItem oi1= new OrderItem(p1, 2);
		OrderItem oi2= new OrderItem(p2, 2);
		OrderItem oi3= new OrderItem(p3, 1);
		OrderItem oi4= new OrderItem(p4, 3);
		OrderItem oi5= new OrderItem(p5, 4);
		
		OrderItem[]list1 = {oi1,oi2,oi3,oi4,oi5};
		OrderItem[]list2 = {oi1,oi3,oi5};
		
		Order od1 =  new Order(list1);
		Order od2 =  new Order(list2);
//		System.out.println(od.cost());
//		System.out.println(Arrays.toString(list));
//		System.out.println(od2.contains(p3));
//		System.out.println(Arrays.toString(od1.filter("")));
		
	}

}
