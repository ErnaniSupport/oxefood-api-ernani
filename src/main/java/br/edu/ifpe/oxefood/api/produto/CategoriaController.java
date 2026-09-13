package br.edu.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final CategoriaProdutoService categoriaService;

    public CategoriaController(CategoriaProdutoService service) {
        this.categoriaService = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaProduto> cadastrar(
            @RequestBody CategoriaDTO dto) {

        CategoriaProduto categoriaCadastrada =
                categoriaService.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaCadastrada);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaProduto>> listar() {

        return ResponseEntity.ok(categoriaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProduto> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

}

