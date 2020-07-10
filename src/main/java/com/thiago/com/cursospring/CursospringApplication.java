package com.thiago.com.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thiago.com.cursospring.domain.Categoria;
import com.thiago.com.cursospring.repositories.CategoriaRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

	}

}
