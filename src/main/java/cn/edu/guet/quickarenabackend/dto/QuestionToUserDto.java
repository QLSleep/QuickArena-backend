package cn.edu.guet.quickarenabackend.dto;

import cn.edu.guet.quickarenabackend.entity.Question;

public class QuestionToUserDto {

  private String content;

  private String answer;

  public QuestionToUserDto(String content, String answer) {
    this.content = content;
    this.answer = answer;
  }

  public QuestionToUserDto(Question question) {
    this.content = question.getContent();
    this.answer = question.getAnswer();
  }

  public QuestionToUserDto() {
  }

  @Override
  public String toString() {
    return "QuestionToUserDto{" +
        "content='" + content + '\'' +
        ", answer='" + answer + '\'' +
        '}';
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
