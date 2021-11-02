package com.ad.admin.interfaces.manage.brand;

import com.ad.admin.application.manage.brand.BrandFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/manage/brand")
public class BrandController {

    private final BrandFacade brandFacade;

    @PostMapping
    public CommonResponse registerBrand(@RequestBody @Valid BrandDto.RegisterRequest request) {
        BrandCommand command = request.toCommand();
        var brandInfo = brandFacade.registerBrand(command);
        var response = new BrandDto.RegisterResponse(brandInfo);
        return CommonResponse.success(response);
    }

}
