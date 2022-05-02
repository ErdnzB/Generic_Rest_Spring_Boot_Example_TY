package shippingChallenge.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import shippingChallenge.generic.GenericEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "route")
public class Route extends  GenericEntity implements Serializable {


    @JsonIgnore
    @ManyToOne(targetEntity = LicencePlate.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "plate", referencedColumnName = "plateName", nullable = false)
    LicencePlate licencePlate;

    @JsonIgnore
    @OneToMany(targetEntity = DeliveryPoints.class, mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<DeliveryPoints> deliveryPointsList = new ArrayList<>();

    public Route(){
        super();
    }

}
