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

#### 1.1.3 消息驱动 (spring cloud stream&Bus)
> 解决应用耦合 异步消息和流量削峰等问题
>消息队列的主要特点是异步处理和解耦:其主要的使用场景就是将比较耗时而且不需
 要 同步返回结果的操作作为消息放入消息队列,从而实现异步处理;同时由于使用了消息
 队列,只要保证消息格式不变,消息的发送方和接受者并不需要彼此直接联系,也不会受
 到对方的影响,即解耦。

#### 1.1.4 分布式事物

```yaml
版本映射关系
Spring Cloud Alibaba 2.1.0 RELEASE对应的Spring Cloud Greenwich版本
Spring Cloud Alibaba 2.2.0 RELEASE对应的Spring Cloud Hoxton.RELEASE版本
Spring Cloud Alibaba 2.2.1 RELEASE对应的Spring Cloud Hoxton.SR3版本
```

#### 1.1.5 服务监控

```markdown

Grafana FlowCharting
https://www.jianshu.com/p/ba4faef24d11

```

### 2 计划

- 集成keycloak作为鉴权授权中心

### 3 更新日志

- 2020.11.30 网关熔断和重试机制
- 2020.11.29 增加限流
- 2020.11.27 增加行政区划微服务
- 2020.11.26 增加gateway
- 2020.11.26 eureka作为服务注册发现中心