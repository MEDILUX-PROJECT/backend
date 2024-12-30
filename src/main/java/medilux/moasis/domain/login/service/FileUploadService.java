//package medilux.moasis.domain.login.service;
//
//import com.amazonaws.SdkClientException;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.UUID;
//
//@RequiredArgsConstructor
//@Service
//public class FileUploadService {
//
//    private final AmazonS3Client s3Client;
//
//    @Value("${app.s3.bucket}")
//    private String bucketName;
//
//    @Value("${defaultUrl}")
//    private String defaultUrl;
//
//    public String uploadFile(MultipartFile file) throws IOException {
//
//        if(file == null){
//            return null;
//        }
//
//        String fileName = generateFileName(file);
//
//        try {
//            s3Client.putObject(bucketName, fileName, file.getInputStream(), getObjectMetadata(file));
//            return s3Client.getUrl(bucketName, fileName).toString();
//        } catch (SdkClientException e) {
//            throw new IOException("Error uploading file to S3", e);
//        }
//    }
//
//    private ObjectMetadata getObjectMetadata(MultipartFile file) {
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setContentType(file.getContentType());
//        objectMetadata.setContentLength(file.getSize());
//        return objectMetadata;
//    }
//
//    private String generateFileName(MultipartFile file) {
//        return UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
//    }
//
//}
