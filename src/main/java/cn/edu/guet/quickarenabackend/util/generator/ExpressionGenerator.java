package cn.edu.guet.quickarenabackend.util.generator;

/**
 * 表达式生成器接口
 */
public interface ExpressionGenerator {
  /**
   * 生成一道题目和答案
   * @return String[0]: 题目, String[1]: 答案
   */
  String[] generate();
}