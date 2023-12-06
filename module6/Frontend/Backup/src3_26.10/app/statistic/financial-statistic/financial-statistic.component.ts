import { Component, OnInit } from '@angular/core';
import {StatisticServiceService} from '../../service/statistic/statistic-service.service';
import {ICart} from '../../model/cart/icart';
import {applySourceSpanToExpressionIfNeeded} from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-financial-statistic',
  templateUrl: './financial-statistic.component.html',
  styleUrls: ['./financial-statistic.component.css']
})
export class FinancialStatisticComponent implements OnInit {
  // KimPBH -Thong ke tai chinh
  ban: number;
  tra: number;
  huy: number;
  nhap: number;
  tongthu = 0;
  tongchi = 0;
  doanhthu = 0;
  search1: string[] = [];
  month = '';
  year = '';
  constructor(private statisticService: StatisticServiceService) { }

  ngOnInit(): void {
    // @ts-ignore
    this.search(undefined);
  }
  // getStatic() {
  //   this.statisticService.getBan().subscribe(
  //     (res) => {
  //       this.ban = res;
  //       this.tongthu = this.tongthu + this.ban;
  //     });
  //   this.statisticService.getTra().subscribe(
  //     (res) => {
  //       this.tra = res;
  //       this.tongthu = this.tongthu + this.tra;
  //     });
  //   this.statisticService.getHuy().subscribe(
  //     (res) => {
  //       this.huy = res;
  //       this.tongthu = this.tongthu + this.huy;
  //     });
  //   this.statisticService.getNhap().subscribe(
  //     (res) => {
  //       this.nhap = res;
  //       this.tongchi = this.tongchi + this.nhap;
  //       this.doanhthu = this.tongthu - this.tongchi;
  //     });
  // }
  exportPDF(): void {
    console.log(this.search1);
    this.statisticService.getPdf2(this.search1).subscribe(x => {
      const blob = new Blob([x], {type: 'application/pdf'});
      if (window.navigator && window.navigator.msSaveOrOpenBlob) {
        window.navigator.msSaveOrOpenBlob(blob);
        return;
      }
      const data1 = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = data1;
      link.download = 'invoice.pdf';
      link.dispatchEvent(new MouseEvent('click' , {bubbles: true, cancelable: true, view: window}));
      // tslint:disable-next-line:only-arrow-functions
      setTimeout(function() {
        window.URL.revokeObjectURL(data1);
        link.remove();
      }, 100);
    });
  }

  search(value) {
    if (value === undefined) {
     this.month = '';
     this.year = '';
     this.statisticService.search(this.month, this.year).subscribe((data: string[]) => {
        this.search1 = data;
        // tslint:disable-next-line:radix
        this.ban  = parseInt(this.search1[0]);
        // tslint:disable-next-line:radix
        this.nhap  = parseInt(this.search1[1]);
        // tslint:disable-next-line:radix
        this.huy  = parseInt(this.search1[2]);
        // tslint:disable-next-line:radix
        this.tra  = parseInt(this.search1[3]);
        this.tongthu = 0;
        this.tongthu = this.ban + this.huy + this.tra;
        this.tongchi = this.nhap;
        this.doanhthu = this.tongthu - this.tongchi;
      });
    } else {
      // tslint:disable-next-line:radix
      if (value.value <= 12) {
        this.month = value.value;
      } else  {
        this.year = value.value;
      }
      if (this.month === undefined) {
        this.month = '';
      }
      if (this.year === undefined) {
        this.year = '';
      }
      console.log(this.month);
      console.log(this.year);
      this.statisticService.search(this.month, this.year).subscribe((data: string[]) => {
        this.search1 = data;
        // tslint:disable-next-line:radix
        this.ban  = parseInt(this.search1[0]);
        // tslint:disable-next-line:radix
        this.nhap  = parseInt(this.search1[1]);
        // tslint:disable-next-line:radix
        this.huy  = parseInt(this.search1[2]);
        // tslint:disable-next-line:radix
        this.tra  = parseInt(this.search1[3]);
        this.tongthu = 0;
        this.tongthu = this.ban + this.huy + this.tra;
        this.tongchi = this.nhap;
        this.doanhthu = this.tongthu - this.tongchi;
      });
    }
  }
}
