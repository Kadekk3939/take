package eu.myszojelenie.controller.dto.offer;

import java.util.List;

public class OffersDto {

    private List<OfferDto> offers;

    public OffersDto(List<OfferDto> offers) {
        this.offers = offers;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }
}
