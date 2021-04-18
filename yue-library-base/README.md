## 介绍
　　基础库提供了丰富的Java工具包，它能够帮助我们简化每一行代码（集成[Hutool](https://hutool.cn)工具包）。<br>
　　同时也自动装配了一系列的基础Bean，可在<b>application.yml</b>文件中配置关闭，所有配置项皆是以`yue.*`开头，如：`yue.cors.allow=false`代表不允许跨域。
- 丰富的Java基础工具类，对文件、流、加密解密、转码、正则、线程、XML等JDK方法进行封装
- `Result`Http最外层响应对象，更适应RESTful风格API
- 默认开启热加载、热部署、支持跨域，一键解决联调问题
- 基于`validator`扩展IPO增强校验注解，更适合国内校验场景。（如：手机号、身份证号码）
- 全局统一异常处理基类，结合`Result`对象，定位异常更轻松，前端显示更贴切
- 异步线程池：共用父线程上下文环境，异步执行任务时不丢失token

## 配置项
　　`yue-library-base`自动装配了一系列的基础Bean与环境配置项，可在<b>application.yml</b>文件中配置关闭，所有配置项皆是以`yue.*`开头，如：`yue.cors.allow=false`代表不允许跨域。

### 默认配置项
- Validator-校验器 （唯一Bean，可直接覆盖）
- RestTemplate-HTTPS客户端 （唯一Bean，可直接覆盖）
- ConstantProperties-yue常量配置 （AES密钥、RSA公钥、RSA私钥、Token超时时间、验证码超时时间等）

### 可选配置项
- ExceptionHandlerConfig-全局统一异常处理 `yue.exception-handler.*`
- AsyncConfig-异步线程池（共用父线程上下文环境，异步执行任务时不丢失token） `yue.thread-pool.async.*`
- CorsConfig-跨域配置 `yue.cors.allow`

## 工具类
依托于`Hutool`工具包等，进行校正与增强，简单强大只有你想不到。

### 类型转换器
[参考](https://hutool.cn/docs/#/core/类型转换/类型转换工具类-Convert)

提供简单全面的类型转换，适合更多的业务场景，内置hutool、fastjson、yue三种类型转换器，判断精确性能强大，未知类型兼容性更强

### 校验
全面简单的校验框架，更适合国内校验场景，支持多种校验方式，配合全局异常处理，只为更好的`RESTful`

## 文档说明
　　基础工具包文档见：[`hutool-core`](https://hutool.cn/docs)<br>
　　更多工具包文档见本示例说明：[工具类](base-工具类.md)，[校验](base-校验.md) ...