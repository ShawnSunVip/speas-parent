======================================系统介绍======================================

小豌豆——speas

=====================================自动化组件介绍==================================

speas-autoswagger  自动化swagger工程，即插即用，可以通过配置文件来控制开关及一些属性配置

访问地址：http://localhost:8080/swagger-ui.html

=====================================操作方法======================================

一.Pom文件引入

        <!-- 自动化swagger -->
        <dependency>
            <groupId>com.sun.speas</groupId>
            <artifactId>speas-autoswagger</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
二.配置文件添加
    
    详细参数见下

=====================================swagger参数===================================

        speas:
            #swagger配置
            #
            swagger:
              #开关
              enable: true
              #分组，使用逗号隔开
              group: inapi,outapi
              #分组名称，使用逗号隔开
              group-name: 内部API,外部API
              #扫描包，使用逗号隔开
              scan-package: com.sun.speas.controller,com.sun.speas.apicontroller
              #标题
              api-info.title: API接口文档
              #描述
              api-info.description: 方便开发人员，测试人员使用
              #版本号
              api-info.version: V1.0.0.RELEASE