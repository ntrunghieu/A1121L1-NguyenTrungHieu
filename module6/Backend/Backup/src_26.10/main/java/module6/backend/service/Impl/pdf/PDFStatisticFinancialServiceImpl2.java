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
import java.util.stream.Stream;

@Service
public class PDFStatisticFinancialServiceImpl2 {

    public ByteArrayInputStream export(String[] data) throws IOException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            Font f = new Font(BaseFont.createFont("D:\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            Font font1 = FontFactory.getFont(FontFactory.TIMES, 20, BaseColor.BLACK);
            Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, BaseColor.BLACK);
            Paragraph para = new Paragraph("Thống kê ", f);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(2);
            Stream.of("Hoạt động", "Trị giá").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new Phrase(headerTitle,f));
                table.addCell(header);
            });

                    int ban = Integer.parseInt(data[0]);
                    int nhap = Integer.parseInt(data[1]);
                    int huy  = Integer.parseInt(data[2]);
                    int tra = Integer.parseInt(data[3]);
                    int tongthu = ban+huy+tra;
                    int tongchi = nhap;
                    int doanhthu = tongthu-tongchi;

                PdfPCell titleCell1 = new PdfPCell(new Phrase("Bán hàng",f));
                titleCell1.setPaddingLeft(1);
                titleCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell1);

                PdfPCell titleCell2 = new PdfPCell(new Phrase(String.valueOf(ban)));
                titleCell2.setPaddingLeft(1);
                titleCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell2);

            PdfPCell titleCell3 = new PdfPCell(new Phrase("Nhập hàng",f));
            titleCell3.setPaddingLeft(1);
            titleCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell3);

            PdfPCell titleCell4 = new PdfPCell(new Phrase(String.valueOf(nhap)));
            titleCell4.setPaddingLeft(1);
            titleCell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell4);


            PdfPCell titleCell5 = new PdfPCell(new Phrase("Hủy hàng",f));
            titleCell5.setPaddingLeft(1);
            titleCell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell5.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell5);

            PdfPCell titleCell6 = new PdfPCell(new Phrase(String.valueOf(huy)));
            titleCell6.setPaddingLeft(1);
            titleCell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell6.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell6);

            PdfPCell titleCell7 = new PdfPCell(new Phrase("Trả hàng",f));
            titleCell7.setPaddingLeft(1);
            titleCell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell7.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell7);

            PdfPCell titleCell8 = new PdfPCell(new Phrase(String.valueOf(tra)));
            titleCell8.setPaddingLeft(1);
            titleCell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell8);

            PdfPCell titleCell9 = new PdfPCell(new Phrase("Tổng chi",f));
            titleCell9.setPaddingLeft(1);
            titleCell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell9.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell9);

            PdfPCell titleCell10 = new PdfPCell(new Phrase(String.valueOf(tongchi)));
            titleCell10.setPaddingLeft(1);
            titleCell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell10.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell10);

            PdfPCell titleCell11 = new PdfPCell(new Phrase("Tổng thu",f));
            titleCell11.setPaddingLeft(1);
            titleCell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell11.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell11);

            PdfPCell titleCell12 = new PdfPCell(new Phrase(String.valueOf(tongthu)));
            titleCell12.setPaddingLeft(1);
            titleCell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell12.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell12);

            PdfPCell titleCell13 = new PdfPCell(new Phrase("Doanh thu",f));
            titleCell13.setPaddingLeft(1);
            titleCell13.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell13.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell13);

            PdfPCell titleCell14 = new PdfPCell(new Phrase(String.valueOf(doanhthu)));
            titleCell14.setPaddingLeft(1);
            titleCell14.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell14.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell14);

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}



