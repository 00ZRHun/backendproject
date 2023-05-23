package com.sabs.backendproject.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

// TODO: add soft delete (annotation + deleted_at)

@Data
@Entity
@Table(name = "greatVowLamp")
public class GreatVowLampModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rowNo")
    private Integer rowNo;

    @Column(name = "columnNo")
    private Integer columnNo;

    @CreationTimestamp
    @Column(name = "created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;
    
}
