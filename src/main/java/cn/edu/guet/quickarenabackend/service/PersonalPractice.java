package cn.edu.guet.quickarenabackend.service;

import cn.edu.guet.quickarenabackend.dto.QuestionToUserDto;
import cn.edu.guet.quickarenabackend.entity.Question;

import java.util.List;

public interface PersonalPractice {

  //获取练习题
  public List<QuestionToUserDto> getPracticeQuestions(int level);

  //提交练习记录
//  public void submitPracticeRecord();
}
