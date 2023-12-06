import {Component, OnInit} from '@angular/core';
import {IMaterial} from '../../model/material/imaterial';
import {IImport} from '../../model/iimport';
import {ICart} from '../../model/cart/icart';
import {StatisticServiceService} from '../../service/statistic/statistic-service.service';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-material-statistic',
  templateUrl: './material-statistic.component.html',
  styleUrls: ['./material-statistic.component.css']
})
export class MaterialStatisticComponent implements OnInit {
  materials: string[] = [];
  materials1: any[] = [];
  tam: string[] = [];
  constructor(private statisticService: StatisticServiceService) {
  }

  ngOnInit(): void {
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
    console.log('PDF');
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
      link.dispatchEvent(new MouseEvent('click' , {bubbles: true, cancelable: true, view: window}));
      // tslint:disable-next-line:only-arrow-functions
      setTimeout(function() {
        window.URL.revokeObjectURL(data);
        link.remove();
      }, 100);
    });
  }

}
