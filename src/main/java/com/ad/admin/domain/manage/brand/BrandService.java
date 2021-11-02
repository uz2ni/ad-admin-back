package com.ad.admin.domain.manage.brand;

public interface BrandService {
    // Command(명령), Criteria(조회) --- Info(리턴)
    BrandInfo registerBrand(BrandCommand command);
    BrandInfo getBrandInfo(String brandId);
    BrandInfo enableBrand(String brandId);
    BrandInfo disableBrand(String brandId);
}
