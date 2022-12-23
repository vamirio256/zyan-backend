package com.zyan.backend.util;

import org.springframework.stereotype.Service;

@Service
public class FileNameConvention {

    public String convertToFileName(String name){
        return name.trim().toLowerCase().replaceAll(" ", "_");
    }
}
