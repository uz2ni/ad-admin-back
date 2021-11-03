package com.ad.admin.manage.brand.infrastructure;

import com.ad.admin.manage.brand.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
