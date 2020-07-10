package com.thiago.com.cursospring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.com.cursospring.domain.Categoria;
import com.thiago.com.cursospring.repositories.CategoriaRepository;
import com.thiago.com.cursospring.service.exceptions.ObjectNotFountException;

@Service
public class CategoriaServices {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
