### 
截取ruoyi框架部分功能实现

基于mybatis，pageHelper

### 数据库
1、必须添加备注说明，否则会出现nullpoint
2、暂时只支持Mysql数据库

### 测试
1、参照test包下的 CreateManager 类

### 生成
1、controller
2、service
3、mapper（接口）
4、domain（实体类）
5、xml（mybatis配置文件）

### controller
1、继承BaseController
2、实现基本的增删改查，都是post请求
3、查询 pageSize和pageNum通过url传递，实体类数据通过form-data格式传递
4、修改  必须传递主键ID
5、删除 通过ID，可以传递多个 通过 , 分割










