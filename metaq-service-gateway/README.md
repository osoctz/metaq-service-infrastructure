
## 基于网关过滤器的熔断
```yaml
            - name: Hystrix
              args:
                name: fallbackcmd
                fallbackUri: forward:/default/fallback
```