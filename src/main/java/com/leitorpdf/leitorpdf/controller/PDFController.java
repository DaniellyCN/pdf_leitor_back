package com.leitorpdf.leitorpdf.controller;

import com.leitorpdf.leitorpdf.domain.PDFDocument;
import com.leitorpdf.leitorpdf.repository.PDFDocumentRepository;
import com.leitorpdf.leitorpdf.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/pdf")
public class PDFController {

    @Autowired
    private PDFService pdfService;

    @Autowired
    private PDFDocumentRepository pdfDocumentRepository;

    @PostMapping
    public ResponseEntity<String> uploadPDF(@RequestParam("file") MultipartFile file) throws IOException {
        String content = pdfService.extrairTextoFromPdf(file);

        PDFDocument pdfDocument = new PDFDocument();
        pdfDocument.setContent(content);
        pdfDocumentRepository.save(pdfDocument);

        return ResponseEntity.ok("Pdf updado");
    }
}
