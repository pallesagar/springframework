package com.swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.request.PassengerRequest;
import com.swagger.response.TicketInfo;

@RestController
public class AirIndiaRestController {

	@PostMapping("/bookFlightTicket")
	public ResponseEntity<TicketInfo>  bookeTicket(@RequestBody PassengerRequest pinfo){
		TicketInfo ticket =new TicketInfo();
		
		ticket.setName(pinfo.getFirstname()+""+pinfo.getLastname());
		ticket.setFrom(pinfo.getFrom());
		ticket.setTo(pinfo.getTo());
		ticket.setTicketstatus("CONFIMED");
		ticket.setTicketprice("4500.00 INR");
		ticket.setJourneydate(pinfo.getJourneydate());
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
		
	}
}
