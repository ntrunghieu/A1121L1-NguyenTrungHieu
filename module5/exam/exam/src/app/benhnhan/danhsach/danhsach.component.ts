import { Component, OnInit } from '@angular/core';
import {BenhnhanService} from "../../service/benhnhan.service";
import {BenhNhan} from "../../model/benhNhan";


@Component({
  selector: 'app-danhsach',
  templateUrl: './danhsach.component.html',
  styleUrls: ['./danhsach.component.css']
})
export class DanhsachComponent implements OnInit {
  benhNhan: BenhNhan[] = [];
  totalLength: number;
  p: string | number = 1;
   id: number;
   ten: string;
   benhNhan1: BenhNhan;
  constructor(private benhnhanService: BenhnhanService) { }

  ngOnInit(): void {
    this.findAll();
  }
  findAll() {
    this.benhnhanService.findAll().subscribe((data) => {
      this.benhNhan = data;
      this.totalLength = data.length;

    });
  }

  guiIdBenhNhan(id: number, tenBenhNhan: string) {
    this.id = id;
    this.ten = tenBenhNhan;
  }

  xemChiTiet(bn: BenhNhan) {
    this.benhNhan1=bn;
  }

  xoa(id: number) {
    this.benhnhanService.deleteBenhNhan(id).subscribe(
      () => {},
      () => {},
      () => {

        this.findAll();
        alert('Xóa bệnh nhân thành công');
      }
    )
  }

}
