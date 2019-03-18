package com.meixiang.beauty.webapp.education.util;

import com.meixiang.beauty.sys.entity.Article;
import com.meixiang.beauty.sys.entity.MusicMessage;
import com.meixiang.beauty.sys.entity.NewsMessage;
import com.meixiang.beauty.sys.entity.TextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum ClassCircleMessage {

	COURSE_COMMENT("课程点评", 1),
	VACATION_APPLY("请假处理", 2),
	HOMEWORK_COMMENT("作业处理", 3);

	// 成员变量
	private String name;
	private int index;
	// 构造方法
	private ClassCircleMessage(String name, int index) {
		this.name = name;
		this.index = index;
	}
	// 普通方法
	public static String getName(int index) {
		for (ClassCircleMessage c : ClassCircleMessage.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}
	// get set 方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
