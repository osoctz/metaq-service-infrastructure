## 微服务基础设施

### List

- 基于eureka实现微服务注册与发现中心
- 基于Gateway实现网关及网关的熔断，服务降级
- 基于redis令牌桶实现服务的限流
- 在网关实现服务异常重试机制
- 基于security+oauth2实现用户的授权和鉴权，基于token的无状态服务
- 实现feign client调用服务的token传递
- 基于alibaba seata组件实现微服务的分布式事务  
- 实现基于角色的访问控制(RBAC)和基于客户端的访问控制(CBAC) 
- 集成springBootAdmin
- 集成swagger3.0
- 实现基于maven插件构建docker镜像并推送至阿里云容器镜像库
- 基于GraphQL-java实现BFF层
- 单点登录

### 1.1 组件

#### 1.1.1 服务注册发现

- consul
- eureka
  高可用配置参考 https://github.com/osoctz/metaq-eureka-discovery.git
- nacos

#### 1.1.2 网关

##### spring cloud gateway

###### 限流

- 计数器/时间窗口法 (突刺效应)
- 漏桶法
- 限流令牌桶

###### 熔断

[说明](metaq-service-gateway/README.md)

###### 重试机制

[说明](metaq-service-gateway/README.md)

#### 1.1.3 消息驱动 (spring cloud stream&Bus)
> 解决应用耦合 异步消息和流量削峰等问题
>消息队列的主要特点是异步处理和解耦:其主要的使用场景就是将比较耗时而且不需
 要 同步返回结果的操作作为消息放入消息队列,从而实现异步处理;同时由于使用了消息
 队列,只要保证消息格式不变,消息的发送方和接受者并不需要彼此直接联系,也不会受
 到对方的影响,即解耦。

#### 1.1.4 分布式事务

##### 版本映射关系

|  Spring Cloud Alibaba   | Spring Cloud  |
|  ----  | ----  |
| 2.1.0  | Greenwich |
| 2.2.0  | Hoxton.RELEASE |
| 2.2.1  | Hoxton.SR3 |

#### 1.1.5 服务监控

##### 版本映射关系

|  server   | client  |
|  ----  | ----  |
| metaq-service-monitor  | metaq-service-uaa |


```markdown

2.Grafana FlowCharting
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
