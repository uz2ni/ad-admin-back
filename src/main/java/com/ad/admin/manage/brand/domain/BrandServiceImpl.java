package com.ad.admin.manage.brand.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandStore brandStore;

    @Override
    public BrandInfo registerBrand(BrandCommand command) {
        // 1. command -> initBrand
        // 2. initBrand save to DB
        // 3. Brand -> brandInfo AND return
        Brand initBrand = new Brand(command.getBrandName(), command.getBrandNo());
        Brand brand = brandStore.store(initBrand);
        return new BrandInfo(brand);

    }

    @Override
    public BrandInfo getBrandInfo(String brandId) {
        return null;
    }

    @Override
    public BrandInfo enableBrand(String brandId) {
        return null;
    }

    @Override
    public BrandInfo disableBrand(String brandId) {
        return null;
    }
}
