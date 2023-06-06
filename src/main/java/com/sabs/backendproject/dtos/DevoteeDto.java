package com.sabs.backendproject.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sabs.backendproject.enums.BankEnum;
import com.sabs.backendproject.enums.PaymentMethodEnum;
import com.sabs.backendproject.models.GreatVowLampModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class DevoteeDto {

    private Long id;
    private Long membershipId;
    private String receiptNo;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate receiptDate;
    private BigDecimal amount;
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
    private Set<GreatVowLampModel> greatVowLamps = new HashSet<>();
    private String registrationDate;
    private Set<String> customerTags = new HashSet<>();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

}
