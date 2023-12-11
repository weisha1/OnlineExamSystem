package com.rabbiter.oes.controller;

import com.rabbiter.oes.entity.ApiResult;
import com.rabbiter.oes.excel.export.MultiChoiceExport;
import com.rabbiter.oes.service.ramdonquestion.MultiChoiceQuestionService;
import com.rabbiter.oes.util.ApiResultHandler;
import com.rabbiter.oes.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YMH
 * @version V1.0
 * @Package com.rabbiter.oes.controller
 * @date 2023/12/8/0008 16:47
 */
@RestController("/question")
public class QuestionBankImportController {
    @Autowired
    private MultiChoiceQuestionService multiChoiceQuestionService;


    @GetMapping("/build/template")
    public void downloadBuildTemplate(HttpServletResponse response) {
        String fileName = "导入用户模板";
        String sheetName = "导入用户模板";
        try {
            ExcelUtil.writeExcel(response, null, fileName, sheetName, MultiChoiceExport.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/importMulti")
    public ApiResult importMulti(MultipartFile file) {
        try {

            multiChoiceQuestionService.importMulti(file.getInputStream());
            return ApiResultHandler.success();
        } catch (IOException e) {
            throw new RuntimeException("用户信息导入");
        }
    }
}
