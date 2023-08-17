package com.momen.yana.region;


import com.momen.yana.city.City;
import com.momen.yana.common.BaseEntity;
import com.momen.yana.house.House;
import com.momen.yana.region_realestate.RegionRealEstate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;

import java.awt.*;
import java.util.List;

@Entity
@Table(name = Region.tb_name)
@Data
@Audited
public class Region extends BaseEntity {

    public static final String tb_name = "region_tb";


    private String name;
    private Polygon location;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RegionRealEstate> regionRealEstateList;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<House> houses;

}
