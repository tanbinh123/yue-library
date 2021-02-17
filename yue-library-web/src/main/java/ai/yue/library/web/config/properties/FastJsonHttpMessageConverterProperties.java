package ai.yue.library.web.config.properties;

import ai.yue.library.base.constant.FieldNamingStrategyEnum;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * FastJson HTTP消息转换器配置
 * 
 * @author	ylyue
 * @since	2020年4月6日
 */
@Data
@ConfigurationProperties(FastJsonHttpMessageConverterProperties.PREFIX)
public class FastJsonHttpMessageConverterProperties {
	
	/**
	 * Prefix of {@link FastJsonHttpMessageConverterProperties}.
	 */
	public static final String PREFIX = WebProperties.PREFIX + ".http-message-converter.fastjson";
	
	/**
	 * 启用FastJson优先于默认的Jackson做json解析
	 * <p>默认：false
	 */
	private boolean enabled = false;

	/**
	 * 启用属性声明顺序进行序列化排序
	 * <p>FastJson序列化时默认根据字母（ASCII）排序而非成员变量声明顺序，详情见：<a href="https://github.com/alibaba/fastjson/issues/3115">#3115</a></p>
	 */
	private boolean enablePropertyDefineOrderSerializer = true;

	/**
	 * 字段命名策略
	 */
	private FieldNamingStrategyEnum fieldNamingStrategy;
	
	/**
	 * 自定义序列化特性
	 * <p>HTTP序列化时对null值进行初始化处理，默认做如下配置：
	 * <pre>
	 * SerializerFeature.PrettyFormat, // 格式化Json文本
	 * SerializerFeature.BrowserCompatible, // 浏览器兼容（IE）
	 * SerializerFeature.IgnoreErrorGetter, // 忽略错误的字段Get方法
	 * SerializerFeature.WriteDateUseDateFormat, // 对时间类型进行格式化（默认：yyyy-MM-dd HH:mm:ss）
	 * SerializerFeature.WriteMapNullValue, // 对Null值进行输出
	 * SerializerFeature.WriteNullListAsEmpty, // Null List 输出为 []
	 * SerializerFeature.WriteNullStringAsEmpty // Null String 输出为空字符串
	 * SerializerFeature.WriteNullBooleanAsFalse // Null Boolean 输出为 false
	 * </pre>
	 */
	private SerializerFeature[] serializerFeatures = {
			SerializerFeature.PrettyFormat, // 格式化Json文本
			SerializerFeature.BrowserCompatible, // 浏览器兼容（IE）
			SerializerFeature.IgnoreErrorGetter, // 忽略错误的字段Get方法
			SerializerFeature.WriteDateUseDateFormat, // 对时间类型进行格式化（默认：yyyy-MM-dd HH:mm:ss）
			SerializerFeature.WriteMapNullValue, // 对Null值进行输出
			SerializerFeature.WriteNullListAsEmpty, // Null List 输出为 []
			SerializerFeature.WriteNullStringAsEmpty, // Null String 输出为空字符串
			SerializerFeature.WriteNullBooleanAsFalse // Null Boolean 输出为 false
//			SerializerFeature.WriteNullNumberAsZero // Null Number 输出为 0
	};
	
	/**
	 * 输出Null值为空字符串
	 * <p>排除 {@link #getSerializerFeatures()} 中可配置的Null处理（基本数据类型、List、Boolean）
	 * <p>排除 {@link #isWriteNullMapAsEmpty()} (Map)
	 * <p>默认：false
	 */
	private boolean writeNullAsStringEmpty = false;
	
	/**
	 * 输出 Null Map 为 {}
	 * <p>默认：true
	 */
	private boolean writeNullMapAsEmpty = true;
	
	/**
	 * 输出 Null Array 为 []
	 * <p>默认：true
	 */
	private boolean writeNullArrayAsEmpty = true;
	
}
