package org.springsource.samples.cloudburst;

public class OrderProcessor {
	
	private final String location;
	
	public OrderProcessor(String location) {
		this.location = location;
	}
	
	public void processOrder(String order) {
		System.out.println("Processing '" + order + "' in " + this.location);
	}
	
}