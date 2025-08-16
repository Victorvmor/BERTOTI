package com.thehecklers.sburrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class SburRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}

}

@RestController
@RequestMapping("/sucos")
class RestApiDemoController {
	private List<Sucos> sucos = new ArrayList<>();

	public RestApiDemoController() {
		sucos.addAll(List.of(
				new Sucos("Suco de laranja "),
				new Sucos("Suco de limão"),
				new Sucos("Suco de maracuja"),
				new Sucos("Suco de morango")
		));
	}

	@GetMapping
	Iterable<Sucos> getSucos() {
		return sucos;
	}

	@GetMapping("/{id}")
	Optional<Sucos> getCoffeeById(@PathVariable String id) {
		for (Sucos c: sucos) {
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}

	@PostMapping
    Sucos postSucos(@RequestBody Sucos sucos) {
		this.sucos.add(sucos);
		return sucos;
	}

	@PutMapping("/{id}")
	ResponseEntity<Sucos> putCoffee(@PathVariable String id,
                                    @RequestBody Sucos sucos) {
		int sucosIndex = -1;

		for (Sucos c: this.sucos) {
			if (c.getId().equals(id)) {
				sucosIndex = this.sucos.indexOf(c);
				this.sucos.set(sucosIndex, sucos);
			}
		}

		return (sucosIndex == -1) ?
				new ResponseEntity<>(postSucos(sucos), HttpStatus.CREATED) :
				new ResponseEntity<>(sucos, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteSucos(@PathVariable String id) {
		sucos.removeIf(c -> c.getId().equals(id));
	}
}

class Sucos {
	private final String id;
	private String name;

	public Sucos(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Sucos(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}