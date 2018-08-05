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
