package com.sabs.backendproject.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sabs.backendproject.enums.GreatVowLampStatusEnum;
import com.sabs.backendproject.models.DevoteeModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class GreatVowLampDto {

    private Long id;
    private char area;
    private Integer rowNo;
    private Integer columnNo;
    private String lampNo;
    private BigDecimal price;
    private GreatVowLampStatusEnum status;

    // Foreign Key
    private Long devoteeId = null;
    private DevoteeModel devotee = null;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

}
