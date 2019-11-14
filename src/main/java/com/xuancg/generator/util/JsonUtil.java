package com.xuancg.generator.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 处理JSON相关的工具类
 * 
 * @author xuancg
 * @date 2018年6月22日
 */
public class JsonUtil {

	 private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	/**
	 * 单位缩进字符串tab
	 */									  
	private static final String SPACE = "   "; 
	
	private JsonUtil() {
	}

	/**
	 * 
	 * @author xuancg
	 * @date 2018年6月22日
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String object2Json(Object object){
		if (object == null){
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();

		try {
			return  mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error("JSON转化异常：", e);
		}
		return null;
	}

	
	/**
	 * JSON转换为ArrayList/HashMap/Array等集合
	 * 
	 * @author xuancg
	 * @date 2018年6月22日
	 * @param jsonStr
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static <T> T json2Collection(String jsonStr)  {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonStr, new TypeReference<T>() {});
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * JSON转换为对象集合
	 * 
	 * @author xuancg
	 * @date 2018年6月22日
	 * @param jsonStr
	 * @param new TypeReference<List<clazz>>() { }
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static <T> T json2CollectionObj(String jsonStr , TypeReference<T> type)  {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonStr, type);
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String str = "[{\"toUser\":\"张锋\",\"toPhone\":\"17111111111\",\"signType\":\"0\"},{\"toUser\":\"阿斯蒂芬\",\"toPhone\":\"19485757462\",\"signType\":\"\"},{\"toUser\":\"阿斯蒂芬2\",\"toPhone\":\"193835652\",\"signType\":\"\"},{\"carbonUser\":\"撒旦法\",\"carbonPhone\":\"193843753285\"},{\"carbonUser\":\"暗杀\",\"carbonPhone\":\"19375632423\"}]";
		//System.out.println(json2CollectionObj(str,new TypeReference<List<FileSignatory>>() { }));
	}
	/**
	 * Json转换为Pojo
	 * @author xuancg
	 * @date 2018年6月22日
	 * @param jsonStr
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T json2Pojo(String jsonStr,Class<T> clazz)  {
		try{
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonStr, clazz);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @author xcg
	 * @date 2018/08/03
	 * 实现json字符串格式化输出
	 * @param json
	 * @return
	 */
	public  static String formatJson(String json) {
		StringBuffer result = new StringBuffer();
		int length = json.length();
		int number = 0;
		char key = 0;
		//遍历字符串
		for(int i=0;i<length;i++) {
			key = json.charAt(i);
			if((key == '[') || (key == '{')) {
				if((i-1>0) && (json.charAt(i-1) == ':')) {
					result.append('\n');
					result.append(indent(number));
				}
				result.append(key);
				result.append('\n');
				number++;
				result.append(indent(number));
				continue;
			}
			
			if((key == ']') || (key == '}')) {
				result.append('\n');
				number--;
				result.append(indent(number));
				result.append(key);
				
				if(((i+1) <length) && (json.charAt(i+1) != ',')) {
					result.append('\n');
				}
				continue;
			}
			
			//当前字符为逗号，逗号后面换行、缩进、不改变缩进次数
			if(key == ',' ) {
				result.append(key);
				result.append('\n');
				result.append(indent(number));
				continue;
			}
			
			result.append(key);
			
		}
		return result.toString();
	}
	
	/**
	 * 返回制定次数的缩进字符串，每一次缩进三个空格
	 * @param number
	 * @return
	 */
	private static String indent(int number) {
		StringBuffer result = new StringBuffer();
		for(int i=0;i<number;i++) {
			result.append(SPACE);
		}
		return result.toString();
	}
	
	
	
}
