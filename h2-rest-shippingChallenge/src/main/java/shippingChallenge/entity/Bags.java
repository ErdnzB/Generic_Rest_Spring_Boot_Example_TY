package shippingChallenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import shippingChallenge.enums.StatusOfBags;
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
@Table(name = "bags")
public class Bags extends GenericEntity implements Serializable  {

    @Column(name = "barcode", nullable = false)
    String barcode;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_point_deliveryValue", referencedColumnName = "deliveryValue", nullable = false)
    DeliveryPoints deliveryPoints;

    @Enumerated(value = EnumType.ORDINAL)
    StatusOfBags bagStatus;

    @JsonIgnore
    @OneToMany(targetEntity = Packs.class, mappedBy = "bags", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Packs> packsList = new ArrayList<>();

    public Bags(){
        super();
    }

}
