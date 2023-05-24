package com.sabs.backendproject.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "greatVowLamp")
@SQLDelete(sql = "UPDATE great_vow_lamp SET deleted_at = to_char(NOW(), 'YYYY-MM-DD HH24:MI:SS')::timestamp WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class GreatVowLampModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rowNo")
    private Integer rowNo;

    @Column(name = "columnNo")
    private Integer columnNo;

    // Foreign Key
    // default fetch type for ManyToOne: EAGER
    @ManyToOne   // OPT: (fetch = FetchType.LAZY)
    @JoinColumn(name = "devoteeId", referencedColumnName = "id")
    private DevoteeModel devotee = null;

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
