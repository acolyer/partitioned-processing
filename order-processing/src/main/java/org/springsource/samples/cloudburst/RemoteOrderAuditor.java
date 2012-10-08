package org.springsource.samples.cloudburst;

public class RemoteOrderAuditor {
	
	public void auditOrder(String order) {
		System.out.println("Sent '" + order + "' to EU West (Ireland) for processing.");
	}
	
}