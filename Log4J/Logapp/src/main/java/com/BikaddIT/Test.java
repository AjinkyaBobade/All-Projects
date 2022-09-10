package com.BikaddIT;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class Test {

	private static Logger log=Logger.getLogger(Test.class);
	
	public static void main(String[] args) throws IOException {
		//Layout layout=new SimpleLayout();
		//Layout layout=new HTMLLayout();
		//Layout layout=new XMLLayout();
		//Layout layout=new PatternLayout();
		//Layout layout=new PatternLayout("%p /n");
		//Layout layout=new PatternLayout("%p %d /n");
		//Layout layout=new PatternLayout("%p %d %c /n");
		//Layout layout=new PatternLayout("%p %d %c %M %m %L  /n");
//		Layout layout=new PatternLayout("%p %d{yyyy/MMM/dd hh:mm:ss}%C %m %l %n");
		Layout layout=new PatternLayout("%d-%C[%M] : {%p}=%m<%L> %n ");
		//Appender app=new ConsoleAppender(layout);
		Appender app=new FileAppender(layout,"C:\\Users\\ajink\\OneDrive\\Desktop\\Log4J.log");
		log.addAppender(app);
		log.debug("this id debug massage");
		log.info("this is info massage");
		log.warn("this is warning massage");
		log.error("this is error massage");
		log.fatal("this is fatal massage");
	}

}
