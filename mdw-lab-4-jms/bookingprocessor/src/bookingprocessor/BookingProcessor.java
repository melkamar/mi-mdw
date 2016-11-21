package bookingprocessor;

public class BookingProcessor {
	public static void main(String[] args) throws Exception {
        // input arguments
        String queueName = "jms/mdw-queue-booking" ;
 
        // create the producer object and receive the message
        BookingConsumer consumer = new BookingConsumer();
        consumer.receive(queueName);
    }
}
