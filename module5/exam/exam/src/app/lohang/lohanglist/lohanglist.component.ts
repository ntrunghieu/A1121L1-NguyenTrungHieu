import { Component, OnInit } from '@angular/core';
import {LoHang} from "../../loHang";
import {LohangService} from "../../service/lohang.service";
import {FormControl, FormGroup} from "@angular/forms";
import {SanPham} from "../../sanPham";

@Component({
  selector: 'app-lohanglist',
  templateUrl: './lohanglist.component.html',
  styleUrls: ['./lohanglist.component.css']
})
export class LohanglistComponent implements OnInit {

  loHang: LoHang[] = [];
  totalLength: number;
  p: string | number = 1;
  id: number;
  maLH: string;
  loHang1: LoHang;
  searchForm: FormGroup;
  name: string;
  constructor(private loHangService: LohangService) { }

  ngOnInit(): void {
    this.findAll();

    this.searchForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('')
    });
  }

  findAll() {
    this.loHangService.findAll().subscribe((data) => {
      this.loHang = data;
      this.totalLength = data.length;
    });
  }

  guiIdLoHanh(id: number, maLoHang: string) {
    this.id=id;
    this.maLH=maLoHang;
  }

  xemChiTiet(lh: LoHang) {
    this.loHang1=lh;
  }

  send() {
    // this.loHang.sa(this.searchLevelForm.get('name').value,this.searchLevelForm.get('id').value ).subscribe((data) => {
    //   this.employee = data;
    //   console.log(this.employee);
    // });
  }

  xoa(id: number) {
    this.loHangService.deleteLoHang(id).subscribe(
      () => {},
      () => {},
      () => {
        this.findAll()
      }
    )
  }

  search() {
    if (this.name==""){
      this.ngOnInit();
    }else {
      this.loHangService.searchName(this.name).subscribe((data) => {
        this.loHang = data;
        console.log(this.loHang);
      });
      // this.employee= this.employee.filter(res => {
      //   return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      // });
    }
  }
}
