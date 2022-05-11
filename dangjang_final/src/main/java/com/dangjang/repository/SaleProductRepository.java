package com.dangjang.repository;

import com.dangjang.domain.BasicProduct;
import com.dangjang.domain.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {
    List<SaleProduct> findAllByBasicProduct(BasicProduct basicProduct);

}
