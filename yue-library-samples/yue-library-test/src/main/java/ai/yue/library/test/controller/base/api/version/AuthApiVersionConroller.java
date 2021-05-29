package ai.yue.library.test.controller.base.api.version;

import ai.yue.library.base.annotation.api.version.ApiVersion;
import ai.yue.library.base.view.R;
import ai.yue.library.base.view.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author	ylyue
 * @since	2019年8月2日
 */
@ApiVersion(2)
@RestController
@RequestMapping("/auth/{version}/apiVersion")
public class AuthApiVersionConroller {

	/**
	 * get
	 * <p>弃用API接口版本演示
	 * 
	 * @param version
	 * @return
	 */
	@ApiVersion(deprecated = true)
	@GetMapping("/get")
	public Result<?> get(@PathVariable String version) {
		return R.success("get：" + version);
	}
	
	/**
	 * get2
	 * 
	 * @param version
	 * @return
	 */
	@ApiVersion(value = 2, deprecated = true)
	@GetMapping("/get")
	public Result<?> get2(@PathVariable String version) {
		return R.success("get2：" + version);
	}
	
	/**
	 * get3
	 * 
	 * @param version
	 * @return
	 */
	@ApiVersion(3.1)
	@GetMapping("/get")
	public Result<?> get3(@PathVariable String version) {
		return R.success("get3：" + version);
	}
	
	/**
	 * get4
	 * 
	 * @param version
	 * @return
	 */
	@ApiVersion(4)
	@GetMapping("/get")
	public Result<?> get4(@PathVariable String version) {
		return R.success("get4：" + version);
	}

	/**
	 * 性能测试
	 */
	@ApiVersion(5.2)
	@GetMapping("/performance")
	public Result<?> performance(@PathVariable String version, String cellphone, Long id) {
		return R.success(cellphone+id);
	}

}
