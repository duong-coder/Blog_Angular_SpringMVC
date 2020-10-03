//package com.dependency.inject.stack.web.rest;
//
//import com.dependency.inject.stack.service.dto.UploadFileDTO;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//
//import static com.dependency.inject.stack.common.ResourcesConstants.RESOURCE_API;
//
///**
// * The type Upload file controller.
// */
//@RestController
//@RequestMapping(RESOURCE_API)
//public class UploadFileController {
//
//    /**
//     * Upload file response entity.
//     *
//     * @param multipartFile the multipart file
//     * @param request       the request
//     * @return the response entity
//     */
//    @PostMapping("/upload-avatar")
//    public ResponseEntity<UploadFileDTO> uploadFile(@RequestParam("file") MultipartFile multipartFile,
//                                                    HttpServletRequest request) {
//        StringBuilder urlFile = new StringBuilder();
//        String fileName = "";
//        try {
//            fileName = multipartFile.getOriginalFilename();
//            File file = new File(this.getFolderUpload(request), fileName);
//            multipartFile.transferTo(file);
//
//            urlFile.append("http://");
//            urlFile.append(request.getServerName());
//            urlFile.append(":");
//            urlFile.append(request.getServerPort());
//            urlFile.append(request.getContextPath());
//            urlFile.append("/uploads/");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return ResponseEntity.ok(new UploadFileDTO(fileName, urlFile.toString()));
//    }
//
//
//    /**
//     * Upload location response entity.
//     *
//     * @param request the request
//     * @return the response entity
//     */
//    @GetMapping("/upload")
//    public ResponseEntity<UploadFileDTO> uploadLocation(HttpServletRequest request) {
//        StringBuilder urlFile = new StringBuilder();
//        urlFile.append("http://");
//        urlFile.append(request.getServerName());
//        urlFile.append(":");
//        urlFile.append(request.getServerPort());
//        urlFile.append(request.getContextPath());
//        urlFile.append("/uploads/");
//
//        return ResponseEntity.ok(new UploadFileDTO("", urlFile.toString()));
//    }
//
//    private File getFolderUpload(HttpServletRequest request) {
////        File folderUpload = new File(System.getProperty("user.home") + "/uploads");
//        File folderUpload = new File(request.getServletContext().getRealPath("/uploads/"));
//        if (!folderUpload.exists()) {
//            folderUpload.mkdirs();
//        }
//        return folderUpload;
//    }
//
//}