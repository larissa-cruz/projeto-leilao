package br.com.leilao.leiloesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.transaction.annotation.Transactional;

import br.com.leilao.leiloesapi.dtos.DadosCadastroLance;
import br.com.leilao.leiloesapi.dtos.DadosDetalhamentoLance;
import br.com.leilao.leiloesapi.dtos.DadosListagemLance;
import br.com.leilao.leiloesapi.repositories.LanceRepository;
import jakarta.validation.Valid;
import br.com.leilao.leiloesapi.entities.Lance;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/lance")
public class LanceController {

    @Autowired
    private LanceRepository lanceRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLance> cadastrarLance(@RequestBody @Valid DadosCadastroLance dadosCadastroLance, UriComponentsBuilder uriBuilder) {

        var lance = new Lance(dadosCadastroLance);
        lanceRepository.save(lance);

        var uri = uriBuilder.path("/lance/{id}").buildAndExpand(lance.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLance(lance));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLance>> listarLances(@PageableDefault(size = 10) Pageable paginacao) {

        var lances = lanceRepository.findAll(paginacao).map(DadosListagemLance::new);

        return ResponseEntity.ok(lances);

    }
    
}
