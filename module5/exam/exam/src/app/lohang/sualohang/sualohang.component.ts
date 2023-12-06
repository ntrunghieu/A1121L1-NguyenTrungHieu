import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LohangService} from "../../service/lohang.service";
import {SanphamService} from "../../service/sanpham.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SanPham} from "../../sanPham";

@Component({
  selector: 'app-sualohang',
  templateUrl: './sualohang.component.html',
  styleUrls: ['./sualohang.component.css']
})
export class SualohangComponent implements OnInit {
  suaForm: FormGroup;
  sanPhamList: SanPham[] = [];
  id:number;
  constructor(private lohangService: LohangService,
              private sanPham: SanphamService,
              private route: Router,
              private activedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activedRouter.snapshot.params.id;
    this.lohangService.findByIdLoHang(this.id).subscribe(
      (data) => {
        this.suaForm = new FormGroup({
          id: new FormControl(data.id),
          maLH: new FormControl(data.maLoHang,[Validators.required, Validators.pattern(/^[L]{1}[H]{1}[-]{1}[0-9]{4}$/)]),
          sanPham: new FormControl(data.sanPham,[Validators.required]),
          ngayNhap: new FormControl(data.ngayNhap, [Validators.required] ),
          nsx: new FormControl(data.ngaySX,[Validators.required]),
          hsd: new FormControl(data.ngayHetHan,[Validators.required])
        })
        // this.cus = data;
        // console.log(this.cus);
      }
    );

    this.suaForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', [Validators.required]),
      date: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      type: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.email]),
      address: new FormControl('', [Validators.required])
    });
    this.getSanPham() ;

  }
  getSanPham() {
    this.sanPham.findAll().subscribe((data) => {
      this.sanPhamList = data;
    });
  }
  compareObjects(o1: any, o2: any) {
    // if(o1.name == o2.name && o1.id == o2.id )
    //   return true;
    // else return false
    return o1 && o2 ? o1.id === o2.id : o1 = o2;
  }


  submit() {
    console.log(this.suaForm.value);
    this.lohangService.updateLoHang(this.id, this.suaForm.value).subscribe(
      data => {
        console.log('Sửa thành công');
        this.route.navigateByUrl('');
      }
    );
  }
}
