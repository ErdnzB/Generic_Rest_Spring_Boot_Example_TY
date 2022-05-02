package shippingChallenge.baseServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.BagsRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.Bags;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IRepository;
import shippingChallenge.requestModels.InnerRequestModel;

import javax.transaction.Transactional;

@Slf4j
@Service
@Component
public class BagsServiceImpl extends GenericService<Bags> implements BagsService  {

    private final BagsRepository bagsRepository;

    public BagsServiceImpl(IRepository<Bags> iRepo, BagsRepository bagsRepository) {
        super(iRepo);
        this.bagsRepository = bagsRepository;
    }

    @Override
    @Transactional
    public Bags findBagByBarcode(InnerRequestModel req) {
        try {
            Bags bag = bagsRepository.findBagByBarcode(req.getBarcode());
            if(bag == null){
                throw new ShippingChallengeApiException(EnumMessages.BAG_NOT_FOUND);
            }else{
                return bag;
            }
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.BAG_BARCODE_SEARCH);
        }
    }

}
