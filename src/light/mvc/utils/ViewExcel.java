package light.mvc.utils;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import light.mvc.pageModel.sys.User;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * 生成excel视图，可用excel工具打开或者保存
 * 由ViewController的return new ModelAndView(viewExcel, model)生成
 */
public class ViewExcel extends AbstractExcelView {

	@Override
	public void buildExcelDocument(Map model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String excelName = "用户统计.xls";
		// 设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(excelName, "UTF-8"));

		List stuList = (List) model.get("list");
		// 产生Excel表头
		HSSFSheet sheet = workbook.createSheet("绩效考核");
		HSSFRow header = sheet.createRow(0); // 第0行
		// 产生标题列
		header.createCell((short) 0).setCellValue("ID");
		header.createCell((short) 1).setCellValue("名称");
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));

		// 填充数据
		int rowNum = 1;
		for (Iterator iter = stuList.iterator(); iter.hasNext();) {
			User element = (User) iter.next();
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell((short) 0).setCellValue(element.getId());
			row.createCell((short) 1).setCellValue(element.getName());
		}

		// 列总和计算
		/*
		 * HSSFRow row = sheet.createRow(rowNum);
		 * row.createCell((short) 0).setCellValue("TOTAL:");
		 * String formual = "SUM(D2:D" + rowNum + ")"; // D2到D[rowNum]单元格起(count数据)
		 * row.createCell((short) 3).setCellFormula(formual);
		 */
	}
}