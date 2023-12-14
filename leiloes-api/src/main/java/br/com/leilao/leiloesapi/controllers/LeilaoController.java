package br.com.leilao.leiloesapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import br.com.leilao.leiloesapi.entities.Leilao;
import br.com.leilao.leiloesapi.repositories.LeilaoRepository;
import br.com.leilao.leiloesapi.dtos.DadosCadastroLeilao;
import br.com.leilao.leiloesapi.dtos.DadosDetalhamentoLeilao;
import br.com.leilao.leiloesapi.dtos.DadosListagemLeilao;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/leilao")
public class LeilaoController {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLeilao> cadastrarLeilao(@RequestBody @Valid DadosCadastroLeilao dadosCadastroLeilao, UriComponentsBuilder uriBuilder) {

        var leilao = new Leilao(dadosCadastroLeilao);
        leilaoRepository.save(leilao);

        var uri = uriBuilder.path("/leilao/{id}").buildAndExpand(leilao.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLeilao(leilao));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLeilao>> listarLeiloes(@PageableDefault(size = 10) Pageable paginacao) {

        var leiloes = leilaoRepository.findAll(paginacao).map(DadosListagemLeilao::new);

        return ResponseEntity.ok(leiloes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoLeilao> detalharLeilao(@PathVariable Long id) {

        var leilao = leilaoRepository.findLeilaoComLancesEUsuarios(id);

        return ResponseEntity.ok(new DadosDetalhamentoLeilao(leilao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirLeilao(@PathVariable Long id) {

        leilaoRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }


    
}
