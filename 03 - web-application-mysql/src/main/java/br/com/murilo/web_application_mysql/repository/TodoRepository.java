package br.com.murilo.web_application_mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.murilo.web_application_mysql.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	List<Todo> findByUser(String user);
}
