package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailsDto;


public interface ICustomersService {

    /**
     *
     * @param mobileNumber
     * @return
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
