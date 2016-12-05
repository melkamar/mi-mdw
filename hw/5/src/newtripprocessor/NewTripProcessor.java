package newtripprocessor;

import util.Constants;

public class NewTripProcessor {
	public static void main(String[] args) throws Exception {
        // input arguments
        String queueName = Constants.NAME_QUEUE_NEWTRIPS;
 
        // create the producer object and receive the message
        NewTripConsumer consumer = new NewTripConsumer();
        consumer.receive(queueName);
    }
}

