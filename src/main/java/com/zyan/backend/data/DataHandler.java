package com.zyan.backend.data;

import com.zyan.backend.util.FileNameConvention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class DataHandler {

    private static final String AUDIO_PATH = "src/main/resources/static/audio/";

    private static final String IMAGE_PATH = "src/main/resources/static/image/";

    private static final String URI = "http://localhost:8080";

    @Autowired
    private FileNameConvention fileNameConvention;

    public String storeAudio(MultipartFile file, String songName) throws IOException {
        String fileName = fileNameConvention.convertToFileName(songName);
        String mimeType = ".m4a";
        java.io.File convertFile = new java.io.File(AUDIO_PATH + fileName + mimeType);
        convertFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convertFile);
        fos.write(file.getBytes());
        fos.close();
        return URI + "/audio/" + fileName + mimeType;
    }

    public String storeImage(MultipartFile file, String imageName) throws IOException {
        String fileName = fileNameConvention.convertToFileName(imageName);
        String mimeType = ".jpg";
        java.io.File convertFile = new java.io.File(IMAGE_PATH + fileName + mimeType);
        convertFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convertFile);
        fos.write(file.getBytes());
        fos.close();
        return URI + "/image/" + fileName + mimeType;
    }
}
