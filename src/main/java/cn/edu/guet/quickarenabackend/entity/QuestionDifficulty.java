package cn.edu.guet.quickarenabackend.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum QuestionDifficulty {
  VERYEASY(1),
  EASY(2),
  MEDIUM(3);

  @EnumValue
  private final int value;

  QuestionDifficulty(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  // 可选：通过数字反查枚举
  public static QuestionDifficulty fromValue(int value) {
    for (QuestionDifficulty d : values()) {
      if (d.value == value) {
        return d;
      }
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
