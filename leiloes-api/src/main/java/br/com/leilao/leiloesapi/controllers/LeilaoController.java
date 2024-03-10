package br.com.leilao.leiloesapi.controllers;

import br.com.leilao.leiloesapi.dtos.LeilaoDTO;
import br.com.leilao.leiloesapi.dtos.LeilaoDetalhamentoDTO;
import br.com.leilao.leiloesapi.services.LeilaoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import br.com.leilao.leiloesapi.dtos.LeilaoListagemDTO;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/leilao")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @PostMapping
    public ResponseEntity<LeilaoDTO> cadastrarLeilao(@RequestBody @Valid LeilaoDTO leilaoDTO) {
        LeilaoDTO savedLeilao = leilaoService.insert(leilaoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(leilaoDTO.id()).toUri();
        return ResponseEntity.created(uri).body(savedLeilao);
    }

    @GetMapping
    public ResponseEntity<Page<LeilaoListagemDTO>> listarLeiloes(@PageableDefault(size = 10) Pageable paginacao) {
        Page<LeilaoListagemDTO> dto = leilaoService.findAll(paginacao);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LeilaoDetalhamentoDTO> detalharLeilao(@PathVariable Long id) {
        LeilaoDetalhamentoDTO dto = leilaoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarLeilao(@PathVariable Long id) {
        leilaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
