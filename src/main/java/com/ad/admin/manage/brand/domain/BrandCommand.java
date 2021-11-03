package com.ad.admin.manage.brand.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class BrandCommand {
    private final String brandName;
    private final String brandNo;

    public Brand toEntity() {
        return Brand.builder()
                .brandName(brandName)
                .brandNo(brandNo)
                .build();
    }
}
