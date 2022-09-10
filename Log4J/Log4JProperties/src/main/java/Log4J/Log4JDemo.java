package Log4J;

import org.apache.log4j.Logger;

public class Log4JDemo {

	private static Logger log=Logger.getLogger(Log4JDemo.class);
	public static void main(String[] args) {
		
	
		
		log.debug("This id Debug Massage");
		log.error("this id Error Massage");
		log.info("This is INFO Massage");
		log.fatal("This is Fatal mAssage");
		log.warn("For Printing the massage in files just set path and fire the Aapplication");
		
	}
}
