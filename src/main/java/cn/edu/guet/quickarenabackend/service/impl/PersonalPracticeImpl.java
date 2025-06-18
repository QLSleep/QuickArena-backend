package cn.edu.guet.quickarenabackend.service.impl;

import cn.edu.guet.quickarenabackend.dto.QuestionToUserDto;
import cn.edu.guet.quickarenabackend.entity.Question;
import cn.edu.guet.quickarenabackend.entity.QuestionDifficulty;
import cn.edu.guet.quickarenabackend.mapper.QuestionMapper;
import cn.edu.guet.quickarenabackend.service.PersonalPractice;
import cn.edu.guet.quickarenabackend.util.GeneratorFactory;
import cn.edu.guet.quickarenabackend.util.QuestionAnswerUtil;
import cn.edu.guet.quickarenabackend.util.generator.ExpressionGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalPracticeImpl implements PersonalPractice {

  @Autowired
  private QuestionMapper questionMapper;

  /***
   * 获取练习题
   * 传入难度等级作为参数
   * 返回封装后的题目实体类列表
   * @param level
   * @return List<Question>
   */
  @Override
  public List<QuestionToUserDto> getPracticeQuestions(int level) {
    ExpressionGenerator generator = GeneratorFactory.getGenerator(level);
    List<Question> questionList = new ArrayList<>();
    List<QuestionToUserDto> questionToUserDtoList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      String[] qa = generator.generate();
      System.out.println((i + 1)+" 题目: " + qa[0] + " 答案: " + qa[1]);
      questionList.add(QuestionAnswerUtil.buildQuestion(qa[0], qa[1], QuestionDifficulty.fromValue(level), LocalDateTime.now()));
    }
    //将生成的题目插入数据库
    questionMapper.insertBatch(questionList);
    for (Question question : questionList) {
      questionToUserDtoList.add(new QuestionToUserDto(question));
    }
    return questionToUserDtoList;
  }
}
