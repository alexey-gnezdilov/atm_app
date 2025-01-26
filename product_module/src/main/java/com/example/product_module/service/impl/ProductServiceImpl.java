package com.example.product_module.service.impl;

import com.example.product_module.entity.Promocode;
import com.example.product_module.model.BookingInfoForProductDto;
import com.example.product_module.repository.PromocodeCriteriaDaoRepository;
import com.example.product_module.repository.PromocodeRepository;
import com.example.product_module.service.ProductService;
import com.example.product_module.util.Base64EncodeDecode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.product_module.constant.ProductModuleConstants.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final PromocodeCriteriaDaoRepository promocodeCriteriaDaoRepository;
    private final PromocodeRepository promocodeRepository;

    private Promocode promocode;

    @Value(MODULE_VERSION)
    private String currentVersion;

    @Value(PRODUCT_INTEGRATION_KEY)
    private String nativeIntegrationKey;

    @Override
    public String getVersion() {
        return currentVersion;
    }

    @Override
    public void checkIntegrationKey(String integrationKey) {
        if (!nativeIntegrationKey.equals(Base64EncodeDecode.encoder(integrationKey)))
            throw new RuntimeException(INVALID_INTEGRATION_KEY_MESSAGE);
    }

    @Override
    public String prepareDiscount(BookingInfoForProductDto info) {

        List<Double> discounts = new ArrayList<>();

        //Пользак зарегался в свой ДР - 50%
        if (info.getUserRegistrationDate().isEqual(info.getBirthDate())) {
            discounts.add(0.5);
        }

        //Букинг в выходной день (СБ и ВС) - 5%
        String dayOfTheWeek = LocalDate.now().getDayOfWeek().toString();
        if (dayOfTheWeek.equals(SATURDAY) || dayOfTheWeek.equals(SUNDAY)) {
            discounts.add(0.05);
        }

        //Зарегался на более, чем 1 неделя - 7%
        if(Duration.between(info.getStartDate(), info.getEndDate()).toDays() >= ONE_WEEK_DAYS) {
            discounts.add(0.07);
        }

        //Иностранец - 10%
        if (info.isForeignCitizen()) {
            discounts.add(0.1);
        }

        //С другого города - 9%
        if (!info.getUserCityFrom().equals(info.getCity())) {
            discounts.add(0.09);
        }

        //Оплата наликом - 15%
        if (info.isByCash()) {
            discounts.add(0.15);
        }

        //Постоянный клиент - 25%
        if (info.getBookingAmount() > AMOUNT_OF_BOOKINGS_FOR_REGULAR_CUSTOMER) {
            discounts.add(0.25);
        }

        //100 бронирований - 100%
        if (info.getBookingAmount() > AMOUNT_OF_BOOKINGS_FOR_FREE_BOOKING) {
            discounts.add(1.0);
        }

        //Новый пользователь - 11% (считается новым в течение недели после регистрации)
        if (Duration.between(info.getUserRegistrationDate(), LocalDateTime.now()).toDays() >= ONE_WEEK_DAYS) {
            discounts.add(0.11);
        }

        //Промокод - 30%
        if (info.getPromocode() != null) {
            promocode = promocodeCriteriaDaoRepository.findByPromocode(info.getPromocode());
            if (promocode != null && !promocode.isUsed()) {
                discounts.add(0.3);
            }
        }

        double totalDiscount = discounts.stream().mapToDouble(d -> d).max().orElseThrow(NoSuchElementException::new);

        //Если применился промокод
        if (totalDiscount == 0.3) {
            promocode.setUsed(true);
            promocodeRepository.save(promocode);
        }

        double totalPrice = Double.parseDouble(info.getPrice());

        return String.valueOf(totalPrice - (totalPrice * totalDiscount));
    }

}
