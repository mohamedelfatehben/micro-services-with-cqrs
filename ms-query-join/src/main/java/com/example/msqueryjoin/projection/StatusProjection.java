package com.example.msqueryjoin.projection;

import com.example.coreapi.events.ChambreAddedEvent;
import com.example.coreapi.events.ChambreRemovedEvent;
import com.example.coreapi.events.ReservationAddedEvent;
import com.example.coreapi.events.ReservationRemovedEvent;
import com.example.msqueryjoin.entities.StatusTable;
import com.example.msqueryjoin.repository.StatusTableRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusProjection {

    @Autowired
    private StatusTableRepository statusTableRepository;

    @EventHandler
    public void addChambre(ChambreAddedEvent event)
    {
        statusTableRepository.save(new StatusTable(event.getIdCh(),event.getIdH(),0L));
    }

    //----A complèter-------------
    @EventHandler
    public void removeChambre(ChambreRemovedEvent event)
    {
        statusTableRepository.deleteById(event.getIdCh());
    }
    @EventHandler
    public void addReservation(ReservationAddedEvent event)
    {
        StatusTable statusTable= statusTableRepository.getById(event.getIdCh());
        statusTable.setNbReservation(statusTable.getNbReservation()+1);
        statusTableRepository.save(statusTable);
    }
    @EventHandler
    public void removeReservation(ReservationRemovedEvent event)
    {
        StatusTable statusTable= statusTableRepository.getById(event.getIdCh());
        statusTable.setNbReservation(statusTable.getNbReservation()-1);
        statusTableRepository.save(statusTable);
    }
}
