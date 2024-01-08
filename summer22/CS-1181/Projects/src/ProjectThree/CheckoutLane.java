package ProjectThree;

import java.util.*;

abstract class CheckoutLane extends LinkedList<Customer> implements Comparable<CheckoutLane> {

	private LinkedList<Customer> customers;

	public CheckoutLane() {
		this.customers = new LinkedList<>();
	}

	public int compareTo(CheckoutLane t) {
		if (this.customers.size() < t.customers.size()) {
			return -1;
		} else if (this.customers.size() > t.customers.size()) {
			return 1;
		} else {
			return 0;
		}
	}
}
