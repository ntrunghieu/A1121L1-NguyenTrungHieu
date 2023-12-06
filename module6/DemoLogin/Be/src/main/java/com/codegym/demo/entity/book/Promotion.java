package com.codegym.demo.entity.book;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionId;

    private Double promotionPercent;

    public Promotion() {
    }

    public Promotion(Long promotionId, Double promotionPercent) {
        this.promotionId = promotionId;
        this.promotionPercent = promotionPercent;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Double getPromotionPercent() {
        return promotionPercent;
    }

    public void setPromotionPercent(Double promotionPercent) {
        this.promotionPercent = promotionPercent;
    }
}
