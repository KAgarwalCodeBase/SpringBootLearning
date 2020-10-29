package com.cardIntegration.roiim.controller;

import com.cardIntegration.roiim.dto.RequestDtos.CustomerRequestDto;
import com.cardIntegration.roiim.dto.ResponseDto;
import com.cardIntegration.roiim.dto.ResponseDtos.PaymentHandlerTokenResponseDto;
import com.cardIntegration.roiim.model.PaymentHandle;
import com.cardIntegration.roiim.service.CheckoutService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class RestEndPointController {
    @Autowired
    private CheckoutService checkoutService;
    @PostMapping( "/SingleUseCustomerToken2" )
    public ResponseDto createUserAndSingleUseCustomerToken(@RequestBody CustomerRequestDto createNewCustomerRequestDTO){
        System.out.println("Post method executing SingleUseCustomerToken2");

        ResponseDto<PaymentHandlerTokenResponseDto> responseDTO = new ResponseDto< PaymentHandlerTokenResponseDto >();
        responseDTO.setStatus( HttpStatus.OK );
        responseDTO.setMessage( "SingleUseCustomerToken Created" );
        responseDTO.setData(checkoutService.creatSingleUserCustomerToken(createNewCustomerRequestDTO) );
        return responseDTO;

    }
}
