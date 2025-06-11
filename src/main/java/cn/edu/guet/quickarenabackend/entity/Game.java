package cn.edu.guet.quickarenabackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("game")
public class Game {
  @TableId(type = IdType.AUTO)
  private Long id;

  @TableField("player1_id")
  private Long player1Id;

  @TableField("player2_id")
  private Long player2Id;

  @TableField("start_time")
  private LocalDateTime startTime;

  @TableField("end_time")
  private LocalDateTime endTime;

  @TableField("status")
  private String status;

  @TableField("winner_id")
  private Long winnerId;

  @TableField("result")
  private String result;

  public Game(Long id, Long player1Id, Long player2Id, LocalDateTime startTime, LocalDateTime endTime, String status, Long winnerId, String result) {
    this.id = id;
    this.player1Id = player1Id;
    this.player2Id = player2Id;
    this.startTime = startTime;
    this.endTime = endTime;
    this.status = status;
    this.winnerId = winnerId;
    this.result = result;
  }

  public Game() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPlayer1Id() {
    return player1Id;
  }

  public void setPlayer1Id(Long player1Id) {
    this.player1Id = player1Id;
  }

  public Long getPlayer2Id() {
    return player2Id;
  }

  public void setPlayer2Id(Long player2Id) {
    this.player2Id = player2Id;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getWinnerId() {
    return winnerId;
  }

  public void setWinnerId(Long winnerId) {
    this.winnerId = winnerId;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "Game{" +
        "id=" + id +
        ", player1Id=" + player1Id +
        ", player2Id=" + player2Id +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", status='" + status + '\'' +
        ", winnerId=" + winnerId +
        ", result='" + result + '\'' +
        '}';
  }
}