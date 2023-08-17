package com.momen.yana.house_benfit;


import com.momen.yana.benefit.Benefit;
import com.momen.yana.common.BaseEntity;
import com.momen.yana.house.House;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Table(name = HouseBenefit.tb_name)
@Data
@Audited
public class HouseBenefit extends BaseEntity {
    public static final String tb_name = "house_benefit_tb";

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @ManyToOne
    @JoinColumn(name = "benefit_id")
    private Benefit benefit;


}
