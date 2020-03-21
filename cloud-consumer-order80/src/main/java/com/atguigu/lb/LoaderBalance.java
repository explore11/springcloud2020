package com.atguigu.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoaderBalance {
    ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances);
}
