package ai.yue.library.test.controller.base.validation;

import ai.yue.library.base.util.ParamUtils;
import ai.yue.library.base.validation.Validator;
import ai.yue.library.base.view.R;
import ai.yue.library.base.view.Result;
import ai.yue.library.test.ipo.ValidationIPO;
import ai.yue.library.test.ipo.ValidationIPO2;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * @author  ylyue
 * @version 创建时间：2019年6月25日
 */
@RestController
@RequestMapping("/validation")
public class ValidationController {

	@Autowired
	private Validator validator;
	
	/**
	 * valid
	 * @param validationIPO
	 * @return
	 */
	@PostMapping("/valid")
	public Result<?> valid(@Valid ValidationIPO validationIPO) {
		System.out.println(validationIPO);
		return R.success(validationIPO);
	}
	
	/**
	 * validatorValid
	 * @param validationIPO
	 * @return
	 */
	@PostMapping("/validatorValid")
	public Result<?> validatorValid(ValidationIPO validationIPO) {
		validator.valid(validationIPO);
		System.out.println(validationIPO);
		return R.success(validationIPO);
	}
	
	/**
	 * validatorParam
	 * @param validationIPO
	 * @return
	 */
	@PostMapping("/validatorParam")
	public Result<?> validatorParam(ValidationIPO validationIPO) {
		// 参数
		String name = validationIPO.getName();
		String email = validationIPO.getEmail();
		String cellphone = validationIPO.getCellphone();
		int age = validationIPO.getAge();
		LocalDate birthday = validationIPO.getBirthday();
		
		// 单个参数校验
		validator.param(email).email("email");
		validator.param(cellphone).cellphone("cellphone");
		validator.param(name).notNull("name").chinese("name").length(1, 30, "name");
		
		// 单个参数校验-通过param()连写（连写直接切换校验对象）
		validator.param(name).notNull("name").param(email).length(5, 25, "email").param(age).min(20, "age").max(60, "age");
		
		// POJO对象校验-通过调用validator.valid()方法
		validator.valid(validationIPO);
		// 同样支持连写
		validator.valid(validationIPO).param(birthday).birthday("birthday");
		
		// 返回结果
		return R.success(validationIPO);
	}

	/**
	 * valid2
	 * @param validationIPO2
	 * @return
	 */
	@PostMapping("/valid2")
	public Result<?> valid2(ValidationIPO2 validationIPO2) {
		System.out.println(validationIPO2);
		return R.success(validationIPO2);
	}

	@PostMapping("/validJson")
	public Result<?> validJson(JSONObject paramJson) {
		String[] mustContainKeys = {"name", "birthday", "idcard"};
		String[] canContainKeys = {"age", "cellphone"};
		ParamUtils.paramValidate(paramJson, mustContainKeys, canContainKeys);
		return R.success(paramJson);
	}

}
