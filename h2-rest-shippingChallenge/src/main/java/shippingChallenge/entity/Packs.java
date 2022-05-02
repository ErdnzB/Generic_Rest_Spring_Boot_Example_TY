package shippingChallenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import shippingChallenge.enums.StatusOfPacks;
import shippingChallenge.generic.GenericEntity;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "packs")
public class Packs  extends  GenericEntity implements Serializable {


    @Column(name = "packBarcode", nullable = false)
    String packBarcode;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_point_deliveryValue", referencedColumnName = "deliveryValue", nullable = false)
    DeliveryPoints deliveryPoints;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bags_barcode", referencedColumnName = "barcode", nullable = true)
    Bags bags;

    @Column(name = "volumetricWeight")
    Integer volumetricWeight;


    @Enumerated(value = EnumType.ORDINAL)
    StatusOfPacks statusOfPacks;

    public Packs(){
        super();
    }
}
