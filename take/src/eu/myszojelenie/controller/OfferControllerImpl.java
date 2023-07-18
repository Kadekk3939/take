package eu.myszojelenie.controller;

import eu.myszojelenie.controller.dto.offer.NewOfferDto;
import eu.myszojelenie.controller.dto.offer.OfferDto;
import eu.myszojelenie.controller.dto.offer.OffersDto;
import eu.myszojelenie.service.OfferService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OfferControllerImpl implements OfferController {

    @EJB
    private OfferService offerService;

    @Override
    public OfferDto createOffer(NewOfferDto offerDto) {
        return offerService.createOffer(offerDto);
    }

    @Override
    public OfferDto getOfferById(Long offerId) {
        return offerService.getOfferById(offerId).orElseThrow(() -> new IllegalArgumentException("Offer with given id does not exist!"));
    }

    @Override
    public OffersDto getOffers(Boolean withRemoved) {
        return offerService.getAllOffers(withRemoved);
    }

    @Override
    public void inactivateOffer(Long offerId) {
        offerService.inactiveOffer(offerId);
    }

    @Override
    public OfferDto activateOffer(Long offerId) {
        return offerService.activateOfer(offerId).orElseThrow(() -> new IllegalArgumentException("Offer with given id does not exist!"));
    }
}
