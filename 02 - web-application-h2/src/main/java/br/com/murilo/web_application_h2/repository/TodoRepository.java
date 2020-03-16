package br.com.murilo.web_application_h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.murilo.web_application_h2.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	List<Todo> findByUser(String user);
}
