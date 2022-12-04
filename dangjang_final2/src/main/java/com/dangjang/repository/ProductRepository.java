package com.dangjang.repository;

import com.dangjang.domain.Product;
import com.dangjang.domain.type.DisplayOnoff;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    // 전시된 모든 상품을 끄집어내려고 하고
    @Query("select p from Product p where p.displayOnoff = ?1")
    List<Product> findAllByDisplayOnoff(DisplayOnoff displayOnoff);

    // 전시된 상품 중에 작은 카테고리에 속한 상품 리스트
    @Query("select p from Product p where p.basicProduct.smallCategory.id =?1 and p.displayOnoff= ?2")
    List<Product> findAllBySmallCategoryId(Long smallCategoryId, DisplayOnoff displayOnoff);

    // 전시된 상품중에 큰카테고리를 눌렀을 때 상품 리스트
    @Query("select p from Product p where p.basicProduct.smallCategory.bigCategory = ?1 and p.displayOnoff=?2")
    List<Product> findAllByBigCategoryId(Long bigCategoryId, DisplayOnoff displayOnoff);

    @Query("select p from Product p where p.content like ?1 and p.name like ?2")
    List<Product> findAllByContentLikeAndNameLike(String content, String name, Pageable pageable);
   // ----------------------------------------------------------------------------------------------------


    @Query("select p from Product p where p.id in (:ids2)") // 상품 정보 끄집어내기 for
    List<Product> getProductInformation(@Param("ids2") List<Product> ids2);


   // List<Product> create2week(); // 신상품 ( 생성된지 2주 내 상품들 ) // select * from product
                                                                 // where create_date - now() <= 14

  //  List<Product> suggestionList(); // 추천순 ( 생성된지 2주 내 상품들 )

   // List<Product> bestProductList(); // 많이 팔린순 ( 생성된지 2주 내 상품들 )  // select * from product
                                                                          // where create_date - now() <= 14
                                                                          // group by discount_selling and normal_selling
                                                                          // order by discount_selling and normal_selling desc;

   // List<Product> highestPrice(@Param("ids") List<BasicProduct> ids); // 최고가 순 ( 생성된지 2주 내 상품들 )  // select * from
                                                                        // (select * from product where create_date - now() <= 14) as p
                                                                        // join basic_product as b
                                                                        // where p.seq_basic_product = 1
                                                                        // order by b.selling_price desc;

   // List<Product> lowestPrice(); // 최저가 순 ( 생성된지 2주 내 상품들 )  // select * from
                                                                     // (select * from product where create_date - now() <= 14) as p
                                                                     // join basic_product as b
                                                                     // where p.seq_basic_product = 1
                                                                     // order by b.selling_price asc;
}
