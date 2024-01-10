package ProjectThree;

import java.io.*;
import java.util.*;

public class Simulator {

    public static void main(String[] args) throws FileNotFoundException {

        PriorityQueue<Event> events = new PriorityQueue<>();
        ArrayList<Customer> customers = new ArrayList<>();    
		PriorityQueue<RegularCheckout> regularCheckoutLane = new PriorityQueue<>();
		PriorityQueue<ExpressCheckout> expressCheckoutLane = new PriorityQueue<>();

		int regularLanes = 9;
		int expressLanes = 3;

		for (int i = 0; i <= regularLanes; i++) {
			RegularCheckout regularLane = new RegularCheckout();
			regularCheckoutLane.add(regularLane);
		}

		for (int i = 0; i <= expressLanes; i++) {
			ExpressCheckout expressLane = new ExpressCheckout();
			expressCheckoutLane.add(expressLane);
		}

		Scanner data = new Scanner(new File("projects/src/txt/arrival medium.txt"));

		while (data.hasNextLine()) {
			String customerDetails = data.nextLine();
			String[] eachDetail = customerDetails.split("\t");
			double arrivalTime = Double.parseDouble(eachDetail[0]);
			int numItems = Integer.parseInt(eachDetail[1]);
			double timePerItem = Double.parseDouble(eachDetail[2]);

			Customer customer = new Customer(arrivalTime, numItems, timePerItem);
			customers.add(customer);
			ArrivalEvent arrival = new ArrivalEvent(customer, arrivalTime);
			events.offer(arrival);
		}

		int numCustomers = 0;
		// double simClock = 0.0;

		while (!events.isEmpty()) {
			Event thisEvent = events.poll();
			Customer thisCustomer = customers.get(numCustomers);

			if (thisEvent instanceof ArrivalEvent) {
				FinishedShoppingEvent finishedShopping = new FinishedShoppingEvent(thisCustomer, thisCustomer.getArrivalTime());
				events.add(finishedShopping);
			} else if (thisEvent instanceof FinishedShoppingEvent) {
				if (thisCustomer.getNumItems() > 12) {
					RegularCheckout regularLane = regularCheckoutLane.poll();
					regularLane.add(thisCustomer);
					regularCheckoutLane.offer(regularLane);
				} else {
					RegularCheckout regularLane = regularCheckoutLane.peek();
					ExpressCheckout expressLane = expressCheckoutLane.peek();
					if (regularLane.size() > expressLane.size()) {
						expressLane = expressCheckoutLane.poll();
						expressLane.add(thisCustomer);
						expressCheckoutLane.offer(expressLane);
					} else if (regularLane.size() < expressLane.size()) {
						regularLane = regularCheckoutLane.poll();
						regularLane.add(thisCustomer);
						regularCheckoutLane.offer(regularLane);
					} else {
						if (thisCustomer.getNumItems() <= 12) {
							expressLane = expressCheckoutLane.poll();
							expressLane.add(thisCustomer);
							expressCheckoutLane.offer(expressLane);
						} else {
							int pickLane = (int) (Math.random() * 2) + 1;
							if (pickLane == 1) {
								regularLane = regularCheckoutLane.poll();
								regularLane.add(thisCustomer);
								regularCheckoutLane.offer(regularLane);
							} else {
								expressLane = expressCheckoutLane.poll();
								expressLane.add(thisCustomer);
								expressCheckoutLane.offer(expressLane);
							}
						}
					}
				}

				RegularCheckout checkRegularLane = regularCheckoutLane.poll();
				ExpressCheckout checkExpressLane = expressCheckoutLane.poll();

				if ((regularCheckoutLane.size() == 1 && checkRegularLane.contains(thisCustomer)) || (expressCheckoutLane.size() == 1 && checkExpressLane.contains(thisCustomer))) {
					thisCustomer.getFinishedCheckoutTime();
					FinishedCheckoutEvent finishedCheckingOut = new FinishedCheckoutEvent(thisCustomer, thisCustomer.getArrivalTime());
					events.add(finishedCheckingOut);
				}
			} else if (thisEvent instanceof FinishedCheckoutEvent) {
				RegularCheckout checkRegularLane = regularCheckoutLane.poll();
				ExpressCheckout checkExpressLane = expressCheckoutLane.poll();

				if (checkRegularLane.contains(thisCustomer)) {
					checkRegularLane.remove(thisCustomer);
				} else if (checkExpressLane.contains(thisCustomer)) {
					checkExpressLane.remove(thisCustomer);
				}
			}

			// simClock = thisEvent.getTime();
			numCustomers++;
		}

        	// if this is a FinishedCheckoutEvent, remove the associated customer from the checkout lane they were in
        	// if there is anyone else still in that checkout lane, compute that customer's endCheckoutTime, set the 
        	// attribute, create the customer's FinishedCheckoutEvent, and add the event to the events pq

			double totalWait = 0.0;
			double averageWait = 0.0;
			for (int i = 0; i < customers.size(); i++) {
				totalWait += customers.get(i).getWaitTime();
			}
			averageWait = totalWait / customers.size();
        	// after the big while loop is done, loop through all of the customers and add up their wait times
        	// divide the total wait time by the number of customers to get the average wait time, and print it out.\
			System.out.println("The average wait time for each customer is " + averageWait + " minutes.");
    }
}
