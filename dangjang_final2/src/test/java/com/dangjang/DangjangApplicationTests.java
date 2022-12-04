package com.dangjang;

import com.dangjang.dto.CartMapperDTO;
import com.dangjang.dto.NoticeDTO;
import com.dangjang.dto.NoticeMapperDTO;
import com.dangjang.dto.ProductMapperDTO;
import com.dangjang.mapper.CartMapper;
import com.dangjang.mapper.NoticeMapper;
import com.dangjang.service.CartService;
import com.dangjang.service.ProductService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DangjangApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void 회원가입(){

    }
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void connection_test(){
        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            System.out.println("커넥션 성공");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Autowired
    private NoticeMapper noticeMapper;

    @Test
    @Transactional
    @Rollback
    @DisplayName("mybatis 공지 리스트 테스트")
    public void noticeList(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startPage", 1);
        map.put("endPage", 10);
        List<NoticeMapperDTO> list = noticeMapper.getNoticeList(map);
        System.out.println(list);
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("mybatis 총 글 수")
    public void getTotalRecords(){
        int totalSize = noticeMapper.getTotalRecords();
        System.out.println(totalSize);
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("mybatis 상세보기")
    public void getNotice(){
        NoticeMapperDTO noticeMapperDTO = noticeMapper.getNotice("3");
        System.out.println(noticeMapperDTO);
    }

    @Autowired
    private ProductService productService;

    @Test
    @Transactional
    @Rollback
    @DisplayName("카테고리 수 체크")
    public void categoryCount(){
        int productCount = productService.getProductCount("D1", "null");
        System.out.println(productCount);
    }


    @Autowired
    private CartService cartService;

    @Test
    @Transactional
    @Rollback
    @DisplayName("카트 리스트 체크")
    public void cartList(){
        List<CartMapperDTO> cartProductCount = cartService.getUserCartCount();
        List<ProductMapperDTO> cartProduct = cartService.getUserCartList(cartProductCount);
        System.out.println(cartProduct);
    }


}
