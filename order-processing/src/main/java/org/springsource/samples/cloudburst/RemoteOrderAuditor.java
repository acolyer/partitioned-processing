package org.springsource.samples.cloudburst;

public class RemoteOrderAuditor {
	
	public void auditOrder(String order) {
		System.out.println("Shipped '" + order + "' to EU West (Ireland) for remote processing.");
	}
	
}