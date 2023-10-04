package Lab3;

public class OrderItem implements Comparable<OrderItem> {
	private Product p;
	private int quality;

	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}

	public double cost() {
		return this.quality * this.p.getPrice();
	}

	@Override
	public int compareTo(OrderItem o) {

		return p.compare(o.p);
	}

	@Override
	public String toString() {
		return "OrderItem [p=" + p + ", quality=" + quality + "]";
	}

	public Product getP() {
		return p;
	}

}
