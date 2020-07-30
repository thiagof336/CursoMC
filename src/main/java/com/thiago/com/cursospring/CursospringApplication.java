package com.thiago.com.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thiago.com.cursospring.domain.Categoria;
import com.thiago.com.cursospring.domain.Cidade;
import com.thiago.com.cursospring.domain.Cliente;
import com.thiago.com.cursospring.domain.Endereco;
import com.thiago.com.cursospring.domain.Estado;
import com.thiago.com.cursospring.domain.Produto;
import com.thiago.com.cursospring.domain.enuns.TipoCliente;
import com.thiago.com.cursospring.repositories.CategoriaRepository;
import com.thiago.com.cursospring.repositories.CidadeRepository;
import com.thiago.com.cursospring.repositories.ClienteRepository;
import com.thiago.com.cursospring.repositories.EnderecoRepository;
import com.thiago.com.cursospring.repositories.EstadoRepository;
import com.thiago.com.cursospring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "maria", "maria@gmail.com", "3897238976234", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("123124423423", "3232141234234"));

		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 30", "mauro Marcondes", "1305400", cli1, c1);

		Endereco e2 = new Endereco(null, "rua nadir", "231", "casa", "vida nova", "13034500", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
