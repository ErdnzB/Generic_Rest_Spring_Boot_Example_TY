package shippingChallenge.baseServices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.RouteRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.Route;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IRepository;
import shippingChallenge.requestModels.InnerRequestModel;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Component
@Primary
public class RouteServiceImpl extends GenericService<Route>  implements RouteService {


    private final RouteRepository routeRepository;

    public RouteServiceImpl(IRepository<Route> iRepo, RouteRepository routeRepository) {
        super(iRepo);
        this.routeRepository = routeRepository;
    }

    @Override
    @Transactional
    public List<Route> getRoutesByLicencePlate(InnerRequestModel req) {
        try {
            List<Route> findingRoute = routeRepository.getRoutesByLicencePlate(req.getBarcode());
            if(findingRoute == null || findingRoute.size() == 0){
                throw new ShippingChallengeApiException(EnumMessages.ROUTE_NOT_FOUND);
            }else{
                return findingRoute;
            }
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.ROUTE_BARCODE_SEARCH);
        }
    }

}
