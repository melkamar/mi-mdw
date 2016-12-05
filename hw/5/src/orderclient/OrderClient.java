package orderclient;

import java.util.Random;

import util.MessageSender;

public class OrderClient {
	public static void main(String[] args) throws Exception {
        // create the producer object and send the message
        MessageSender producer = new MessageSender();
        
        String msg = createOrder();
        System.out.println("[order-client] sending message '"+msg+"'");
        producer.send("jms/all-orders-queue", msg);
        System.out.println("[order-client] done.");
        //ConfirmationConsumer confirmationConsumer = new ConfirmationConsumer();
        //confirmationConsumer.receive("jms/mdw-queue-confirmation");
    }
	
	private static String createOrder(){
		Random rnd = new Random();
		
		if (rnd.nextBoolean()){
			return "[booking] somebooking #"+rnd.nextInt(100000);
		} else {
			return "[new-trip] sometrip #"+rnd.nextInt(100000);
		}
	}
}
