package com.example.demo.logic0207;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao0207.ReBoardDao0207;
import com.example.demo.model0206.ReactBoard0206;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ReBoardLogic0207 {

  @Autowired
  private ReBoardDao0207 reBoardDao = null; // 절대로 new 하면 안된다. - 빈관리를 받지 않는다.

  public List<Map<String, Object>> boardList(Map<String, Object> pmap) {
    log.info("boardList 호출 성공.");
    List<Map<String, Object>> bList = null;
    bList = reBoardDao.boardList(pmap);
    return bList;
  }

  public String imageUpload(MultipartFile image) {
    Map<String, Object> pmap = new HashMap<>();
    String savePath = "D:\\Java\\workspace_board\\mvc-board\\src\\main\\webapp\\pds0207\\";
    String fileName = null;
    String fullPath = null;

    // 이미지 파일이 존재하면 처리한다.
    // 같은 이름의 파일이 존재하면 안되니까 예방하는 코드 작성
    if (image != null && !image.isEmpty()) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
      Calendar time = Calendar.getInstance();
      fileName = sdf.format(time.getTime()) + "-" + image.getOriginalFilename().replaceAll("", "");
      fullPath = savePath + fileName;

      try {
        // file명을 클래스로 만들어 주는 클래스 File - 파일이름을 객체화 될 뿐 내용은 없다.
        File file = new File(fullPath);
        byte[] bytes = image.getBytes();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(bytes);
        bos.close();

        // 파일 처리하는 경우 - 추가 파일 정보가 필요할 때
        double size = Math.floor(file.length() / (1024.0 * 1024.0) * 10) / 10;
        log.info("size : " + size);
        pmap.put("file_name", fileName);
        pmap.put("file_size", size);
        pmap.put("file_path", fullPath);

      } catch (Exception e) {
        log.info(e.toString());
      }
    }
    return fileName;
  }

  public byte[] imageGet(String imageName) {
    log.info("imageGet");
    String fname = null;
    try {
      fname = URLDecoder.decode(imageName, "UTF-8");
      log.info(fname);
    } catch (Exception e) {

    }
    byte[] fileArray = null;
    return fileArray;
  }

  public int boardInsert(ReactBoard0206 board) {
    int result = -1;
    result = reBoardDao.boardInsert(board);
    return result;
  }

  public List<Map<String, Object>> boardDetail(Map<String, Object> pmap) {
    // 1. 상세조회를 한다.(where b_no = 5)
    // 2. 상세조회가 되면 조회수를 1증가 시킨다.
    // 3. 댓글이 존재하면 댓글을 목록에 포함 시킨다.
    List<Map<String, Object>> bList = null;
    bList = reBoardDao.boardList(pmap);
    if (bList.size() == 1) { // size()가 0이면 조회결과가 없고 1이면 조회결과가 있다.
      reBoardDao.hitCount(pmap);
    }

    // 댓글 가져오기
    List<Map<String, Object>> commList = reBoardDao.commentList(pmap);
    if (commList != null && commList.size() > 0) {
      Map<String, Object> cmap = new HashMap<>();
      cmap.put("comments", commList);
      bList.add(1, cmap);
    }
    return bList;
  } // end of boardDetail

}