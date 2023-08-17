package com.momen.yana.city;


import com.momen.yana.common.BaseEntity;
import com.momen.yana.region.Region;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = City.tb_name)
@Data
@Audited
public class City extends BaseEntity {

    public static final String tb_name = "city_tb";

    @Column
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Region> regions;
}
