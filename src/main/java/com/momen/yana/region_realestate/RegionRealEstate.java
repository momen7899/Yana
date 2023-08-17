package com.momen.yana.region_realestate;

import com.momen.yana.common.BaseEntity;
import com.momen.yana.realestate.RealEstate;
import com.momen.yana.region.Region;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.envers.Audited;


@Entity
@Table(name = RegionRealEstate.tb_name)
@Data
@Audited
public class RegionRealEstate extends BaseEntity {

    public static final String tb_name = "region_realestate_tb";
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "real_estate_id")
    private RealEstate realEstate;

}
