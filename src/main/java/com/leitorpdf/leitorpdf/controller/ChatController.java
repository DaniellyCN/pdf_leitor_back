package com.leitorpdf.leitorpdf.controller;

import com.leitorpdf.leitorpdf.domain.PDFDocument;
import com.leitorpdf.leitorpdf.repository.PDFDocumentRepository;
import com.leitorpdf.leitorpdf.service.LlamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private PDFDocumentRepository pdfDocumentRepository;

    @Autowired
    private LlamaService llamaService;

    @GetMapping("/{pdfId}")
    public ResponseEntity<String> perguntar(@PathVariable("pdfId") Long id, @RequestParam String pergunta) {
        PDFDocument pdfDocument = pdfDocumentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("PDF não encontrado")
        );

        String response = llamaService.ask(pdfDocument.getContent(), pergunta);
        return ResponseEntity.ok(response);
    }


}
