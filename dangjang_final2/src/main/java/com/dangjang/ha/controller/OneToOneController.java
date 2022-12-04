package com.dangjang.ha.controller;

import com.dangjang.domain.ImageContent;
import com.dangjang.domain.type.ImageType;
import com.dangjang.domain.type.RequestType;
import com.dangjang.dto.ImageContentDTO;
import com.dangjang.dto.OneToOneRequestDTO;
import com.dangjang.dto.OneToOneRequestMapperDTO;
import com.dangjang.dto.OneToOneRequestMapperSDTO;
import com.dangjang.service.ImageContentService;
import com.dangjang.service.OneToOneRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping(value="/dangjang/mypage/oto")
public class OneToOneController {
    private final OneToOneRequestService oneToOneRequestService;
    private final HttpSession session;
    private final ImageContentService imageContentService;

    @GetMapping(value="/qnaRegister")
    public String qnaRegister(Model model) {
        model.addAttribute("display", "/mypage/snb09_01OtoWriteForm.jsp");

        return "index";
    }

    @GetMapping(value="/test")
    public String test() {
        return "onetoone";
    }

    @PostMapping(value="/writeOto")
    @ResponseBody
    public void writeOto(@RequestParam Map<String, String> map,
                         // @RequestParam("uploadFile") MultipartFile[] uploadFile,
                         MultipartHttpServletRequest request,
                         Model model ) {
        String memberId = session.getAttribute("memberId") + "";
        log.info("writeOto -------------------------------: " + map);
        List<MultipartFile> fileList = request.getFiles("image");
        log.info("fileList : " + fileList);
        String filePath = session.getServletContext().getRealPath("/storage");
        String fileName;
        File file;
        MultipartFile uploadFile = fileList.get(0);
        if(!fileList.get(1).isEmpty() || fileList != null){
            MultipartFile uploadFile2 = fileList.get(1);
        }
        MultipartFile uploadFile2 = fileList.get(1); // error 안날려고 임시 입니다 ~
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
        oneToOneRequestService.registerOto(map);
    }




    @GetMapping(value="/getOtoList")
    //@ResponseBody
    public String getOneToOneList(@RequestParam(required = false, defaultValue = "1") String pg
            ,Model model) {
        System.out.println("getOneToOneList---------------------------------------- pg : " + pg);

        //1:1문의 목록(페이징 처리)
        List<OneToOneRequestMapperSDTO> otoList = oneToOneRequestService.getOneToOneList(pg);

        System.out.println("qnaList-------------------------------" + otoList);

        Map<String, Object> map = new HashMap<>();
        map.put("otoList", otoList);
        map.put("paging", oneToOneRequestService.paging(pg));

        model.addAttribute("otoList", otoList);
        model.addAttribute("paging", oneToOneRequestService.paging(pg));

        return "/mypage/snb09_01personalQna";
    }



    @PostMapping(value="/updateOto")
    @ResponseBody
    public void updateOto(@RequestParam Map<String, String> map,
                          MultipartHttpServletRequest request, Model model ) {
        String memberId = session.getAttribute("memberId") + "";
        log.info("updateOto -------------------------------: " + map);
        List<MultipartFile> fileList = request.getFiles("image");
        log.info("fileList : " + fileList);
        String filePath = session.getServletContext().getRealPath("/storage");
        String fileName;
        File file;
        MultipartFile uploadFile = fileList.get(0);
        if(!fileList.get(1).isEmpty() || fileList != null){
            MultipartFile uploadFile2 = fileList.get(1);
        }
        MultipartFile uploadFile2 = fileList.get(1); // error 안날려고 임시 입니다 ~
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
        oneToOneRequestService.updateOto(map);
    }
//    @GetMapping(value = "/qnaRegister")
//    public String perQnaWrite(Model model){
//        model.addAttribute("display", "mypage/snb09_01OtoWriteForm.jsp");
//        return "index";
//    }

    @PostMapping(value="/deleteOto")
    @ResponseBody
    public void deleteOto(@RequestParam Map<String, String> map) {
        //해당 1:1이 답변이 달렸는지 아닌지 확인
        //OneToOneRequestMapperDTO oneToOneRequestMapperDTO = oneToOneRequestService.checkReplyOto(map);
        oneToOneRequestService.deleteOto(map);
    }
}
