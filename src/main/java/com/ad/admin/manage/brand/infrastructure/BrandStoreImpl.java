package com.ad.admin.manage.brand.infrastructure;

import com.ad.admin.manage.brand.domain.Brand;
import com.ad.admin.manage.brand.domain.BrandStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Slf4j
@Component
@RequiredArgsConstructor
public class BrandStoreImpl implements BrandStore {

    private final BrandRepository brandRepository;

    @Override
    public Brand store(Brand brand) {
        if(brand.getBrandName().isEmpty()) throw new InvalidParameterException("brand.getBrandName()");
        if(brand.getBrandNo().isEmpty()) throw new InvalidParameterException("brand.getBrandNo()");

        return brandRepository.save(brand);
    }
}
