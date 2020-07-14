package com.jc.excel;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

@FunctionalInterface
public interface ExcelExportService {

    void makeWorkBoot(Map<String, Object> model, Workbook workBook);

}
