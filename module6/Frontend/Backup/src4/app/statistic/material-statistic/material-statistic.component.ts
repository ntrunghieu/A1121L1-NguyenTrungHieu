import {Component, OnInit} from '@angular/core';
import {StatisticServiceService} from '../../service/statistic/statistic-service.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Chart} from 'chart.js';

@Component({
  selector: 'app-material-statistic',
  templateUrl: './material-statistic.component.html',
  styleUrls: ['./material-statistic.component.css']
})
export class MaterialStatisticComponent implements OnInit {
  materials: any[] = [];
  materials1: any[] = [];
  tam: string[] = [];
  formSearch: FormGroup;
  result: any;

  chart: Chart;
  chartMaterial1: any[] = [];
  tam2: string[] = [];
  labels: any;
  dataImport: any;
  dataExport: any;
  dataInventory: any;


  constructor(private statisticService: StatisticServiceService) {
  }

  ngOnInit(): void {
    this.formSearch = new FormGroup({
      fromDate: new FormControl(''),
      toDate: new FormControl('')
    });
    this.getAll();
  }

  getAll() {
    this.statisticService.getAll().subscribe((data: string[]) => {
      this.materials = data;
      for (let i = 0; i <= data.length; i++) {
        this.tam = data[i].split(',');
        this.materials1.push(this.tam);
      }
    });
  }

  exportPDF(): void {
    this.statisticService.getPdf().subscribe(x => {
      const blob = new Blob([x], {type: 'application/pdf'});
      if (window.navigator && window.navigator.msSaveOrOpenBlob) {
        window.navigator.msSaveOrOpenBlob(blob);
        return;
      }
      const data = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = data;
      link.download = 'statistic-material.pdf';
      link.dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true, view: window}));
      // tslint:disable-next-line:only-arrow-functions
      setTimeout(function () {
        window.URL.revokeObjectURL(data);
        link.remove();
      }, 100);
    });
  }

  search() {
    this.statisticService.searchStatisticMaterial(
      this.formSearch.get('fromDate').value,
      this.formSearch.get('toDate').value
    ).subscribe(
      (data) => {
        this.materials = [];
        this.materials1 = [];
        this.materials = data;
        for (let i = 0; i <= data.length; i++) {
          this.tam = data[i].split(',');
          this.materials1.push(this.tam);
        }
      }
    );
    console.log(this.materials1);
  }

  // test chart material
  chartMaterial() {
    if (this.formSearch.get('fromDate').value !== '' &&
      this.formSearch.get('toDate').value !== '') {
      this.statisticService.cryptoData(
        this.formSearch.get('fromDate').value,
        this.formSearch.get('toDate').value).then((res) => {
          this.result = res;
          this.chartMaterial1 = [];

          for (let i = 0; i < this.result.length; i++) {
            this.tam2 = this.result[i].split(',');
            this.chartMaterial1.push(this.tam2);
          }
          this.labels = this.chartMaterial1.map((statistic: any) => statistic[1]);
          this.dataImport = this.chartMaterial1.map((statistic: any) => statistic[2]);
          this.dataExport = this.chartMaterial1.map((statistic: any) => statistic[3]);
          this.dataInventory = this.chartMaterial1.map((statistic: any) => statistic[4]);

          // show Chart data
          this.chart = new Chart('canvas', {
            type: 'line',
            data: {
              labels: this.labels,
              datasets: [
                {
                  label: 'Vật tư nhập',
                  data: this.dataImport,
                  borderWidth: 3,
                  fill: false,
                  backgroundColor: 'rgba(93, 175, 89, 0.1)',
                  borderColor: 'red'
                },
                {
                  label: 'Vật tư bán được',
                  data: this.dataExport,
                  borderWidth: 3,
                  fill: false,
                  backgroundColor: 'rgba(93, 175, 89, 0.1)',
                  borderColor: 'yellow'
                },
                {
                  label: 'Vật tư tồn kho',
                  data: this.dataInventory,
                  borderWidth: 3,
                  fill: false,
                  backgroundColor: 'rgba(93, 175, 89, 0.1)',
                  borderColor: 'green'
                }
              ]
            },
          });
        }
      );
    } else {
      this.statisticService.cryptoData1().then((res) => {
          this.result = res;
          this.chartMaterial1 = [];

          for (let i = 0; i < this.result.length; i++) {
            this.tam2 = this.result[i].split(',');
            this.chartMaterial1.push(this.tam2);
          }
          this.labels = this.chartMaterial1.map((statistic: any) => statistic[0]);
          this.dataImport = this.chartMaterial1.map((statistic: any) => statistic[1]);
          this.dataExport = this.chartMaterial1.map((statistic: any) => statistic[2]);
          this.dataInventory = this.chartMaterial1.map((statistic: any) => statistic[3]);

          // show Chart data
          this.chart = new Chart('canvas', {
            type: 'line',
            data: {
              labels: this.labels,
              datasets: [
                {
                  label: 'Vật tư nhập',
                  data: this.dataImport,
                  borderWidth: 3,
                  fill: false,
                  backgroundColor: 'rgba(93, 175, 89, 0.1)',
                  borderColor: 'red'
                },
                {
                  label: 'Vật tư bán được',
                  data: this.dataExport,
                  borderWidth: 3,
                  fill: false,
                  backgroundColor: 'rgba(93, 175, 89, 0.1)',
                  borderColor: 'yellow'
                },
                {
                  label: 'Vật tư tồn kho',
                  data: this.dataInventory,
                  borderWidth: 3,
                  fill: false,
                  backgroundColor: 'rgba(93, 175, 89, 0.1)',
                  borderColor: 'green'
                }
              ]
            },
          });
        }
      );
    }
  }
}
