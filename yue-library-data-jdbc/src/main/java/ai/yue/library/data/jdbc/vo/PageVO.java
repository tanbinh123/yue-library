package ai.yue.library.data.jdbc.vo;

import ai.yue.library.base.view.R;
import ai.yue.library.base.view.Result;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果
 * 
 * @author	ylyue
 * @since	2018年7月18日
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> {
	
	/** 总数 */
	Long count;
	/** 分页列表数据 */
	List<T> data;
	
	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		json.put("count", count);
		json.put("data", data);
		return json;
	}
	
	/**
	 * 将分页结果转换成最外层响应对象
	 * 
	 * @return HTTP请求，最外层响应对象
	 */
	public Result<List<T>> toResult() {
		return R.success(count, data);
	}
	
}
