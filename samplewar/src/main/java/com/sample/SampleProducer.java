package com.sample;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

public class SampleProducer {
	
	@Resource(mappedName = "java:/jms/QueueConnectionFactory")
    public ConnectionFactory localQueueFactory;

	@Resource(mappedName = "java:/queue/test")
	public Queue queue;

	public void sendMessage(String msge) throws Exception {
		MessageProducer producer = null;
		Session session = null;
		Connection con = null;
		try {
			con = this.localQueueFactory.createConnection();
			session = con.createSession(true, QueueSession.AUTO_ACKNOWLEDGE);
			//Queue queue = session.createQueue("queue://TEST");
			producer = session.createProducer(queue);
			int i = 1;
			for (int j = 0; j < i; j++) {
				TextMessage tm = session.createTextMessage(msge);
				producer.send(tm);
				System.out.println("Message [" + tm.getText()
						+ "] sent to Queue: " + queue.getQueueName());
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
