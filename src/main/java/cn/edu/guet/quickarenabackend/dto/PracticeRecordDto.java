package cn.edu.guet.quickarenabackend.dto;

import java.time.LocalDateTime;

/**
 * 前端传递的练习记录数据，不包含id和userId
 */
public class PracticeRecordDto {
  private Long questionId;
  private String userAnswer;
  private Integer isCorrect;
  private LocalDateTime recordTime;

  public PracticeRecordDto(Long questionId, String userAnswer, Integer isCorrect, LocalDateTime recordTime) {
    this.questionId = questionId;
    this.userAnswer = userAnswer;
    this.isCorrect = isCorrect;
    this.recordTime = recordTime;
  }

  public PracticeRecordDto() {
  }

  @Override
  public String toString() {
    return "PracticeRecordDto{" +
        "questionId=" + questionId +
        ", userAnswer='" + userAnswer + '\'' +
        ", isCorrect=" + isCorrect +
        ", recordTime=" + recordTime +
        '}';
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public String getUserAnswer() {
    return userAnswer;
  }

  public void setUserAnswer(String userAnswer) {
    this.userAnswer = userAnswer;
  }

  public Integer getIsCorrect() {
    return isCorrect;
  }

  public void setIsCorrect(Integer isCorrect) {
    this.isCorrect = isCorrect;
  }

  public LocalDateTime getRecordTime() {
    return recordTime;
  }

  public void setRecordTime(LocalDateTime recordTime) {
    this.recordTime = recordTime;
  }
}