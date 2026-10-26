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

    public CategoriaProduto build(CategoriaProdutoDTO dto) {

        CategoriaProduto categoria = null;

        if (dto.getId() == null) { //Montado para o cadastro

            categoria = new CategoriaProduto();

        } else { //Consultado para a alteração

            categoria = repository.findById(dto.getId()).get();
        }

        categoria.setDescricao(dto.getDescricao());

        return categoria;
    }

    @Transactional
    public CategoriaProduto cadastrar(CategoriaProdutoDTO dto) {

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

    @Transactional
    public CategoriaProduto atualizar(CategoriaProdutoDTO dto) {

        CategoriaProduto categoria = build(dto);
	    return repository.save(categoria);
    }

    @Transactional
    public void remover(Long id) {

        CategoriaProduto categoria = repository.findById(id).get();
        categoria.setHabilitado(false);

        repository.save(categoria);
    }

}