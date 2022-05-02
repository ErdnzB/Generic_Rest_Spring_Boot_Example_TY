package shippingChallenge.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface IRepository<T extends GenericEntity> extends JpaRepository<T, Integer> {


}