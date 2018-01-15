package org.example.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class DBDemoRB extends RouteBuilder {
	    
	
	public void configure() {
	    	
		from("timer://runOnce?repeatCount=1&delay=10")
		 .to("sql:select * from student?dataSource=sampleDataSource")
		  .log(LoggingLevel.INFO, "${body}").end();
		
		
		from("timer://runOnce?repeatCount=1&delay=10")
		.to("bean:databaseOperations?method=getDetails").end();
	}

}

