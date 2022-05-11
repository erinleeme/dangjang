package com.dangjang.service;

import com.dangjang.domain.BasicProduct;
import com.dangjang.domain.Product;
import com.dangjang.dto.*;
import com.dangjang.mapper.ImageMapper;
import com.dangjang.repository.ImageContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImageContentService {
    private final ImageContentRepository imageContentRepository;
    @Autowired
    private ImageMapper imageMapper;

    public BasicProductMapperDTO getProductImage(ProductMapperDTO productMapperDTO) {
        BasicProductMapperDTO basicProductMapperDTO = imageMapper.getOneImage(productMapperDTO);

        return basicProductMapperDTO;
    }

    public List<BasicProductMapperDTO> productImage(List<ProductMapperDTO> productList) { // seq_product 값으로 해당하는 이미지 뽑아오기 순서 동일

        List<Long> ids = new ArrayList<>();
        for(int i = 0; i < productList.size(); i++) { // seq_basic_product 값만 추출
            ids.add(productList.get(i).getSeq_basic_product());
        } // for

        List<BasicProductMapperDTO> imageList = imageMapper.getImageCode(productList);
        System.out.println(imageList);

        return imageList;
    }


//    @Transactional
//    public Long saveQnaFile(ImageContentDTO imageContentDTO) {
//        return imageContentRepository.save(imageContentDTO.toEntity()).getId();
//    }
//
//    @Transactional
//    public ImageContentDTO getQnaFile(Long id) {
//        ImageContent imageContent = imageContentRepository.findById(id).get();
//
//        ImageContentDTO imageContentDTO = ImageContentDTO.builder()
//                .id(id)
//                .originalName(imageContent.getOriginalName())
//                .uploadName(imageContent.getUploadName())
//                .imageType(imageContent.getImageType())
//                .imageTypeSeq(imageContent.getImageTypeSeq())
//                .build();
//        return imageContentDTO;
//    }

    public void registerImage(ImageContentDTO imageContentDTO) {
        imageMapper.registerImage(imageContentDTO);
    }
}
