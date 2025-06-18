package cn.edu.guet.quickarenabackend.util.generator.impl;

import cn.edu.guet.quickarenabackend.util.generator.ExpressionGenerator;

import java.util.Random;

/**
 * 难度三：包含一元一次方程、一元二次方程（仅双根）、平方和/平方差、差和平方题型
 * 题目全部为“解x”类型，答案随题给出，便于判题
 *
 * 所有返回值均为长度2的字符串数组：
 * [0] 题目文本（如 "x^2 - 5x + 6 = 0，x=?"）
 * [1] 答案文本，格式如下：
 *     - 一元一次方程、平方和/差、差和平方型：只有一个解，格式为 "x=某值"
 *     - 一元二次方程（仅双根）：格式为 "x1=某值, x2=某值"
 * 你可直接用字符串分割或正则提取结果！
 */
public class Level3Generator implements ExpressionGenerator {
  private static final Random RANDOM = new Random();

  /**
   * 随机生成一种难度三的题目类型
   * 0: 一元一次方程
   * 1: 一元二次方程（双根）
   * 2: 平方和/平方差型
   * 3: 差和平方型
   *
   * @return 长度为2的字符串数组 String[]:
   *         [0] 题目文本，例如："2x + 3 = 13，x=?"
   *         [1] 答案文本，见本类JavaDoc顶部说明
   */
  @Override
  public String[] generate() {
    int type = RANDOM.nextInt(4);
    switch (type) {
      case 0:
        return generateLinear();      // 一元一次方程
      case 1:
        return generateQuadratic();   // 一元二次方程（双根）
      case 2:
        return generateSquareSumOrDiff();  // 平方和/平方差
      case 3:
        return generateSquarePlusOrMinusAlt(); // 差和平方
      default:
        return new String[]{"未定义题型", ""};
    }
  }

  /**
   * 生成一元一次方程：ax + b = c，解x
   * 例如：2x + 3 = 13，x=5
   *
   * @return String[]:
   *         [0] 题目文本，如 "2x + 3 = 13，x=?"
   *         [1] 答案文本，格式为 "x=5"
   */
  private String[] generateLinear() {
    int a = randomNonZero(-10, 10); // 系数a，非零
    int x = RANDOM.nextInt(21) - 10; // x的解，-10~10
    int b = RANDOM.nextInt(21) - 10; // 常数b，-10~10
    int c = a * x + b; // 右侧结果
    String q = a + "x " + (b >= 0 ? "+ " : "- ") + Math.abs(b) + " = " + c + "，x=?";
    return new String[]{q, "x=" + x};
  }

  /**
   * 生成一元二次方程：x^2 + bx + c = 0，解x;
   * a = 1 , x1 + x2 = -(b/a) , x1 * x2 = c/a
   * 例如：x^2 - 5x + 6 = 0，x1=2, x2=3
   *
   * @return String[]:
   *         [0] 题目文本，如 "x^2 - 5x + 6 = 0，x=?"
   *         [1] 答案文本，格式始终为 "x1=2,x2=3"
   */
  private String[] generateQuadratic() {
    int x1 = RANDOM.nextInt(15) - 7; // 根1
    int x2 = RANDOM.nextInt(15) - 7; // 根2
    int b = -(x1 + x2);
    int c = x1 * x2;
    String q = "x^2 " + (b >= 0 ? "+ " : "- ") + Math.abs(b) + "x " +
        (c >= 0 ? "+ " : "- ") + Math.abs(c) + " = 0，x=?";
    String aStr;
    if (x1 == x2){
      aStr = "x="+x1;
    } else {
      aStr = "x=" + x1 + ",x=" + x2;
    }
    return new String[]{q, aStr};
  }

  /**
   * 生成平方和/平方差型题目：x^2 ± a^2 = k，解x
   * 例如：x^2 + 9 = 25，x=4
   *      x^2 - 9 = 7，x=4
   *
   * @return String[]:
   *         [0] 题目文本，如 "x^2 + 9 = 25，x=?"
   *         [1] 答案文本，格式为 "x=4,x=-4"
   */
  private String[] generateSquareSumOrDiff() {
    boolean isSum = RANDOM.nextBoolean(); // true:平方和，false:平方差
    int a = RANDOM.nextInt(9) + 1; // a取1~9
    int x;
    if (isSum){
      x = RANDOM.nextInt(16) + 1;
    } else {
      // 平方差，x必须>=a且x≠0
      do {
        x = RANDOM.nextInt(16) + 1;
      } while (x < a);
    }
    int k = isSum ? (x * x + a * a) : (x * x - a * a);
    String op = isSum ? "+" : "-";
    String q = "x^2 " + op + " " + a + "^2 = " + k + "，x=?";
    return new String[]{q, "x=" + x + ",x=" + (-x)};
  }

  /**
   * 生成差和平方型题目：(x ± a)^2 = k，解x
   * 例如：(x+3)^2=49，x=4
   *      (x-5)^2=36，x=11
   *
   * @return String[]:
   *         [0] 题目文本，如 "(x + 3)^2 = 49，x=?"
   *         [1] 答案文本，格式为 "x=4,x=-10"
   */
  private String[] generateSquarePlusOrMinusAlt() {
    boolean isPlus = RANDOM.nextBoolean(); // true:加，false:减
    int a = RANDOM.nextInt(10) + 1; // a取1~10
    int x, k, sqrtK, x1, x2;
    while (true){
      x = RANDOM.nextInt(21) - 10;//x取-10~10
      int base = isPlus ? (x + a) : (x - a);
      k = base * base;
      if (k > 100 || k == 0) continue;//展开后右项不能超过100也不能为0
      sqrtK = (int)Math.sqrt(k);
      if (isPlus){
        x1 = sqrtK - a;
        x2 = -sqrtK -a;
      }else {
        x1 = sqrtK + a;
        x2 = -sqrtK + a;
      }
      if (x1 < -100 || x1 > 100 || x2 < -100 || x2 > 100) continue;
      break;
    }
    String sign = isPlus ? "+" : "-";
    String q = "(x " + sign + " " + a + ")^2 = " + k + "，x=?";
    String ans = x1 == x2 ? "x=" + x1 : "x=" + x1 + ",x=" + x2;
    return new String[]{q, ans};
  }

  /**
   * 辅助生成非零整数
   * @param min 最小值（含）
   * @param max 最大值（含）
   * @return 非零的随机整数
   */
  private int randomNonZero(int min, int max) {
    int val = 0;
    while (val == 0) {
      val = RANDOM.nextInt(max - min + 1) + min;
    }
    return val;
  }
}