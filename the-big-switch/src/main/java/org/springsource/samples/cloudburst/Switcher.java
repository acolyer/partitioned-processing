package org.springsource.samples.cloudburst;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import com.rabbitmq.client.Channel;

public class Switcher {
	
	private final RabbitTemplate amqpTemplate;
	private final String destinationExchange;
	private final String sourceExchange;
	private final String routingKey;
	
	private Location currentLocation = Location.HQ;
	
	public Switcher(RabbitTemplate template,
		            String destinationExchange, String sourceExchange, String routingKey) {
		this.amqpTemplate = template;
		this.destinationExchange = destinationExchange;
		this.sourceExchange = sourceExchange;
		this.routingKey = routingKey;
	}
	

	public enum Location { HQ, CLOUD };
	
	public void setOrderProcessingLocation(Location location) {
		if (location == Location.HQ && this.currentLocation != Location.HQ) {
			removeExchangeBindings();
			this.currentLocation = Location.HQ;
		}
		else if (location == Location.CLOUD && this.currentLocation != Location.CLOUD){
			addExchangeToExchangeBinding();
			this.currentLocation = Location.CLOUD;
		}
	}
	
	
	private void removeExchangeBindings() {
		//TODO: should really use management API to check that binding exists before trying to delete it.
		// this.currentLocation is a poor-mans protection against that crime.
		this.amqpTemplate.execute(new ChannelCallback<Void>() {
			public Void doInRabbit(Channel channel) throws java.io.IOException {
				channel.exchangeUnbind(destinationExchange, sourceExchange, routingKey);
				return null;			
			}
		});
	}
	
	private void addExchangeToExchangeBinding() {
		this.amqpTemplate.execute(new ChannelCallback<Void>() {
			public Void doInRabbit(Channel channel) throws java.io.IOException {
				channel.exchangeBind(destinationExchange, sourceExchange, routingKey);			
				return null;
			}
		});		
	}
	
}