package bookingclient;

public class BookingClient {
	public static void main(String[] args) throws Exception {
        // input arguments
        String msg = "Booking: helloworld" ;

        // create the producer object and send the message
        BookingProducer producer = new BookingProducer();
        producer.send("jms/mdw-queue-booking", msg);
        
        ConfirmationConsumer confirmationConsumer = new ConfirmationConsumer();
        confirmationConsumer.receive("jms/mdw-queue-confirmation");
    }
}
