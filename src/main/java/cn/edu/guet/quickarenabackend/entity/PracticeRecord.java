package cn.edu.guet.quickarenabackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("practice_record")
public class PracticeRecord {

  @TableId(type = IdType.AUTO)
  private Long id;

  @TableField("user_id")
  private Long userId;

  @TableField("question_id")
  private Long questionId;

  @TableField("user_answer")
  private String userAnswer;

  @TableField("is_correct")
  private Integer isCorrect;

  @TableField("record_time")
  private LocalDateTime recordTime;

  public PracticeRecord(Long id, Long userId, Long questionId, String userAnswer, Integer isCorrect, LocalDateTime recordTime) {
    this.id = id;
    this.userId = userId;
    this.questionId = questionId;
    this.userAnswer = userAnswer;
    this.isCorrect = isCorrect;
    this.recordTime = recordTime;
  }

  public PracticeRecord() {
  }

  @Override
  public String toString() {
    return "PracticeRecord{" +
        "id=" + id +
        ", userId=" + userId +
        ", questionId=" + questionId +
        ", userAnswer='" + userAnswer + '\'' +
        ", isCorrect=" + isCorrect +
        ", recordTime=" + recordTime +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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
