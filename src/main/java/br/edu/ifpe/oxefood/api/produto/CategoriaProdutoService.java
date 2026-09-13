package br.edu.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {

    private final CategoriaProdutoRepository repository;

    public CategoriaProdutoService(CategoriaProdutoRepository repository) {
        this.repository = repository;
    }

    public CategoriaProduto build(CategoriaDTO dto) {

        CategoriaProduto categoria = new CategoriaProduto();

        categoria.setDescricao(dto.getDescricao());

        return categoria;
    }

    @Transactional
    public CategoriaProduto cadastrar(CategoriaDTO dto) {

        CategoriaProduto categoria = build(dto);

        categoria.setHabilitado(true);

        return repository.save(categoria);
    }

    public List<CategoriaProduto> listar() {

        return repository.findAll();
    }

    public CategoriaProduto buscarPorId(Long id) {

        return repository.findById(id).get();
    }

}

