package shippingChallenge.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@MappedSuperclass
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class GenericEntity {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

}