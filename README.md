## 1 微服务基础设施

### 1.1 组件

#### 1.1.1 服务注册发现

- consul
- eureka
- nacos

#### 1.1.2 网关

##### spring cloud gateway

###### 限流

- 计数器/时间窗口法 (突刺效应)
- 漏桶法
- 限流令牌桶

##### 熔断

[说明](metaq-service-gateway/README.md)

##### 重试机制

[说明](metaq-service-gateway/README.md)

#### 1.1.3 消息驱动 (spring cloud stream)


### 2 计划

- 集成keycloak作为鉴权授权中心

### 3 更新日志

- 2020.11.30 网关熔断和重试机制
- 2020.11.29 增加限流
- 2020.11.27 增加行政区划微服务
- 2020.11.26 增加gateway
- 2020.11.26 eureka作为服务注册发现中心