package br.com.leilao.leiloesapi.controllers;

import br.com.leilao.leiloesapi.dtos.LanceDTO;
import br.com.leilao.leiloesapi.services.LanceService;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.leilao.leiloesapi.dtos.LanceListagemDTO;
import jakarta.validation.Valid;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/lance")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping
    public ResponseEntity<LanceDTO> cadastrarLance(@RequestBody @Valid LanceDTO lanceDTO) {
        lanceDTO = lanceService.insert(lanceDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(lanceDTO.id()).toUri();
        return ResponseEntity.created(uri).body(lanceDTO);
    }

    @GetMapping
    public ResponseEntity<Page<LanceListagemDTO>> listarLances(@PageableDefault(size = 10) Pageable paginacao) {
        Page<LanceListagemDTO> dto = lanceService.findAll(paginacao);
        return ResponseEntity.ok(dto);
    }
    
}
