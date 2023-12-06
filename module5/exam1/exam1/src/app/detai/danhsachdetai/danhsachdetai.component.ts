import { Component, OnInit } from '@angular/core';
import {SanPham} from '../../model/sanpham';
import {FormControl, FormGroup} from '@angular/forms';
import {formatDate} from '@angular/common';
import {SanphamService} from '../../service/sanpham.service';
import {Detai} from '../../model/detai';
import {DetaiService} from '../../service/detai.service';

@Component({
  selector: 'app-danhsachdetai',
  templateUrl: './danhsachdetai.component.html',
  styleUrls: ['./danhsachdetai.component.css']
})
export class DanhsachdetaiComponent implements OnInit {

  detai: Detai[] = [];
  totalLength: number;
  p: string | number = 1;
  id: number;
  ten: string;
  detai1: Detai;
  name: string;
  searchForm: FormGroup;
  date1 = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');
  constructor(private detaiService: DetaiService) { }

  ngOnInit(): void {
    this.detai1 = {
      tenSV: ''
    };
    this.findAll();

    this.searchForm = new FormGroup({
      // id: new FormControl(''),
      // ngay: new FormControl('')
      nsx: new FormControl(''),
      hsd: new FormControl('')
    });
  }
  findAll() {
    this.detaiService.findAll().subscribe((data) => {
      this.detai = data;
      this.totalLength = data.length;

    });
  }

  guiIdSP(id: number, ten: string) {
    this.id = id;
    this.ten = ten;
  }

  xemChiTiet(id: number) {
    // this.sp1= sp;
    this.detaiService.findByIdSP(id).subscribe(
      (data) => {
        this.detai1 = data;
      },
      () => {},
      () => {

        // this.findAll();
        // alert('Xóa sản phẩm thành công');
      }
    );
  }

  xoa(id: number) {
    this.detaiService.deleteSP(id).subscribe(
      () => {},
      () => {},
      () => {

        this.findAll();
        alert('Xóa sinh viên thành công');
      }
    );
  }

  search() {
    if (this.name == '') {
      this.ngOnInit();
    } else {
      this.detaiService.searchName(this.name).subscribe((data) => {
        this.detai = data;
        console.log(this.detai);
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
    this.detaiService.searchDate2(this.searchForm.get('nsx').value, this.searchForm.get('hsd').value).subscribe((data) => {
      this.detai = data;
      console.log(this.detai);
    });
  }

}
