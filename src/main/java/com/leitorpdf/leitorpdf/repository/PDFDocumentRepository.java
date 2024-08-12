package com.leitorpdf.leitorpdf.repository;

import com.leitorpdf.leitorpdf.domain.PDFDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PDFDocumentRepository extends JpaRepository<PDFDocument, Long> {

}
