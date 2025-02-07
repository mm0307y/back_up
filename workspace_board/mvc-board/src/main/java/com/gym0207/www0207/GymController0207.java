package com.gym0207.www0207;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class GymController0207 {
  @RequestMapping("/gym")
  public String gym(){
    log.info("gym 호출 성공");
    return "gym";
  }
}
