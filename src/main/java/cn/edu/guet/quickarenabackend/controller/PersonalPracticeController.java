package cn.edu.guet.quickarenabackend.controller;

import cn.edu.guet.quickarenabackend.dto.PracticeRecordDetailDto;
import cn.edu.guet.quickarenabackend.dto.PracticeRecordDto;
import cn.edu.guet.quickarenabackend.dto.QuestionToUserDto;
import cn.edu.guet.quickarenabackend.entity.QuestionDifficulty;
import cn.edu.guet.quickarenabackend.entity.Result;
import cn.edu.guet.quickarenabackend.entity.ResultCode;
import cn.edu.guet.quickarenabackend.service.PersonalPracticeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalpractice")
public class PersonalPracticeController {

  @Autowired
  private PersonalPracticeService personalPracticeService;

  @GetMapping("/getquestions/{level}")
  public Result<List<QuestionToUserDto>> getQuestions(@PathVariable int level) {
    //判断难度等级是否存在
    try {
      QuestionDifficulty.fromValue(level);
    }catch (IllegalArgumentException e) {
      return Result.error(ResultCode.PARAM_ERROR.getCode(), "难度等级不存在！");
    }
    List<QuestionToUserDto> questions = personalPracticeService.getPracticeQuestions(level);
    return Result.success(questions);
  }

  @PostMapping("/submitrecords")
  public Result<Void> submitRecords(HttpServletRequest request,@RequestBody List<PracticeRecordDto> practiceRecordDtoList) {
    Object userIdObj = request.getAttribute("userId");
    if (userIdObj == null) {
      return Result.error(ResultCode.UNAUTHORIZED, null);
    }
    Long userId;
    try {
      userId = Long.valueOf(userIdObj.toString());
    } catch (Exception e) {
      return Result.error(ResultCode.UNAUTHORIZED, null);
    }
    boolean success = personalPracticeService.submitPracticeRecord(userId ,practiceRecordDtoList);
    if (success) {
      return Result.success();
    } else {
      return Result.error(ResultCode.FAIL, null);
    }
  }

  @GetMapping("/checkmyrecord")
  public Result<List<PracticeRecordDetailDto>> getMyPracticeRecord(HttpServletRequest request) {
    Object userIdObj = request.getAttribute("userId");
    if (userIdObj == null) {
      return Result.error(ResultCode.UNAUTHORIZED, null);
    }
    Long userId;
    try {
      userId = Long.valueOf(userIdObj.toString());
    } catch (Exception e) {
      return Result.error(ResultCode.UNAUTHORIZED, null);
    }
    List<PracticeRecordDetailDto> success = personalPracticeService.getPracticeRecordDetails(userId);
    if (success != null && success.size() > 0) {
      return Result.success(success);
    } else {
      return Result.error(ResultCode.FAIL, null);
    }
  }
}
