package com.dangjang.ha.controller;

import com.dangjang.dto.*;
import com.dangjang.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping(value="/dangjang/mypage/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final OrderProductService orderProductService;
    private final ProductService productService;
    private final ImageContentService imageContentService;
    private final HttpSession session;

    //작성 가능한 리뷰 목록 갖고오기
    @GetMapping(value = "/getWriteReviewList")
    public String getWriteReviewList(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        //리뷰 가능한 주문 아이템 리스트
        List<ReviewPossibleMapperDTO> reviewPossibleMapperDTOList = reviewService.getReviewPossibleList(pg);

        Map<String, Object> map = new HashMap<>();
        map.put("reviewPossibleMapperDTOList", reviewPossibleMapperDTOList);
        map.put("reviewPossiblePaging", reviewService.possiblePaging(pg));

        model.addAttribute("reviewPossibleMapperDTOList", reviewPossibleMapperDTOList);
        model.addAttribute("reviewPossiblePaging", reviewService.possiblePaging(pg));

        return "/mypage/snb05_01reviewWrite";
    }

    //리뷰 작성
    @PostMapping(value="/writeReview")
    @ResponseBody
    public void writeReview(@RequestParam Map<String, String> map,
                            MultipartHttpServletRequest request) {
        log.info("review -------------------------------: " + map);
        String memberId = session.getAttribute("memberId") + "";
        List<MultipartFile> fileList = request.getFiles("image");

        log.info("fileList : " + fileList);

        String filePath = session.getServletContext().getRealPath("/review");
        String fileName;
        File file;

        MultipartFile uploadFile = fileList.get(0);
        System.out.println("uploadFile>>>>>>>>>>>>>>>>>>>>>>>" + uploadFile);
        System.out.println("uploadFile>>>>>>>>>>>>>>>>>>>>>>>" + uploadFile.getOriginalFilename());

        if(!fileList.get(1).isEmpty() || fileList != null){
            MultipartFile uploadFile2 = fileList.get(1);
        }
        MultipartFile uploadFile2 = fileList.get(1); // error 안날려고 임시 입니다 ~
        System.out.println("uploadFile2>>>>>>>>>>>>>>>>>>>>>>>" + uploadFile2);
        System.out.println("uploadFile>>>>>>>>>>>>>>>>>>>>>>>" + uploadFile2.getOriginalFilename());

        if(!uploadFile.getOriginalFilename().isEmpty()) {
            int num = (int)(Math.random()*100+1);
            String numS = num + "";
            fileName = numS + memberId + "_1" + uploadFile.getOriginalFilename();
            file = new File(filePath, fileName);

            System.out.println("image1 fileName >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + fileName);

            try {
                uploadFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            map.put("image1", fileName);

        } else { //null인 경우에는 ""로
            map.put("image1", "");
        }

        if(!uploadFile2.getOriginalFilename().isEmpty()) {
            int num = (int)(Math.random()*100+1);
            String numS = num + "";
            fileName = numS + memberId + "_2" + uploadFile2.getOriginalFilename();
            file = new File(filePath, fileName);

            System.out.println("image2 fileName >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + fileName);

            try {
                uploadFile2.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            map.put("image2", fileName);

        } else { //null인 경우에는 ""로
            map.put("image2", "");
        }
        reviewService.writeReview(map);

        //review Check 1로
        orderProductService.changeReviewCheck(map);
    }

    //리뷰 작성한 목록 가져오기
    @GetMapping(value="/getWritenReviewList")
    //@ResponseBody
    public String getWritenReviewList(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        List<WrittenReviewMapperDTO> writtenReviewMapperDTOList = reviewService.getWrittenReviewList(pg);

        Map<String, Object> map = new HashMap<>();
        map.put("writtenReviewMapperDTOList", writtenReviewMapperDTOList);
        map.put("writenReviewPaging", reviewService.paging(pg));

        model.addAttribute("writtenReviewMapperDTOList", writtenReviewMapperDTOList);
        model.addAttribute("writenReviewPaging", reviewService.paging(pg));


        System.out.println("WrittenList>>>>>>>>>>>>>>>>>>>>>>>>>" +  writtenReviewMapperDTOList);
        return "/mypage/snb05_02myReview";
    }

    @GetMapping(value="/deleteReview")
    @ResponseBody
    public void deleteReview(@RequestParam Map<String, String> map) {
        String reviewNum = map.get("reviewNum");
        reviewService.deleteReview(reviewNum);
    }

    //리뷰 수정
    @PostMapping("/updateReview")
    @ResponseBody
    public void updateReview(@RequestParam Map<String, String> map,
                             MultipartHttpServletRequest request) {
        String memberId = session.getAttribute("memberId") + "";
        log.info("updateOto -------------------------------: " + map);
        List<MultipartFile> fileList = request.getFiles("image");
        log.info("fileList : " + fileList);
        String filePath = session.getServletContext().getRealPath("/review");
        String fileName;
        File file;
        MultipartFile uploadFile = fileList.get(0);

        System.out.println("uploadFile>>>>>>>>>>>>>>>>>>>>>>>" + uploadFile);


        if(!fileList.get(1).isEmpty() || fileList != null){
            MultipartFile uploadFile2 = fileList.get(1);
        }
        MultipartFile uploadFile2 = fileList.get(1); // error 안날려고 임시 입니다 ~

        System.out.println("uploadFile2>>>>>>>>>>>>>>>>>>>>>>>" + uploadFile2);

        if(!uploadFile.getOriginalFilename().isEmpty()) {
            int num = (int)(Math.random()*100+1);
            String numS = num + "";
            fileName = numS + memberId + "_1" + uploadFile.getOriginalFilename();
            file = new File(filePath, fileName);

            System.out.println("image1 fileName >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + fileName);

            try {
                uploadFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            map.put("image1", fileName);

        } else { //null인 경우에는 ""로
            map.put("image1", "");
        }

        if(!uploadFile2.getOriginalFilename().isEmpty()) {
            int num = (int)(Math.random()*100+1);
            String numS = num + "";
            fileName = numS + memberId + "_2" + uploadFile2.getOriginalFilename();
            file = new File(filePath, fileName);

            System.out.println("image2 fileName >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + fileName);

            try {
                uploadFile2.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            map.put("image2", fileName);

        } else { //null인 경우에는 ""로
            map.put("image2", "");
        }
        reviewService.updateReview(map);
    }

    @GetMapping("/countReview")
    public String countReview(Model model) {
        int possibleCount = reviewService.getReviewPossibleCount();
        int writtenCount = reviewService.getWrittenReviewCount();

        Map<String, Integer> map = new HashMap<>();
        map.put("possibleCount", possibleCount);
        map.put("writtenCount", writtenCount);

        model.addAttribute("map", map);

        return  "/mypage/snb05_review";
    }

}