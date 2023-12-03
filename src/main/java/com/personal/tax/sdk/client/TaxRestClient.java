package com.personal.tax.sdk.client;

import com.personal.tax.model.dto.TaxRequestDto;
import com.personal.tax.model.dto.TaxResponseDto;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@AllArgsConstructor
public class TaxRestClient {

    @Autowired
    RestTemplate restTemplate;

    @SneakyThrows
    public TaxResponseDto calculateTax(Double annualIncome) {
        TaxRequestDto requestDto = new TaxRequestDto();
        requestDto.setAnnualIncome(annualIncome);

        RequestEntity<TaxRequestDto> requestEntity = new RequestEntity<>(requestDto, HttpMethod.POST, new URI("http://localhost:8081/tax-svc/calculate"));
        return restTemplate.exchange(requestEntity, TaxResponseDto.class).getBody();
    }

}
