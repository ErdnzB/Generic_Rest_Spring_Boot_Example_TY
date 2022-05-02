package shippingChallenge.baseServices;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import shippingChallenge.entity.Bags;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IGenericService;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

public interface BagsService extends IGenericService<Bags> {

    public Bags findBagByBarcode(@RequestBody InnerRequestModel req);

}
