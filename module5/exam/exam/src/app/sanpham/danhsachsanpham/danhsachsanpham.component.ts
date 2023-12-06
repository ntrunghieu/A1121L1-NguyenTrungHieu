import { Component, OnInit } from '@angular/core';
import {BenhNhan} from "../../model/benhNhan";
import {BenhnhanService} from "../../service/benhnhan.service";
import {SanphamService} from "../../service/sanpham.service";
import {SanPham} from "../../sanPham";

@Component({
  selector: 'app-danhsachsanpham',
  templateUrl: './danhsachsanpham.component.html',
  styleUrls: ['./danhsachsanpham.component.css']
})
export class DanhsachsanphamComponent implements OnInit {
  sp1: SanPham;
  sanPham: SanPham[] = [];
  totalLength: number;
  p: string | number = 1;
  id: number;
  ten: string;


  constructor(private sanphamService: SanphamService) { }

  ngOnInit(): void {
    this.findAll();
  }
  findAll() {
    this.sanphamService.findAll().subscribe((data) => {
      this.sanPham = data;
      this.totalLength = data.length;

    });
  }

  guiIdSP(id: number, ten: string) {
    this.id=id;
    this.ten=ten;
  }

  xemChiTiet(id: number) {
    // this.sp1= sp;
    this.sanphamService.findByIdSP(id).subscribe(
      (data) => {
        this.sp1=data;
      },
      () => {},
      () => {

        // this.findAll();
        // alert('Xóa sản phẩm thành công');
      }
    )
  }

  xoa(id: number) {
    this.sanphamService.deleteSP(id).subscribe(
      () => {},
      () => {},
      () => {

        this.findAll();
        alert('Xóa sản phẩm thành công');
      }
    )
  }
}
