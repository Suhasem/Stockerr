package com.stockerr.Entity;

import com.stockerr.enums.AlertCondition;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "price_alerts")
public class PriceAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stockSymbol;

    private String exchange;

    @Enumerated(EnumType.STRING)
    private AlertCondition conditionType;

    private BigDecimal targetPrice;

    private Boolean active = true;

    private LocalDateTime lastTriggeredAt;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
