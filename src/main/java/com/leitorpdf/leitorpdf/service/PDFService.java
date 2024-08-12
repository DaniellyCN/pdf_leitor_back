package com.leitorpdf.leitorpdf.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PDFService {

    public String extrairTextoFromPdf(MultipartFile file) throws IOException {
        try(PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return  pdfStripper.getText(document);
        }
    }
}
