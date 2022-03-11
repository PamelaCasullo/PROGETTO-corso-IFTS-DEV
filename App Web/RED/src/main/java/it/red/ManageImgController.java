package it.red;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ManageImgController {

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(
			@RequestParam Photo photo) {

		MultipartFile uploadFile = photo.getUploadfile();
		String name = photo.getInstitutional_email();
		try {

			String directory = "./src/main/resources/static/red_img";
			String filePath = Paths.get(directory, name).toString();

			BufferedOutputStream stream =
					new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(uploadFile.getBytes());
			stream.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
