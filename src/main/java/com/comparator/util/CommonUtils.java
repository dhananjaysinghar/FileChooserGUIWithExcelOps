package com.comparator.util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.comparator.domain.Account;

public class CommonUtils {

	public static void runJob(String path) throws Exception {
		List<Account> accountDetailsList = CommonUtils.extractAccountDetails(path);

		List<String> accountList = accountDetailsList.stream().map(Account::getAccNo).collect(Collectors.toList());

		List<String> encodedAccountList = CommonUtils.getEncodedAccountList(accountList);

		System.out.println(accountDetailsList);
		System.out.println("Account List: " + accountList);
		System.out.println("Encoded Account List: " + encodedAccountList);
	}

	public static List<String> getEncodedAccountList(List<String> accountList) {
		return accountList.stream().map(CommonUtils::encode).collect(Collectors.toList());

	}

	private static String encode(String value) {
		return Base64.getEncoder().encodeToString(value.getBytes());
	}

	public static List<Account> extractAccountDetails(String path) throws Exception {
		List<Account> accountList = new ArrayList<>();
		String actualPath = resolvePath(path);
		try (Workbook workbook = WorkbookFactory.create(new File(actualPath));) {
			accountList = getData(workbook);
		}
		return accountList;
	}

	private static List<Account> getData(Workbook workbook) throws Exception {
		List<Account> accountList = new ArrayList<>();
		Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++) {
			Account account = new Account();
			Field[] declaredFields = account.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				if (field.isAnnotationPresent(IndexNo.class)) {
					int index = field.getAnnotation(IndexNo.class).index();
					Row row = sheet.getRow(i);
					Cell cell = row.getCell(index);
					cell.setCellType(CellType.STRING);
					String value = cell.getStringCellValue();
					field.setAccessible(true);
					field.set(account, value);
				}
			}
			accountList.add(account);
		}
		return accountList;
	}

	private static String resolvePath(String path) throws Exception {
		String actualPath = "";
		if (path != null && !path.contains(":")) {
			actualPath = ClassLoader.getSystemResource(path).toURI().getPath();
		} else {
			actualPath = path;
		}
		return actualPath;
	}

	public static void start() {
		new FileUploadGUI().setVisible(true);
	}
}
