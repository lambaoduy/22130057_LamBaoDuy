package Lab3;

import java.util.Arrays;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public double cost() {
		int result = 0;
		for (OrderItem orderItem : items) {
			result += orderItem.cost();
		}
		return result;
	}

	// using binary search approach
	public boolean contains(Product p) {
		Arrays.sort(items);
		int left = 0;
		int right = items.length - 1;
		boolean result = false;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (items[mid].getP().compare(p)==0) {
				result = true;
				break;
			} else {
				if (items[mid].getP().compare(p) > 0) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return result;
	}

	// get all products based on the given type using linear search
	public Product[] filter(String type) {
		// TODO
		int count=countType(type);	
		Product[] result= new Product[count];
		int j=0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getP().getType().equals(type)) {
				result[j]=items[i].getP();
				j+=1;
			} 
		}
		return result;
	}

	private int countType(String type) {
		// TODO Auto-generated method stub
		int result=0;
		for (OrderItem orderItem : items) {
			if (orderItem.getP().getType().equals(type)) {
				result++;
			}
		}
		return result;
	}

}
