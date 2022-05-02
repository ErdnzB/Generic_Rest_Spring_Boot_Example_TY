package shippingChallenge.baseServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.LicencePlateRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.LicencePlate;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IRepository;
import shippingChallenge.requestModels.InnerRequestModel;

import javax.transaction.Transactional;

@Slf4j
@Service
@Component
public class LicencePlateServiceImpl  extends GenericService<LicencePlate>  implements LicencePlateService {


    private final LicencePlateRepository licencePlateRepository;

    public LicencePlateServiceImpl(IRepository<LicencePlate> iRepo, LicencePlateRepository licencePlateRepository) {
        super(iRepo);
        this.licencePlateRepository = licencePlateRepository;
    }

    @Override
    @Transactional
    public LicencePlate getShipByPlate(InnerRequestModel innerRequestModel) {
        try {
            return licencePlateRepository.getOrderByOrderNum(innerRequestModel.getPlateNo());
        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.LICENCE_PLATE_BARCODE_SEARCH);
        }
    }

}
