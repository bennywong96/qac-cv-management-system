package com.qa.service;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.domain.Cv;
import com.qa.repository.ICvRepository;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class CvService {

	@Autowired
	private ICvRepository iCvRepository;

	public List<Cv> getAllCv() {
	    return iCvRepository.findAll();
    }


    public ResponseEntity<Object> uploadCv(MultipartFile file, String name) {
            try {
                Binary fileToBinaryStorage = new Binary(BsonBinarySubType.BINARY, file.getBytes());
                Cv cv = new Cv(name, fileToBinaryStorage);
                cv.setLastModified(new Date());
                iCvRepository.save(cv);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("Upload failed", HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity<>("File is successfully uploaded", HttpStatus.OK);
    }

    public Cv downloadCv(String id) {
        Cv cv = iCvRepository.findById(id).get();
        //Writes file to PC
//        Binary document = cv.getCvFile();
//        try {
//            FileOutputStream fos = null;
//            String fileDestination = "/home/tony308/Documents/" + cv.getName()+"'s_CV";
//            fos = new FileOutputStream(fileDestination);
//            //Will write Byte data to fileDestination
//            fos.write(document.getData());
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return cv;
//        }
        return cv;
    }

	
	public ResponseEntity<Object> deleteCv(String id) {
        iCvRepository.delete(iCvRepository.findById(id).get());
		return new ResponseEntity<>("CV successfully deleted", HttpStatus.OK);
	}

	public ResponseEntity<Object> updateCv(String id, MultipartFile file, String name) {
        Cv cvToUpdate = iCvRepository.findById(id).get();
        if (name.equals("")) {
            name = cvToUpdate.getName();
        }
        try {
            Binary updatedCvBinary = new Binary(BsonBinarySubType.BINARY, file.getBytes());
            cvToUpdate.setCvFile(updatedCvBinary);
            cvToUpdate.setLastModified(new Date());
            cvToUpdate.setName(name);
            iCvRepository.save(cvToUpdate);

        } catch(IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to update.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("CV successfully updated.", HttpStatus.OK);
    }
}