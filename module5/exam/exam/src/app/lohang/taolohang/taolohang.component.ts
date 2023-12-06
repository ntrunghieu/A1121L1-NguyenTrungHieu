import { Component, OnInit } from '@angular/core';
import {LoHang} from "../../loHang";
import {LohangService} from "../../service/lohang.service";
import {SanphamService} from "../../service/sanpham.service";
import {SanPham} from "../../sanPham";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-taolohang',
  templateUrl: './taolohang.component.html',
  styleUrls: ['./taolohang.component.css']
})
export class TaolohangComponent implements OnInit {
  taoForm: FormGroup;
  sanPham: SanPham[] = [];
  constructor(private sanphamService: SanphamService,
              private lohangService: LohangService,
              private route: Router) { }

  ngOnInit(): void {
    this.getLoHang();

    this.taoForm = new FormGroup({
      id: new FormControl(''),
      maLH: new FormControl('',[Validators.required, Validators.pattern(/^[L]{1}[H]{1}[-]{1}[0-9]{4}$/)]),
      sanPham: new FormControl('',[Validators.required]),
      ngayNhap: new FormControl('', [Validators.required] ),
      nsx: new FormControl('',[Validators.required]),
      hsd: new FormControl('',[Validators.required])
    },);
  }

  submit() {
    this.lohangService.createLoHang(this.taoForm.value).subscribe(data => {
        console.log(data);

      }, (err) => {
        console.log(err);
      },
      () => {
        alert('Thêm mới lô hàng thành công');
        this.route.navigateByUrl('');
      });
  }

  getLoHang() {
    this.sanphamService.findAll().subscribe((data) => {
      this.sanPham = data;
    });
  }
}
