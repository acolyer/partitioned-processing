package org.springsource.samples.cloudburst;

public class OrderCapture {
	
	private int orderNo = 1;
	
	public String placeOrder() {
		String order = "order #" + orderNo++;
		System.out.println("Sent " + order + " for processing");
		return order;
	}
	
}