package module6.backend.service.Impl;


import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import module6.backend.entity.cart.Cart;
import module6.backend.entity.cart.CartMaterial;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PDFCartGeneratorServiceImpl {

public ByteArrayInputStream export(List<CartMaterial> carts,Cart cart1) throws IOException {
    Document document = new Document();
    Double totalBill = 0.0;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try {
        PdfWriter.getInstance(document,out);
        document.open();
        Font fontTitle = new Font(BaseFont.createFont("D:\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
        fontTitle.setSize(20);
        Font fontTitle1 = new Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD));

        fontTitle.setStyle(Font.NORMAL);
        Font f = new Font(BaseFont.createFont("D:\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
        Paragraph para = new Paragraph("Hóa đơn", fontTitle);
        para.setAlignment(Element.ALIGN_CENTER);
        document.add(para);
        document.add(Chunk.NEWLINE);
        Paragraph para1 = new Paragraph("Thông tin khách hàng", fontTitle1);
        document.add(para1);
        Paragraph para2 = new Paragraph("Họ và tên: " + cart1.getCartCustomerId().getCustomerName(), f);
        document.add(para2);
        Paragraph para3 = new Paragraph("Số điện thoại: " + cart1.getCartCustomerId().getCustomerPhone(), f);
        document.add(para3);
        Paragraph para4 = new Paragraph("Địa chỉ: " + cart1.getCartCustomerId().getCustomerAddress(), f);
        document.add(para4);
        Paragraph para5 = new Paragraph("Mã hóa đơn: " + cart1.getCartCode(), f);
        document.add(para5);
        Paragraph para6 = new Paragraph("Email: " + cart1.getCartCustomerId().getCustomerEmail(), f);
        document.add(para6);
        Paragraph para7 = new Paragraph("Ngày: " + java.time.LocalDate.now(), f);
        document.add(para7);
        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(4);
        Stream.of("Sản phẩm","Đơn giá","Số lượng","Thành tiền").forEach(headerTitle -> {
            PdfPCell header = new PdfPCell();

            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setBorderWidth(1);
            header.setPhrase(new Phrase(headerTitle,f));
            table.addCell(header);
        });

        for (CartMaterial cart: carts) {
            PdfPCell titleCell1 = new PdfPCell(new Phrase(String.valueOf(cart.getMaterialId().getMaterialName())));
            titleCell1.setPaddingLeft(1);
            titleCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell1);

            PdfPCell titleCell = new PdfPCell(new Phrase(String.valueOf(cart.getMaterialId().getMaterialPrice())));
            titleCell.setPaddingLeft(1);
            titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(titleCell);

            PdfPCell desCell1 = new PdfPCell(new Phrase(String.valueOf(cart.getCartId().getCartQuantity())));
            desCell1.setPaddingLeft(1);
            desCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            desCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(desCell1);

            PdfPCell desCell = new PdfPCell(new Phrase(String.valueOf(cart.getCartId().getCartTotalMoney())));
            desCell.setPaddingLeft(1);
            desCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            desCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(desCell);
            totalBill = totalBill + cart.getCartId().getCartTotalMoney();
        }
        Paragraph total = new Paragraph("                                                                                                              Tổng tiền: " + String.valueOf(totalBill), f);

        document.add(table);
        document.add(total);
        document.close();
    } catch (DocumentException e) {
        e.printStackTrace();
    }
    return new ByteArrayInputStream(out.toByteArray());
}
}
