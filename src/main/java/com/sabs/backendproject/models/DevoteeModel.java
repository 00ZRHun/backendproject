package com.sabs.backendproject.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sabs.backendproject.enums.BankEnum;
import com.sabs.backendproject.enums.PaymentMethodEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "devotee")
@SQLDelete(sql = "UPDATE devotee SET deleted_at = to_char(NOW(), 'YYYY-MM-DD HH24:MI:SS')::timestamp WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class DevoteeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "membershipId")
    private Long membershipId;

    @Column(name = "receiptNo")
    private String receiptNo;

    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "receiptDate")
    private LocalDate receiptDate;

    @Column(name = "amount")
    private BigDecimal amount;   // TODO: BigDecimal(2)

    @Column(name = "paymentMethod")
    private PaymentMethodEnum paymentMethod;

    @Column(name = "bank")
    private BankEnum bank;

    @Column(name = "chequeNo ")
    private String chequeNo ;

    @Column(name = "nameEn")
    private String nameEn;

    @Column(name = "nameCh")
    private String nameCh;

    @Column(name = "address")
    private String address;

    @Column(name = "icOrPassportNo")
    private String icOrPassportNo;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "phoneNoHome")
    private String phoneNoHome;

    @Column(name = "phoneNoOffice")
    private String phoneNoOffice;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "devoteeName")
    private String devoteeName;

    @Column(name = "remark", columnDefinition = "text")   // TODO: double chk it
    private String remark;

    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "startDate")
    private LocalDate startDate;

    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "expiryDate")
    private LocalDate expiryDate;

    /*@Column(name = "lampNo")
    private String lampNo;*/
    // hidden field(s)
    @JsonIgnore
    @OneToMany(mappedBy = "devotee")
    private Set<GreatVowLampModel> greatVowLamps = new HashSet<>();

    @Column(name = "registrationDate")
    private String registrationDate;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "createdAt")
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "deletedAt")
    private LocalDateTime deletedAt = null;
    
}
