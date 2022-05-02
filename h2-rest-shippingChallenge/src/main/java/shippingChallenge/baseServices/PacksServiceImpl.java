package shippingChallenge.baseServices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.PacksRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.Packs;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IRepository;
import shippingChallenge.requestModels.InnerRequestModel;

import javax.transaction.Transactional;

@Slf4j
@Service
@Component
public class PacksServiceImpl extends GenericService<Packs>  implements PacksService {


    private final PacksRepository packsRepository;

    public PacksServiceImpl(IRepository<Packs> iRepo, PacksRepository packsRepository) {
        super(iRepo);
        this.packsRepository = packsRepository;
    }

    @Override
    @Transactional
    public Packs findPackByBarcode(InnerRequestModel req) {
        try {
            Packs findingPack = packsRepository.findPackByBarcode(req.getBarcode());
            if(findingPack == null){
                throw new ShippingChallengeApiException(EnumMessages.PACK_NOT_FOUND);
            }else{
                return findingPack;
            }
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.PACK_BARCODE_SEARCH);
        }
    }
}
