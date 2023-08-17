package com.momen.yana.benefit;


import com.momen.yana.common.BaseEntity;
import com.momen.yana.house_benfit.HouseBenefit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = Benefit.tb_name)
@Data
@Audited
public class Benefit extends BaseEntity {

    public static final String tb_name = "benefit_tb";
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "benefit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HouseBenefit> houseBenefitList;
}
