package ai.yue.library.test.ipo;

import ai.yue.library.base.validation.annotation.Cellphone;
import ai.yue.library.base.validation.annotation.IdCard;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * 将`@Valid`注解添加到POJO类上
 *
 * @author  ylyue
 * @version 创建时间：2018年9月25日
 */
@Data
@Valid
//@Validated
public class ValidationAnnotationInIPO {

    @NotEmpty(message = "姓名不能为空")
    @Length(max = 20, message = "姓名不能超过20个字")
    private String name;
    
    private LocalDate birthday;
    
    @IdCard(notNull = false)
    private String idcard;
    
    @Max(30)
    @Min(12)
    private int age;
    
    @Email
    @Length(max = 50)
    private String email;
    
    @Cellphone
    private String cellphone;
    
    @Pattern(regexp = "[1-9]([0-9]{5,11})")
    private String qq;
    
}
