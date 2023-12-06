package module6.backend.service.Impl.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.prism.paint.Color;
import module6.backend.entity.Import;
import module6.backend.entity.cart.CartMaterial;
import module6.backend.entity.employee.Employee;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PDFGeneratorImportServiceImpl {
    public ByteArrayInputStream export(Import import1, Employee employee) throws IOException {
        Document document = new Document();
        Double totalBill = 0.0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            Font font = new Font(BaseFont.createFont("D:\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            Font font1 = FontFactory.getFont(FontFactory.TIMES, 20, BaseColor.BLACK);
            Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, BaseColor.BLACK);
            Paragraph para = new Paragraph("Đơn nhập kho", font);
            font.setSize(24);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            Paragraph para13 = new Paragraph("- Thông tin Nhập kho", font);
            font.setSize(18);
            document.add(para13);
            Paragraph para14 = new Paragraph("Mã nhập kho: " + import1.getImportCode(), font);
            font.setSize(16);
            document.add(para14);
            Paragraph para15 = new Paragraph("Ngày nhập kho: " + import1.getImportStartDate(), font);
            document.add(para15);
            Paragraph para16 = new Paragraph("Số lượng nhập kho: " + import1.getImportQuantity(), font);
            document.add(para16);
            Paragraph para17 = new Paragraph("Tổng tiền: " + import1.getImportQuantity() * import1.getImportMaterialId().getMaterialPrice(), font);
            document.add(para17);
            document.add(Chunk.NEWLINE);

            Paragraph para7 = new Paragraph("- Thông tin Vật tư", font);
            font.setSize(18);
            document.add(para7);
            Paragraph para8 = new Paragraph("Mã vật tư: " + import1.getImportMaterialId().getMaterialCode(), font);
            font.setSize(16);
            document.add(para8);
            Paragraph para9 = new Paragraph("Tên vật tư: " + import1.getImportMaterialId().getMaterialName(), font);
            document.add(para9);
            Paragraph para10 = new Paragraph("Giá thành: " + import1.getImportMaterialId().getMaterialPrice(), font);
            document.add(para10);
            Paragraph para11 = new Paragraph("Hạn sử dụng: " + import1.getImportMaterialId().getMaterialExpiridate(), font);
            document.add(para11);
            Paragraph para12 = new Paragraph("Đơn vị: " + import1.getImportMaterialId().getMaterialUnit(), font);
            document.add(para12);
            document.add(Chunk.NEWLINE);

            Paragraph para1 = new Paragraph("- Thông tin Nhà cung cấp", font);
            font.setSize(18);
            document.add(para1);
            Paragraph para2 = new Paragraph("Tên nhà cung cấp: " + import1.getImportMaterialId().getMaterialCustomerId().getCustomerName(), font);
            font.setSize(16);
            document.add(para2);
            Paragraph para3 = new Paragraph("Mã nhà cung cấp: " + import1.getImportMaterialId().getMaterialCustomerId().getCustomerCode(), font);
            document.add(para3);
            Paragraph para4 = new Paragraph("Địa chỉ: " + import1.getImportMaterialId().getMaterialCustomerId().getCustomerAddress(), font);
            document.add(para4);
            Paragraph para5 = new Paragraph("Số điện thoại: " + import1.getImportMaterialId().getMaterialCustomerId().getCustomerPhone(), font);
            document.add(para5);
            Paragraph para6 = new Paragraph("Gmail: " + import1.getImportMaterialId().getMaterialCustomerId().getCustomerEmail(), font);
            document.add(para6);
            document.add(Chunk.NEWLINE);


//            PdfPTable table = new PdfPTable(4);
//            Stream.of("Sản phẩm", "Đơn giá", "Số lượng", "Thành tiền").forEach(headerTitle -> {
//                PdfPCell header = new PdfPCell();
//                Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
//                header.setHorizontalAlignment(Element.ALIGN_CENTER);
//                header.setBorderWidth(1);
//                header.setPhrase(new Phrase(headerTitle, headerFont));
//                table.addCell(header);
//            });
//
//            for (CartMaterial cart : carts) {
//                PdfPCell titleCell1 = new PdfPCell(new Phrase(String.valueOf(cart.getMaterialId().getMaterialName())));
//                titleCell1.setPaddingLeft(1);
//                titleCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                titleCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
//                table.addCell(titleCell1);
//
//                PdfPCell titleCell = new PdfPCell(new Phrase(String.valueOf(cart.getMaterialId().getMaterialPrice())));
//                titleCell.setPaddingLeft(1);
//                titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//                table.addCell(titleCell);
//
//                PdfPCell desCell1 = new PdfPCell(new Phrase(String.valueOf(cart.getCartId().getCartQuantity())));
//                desCell1.setPaddingLeft(1);
//                desCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                desCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
//                table.addCell(desCell1);
//
//                PdfPCell desCell = new PdfPCell(new Phrase(String.valueOf(cart.getCartId().getCartTotalMoney())));
//                desCell.setPaddingLeft(1);
//                desCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                desCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//                table.addCell(desCell);
//                totalBill = totalBill + cart.getCartId().getCartTotalMoney();
//            }
//            Paragraph total = new Paragraph("                                                                                                                    Tổng tiền: " + String.valueOf(totalBill), font2);
//
//            document.add(table);
//            document.add(total);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
