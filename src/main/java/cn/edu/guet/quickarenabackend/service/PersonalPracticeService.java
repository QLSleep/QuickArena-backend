package cn.edu.guet.quickarenabackend.service;

import cn.edu.guet.quickarenabackend.dto.PracticeRecordDetailDto;
import cn.edu.guet.quickarenabackend.dto.PracticeRecordDto;
import cn.edu.guet.quickarenabackend.dto.QuestionToUserDto;

import java.util.List;

public interface PersonalPracticeService {

  //获取练习题
  public List<QuestionToUserDto> getPracticeQuestions(int level);

  //提交练习记录
  public boolean submitPracticeRecord(long userId, List<PracticeRecordDto> practiceRecordDtoList);

  public List<PracticeRecordDetailDto> getPracticeRecordDetails(long userId);
}
