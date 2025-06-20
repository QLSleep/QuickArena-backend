package cn.edu.guet.quickarenabackend.mapper;

import cn.edu.guet.quickarenabackend.dto.PracticeRecordDetailDto;
import cn.edu.guet.quickarenabackend.entity.PracticeRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PracticeRecordMapper extends BaseMapper<PracticeRecord> {

  int insertBatch(@Param("records") List<PracticeRecord> records);

  List<PracticeRecordDetailDto> selectUserPracticeRecordDetail(@Param("userId") Long userId);
}
