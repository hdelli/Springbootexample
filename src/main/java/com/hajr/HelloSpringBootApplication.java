package com.hajr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}


	//local host:8080 - localhost is the local path
	@GetMapping
	String greet() {
		return "Hello Princess";
	}

	@GetMapping(params = "name")
	String greetName(@RequestParam("name") String name) {
		return " Hello " + name + " how are you today? ";
	}

	//localHost:8080/ping -created a new path
	@GetMapping(path = "ping")
	String ping() {
		return "pong";
	}

	//localhost:8080/foo
	@GetMapping(path = "foo")
	String foo() {
		return "bar";
	}

	@GetMapping("/people")
	List<Person> getPerson() {
		return List.of(
				new Person("Alex", 24),
				new Person("Gorge", 22),
				new Person("Wendy", 21)
		);

	}
	static class Person {
		private String name;
		private Integer age;

		Person(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Person person = (Person) o;
			return Objects.equals(name, person.name) && Objects.equals(age, person.age);
		}
 		@Override
		public int hashCode() {
			return Objects.hash(name, age);
		}


	}
}
