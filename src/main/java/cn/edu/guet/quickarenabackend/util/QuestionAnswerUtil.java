package cn.edu.guet.quickarenabackend.util;

import cn.edu.guet.quickarenabackend.entity.Question;
import cn.edu.guet.quickarenabackend.entity.QuestionDifficulty;

import java.time.LocalDateTime;

/**
 * 工具类：将题目与答案封装为Question对象
 */
public class  QuestionAnswerUtil {

  /**
   * 根据题目、答案和难度封装为Question实体（自动生成创建时间，无ID）
   * @param content 题目内容
   * @param answer  答案
   * @param difficulty 难度
   * @return Question实体
   */
  public static Question buildQuestion(String content, String answer, QuestionDifficulty difficulty) {
    return new Question(
        0L,
        content,
        answer,
        difficulty,
        LocalDateTime.now()
    );
  }

  /**
   * 根据题目、答案、难度、指定创建时间封装为Question实体（无ID）
   * @param content 题目内容
   * @param answer  答案
   * @param difficulty 难度
   * @param createTime 创建时间
   * @return Question实体
   */
  public static Question buildQuestion(String content, String answer, QuestionDifficulty difficulty, LocalDateTime createTime) {
    return new Question(
        0L,
        content,
        answer,
        difficulty,
        createTime
    );
  }

  /**
   * 全参数封装为Question实体
   * @param id        主键ID
   * @param content   题目内容
   * @param answer    答案
   * @param difficulty 难度
   * @param createTime 创建时间
   * @return Question实体
   */
  public static Question buildQuestion(long id, String content, String answer, QuestionDifficulty difficulty, LocalDateTime createTime) {
    return new Question(
        id,
        content,
        answer,
        difficulty,
        createTime
    );
  }
}