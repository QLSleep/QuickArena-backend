package cn.edu.guet.quickarenabackend.dto;

import cn.edu.guet.quickarenabackend.entity.QuestionDifficulty;
import com.alibaba.fastjson2.annotation.JSONField;

import java.time.LocalDateTime;

public class PracticeRecordDetailDto {
  @JSONField(ordinal = 1)
  private Long recordId;

  @JSONField(ordinal = 2)
  private Long questionId;

  @JSONField(ordinal = 3)
  private String questionContent;

  @JSONField(ordinal = 4)
  private String correctAnswer;

  @JSONField(ordinal = 5)
  private String userAnswer;

  @JSONField(ordinal = 6)
  private Integer isCorrect;

  @JSONField(ordinal = 7)
  private QuestionDifficulty questionDifficulty;

  @JSONField(ordinal = 8)
  private LocalDateTime recordTime;

  public PracticeRecordDetailDto(Long recordId, Long questionId, String questionContent, String correctAnswer, String userAnswer, Integer isCorrect, LocalDateTime recordTime) {
    this.recordId = recordId;
    this.questionId = questionId;
    this.questionContent = questionContent;
    this.correctAnswer = correctAnswer;
    this.userAnswer = userAnswer;
    this.isCorrect = isCorrect;
    this.recordTime = recordTime;
  }

  public PracticeRecordDetailDto() {
  }

  @Override
  public String toString() {
    return "PracticeRecordDetailDto{" +
        "recordId=" + recordId +
        ", questionId=" + questionId +
        ", questionContent='" + questionContent + '\'' +
        ", correctAnswer='" + correctAnswer + '\'' +
        ", userAnswer='" + userAnswer + '\'' +
        ", isCorrect=" + isCorrect +
        ", recordTime=" + recordTime +
        '}';
  }

  public Long getRecordId() {
    return recordId;
  }

  public void setRecordId(Long recordId) {
    this.recordId = recordId;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public String getQuestionContent() {
    return questionContent;
  }

  public void setQuestionContent(String questionContent) {
    this.questionContent = questionContent;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
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

  public QuestionDifficulty getQuestionDifficulty() {
    return questionDifficulty;
  }

  public void setQuestionDifficulty(QuestionDifficulty questionDifficulty) {
    this.questionDifficulty = questionDifficulty;
  }

  public LocalDateTime getRecordTime() {
    return recordTime;
  }

  public void setRecordTime(LocalDateTime recordTime) {
    this.recordTime = recordTime;
  }
}
