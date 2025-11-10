//package Employee.Registration.demo.configuration;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.FileContent;
////import com.google.api.client.json.jackson2.JacksonFactory;.
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.DriveScopes;
//import com.google.api.services.drive.model.File;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.Collections;
//
//@Service
//public class GoogleDriveService {
//
//    private static final String APPLICATION_NAME = "Employee Upload App";
//    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
//
//    private Drive getDriveService() throws IOException, GeneralSecurityException {
//        GoogleCredential credential = GoogleCredential.fromStream(
//                        getClass().getResourceAsStream(CREDENTIALS_FILE_PATH))
//                .createScoped(Collections.singleton(DriveScopes.DRIVE_FILE));
//
//        return new Drive.Builder(
//                GoogleNetHttpTransport.newTrustedTransport(),
//                JacksonFactory.getDefaultInstance(),
//                credential)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
//
//    public String uploadFile(java.io.File file) throws IOException {
//        File fileMetadata = new File();
//        fileMetadata.setName(file.getName());
//
//        FileContent mediaContent = new FileContent("image/jpeg", file);
//
//        Drive driveService = getDriveService();
//        File uploadedFile = driveService.files().create(fileMetadata, mediaContent)
//                .setFields("id")
//                .execute();
//
//        return "https://drive.google.com/uc?id=" + uploadedFile.getId();
//    }
//}
