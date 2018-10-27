package com.qa.service;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.domain.Cv;
import com.qa.repository.ICvRepository;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class CvService {

	@Autowired
	private ICvRepository iCvRepository;

	public List<Cv> getAllCv() {
	    return iCvRepository.findAll();
    }


    public ResponseEntity<Object> uploadCv(MultipartFile file) {
            try {
                Cv cv = new Cv();
                cv.setName("Testing");
                cv.setLastModified(new Date());
                cv.setCvFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
                iCvRepository.save(cv);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("Upload failed", HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity<>("File is successfully uploaded", HttpStatus.OK);
    }

//	public Cv downloadCv(Long id) {
//		return iCvRepository.findById(id).get();
//	}

    public Cv downloadCv(String id) {
	    //Will not return Cv is there is no cvFile.
        Cv cv = iCvRepository.findById(id).get();
        Binary document = cv.getCvFile();
        try {
            FileOutputStream fos = null;
            String fileDestination = "/home/tony308/Documents/" + cv.getName()+"'s_CV";
            fos = new FileOutputStream(fileDestination);
            //Will write Byte data to fileDestination
            fos.write(document.getData());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return cv;
        }
        return cv;
    }

	
	public ResponseEntity<Object> deleteCv(String id) {
//        Cv tempCv = iCvRepository.findById(id).get();
//        iCvRepository.delete(tempCv);
        iCvRepository.delete(iCvRepository.findById(id).get());

		return new ResponseEntity<>("CV successfully deleted", HttpStatus.OK);
	}


	//Successfully updates cvFile
	public ResponseEntity<Object> updateCv(String id, MultipartFile file) {
        Cv updatedCv = iCvRepository.findById(id).get();
        try {
            updatedCv.setCvFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            updatedCv.setLastModified(new Date());
            iCvRepository.save(updatedCv);

        } catch(IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to update.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("CV successfully updated.", HttpStatus.OK);
    }
}
