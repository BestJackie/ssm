package com.jc.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * FileName: ExcelView
 *
 * @author: haichaoyang3
 * @date: 2020/7/13 15:53
 * Description:
 * History:
 * since: 1.0.0
 */

public class ExcelView extends AbstractXlsView {

    private String fileName;
    private ExcelExportService excelExportService;

    public ExcelView(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    public ExcelView(String viewName, ExcelExportService excelExportService) {
        this.setBeanName(viewName);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ExcelExportService getExcelExportService() {
        return excelExportService;
    }

    public void setExcelExportService(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (Objects.isNull(excelExportService))
            throw new RuntimeException("导出服务接口不能为null");
        if (StringUtils.hasText(fileName)) {
            String reqCharSet = request.getCharacterEncoding();
            reqCharSet = Objects.isNull(reqCharSet) ? "UTF-8" : reqCharSet;
            fileName = new String(fileName.getBytes(reqCharSet), "ISO8859-1");
            response.setContentType("application/msexcel");
            response.setHeader("Content-disposition", "attachment;fileName=" + fileName);
        }
        excelExportService.makeWorkBoot(model,workbook);


    }
}
