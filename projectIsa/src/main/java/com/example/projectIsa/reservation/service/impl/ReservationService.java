package com.example.projectIsa.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.reservation.model.Reservation;
import com.example.projectIsa.reservation.repository.ReservationRepository;
import com.example.projectIsa.reservation.service.IReservationService;

@Service
public class ReservationService implements IReservationService{

	private ReservationRepository reservationRepository;
	
	@Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

	@Override
	public List<Reservation> findPreviousClientReservations(Integer clientId) {
		return reservationRepository.findPreviousClientReservations(clientId,new Date());
	}

	@Override
	public List<Reservation> findFutureClientReservations(Integer clientId) {
		return reservationRepository.findFutureClientReservations(clientId,new Date());
	}

	@Override
	public boolean cancelReservation(Integer reservationId) {
		Reservation reservation = reservationRepository.getById(reservationId);
        reservation.setCancelled(true);
        reservationRepository.save(reservation);
        return true;
	}
}
