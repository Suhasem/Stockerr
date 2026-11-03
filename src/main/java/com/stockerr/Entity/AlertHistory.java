package com.stockerr.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "alert_history")
public class AlertHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal triggeredPrice;

    private LocalDateTime triggeredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_alert_id", nullable = false)
    private PriceAlert priceAlert;

}