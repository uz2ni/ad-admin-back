package com.ad.admin.application.manage.brand;

import com.ad.admin.domain.manage.brand.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandFacade {

    private final BrandService brandService;

}
