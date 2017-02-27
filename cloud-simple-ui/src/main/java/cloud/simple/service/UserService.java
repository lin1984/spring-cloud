/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package cloud.simple.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cloud.simple.model.User;
//import cloud.simple.service.UserServiceProvider.FeignUserService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.loadbalancer.ILoadBalancer;

@Service
public class UserService {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Autowired
	RibbonLoadBalancerClient ribbonLoadBalancerClient;
	@Autowired
	SpringClientFactory clientFactory;

	// @Autowired
	// FeignUserService feignUserService;

	final String SERVICE_NAME = "cloud-simple-service";

	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "fallbackSearchAll")
	public List<User> readUserInfo() {
//		ServiceInstance instance = loadBalancerClient.choose(SERVICE_NAME);
//		// instance.getServiceId()
//		// if(instance.isSecure()){
//		//
//		// }
//		ILoadBalancer loadBalancer = this.clientFactory
//				.getLoadBalancer(SERVICE_NAME);
//		// loadBalancer.getAllServers().get(0).getMetaInfo().isAlive();
//
//		// ILoadBalancer loadBalancer =(ILoadBalancer)
//		// clientFactory.getLoadBalancerContext(SERVICE_NAME);
//		// RibbonLoadBalancerContext ribbonLoadBalancerContext=
//		// ribbonLoadBalancerContext.getServerStats(instance.);
//		Map<String, String> info = new HashMap<String, String>();
//		info.put("sysName", "DFCFMonitor");
//		info.put("phoneNumbers", "123123123123");
//		info.put("content", "2131");
//		info.put("priority", "1");

		// instance.get
		List<User> users = restTemplate.getForObject("http://" + SERVICE_NAME
				+ "/user", List.class);
		// restTemplate.get

		return users;
		// return feignUserService.readUserInfo();
	}

	private List<User> fallbackSearchAll() {
		System.out.println("HystrixCommand fallbackMethod handle!");
		List<User> ls = new ArrayList<User>();
		User user = new User();
		user.setUsername("TestHystrixCommand-Error");
		ls.add(user);
		return ls;
	}

	// @Bean
	// @ConditionalOnMissingBean
	// public ILoadBalancer ribbonLoadBalancer(IClientConfig config,
	// ServerList serverList, ServerListFilter serverListFilter,
	// IRule rule, IPing ping) {
	// ZoneAwareLoadBalancer balancer = LoadBalancerBuilder.newBuilder()
	// .withClientConfig(config).withRule(rule).withPing(ping)
	// .withServerListFilter(serverListFilter).withDynamicServerList(serverList)
	// .buildDynamicServerListLoadBalancer();
	// return balancer;
	// }
}
