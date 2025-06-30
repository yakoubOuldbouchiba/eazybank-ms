package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.service.ICustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "REST API for Customer in EazyBank",
        description = "REST API for Customer in EazyBank to FETCH customer details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {
    @Autowired
    private ICustomersService iCustomersService;
    @Operation(summary = "Fetch Customer Details" ,
            description = "REST API to Customer Details" )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "400", description = "HTTP Status Bad Request"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error")
    })
    @GetMapping(value = "/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam
                                                                   @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                                 String mobileNumber){
        CustomerDetailsDto  customerDetailsDto = this.iCustomersService.fetchCustomerDetails(mobileNumber);
        return ResponseEntity.ok(customerDetailsDto);
    }
}
