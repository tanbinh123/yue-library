package ai.yue.library.web.vo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ai.yue.library.web.util.CaptchaUtils;
import ai.yue.library.web.util.ServletUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图片验证码VO，可直接将图片验证码写入响应结果中
 * 
 * @author	ylyue
 * @since	2018年7月23日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaVO {

	/** 验证码 */
	String captcha;
	/** 验证码图片 */
	BufferedImage captchaImage;
	
	/**
	 * {@linkplain #captcha} set session
	 * <p>{@linkplain #captchaImage} write response
	 * <p>将验证码设置到session
	 * <p>将验证码图片写入response，并设置ContentType为image/png
	 */
	public void writeResponseAndSetSession() {
		HttpSession httpSession = ServletUtils.getSession();
		HttpServletResponse response = ServletUtils.getResponse();
		
		httpSession.setAttribute(CaptchaUtils.CAPTCHA_KEY, captcha);
        response.setContentType("image/png");
        
        OutputStream output;
		try {
			output = response.getOutputStream();
			// 响应结束时servlet会自动将output关闭
			ImageIO.write(captchaImage, "png", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
