package com.stc.assessments.backend.services;

import com.stc.assessments.backend.model.File;

import com.stc.assessments.backend.model.Item;
import com.stc.assessments.backend.model.Permission;
import com.stc.assessments.backend.model.enums.ItemType;
import com.stc.assessments.backend.model.enums.PermissionLevel;
import com.stc.assessments.backend.repository.FileRepository;
import com.stc.assessments.backend.repository.ItemRepository;
import com.stc.assessments.backend.repository.PermissionGroupRepository;
import com.stc.assessments.backend.repository.PermissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
@Slf4j
public class FileServices {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    PermissionGroupRepository permissionGroupRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    FileRepository fileRepository;

    public File downloadFile(String fileName, String userEmail ) {

        Permission permission = permissionRepository.findByUserEmail ( userEmail );
        if ( permission != null & permission.getPermissionLevel ( ) != null & permission.getPermissionLevel ( ).name ( ).equals ( PermissionLevel.EDIT.name ( ) ) ) {

            File file = fileRepository.findByItemName ( fileName ).get ( 0 );


            return file;
        }
       return  null;
    }

    public File uploadFile(MultipartFile file , String parentItemName) throws IOException {
        try {
            //String fileName = StringUtils.cleanPath ( file.getOriginalFilename ( ) );

            File fileDB = new File ( );
            Item parentItem = itemRepository.findByName ( parentItemName );
            Item fileItem = new Item ( );
            fileItem.setType ( ItemType.File.name ( ) );
            fileItem.setParent ( parentItem );
            fileItem.setName ( "test2.txt" );
            fileDB.setItem ( fileItem );
            fileDB.setBinary ( file.getBytes ( ) );
            return fileRepository.save ( fileDB );
        }
        catch ( Exception e ){
            e.printStackTrace (  );
            return null;
        }
    }
}
