package exam.formatter;

import exam.entity.DanhMuc;
import exam.service.danhmuc.impl.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class DanhMucFormatter implements Formatter<DanhMuc> {
    private IDanhMucService iDanhMucService;

    @Autowired
    public DanhMucFormatter(IDanhMucService iDanhMucService) {
        this.iDanhMucService = iDanhMucService;
    }

    @Override
    public DanhMuc parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(DanhMuc object, Locale locale) {
        return null;
    }
}
