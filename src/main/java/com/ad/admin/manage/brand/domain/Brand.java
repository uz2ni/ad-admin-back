package com.ad.admin.manage.brand.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "partners")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String brandNo;
//    private Long accountId;

//    @Enumerated(EnumType.STRING)
//    private Status status;

//    @Getter
//    @RequiredArgsConstructor
//    public enum Status {
//        ENABLE("활성화"), DISABLE("비활성화");
//        private final String description;
//    }

    @Builder
    public Brand(String brandName, String brandNo) {
        if(brandName.isEmpty()) throw new RuntimeException("empty brandName");
        if(brandNo.isEmpty()) throw new RuntimeException("empty brandNo");
        this.brandName = brandName;
        this.brandNo = brandNo;
    }

}
