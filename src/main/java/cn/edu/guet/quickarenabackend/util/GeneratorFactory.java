package cn.edu.guet.quickarenabackend.util;

import cn.edu.guet.quickarenabackend.util.generator.ExpressionGenerator;
import cn.edu.guet.quickarenabackend.util.generator.impl.Level1Generator;
import cn.edu.guet.quickarenabackend.util.generator.impl.Level2Generator;
import cn.edu.guet.quickarenabackend.util.generator.impl.Level3Generator;

/**
 * 难度等级表达式生成器工厂
 */
public class GeneratorFactory {
  /**
   * 根据难度等级获取对应的表达式生成器
   * @param level 难度等级（1开始）
   * @return ExpressionGenerator实现
   */
  public static ExpressionGenerator getGenerator(int level) {
    switch (level) {
      case 1: return new Level1Generator();
      case 2: return new Level2Generator();
      case 3: return new Level3Generator();
      default:
        throw new IllegalArgumentException("暂不支持的难度等级: " + level);
    }
  }
}