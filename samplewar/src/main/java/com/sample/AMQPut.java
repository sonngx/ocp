package com.sample;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/put")
public class AMQPut extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 998638599071628431L;
	private static final Logger logger = LoggerFactory.getLogger(AMQPut.class);
	
	@Inject
	SampleProducer producer;

    public void init() throws ServletException {
        // Do required initialization
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("AMQ put started");
        try {
        	String messageTxt = request.getParameter("message");
        	System.out.println("messageTxt=" + messageTxt);
			producer.sendMessage(request.getParameter("message"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    public void destroy() {
        // do nothing.
    }
}
