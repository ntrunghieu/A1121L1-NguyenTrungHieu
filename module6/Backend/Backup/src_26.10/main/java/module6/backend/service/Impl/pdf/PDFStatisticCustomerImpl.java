package module6.backend.service.Impl.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PDFStatisticCustomerImpl {
    public ByteArrayInputStream export(String[] data) throws IOException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document,out);
            document.open();
            Font f = new Font(BaseFont.createFont("D:\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            Font font1 = FontFactory.getFont(FontFactory.TIMES, 20, BaseColor.BLACK);
            Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, BaseColor.BLACK);
            Paragraph para = new Paragraph("Thống kê khách hàng tiềm năng", f);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            Stream.of("Mã KH ","Tên khách hàng","SL đơn hàng", "Tổng tiền").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new Phrase(headerTitle,headerFont));
                table.addCell(header);
            });

            for (int i =0 ; i < data.length; i++) {
                String[] test = data[i].split(",");
                PdfPCell titleCell1 = new PdfPCell(new Phrase(test[0]));
                titleCell1.setPaddingLeft(1);
                titleCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell1);

                PdfPCell titleCell2 = new PdfPCell(new Phrase(test[1]));
                titleCell2.setPaddingLeft(1);
                titleCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell2);

                PdfPCell titleCell3 = new PdfPCell(new Phrase(test[2]));
                titleCell3.setPaddingLeft(1);
                titleCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell3);

                PdfPCell titleCell4 = new PdfPCell(new Phrase(test[3]));
                titleCell4.setPaddingLeft(1);
                titleCell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell4.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell4);
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}