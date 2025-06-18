package cn.edu.guet.quickarenabackend.mapper;

import cn.edu.guet.quickarenabackend.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
  void insertBatch(@Param("list") List<Question> questionList);
}
