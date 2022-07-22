package com.example.projectIsa.reservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.reservation.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
    @Query(value = "SELECT q FROM Reservation q WHERE q.client.id = ?1 and CAST(q.startTime as date) < CAST(?2 as date) and q.cancelled = false")
    List<Reservation> findPreviousClientReservations(Integer clientId, Date date);

    @Query(value = "SELECT q FROM Reservation q WHERE q.client.id = ?1 and CAST(q.startTime as date) > CAST(?2 as date) and q.cancelled = false")
	List<Reservation> findFutureClientReservations(Integer clientId, Date date);

}
