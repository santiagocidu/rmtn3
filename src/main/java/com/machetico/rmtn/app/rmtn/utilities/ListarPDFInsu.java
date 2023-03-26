package com.machetico.rmtn.app.rmtn.utilities;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.machetico.rmtn.app.rmtn.model.Insumo;
/*
@Component("/insumo/insumo")
public class ListarPDFInsu extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<Insumo> ListadoInsumos = (List<Insumo>) model.get("insumo");
		
		PdfPTable tablaInsumo = new PdfPTable(4);
		
		ListadoInsumos.forEach(insumo ->{
			tablaInsumo.addCell(insumo.getIdinsumo().toString());
			tablaInsumo.addCell(insumo.getNombre_insumo());
			tablaInsumo.addCell(insumo.getCantidad_actual());
			tablaInsumo.addCell(insumo.getUnidad_medida());

		});
		
		document.add(tablaInsumo);
		
	}
	

}
*/