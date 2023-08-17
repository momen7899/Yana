package com.momen.yana.house;

import com.momen.yana.common.BaseEntity;
import com.momen.yana.house_benfit.HouseBenefit;
import com.momen.yana.realestate.RealEstate;
import com.momen.yana.region.Region;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = House.tb_name)
@Data
@Audited
public class House extends BaseEntity {
    public static final String tb_name = "house_tb";


    private String title;
    private String address;
    private Double area;
    private Integer numberOfRooms;
    private Integer constructYear;
    private Integer numberOfParking;
    private String description;
    private Point<G2D> location;
    private HouseType houseType;
    private DealType dealType;
    private BigDecimal rentPrice;
    private BigDecimal salePrice;
    private BigDecimal mortgagePrice;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HouseBenefit> houseBenefitList;

    @ManyToOne
    @JoinColumn(name = "real_state_id")
    private RealEstate realState;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
