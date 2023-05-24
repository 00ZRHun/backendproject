package com.sabs.backendproject.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sabs.backendproject.enums.BankEnum;
import com.sabs.backendproject.enums.PaymentMethodEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DevoteeDto {

    private Long id;
    private Long membershipId;
    private String receiptNo;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate receiptDate;
    private BigDecimal amount;   // TODO: BigDecimal(2)
    private PaymentMethodEnum paymentMethod;
    private BankEnum bank;
    private String chequeNo ;
    private String nameEn;
    private String nameCh;
    private String address;
    private String icOrPassportNo;
    private String emailAddress;
    private String phoneNo;
    private String phoneNoHome;
    private String phoneNoOffice;
    private String postcode;
    private String district;
    private String state;
    private String devoteeName;
    private String remark;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate expiryDate;
    private String lampNo;
    private String registrationDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

}
