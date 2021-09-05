## 分布式事务组件 seata

### 版本
```yaml
spring cloud Hoxton.SR9
spring alibaba cloud 2.2.1.RELEASE
seata 1.1.0
```

### 遇到坑
```yaml
1. 1.0.0之前版本需要数据源代理配置
2. 封装了ExceptionHandle 导致feign链路的调用不抛异常,事务不回滚

```

### 配置
#### 服务端
```yaml
配置参考客户端

启动 bin/seata-server.sh -p 8091 -m file
```

#### 业务端

- file.conf
 ```yaml

my_test_tx_group与application.yml中spring.cloud.alibaba.seata.tx-service-group对应

service {
  #transaction service group mapping
  vgroup_mapping.my_test_tx_group = "seata-server"
  #only support when registry.type=file, please don't set multiple addresses
  seata-server.grouplist = "127.0.0.1:8091"
  #disable seata
  disableGlobalTransaction = false
}

## transaction log store, only used in seata-server
store {
  ## store mode: file、db
  mode = "db"

  ## file store property
  file {
    ## store location dir
    dir = "sessionStore"
  }

  ## database store property
  db {
    ## the implement of javax.sql.DataSource, such as DruidDataSource(druid)/BasicDataSource(dbcp) etc.
    datasource = "druid"
    ## mysql/oracle/h2/oceanbase etc.
    db-type = "mysql"
    driver-class-name = "com.mysql.cj.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1:3306/seata-server?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"
    user = "root"
    password = "123456"
  }
}
```

- registry.conf
```yaml
registry {
  # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "eureka"

  nacos {
    serverAddr = "localhost"
    namespace = ""
    cluster = "default"
  }
  eureka {
    serviceUrl = "http://localhost:7001/eureka"
    application = "seata-server"
    weight = "1"
  }
  redis {
    serverAddr = "localhost:6379"
    db = "0"
  }
  zk {
    cluster = "default"
    serverAddr = "127.0.0.1:2181"
    session.timeout = 6000
    connect.timeout = 2000
  }
  consul {
    cluster = "default"
    serverAddr = "127.0.0.1:8500"
  }
  etcd3 {
    cluster = "default"
    serverAddr = "http://localhost:2379"
  }
  sofa {
    serverAddr = "127.0.0.1:9603"
    application = "default"
    region = "DEFAULT_ZONE"
    datacenter = "DefaultDataCenter"
    cluster = "default"
    group = "SEATA_GROUP"
    addressWaitTime = "3000"
  }
  file {
    name = "file.conf"
  }
}

config {
  # file、nacos 、apollo、zk、consul、etcd3
  type = "file"

  nacos {
    serverAddr = "localhost"
    namespace = ""
  }
  consul {
    serverAddr = "127.0.0.1:8500"
  }
  apollo {
    app.id = "seata-server"
    apollo.meta = "http://192.168.1.204:8801"
  }
  zk {
    serverAddr = "127.0.0.1:2181"
    session.timeout = 6000
    connect.timeout = 2000
  }
  etcd3 {
    serverAddr = "http://localhost:2379"
  }
  file {
    name = "file.conf"
  }
}
```