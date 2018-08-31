# springboot-girl
springboot增删改查

### 1 master分支
基本的增删改查

### 2 develop
#### 2.1 @Valid表单验证
#### 2.2 AOP处理请求 HttpAspect
#### 2.3 统一异常处理  
- 当抛出异常时，返回的数据结构不是我们规定的结构，使用异常处理增强类ExceptionHandle可以对异常信息进行封装，可以在service层直接抛出异常，不需要异常时再封装数据返回。避免service的方法返回String给controller，controller还有根据返回的String进行很多的判断。

- 抛出异常只能抛出String，当需要返回异常信息和其他信息（如code=100）时，需要自定义异常。

#### 2.4 单元测试



## 常用注解
@Controller： 用于标识是处理器类；

@RequestMapping： 请求到处理器功能方法的映射规则；

@RequestParam： 请求参数到处理器功能处理方法的方法参数上的绑定；

@ModelAttribute： 请求参数到命令对象的绑定；

@SessionAttributes： 用于声明 session 级别存储的属性，放置在处理器类上，通常列出模型属性（如@ModelAttribute）对应的名称，则这些属性会透明的保存到session 中；

@InitBinder：自定义数据绑定注册支持，用于将请求参数转换到命令对象属性的对应类型；

@RequestBody： 请求的 body 体的绑定（通过 HttpMessageConverter 进行类型转换）；

@ResponseBody： 处理器功能处理方法的返回值作为响应体（通过 HttpMessageConverter 进行类型转换）；

@ExceptionHandler： 注解式声明异常处理器；

@PathVariable： 请求 URI 中的模板变量部分到处理器功能处理方法的方法参数上的绑定，从而支持 RESTful 架构风格的 URI；
