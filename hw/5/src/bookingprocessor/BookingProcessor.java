package bookingprocessor;

import util.Constants;

public class BookingProcessor {
	public static void main(String[] args) throws Exception {
        // input arguments
        String queueName = Constants.NAME_QUEUE_BOOKINGS;
 
        // create the producer object and receive the message
        BookingConsumer consumer = new BookingConsumer();
        consumer.receive(queueName);
    }
}

