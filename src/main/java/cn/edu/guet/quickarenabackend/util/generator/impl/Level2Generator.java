package cn.edu.guet.quickarenabackend.util.generator.impl;

import cn.edu.guet.quickarenabackend.util.generator.ExpressionGenerator;

import java.util.Random;

/**
 * 难度二：100以内加减乘除
 */
public class Level2Generator implements ExpressionGenerator {
  private static final Random RANDOM = new Random();

  @Override
  public String[] generate() {
    int a = RANDOM.nextInt(101);
    int b = RANDOM.nextInt(101);
    char[] ops = {'+', '-', '*', '/'};
    char op = ops[RANDOM.nextInt(4)];
    String expr;
    String answer;

    if (op == '+') {
      expr = a + " + " + b + " = ?";
      answer = String.valueOf(a + b);
    } else if (op == '-') {
      if (a < b) { int temp = a; a = b; b = temp; }
      expr = a + " - " + b + " = ?";
      answer = String.valueOf(a - b);
    } else if (op == '*') {
      a = RANDOM.nextInt(13); // 乘法避免结果过大
      b = RANDOM.nextInt(13);
      expr = a + " * " + b + " = ?";
      answer = String.valueOf(a * b);
    } else { // division
      b = RANDOM.nextInt(12) + 1; // 1~12
      int result = RANDOM.nextInt(13); // 0~12
      a = b * result;
      expr = a + " / " + b + " = ?";
      answer = String.valueOf(result);
    }
    return new String[]{expr, answer};
  }
}