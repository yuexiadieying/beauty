package com.meixiang.beauty.webapp.education.controller;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.InstanceReturnMoneySignalDTO;
import com.meixiang.beauty.common.dto.transaction.MonthTransactionRecordDTO;
import com.meixiang.beauty.common.dto.transaction.OrderProductRelationDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.sys.utils.ObjectUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.File;
import java.util.*;


@Controller
@RequestMapping(value = "system")
public class EducationExcelController {

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "importStudent", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO importStudent() {
		ResponseDTO responseDto=new ResponseDTO<>();

		File file = new File("C:\\xls\\student.xls");// 表格存储的位置
		List<Map<String, String>> list = readExcel(file);

		for(Map<String,String> data:list)
		{
			try
			{

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return responseDto;
	}

	@RequestMapping(value = "importTeacher", method = {RequestMethod.POST, RequestMethod.GET})
	public
	@ResponseBody
	ResponseDTO importTeacher() {
		ResponseDTO responseDto=new ResponseDTO<>();

		File file = new File("C:\\xls\\teacher.xls");// 表格存储的位置
		List<Map<String, String>> list = readExcel(file);

		for(Map<String,String> data:list)
		{
			try
			{


			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return responseDto;
	}

	private static List<Map<String,String>> readExcel(File file){
		List<Map<String, String>>list =new ArrayList<Map<String,String>>();
		try {
			// 判断文件是否存在
			// 创建工作簿
			Workbook workbook = Workbook.getWorkbook(file);
			// 获得第一个工作表sheet1
			Sheet sheet = workbook.getSheet(0);
			// 获得数据
			for (int i = 1; i < sheet.getRows(); i++) {// sheet.getRows():获得表格文件行数
				Map<String, String>map = new HashMap<String, String>();
				for (int j = 0; j < sheet.getColumns(); j++) {// sheet.getColumns():获得表格文件列数
					Cell cell = sheet.getCell(j, i);
					//    System.out.print(cell.getContents() + " ");
					map.put(sheet.getCell(j,0).getContents(), cell.getContents());
					//(列，行)
				}
				//System.out.println("");// 换行
				list.add(map);
			}
			System.out.println(list);
			workbook.close();// 关闭
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
