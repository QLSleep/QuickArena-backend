package cn.edu.guet.quickarenabackend.controller;

import cn.edu.guet.quickarenabackend.dto.QuestionToUserDto;
import cn.edu.guet.quickarenabackend.entity.Question;
import cn.edu.guet.quickarenabackend.entity.QuestionDifficulty;
import cn.edu.guet.quickarenabackend.entity.Result;
import cn.edu.guet.quickarenabackend.entity.ResultCode;
import cn.edu.guet.quickarenabackend.service.PersonalPractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personalpractice")
public class PersonalPracticeController {

  @Autowired
  private PersonalPractice personalPractice;

  @GetMapping("/getquestions/{level}")
  public Result<List<QuestionToUserDto>> getQuestions(@PathVariable int level) {
    //判断难度等级是否存在
    try {
      QuestionDifficulty.fromValue(level);
    }catch (IllegalArgumentException e) {
      return Result.error(ResultCode.PARAM_ERROR.getCode(), "难度等级不存在！");
    }
    List<QuestionToUserDto> questions = personalPractice.getPracticeQuestions(level);
    return Result.success(questions);
  }

}
