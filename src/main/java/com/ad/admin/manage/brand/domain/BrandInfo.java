package com.ad.admin.manage.brand.domain;

import lombok.Getter;

@Getter
public class BrandInfo {
    private final Long id;
    private final String brandName;
    private final String brandNo;
//    private final Long accountId;
    //private final String Brand.Status status;

    public BrandInfo(Brand brand) {
        this.id = brand.getId();
        this.brandName = brand.getBrandName();
        this.brandNo = brand.getBrandNo();
//        this.accountId = brand.getAccountId();
    }

}
