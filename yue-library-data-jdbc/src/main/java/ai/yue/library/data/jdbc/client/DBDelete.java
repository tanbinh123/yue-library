package ai.yue.library.data.jdbc.client;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import ai.yue.library.base.exception.DBException;
import ai.yue.library.base.util.MapUtils;
import ai.yue.library.base.util.StringUtils;
import ai.yue.library.base.view.ResultErrorPrompt;

/**
 * <h2>SQL优化型数据库操作</h2>
 * Created by sunJinChuan on 2016/6/6
 * @since 0.0.1
 */
class DBDelete extends DBUpdate {
	
	// Delete
	
    private String deleteSql(String tableName) {
		// 1.确认参数
		if (StringUtils.isEmpty(tableName)) {
			throw new DBException("表名不能为空");
		}
        
        // 2.开始安全拼接SQL
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM ");
        sql.append(tableName);
        sql.append(" WHERE id = :id");
        
        return sql.toString();
    }
    
	/**
     * 根据ID删除对应数据
     * @param tableName    	表名
     * @param id     		需要删除的对应数据的主键id
     */
	@Transactional
    public void delete(String tableName, Long id) {
		// 1.确认条件
		if (null == id) {
			throw new DBException("删除条件不能为空");
		}
        
		// 2. 获得SQL
		String sql = deleteSql(tableName);
		
		JSONObject paramJSON = new JSONObject();
        paramJSON.put("id", id);
        int updateRowsNumber = namedParameterJdbcTemplate.update(sql.toString(), paramJSON);
        
        if (updateRowsNumber != 1) {
        	throw new DBException(ResultErrorPrompt.DELETE_ERROR);
        }
    }
	
	/**
     * <b>根据ID</b>批量删除优化SQL<br><br>
     * <b>相对</b>条件批量删除优化SQL可参照如下编写：<br>
     * <code>DELETE FROM table WHERE id IN (:id)</code><br>
     * @param tableName    	表名
     * @param paramJSONs     需要删除的Map数组（key=id, value=具体值）
     * @return
     */
	@Transactional
    public void deleteBatch(String tableName, JSONObject[] paramJSONs) {
		// 1.确认条件
		if (MapUtils.isEmptys(paramJSONs)) {
			throw new DBException("删除条件不能为空");
		}
        
		// 2. 获得SQL
		String sql = deleteSql(tableName);
		
        int updateRowsNumber = namedParameterJdbcTemplate.batchUpdate(sql, paramJSONs).length;
        
        if (updateRowsNumber != paramJSONs.length) {
        	throw new DBException(ResultErrorPrompt.DELETE_ERROR_BATCH);
        }
    }
	
}
