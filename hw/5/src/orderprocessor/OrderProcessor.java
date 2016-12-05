package orderprocessor;

import util.Constants;

public class OrderProcessor {
	public static void main(String[] args) throws Exception {
        // input arguments
        String queueName = Constants.NAME_QUEUE_ALL;
 
        // create the producer object and receive the message
        OrderConsumer consumer = new OrderConsumer();
        consumer.receive(queueName);
    }
}

