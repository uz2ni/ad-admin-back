package com.ad.admin.manage.brand.interfaces;

import com.ad.admin.manage.brand.domain.BrandCommand;
import com.ad.admin.manage.brand.domain.BrandInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

public class BrandDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        @NotEmpty(message = "brandName 는 필수값입니다")
        private String brandName;

        @NotEmpty(message = "brandNo 는 필수값입니다")
        private String brandNo;

        public BrandCommand toCommand() {
            return BrandCommand.builder()
                    .brandName(brandName)
                    .brandNo(brandNo)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final Long id;
        private final String brandName;
        private final String brandNo;

        public RegisterResponse(BrandInfo brandInfo) {
            this.id = brandInfo.getId();
            this.brandName = brandInfo.getBrandName();
            this.brandNo = brandInfo.getBrandNo();
        }
    }


}
