package cn.edu.guet.quickarenabackend.util.generator.impl;

import cn.edu.guet.quickarenabackend.util.generator.ExpressionGenerator;

import java.util.Random;

/**
 * 难度一：100以内加减法
 */
public class Level1Generator implements ExpressionGenerator {
  private static final Random RANDOM = new Random();

  @Override
  public String[] generate() {
    int a = RANDOM.nextInt(101);
    int b = RANDOM.nextInt(101);
    boolean isAdd = RANDOM.nextBoolean();

    String expr;
    int answer;
    if (isAdd) {
      expr = a + " + " + b + " = ?";
      answer = a + b;
    } else {
      if (a < b) { int temp = a; a = b; b = temp; }
      expr = a + " - " + b + " = ?";
      answer = a - b;
    }
    return new String[]{expr, String.valueOf(answer)};
  }
}