import { Component, OnInit } from '@angular/core';
import {SanPham} from '../../model/sanpham';
import {SanphamService} from '../../service/sanpham.service';
import {FormControl, FormGroup} from '@angular/forms';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-danhsachsanpham',
  templateUrl: './danhsachsanpham.component.html',
  styleUrls: ['./danhsachsanpham.component.css']
})
export class DanhsachsanphamComponent implements OnInit {
  sanPham: SanPham[] = [];
  totalLength: number;
  p: string | number = 1;
  id: number;
  ten: string;
  sp1: SanPham;
  name: string;
  searchForm: FormGroup;
  date1 = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');
  constructor(private sanphamService: SanphamService) { }

  ngOnInit(): void {
    this.sp1 = {ten: ''};
    this.findAll();

    this.searchForm = new FormGroup({
      // id: new FormControl(''),
      // ngay: new FormControl('')
      nsx: new FormControl(''),
      hsd: new FormControl('')
    });
  }
  findAll() {
    this.sanphamService.findAll().subscribe((data) => {
      this.sanPham = data;
      this.totalLength = data.length;

    });
  }

  guiIdSP(id: number, ten: string) {
    this.id = id;
    this.ten = ten;
  }

  xemChiTiet(id: number) {
    // this.sp1= sp;
    this.sanphamService.findByIdSP(id).subscribe(
      (data) => {
        this.sp1 = data;
      },
      () => {},
      () => {

        // this.findAll();
        // alert('Xóa sản phẩm thành công');
      }
    );
  }

  xoa(id: number) {
    this.sanphamService.deleteSP(id).subscribe(
      () => {},
      () => {},
      () => {

        this.findAll();
        alert('Xóa sản phẩm thành công');
      }
    );
  }

  search() {
    if (this.name == '') {
      this.ngOnInit();
    } else {
      this.sanphamService.searchName(this.name).subscribe((data) => {
        this.sanPham = data;
        console.log(this.sanPham);
      });
      // this.employee= this.employee.filter(res => {
      //   return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      // });
    }
  }

  send() {
    // this.sanphamService.searchDate(this.searchForm.get('ngay').value).subscribe((data) => {
    //   this.sanPham = data;
    //   console.log(this.sanPham);
    // });
    this.sanphamService.searchDate2(this.searchForm.get('nsx').value, this.searchForm.get('hsd').value).subscribe((data) => {
      this.sanPham = data;
      console.log(this.sanPham);
    });
  }
}
