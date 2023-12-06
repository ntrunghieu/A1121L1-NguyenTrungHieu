import {Component, OnInit} from '@angular/core';
import {StatisticServiceService} from '../../service/statistic/statistic-service.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Chart} from 'chart.js';


@Component({
  selector: 'app-customer-statistic',
  templateUrl: './customer-statistic.component.html',
  styleUrls: ['./customer-statistic.component.css']
})
export class CustomerStatisticComponent implements OnInit {
  customers: string[] = [];
  customers1: any[] = [];
  temp: string[] = [];
  formSearch: FormGroup;
  result: any;

  chart: Chart;
  chartCustomer1: any[] = [];
  temp2: string[] = [];
  labels: any;
  nameCustomer: any;
  totalMoney: any;

  constructor(private statisticService: StatisticServiceService) { }

  ngOnInit(): void {
    this.formSearch = new FormGroup({
      fromMonth : new FormControl(''),
      toMonth : new FormControl(''),
      year : new FormControl('')
    });
    this.getAllCustomer();
  }

  getAllCustomer() {
//    this.page = page;
    this.statisticService.getAllCustomer().subscribe((data: string[]) => {
      // console.log(data);
      // this.size = data.size;
      // this.totalItems = data.totalElements;
      // this.customers = data.content;
      for (let i = 0; i <= data.length; i++) {
        this.temp = data[i].split(',');
        this.customers1.push(this.temp);
      }
    });
  }

  exportPDF(): void {
    console.log('PDF');
    this.statisticService.getPDF().subscribe(x => {
      const blob = new Blob([x], {type: 'application/pdf'});
      if (window.navigator && window.navigator.msSaveOrOpenBlob) {
        window.navigator.msSaveOrOpenBlob(blob);
        return;
      }
      const data = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = data;
      link.download = 'statistic-customer.pdf';
      link.dispatchEvent(new MouseEvent('click' , {bubbles: true, cancelable: true, view: window}));
      // tslint:disable-next-line:only-arrow-functions
      setTimeout(function() {
        window.URL.revokeObjectURL(data);
        link.remove();
      }, 100);
    });
  }

  search() {
    this.statisticService.searchStatisticCustomer(
      this.formSearch.get('fromMonth').value,
      this.formSearch.get('toMonth').value,
      this.formSearch.get('year').value,
    ).subscribe(
      (data) => {
        this.customers = [];
        this.customers1 = [];
        this.customers = data;
        for (let i = 0; i <= data.length; i++) {
          this.temp = data[i].split(',');
          this.customers1.push(this.temp);
        }
        console.log(this.customers);
        this.ngOnInit();
      }
    );
  }

  chartCustomer() {
    if (this.formSearch.get('fromMonth').value !== '' &&
      this.formSearch.get('toMonth').value !== '' &&
      this.formSearch.get('year').value) {
      this.statisticService.cryptoDataHuyen(
        this.formSearch.get('fromMonth').value,
        this.formSearch.get('toMonth').value,
        this.formSearch.get('year').value).then((res) => {
          this.result = res;
          this.chartCustomer1 = [];

        // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.result.length; i++) {
            this.temp2 = this.result[i].split(',');
            this.chartCustomer1.push(this.temp2);
          }
          this.labels = this.chartCustomer1.map((customer: any) => customer[1]);
          this.nameCustomer = this.chartCustomer1.map((customer: any) => customer[2]);
          this.totalMoney = this.chartCustomer1.map((customer: any) => customer[3]);

          console.log(this.nameCustomer, this.totalMoney);

          // show Chart data
          this.chart = new Chart('canvas', {
            type: 'line',
            data: {
              labels: this.labels,
              datasets: [
                {
                  label: 'Tổng giá trị (VND)',
                  data: this.totalMoney,
                  borderWidth: 2,
                  fill: false,
                  backgroundColor: 'rgba(93, 175, 89, 0.1)',
                  borderColor: 'red'
                }
              ]
            },
          });
        }
      );
    } else {
      this.statisticService.cryptoDataCustomer().then((res) => {
          this.result = res;
          this.chartCustomer1 = [];

        // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.result.length; i++) {
            this.temp2 = this.result[i].split(',');
            this.chartCustomer1.push(this.temp2);
          }
          this.labels = this.chartCustomer1.map((customer: any) => customer[0]);
          this.nameCustomer = this.chartCustomer1.map((customer: any) => customer[1]);
          this.totalMoney = this.chartCustomer1.map((customer: any) => customer[3]);

          console.log(this.nameCustomer, this.totalMoney);

          // show Chart data
          this.chart = new Chart('canvas', {
            type: 'line',
            data: {
              labels: this.labels,
              datasets: [
                {
                  label: 'Tổng giá trị (VND)',
                  data: this.totalMoney,
                  borderWidth: 3,
                  fill: false,
                  backgroundColor: 'rgba(93, 175, 89, 0.1)',
                  borderColor: 'red'
                }
              ]
            },
          });
        }
      );
    }
  }
}
