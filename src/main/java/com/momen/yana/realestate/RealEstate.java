package com.momen.yana.realestate;

import com.momen.yana.common.BaseEntity;
import com.momen.yana.house.House;
import com.momen.yana.region_realestate.RegionRealEstate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = RealEstate.tb_name)
@Data
@Audited
public class RealEstate extends BaseEntity {
    public static final String tb_name = "real_estate_tb";

    private String name;
    private String ownerName;
    private String activityRegion;
    private String address;
    private String number;
    private String details;
    private Point<G2D> location;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "realEstate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RegionRealEstate> regionRealEstateList;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "realState", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<House> houses;

}
