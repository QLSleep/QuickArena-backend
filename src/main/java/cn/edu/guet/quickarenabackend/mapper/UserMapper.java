package cn.edu.guet.quickarenabackend.mapper;

import cn.edu.guet.quickarenabackend.entity.Game;
import cn.edu.guet.quickarenabackend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
