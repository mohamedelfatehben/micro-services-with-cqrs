package com.example.mshotelcommand.Aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.EntityId;

import jakarta.persistence.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ChambreAggregate {

    //----A complèter-------------

    @TargetAggregateIdentifier
    @Id
    private String idCh;
    private String type;
    private Integer etage;
    @ManyToOne
    private HotelAggregate hotel;
}
