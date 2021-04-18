package ai.yue.library.data.es.config.rest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * ES REST 可配置属性定义
 * 
 * @author	ylyue
 * @since	2020年8月28日
 */
@Data
@ConfigurationProperties(EsRestProperties.PREFIX)
public class EsRestProperties {

	/**
	 * Prefix of {@link EsRestProperties}.
	 */
	public static final String PREFIX = "yue.es.rest";
	
	/**
	 * 是否启用 <code style="color:red">Elasticsearch RestHighLevelClient</code> 自动配置
	 * <p>默认：false
	 */
	private boolean enabled = false;
	/**
	 * localhost:80
	 */
	private List<String> hostAndPort;
	/**
	 * 开启HTTPS协议进行通信
	 * <p>默认：false
	 */
	private boolean useSsl = false;
	/**
	 * 信任自签证书
	 * <p>默认：true
	 */
	private boolean trustSelfSigned = true;
	/**
	 * hostname验证
	 * <p>默认：false
	 */
	private boolean hostnameVerification = false;
	private String username;
	private String password;
	/**
	 * 连接超时毫秒
	 */
	private long connectTimeoutMillis = 25000L;
	/**
	 * socket超时毫秒
	 */
	private long socketTimeoutMillis = 15000L;

}
