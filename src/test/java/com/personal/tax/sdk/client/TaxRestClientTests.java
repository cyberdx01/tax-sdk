package com.personal.tax.sdk.client;

import com.personal.tax.model.dto.TaxResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class TaxRestClientTests {

	@InjectMocks
	TaxRestClient taxRestClient;

	@Mock
	RestTemplate restTemplate;

	@Test
	void testCalculateTax() {
		Mockito.when(restTemplate.exchange(ArgumentMatchers.any(), ArgumentMatchers.eq(TaxResponseDto.class)))
				.thenReturn(new ResponseEntity<>(new TaxResponseDto(), HttpStatusCode.valueOf(200)));
		Assertions.assertNotNull(taxRestClient.calculateTax(5000.0));
	}

}
