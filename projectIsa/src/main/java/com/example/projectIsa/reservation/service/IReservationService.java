package com.example.projectIsa.reservation.service;

import java.util.List;

import com.example.projectIsa.reservation.model.Reservation;

public interface IReservationService {

	List<Reservation> findPreviousClientReservations(Integer clientId);

}
