package cn.edu.guet.quickarenabackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("question")
public class Question {

  @TableId(type = IdType.AUTO)
  private Long id;

  @TableField("content")
  private String content;

  @TableField("answer")
  private String answer;

  @TableField("difficulty")
  private QuestionDifficulty difficulty;

  @TableField("create_time")
  private LocalDateTime createTime;

  public Question(long id, String content, String answer, QuestionDifficulty difficulty, LocalDateTime createTime) {
    this.id = id;
    this.content = content;
    this.answer = answer;
    this.difficulty = difficulty;
    this.createTime = createTime;
  }

  public Question() {
  }

  @Override
  public String toString() {
    return "Question{" +
        "id=" + id +
        ", content='" + content + '\'' +
        ", answer='" + answer + '\'' +
        ", difficulty=" + difficulty +
        ", createTime=" + createTime +
        '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public QuestionDifficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(QuestionDifficulty difficulty) {
    this.difficulty = difficulty;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
}
