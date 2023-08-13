package com.stc.assessments.backend.controller;

import com.stc.assessments.backend.model.enums.ItemType;
import com.stc.assessments.backend.services.FileServices;
import com.stc.assessments.backend.model.File;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequestMapping ("/files")
@RestController
public class FileController {


    @Autowired
    FileServices fileServices;
    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getFile(@PathVariable String fileName , @RequestParam String userEmail) {
        File file = fileServices.downloadFile ( fileName, userEmail);

        return ResponseEntity.ok()
                .header( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getItem ().getName() + "\"")
                .body(file.getBinary ());
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile( @RequestBody MultipartFile file ,
             @RequestParam(required =true) String parentItemName){
        log.info("FileController - uploadFile ");
        try {

            return ResponseEntity.ok(fileServices.uploadFile ( file,parentItemName ));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
