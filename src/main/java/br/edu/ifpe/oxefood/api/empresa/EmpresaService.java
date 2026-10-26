package br.edu.ifpe.oxefood.api.empresa;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa build(EmpresaDTO dto) {

        Empresa empresa = null;

        if (dto.getId() == null) { //Montado para o cadastro

            empresa = new Empresa();

        } else { //Consultado para a alteração

            empresa = repository.findById(dto.getId()).get();
        }

        empresa.setSite(dto.getSite());
        empresa.setCnpj(dto.getCnpj());
        empresa.setInscricaoEstadual(dto.getInscricaoEstadual());
        empresa.setNomeEmpresarial(dto.getNomeEmpresarial());
        empresa.setNomeFantasia(dto.getNomeFantasia());
        empresa.setFone(dto.getFone());
        empresa.setFoneAlternativo(dto.getFoneAlternativo());

        return empresa;
    }

    @Transactional
    public Empresa cadastrar(EmpresaDTO dto) {

        Empresa empresa = build(dto);
        empresa.setHabilitado(true);
        return repository.save(empresa);
    }

    @Transactional
    public Empresa atualizar(EmpresaDTO dto) {

        Empresa empresa = build(dto);
        return repository.save(empresa); //update ...
    }

    public List<Empresa> listar() {

        return repository.findAll(); // SELECT * FROM Cliente
    }

    public Empresa buscarPorId(Long id) {

        return repository.findById(id).get(); // SELECT * FROM Cliente WHERE id = ?
    }

    @Transactional
    public void remover(Long id) {

        Empresa empresa = repository.findById(id).get();
        empresa.setHabilitado(false);

        repository.save(empresa); 
    }

}

