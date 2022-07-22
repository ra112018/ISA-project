package com.example.projectIsa.reservation.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.reservation.model.Reservation;
import com.example.projectIsa.reservation.service.IReservationService;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

	private final IReservationService reservationService;
	
	public ReservationController(IReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	//@ClientAuthorization
    @GetMapping("/getPreviousClientReservations/{clientId}")
    public List<Reservation> getPreviousClientReservations(@PathVariable Integer clientId) throws ParseException {
        return reservationService.findPreviousClientReservations(clientId);
    }
    
    //@ClientAuthorization
    @GetMapping("/getFutureClientReservations/{clientId}")
    public List<Reservation> getFutureClientReservations(@PathVariable Integer clientId) throws ParseException {
        return reservationService.findFutureClientReservations(clientId);
    }
    
    //@ClientAuthorization
    @PostMapping("/cancelReservation/{reservationId}")
    public boolean cancelReservation(@PathVariable Integer reservationId) throws ParseException {
        return reservationService.cancelReservation(reservationId);
    }
}
