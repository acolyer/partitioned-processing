package org.springsource.samples.cloudburst;

public class CommandProcessor {
	
	private final Switcher switcher;
	
	public CommandProcessor(Switcher switcher) {
		this.switcher = switcher;
		System.out.print("Order processing location (hq|cloud)? > ");
	}
	
	public void onUserInput(String input) {
		if (input.equalsIgnoreCase("hq")) {
			System.out.println("Switching order processing to local (HQ) facility");
			this.switcher.setOrderProcessingLocation(Switcher.Location.HQ);
			System.out.print("Order processing location (hq|cloud)? > ");
		}
		else if (input.equalsIgnoreCase("cloud")) {
			System.out.println("Switching order processing to cloud (EU WEST) facility");
			this.switcher.setOrderProcessingLocation(Switcher.Location.CLOUD);
			System.out.print("Order processing location (hq|cloud)? > ");
		}
		else {
			System.out.println("Sorry, I don't understand '" + input + "'");
			System.out.print("Order processing location (hq|cloud)? > ");
		}
	}
	
}