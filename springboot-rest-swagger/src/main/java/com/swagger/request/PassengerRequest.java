package com.swagger.request;

import lombok.Data;

@Data
public class PassengerRequest {

	private String firstname;
	private String lastname;
	private String from;
	private String to;
	private String flightid;
	private String journeydate;
	
}
