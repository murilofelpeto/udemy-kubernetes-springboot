package br.com.murilo.kubernetes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.kubernetes.entity.HelloWorldEntity;
import br.com.murilo.kubernetes.service.InstanceInformationService;

@RestController
public class HelloWorldController {

	@Autowired
	private InstanceInformationService service;
	
	@GetMapping(path = "/")
	public String imUpAndRunning() {
		return "{healthy:true}";
	}

	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World " + " V3 " + service.retrieveInstanceInfo();
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldEntity helloWorldBean() {
		return new HelloWorldEntity("Hello World");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldEntity helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldEntity(String.format("Hello World, %s", name));
	}
}
