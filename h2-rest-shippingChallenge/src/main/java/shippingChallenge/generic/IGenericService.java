package shippingChallenge.generic;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface IGenericService<T extends GenericEntity> {

    T get(Integer id);

    String add(T req);

    T update(T req);

    Map<String, String> deleteT(Integer id);

    List<T> getAllT();

}